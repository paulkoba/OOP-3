import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.CharArrayWriter;
import java.util.ArrayList;

public class TouristSAXParser extends DefaultHandler {
    private final ArrayList<TouristVoucher> data = new ArrayList<>();
    private final CharArrayWriter contents = new CharArrayWriter();

    public void startDocument() throws SAXException {}
    public void endDocument() throws SAXException {}

    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes attrs) throws SAXException {
        contents.reset();
        if(qName.equals("TouristVoucher")) {
            var voucher = new TouristVoucher();
            voucher.setID(attrs.getValue("id"));
            data.add(voucher);
        }
        if(qName.equals("hotelCharacteristic")) {
            var tmp = data.get(data.size() - 1);
            tmp.setHotelCharacteristic(new TouristVoucher.HotelCharacteristic());
        }
    }


    public void endElement(String namespaceURI, String localName,
                             String qName) throws SAXException {
        var tmp = data.get(data.size() - 1);

        switch (qName) {
            case "type":
                tmp.setType(contents.toString());
                break;
            case "countryCode":
                tmp.setCountryCode(contents.toString());
                break;
            case "dayCount":
                tmp.setDayCount(Integer.valueOf(contents.toString()));
                break;
            case "transportationType":
                tmp.setTransportation(TouristVoucher.Transportation.valueOf(contents.toString()));
                break;
            case "freeMeals": {
                var characteristic = data.get(data.size() - 1).getHotelCharacteristic();
                characteristic.freeMeals = Boolean.valueOf(contents.toString());
                break;
            }
            case "rooms": {
                var characteristic = data.get(data.size() - 1).getHotelCharacteristic();
                characteristic.rooms = Integer.valueOf(contents.toString());
                break;
            }
            case "stars":{
                var characteristic = data.get(data.size() - 1).getHotelCharacteristic();
                characteristic.stars = Integer.valueOf(contents.toString());
                break;
            }
        }
    }

    public void characters( char[] ch, int start, int length )
            throws SAXException {
        contents.write( ch, start, length );
    }

    public ArrayList<TouristVoucher> getParsed() {
        return data;
    }
}
