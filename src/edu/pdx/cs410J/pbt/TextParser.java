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
import java.text.ParseException;

/**
 * Created by Paul on 7/7/2016.
 */
public class TextParser implements edu.pdx.cs410J.AppointmentBookParser {

    private String fileName;

    public TextParser(String newFileName) {
        this.fileName = newFileName;
    }

    public AbstractAppointmentBook parse() throws ParserException {

        // ************************
        // Add handling of relative path including directories.
        // ************************


        DocumentBuilder documentBuilder = null;
        Transformer transformer = null;
        File dir = new File(".");
        File parseFile = null;
        Document document = null;

        try {
            parseFile = new File(dir.getCanonicalPath() + File.separator + this.fileName);

            // Handle case where appointment book does not exist at all.
            if(!parseFile.exists()) {
                return new AppointmentBook("newbook");
            }

            if(parseFile.isDirectory()) {
                throw new ParserException("Directory specified as parse file!");
            }

        }
        catch(IOException e) {
            throw new ParserException("Unable to use parse file!");
        }

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder =   documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            throw new ParserException("Unable to use parse file!");
        }

        try {
            document = documentBuilder.parse(parseFile);
        }
        catch(SAXException|IOException e) {
            throw new ParserException("Unable to read parse file!");
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

        return appointmentBook;
    }

}
