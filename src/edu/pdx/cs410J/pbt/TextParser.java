package edu.pdx.cs410J.pbt;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.ParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import java.io.File;
import java.io.IOException;

/**
 * Created by Paul on 7/7/2016.
 */
public class TextParser implements edu.pdx.cs410J.AppointmentBookParser {

    private String fileName;

    public TextParser(String newFileName) {
        this.fileName = newFileName;
    }

    public AbstractAppointmentBook parse() throws ParserException {

        DocumentBuilder documentBuilder = null;
        Transformer transformer = null;
        File dir = new File(".");
        File parseFile = null;
        Document document = null;

        try {
            parseFile = new File(dir.getCanonicalPath() + File.separator + this.fileName);
        }
        catch(IOException e) {
            System.out.println("IOException!");
        }

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder =   documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            System.err.println("ParserConfigurationException!");
        }

        try {
            document = documentBuilder.parse(parseFile);
        }
        catch(SAXException|IOException e) {
            System.err.println("SAXException or IOException!");
        }

        NodeList nodes = document.getElementsByTagName("appointmentBook");

        Element appointmentBookElement = (Element) nodes.item(0);
        String owner = appointmentBookElement.getElementsByTagName("owner").item(0).getTextContent();

        AppointmentBook appointmentBook = new AppointmentBook(owner);

        NodeList appointmentsNodeList = appointmentBookElement.getElementsByTagName("appointments");

        for(int i = 0; i < appointmentsNodeList.getLength(); ++i) {

            Node appointmentsNode = appointmentsNodeList.item(i);

            if(appointmentsNode.getNodeType() == Node.ELEMENT_NODE) {
                Element appointmentsElement = (Element) appointmentsNode;
                NodeList appointmentNodes = appointmentsElement.getElementsByTagName("appointment");

                for(int j = 0; j < appointmentNodes.getLength(); ++j) {

                    Node appointmentNode = appointmentNodes.item(j);

                    if(appointmentNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element appointmentElement = (Element) appointmentNode;

                        String description = appointmentElement.getElementsByTagName("description").item(0).getTextContent();
                        String beginTime = appointmentElement.getElementsByTagName("beginTime").item(0).getTextContent();
                        String endTime = appointmentElement.getElementsByTagName("endTime").item(0).getTextContent();

                        Appointment appointment = new Appointment(description, beginTime, endTime);
                        appointmentBook.addAppointment(appointment);
                    }
                }
            }
        }



        // for(int i = 0; i < nodes.getLength(); ++i) {

            // Node node = nodes.item(i);
            // System.out.println(nodes.item(i).getTextContent().toString());

            // if(node.getNodeType() == Node.ELEMENT_NODE) {

                // Element e = (Element) node;

                // System.out.println("Owner is: " + element.getElementsByTagName("owner").item(0).getTextContent() );

            // }
        // }
        // Element owner = document.getElementsByTagName("owner");
        // System.out.println("owner is: " + owner.getTextContent());

        // AppointmentBook appointmentBook = new AppointmentBook();





        return appointmentBook;
    }

}
