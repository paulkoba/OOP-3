import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
    private final String xmlPath;

    public DOMParser(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    private TouristVoucher.HotelCharacteristic parseHotelCharacteristic(Node node) {
        TouristVoucher.HotelCharacteristic characteristic = new TouristVoucher.HotelCharacteristic();
        NodeList list = node.getChildNodes();

        for(int i = 0; i < list.getLength(); ++i) {
            if (list.item(i).getNodeType() == Node.TEXT_NODE) continue;

            String context = list.item(i).getChildNodes().item(0).getTextContent();
            switch(list.item(i).getNodeName()) {
                case "stars":
                    characteristic.stars = Integer.valueOf(context);
                    break;
                case "freeMeals":
                    characteristic.freeMeals = Boolean.valueOf(context);
                    break;
                case "rooms":
                    characteristic.rooms = Integer.valueOf(context);
                    break;
            }
        }

        return characteristic;
    }

    private TouristVoucher parseSingleVoucher(Node node) {
        TouristVoucher voucher = new TouristVoucher();
        voucher.setID(((Element)node).getAttribute("id"));
        NodeList list = node.getChildNodes();
        for(int i = 0; i < list.getLength(); ++i) {
            if (list.item(i).getNodeType() == Node.TEXT_NODE) continue;
            String context = list.item(i).getChildNodes().item(0).getTextContent();
            switch(list.item(i).getNodeName()) {
                case "type":
                    voucher.setType(context);
                    break;
                case "countryCode":
                    voucher.setCountryCode(context);
                    break;
                case "dayCount":
                    voucher.setDayCount(Integer.valueOf(context));
                    break;
                case "transportationType":
                    voucher.setTransportation(TouristVoucher.Transportation.valueOf(context));
                    break;
                case "hotelCharacteristic":
                    voucher.setHotelCharacteristic(parseHotelCharacteristic(list.item(i)));
                    break;
                default:
                    System.out.println("Unexpected value");
                    break;
            }
        }
        return voucher;
    }

    public ArrayList<TouristVoucher> parse() {
        ArrayList<TouristVoucher> parsed = new ArrayList<>();
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlPath);
            NodeList list = document.getFirstChild().getChildNodes();
            int n = list.getLength();
            for(int i = 0; i < n; ++i) {
                if (list.item(i).getNodeType() == Node.TEXT_NODE) continue;
                parsed.add(parseSingleVoucher(list.item(i)));
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return parsed;
    }
}
