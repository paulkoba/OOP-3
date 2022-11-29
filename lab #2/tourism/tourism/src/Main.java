import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
        String xmlPath = "./tourism/TouristVoucher.xml";
        String xsdPath = "./tourism/TouristVoucher.xsd";
        TouristVoucherValidator validator = new TouristVoucherValidator(xmlPath, xsdPath);

        validator.validate();

        DOMParser parser = new DOMParser(xmlPath);
        ArrayList<TouristVoucher> result = parser.parse();

        System.out.println("Using DOM parser: ");
        for(TouristVoucher voucher : result) {
            System.out.println(voucher);
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        TouristSAXParser handler = new TouristSAXParser();
        saxParser.parse(xmlPath, handler);
        var saxResult = handler.getParsed();

        System.out.println("Using SAX parser: ");
        for(TouristVoucher voucher : saxResult) {
            System.out.println(voucher);
        }

        TouristStAXParser stAxParser = new TouristStAXParser(xmlPath);
        var staxResult = stAxParser.parse();

        System.out.println("Using StAX parser: ");
        for(TouristVoucher voucher : staxResult) {
            System.out.println(voucher);
        }
    }
}
