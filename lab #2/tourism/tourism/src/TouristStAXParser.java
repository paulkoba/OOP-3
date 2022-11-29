import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TouristStAXParser {
    private final String xmlPath;

    TouristStAXParser(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    ArrayList<TouristVoucher> parse() throws FileNotFoundException, XMLStreamException {
        ArrayList<TouristVoucher> data = new ArrayList<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlPath));
        XMLEvent contents = null;
        while(reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if(event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "TouristVoucher":
                        var voucher = new TouristVoucher();
                        Attribute id = startElement.getAttributeByName(new QName("id"));
                        if(id != null) voucher.setID(id.getValue());
                        data.add(voucher);
                        break;
                    case "hotelCharacteristic":
                        var tmp = data.get(data.size() - 1);
                        tmp.setHotelCharacteristic(new TouristVoucher.HotelCharacteristic());
                        break;
                    default:
                        break;
                }

                contents = reader.nextEvent();
            }

            if(event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                String name = endElement.getName().getLocalPart();
                TouristVoucher tmp = data.get(data.size() - 1);
                switch (name) {
                    case "type":
                        tmp.setType(contents.asCharacters().getData());
                        break;
                    case "countryCode":
                        tmp.setCountryCode(contents.asCharacters().getData());
                        break;
                    case "dayCount":
                        tmp.setDayCount(Integer.valueOf(contents.asCharacters().getData()));
                        break;
                    case "transportationType":
                        tmp.setTransportation(TouristVoucher.Transportation.valueOf(contents.asCharacters().getData()));
                        break;
                    case "freeMeals": {
                        var characteristic = data.get(data.size() - 1).getHotelCharacteristic();
                        characteristic.freeMeals = Boolean.valueOf(contents.asCharacters().getData());
                        break;
                    }
                    case "rooms": {
                        var characteristic = data.get(data.size() - 1).getHotelCharacteristic();
                        characteristic.rooms = Integer.valueOf(contents.asCharacters().getData());
                        break;
                    }
                    case "stars":{
                        var characteristic = data.get(data.size() - 1).getHotelCharacteristic();
                        characteristic.stars = Integer.valueOf(contents.asCharacters().getData());
                        break;
                    }
                }
            }
        }

        return data;
    }
}
