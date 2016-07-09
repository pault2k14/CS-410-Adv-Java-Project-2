package main.java.edu.pdx.cs410J.pbt;

import edu.pdx.cs410J.AbstractAppointmentBook;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by Paul on 7/7/2016.
 */
public class TextDumper implements edu.pdx.cs410J.AppointmentBookDumper {

    private String fileName = null;

    public TextDumper(String fileName) {
        this.fileName = fileName;
    }

    public void dump(AbstractAppointmentBook var1) throws IOException {

        DocumentBuilder documentBuilder = null;
        Transformer transformer = null;
        File dir = new File(".");
        File dumpFile = new File(dir.getCanonicalPath() + File.separator + this.fileName);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder =   documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            System.err.println("ParserConfigurationException!");
        }

        Document document = documentBuilder.newDocument();
        Element appointmentBookRoot = document.createElement("AppointmentBook");
        document.appendChild(appointmentBookRoot);

        Element owner = document.createElement("owner");
        owner.appendChild(document.createTextNode("Paul"));
        appointmentBookRoot.appendChild(owner);

        Element appointments = document.createElement("Appointments");
        Element appointment = document.createElement("Appointment");

        Element description = document.createElement("Description");
        description.appendChild(document.createTextNode("Lunch with Bob."));
        appointment.appendChild(description);

        Element beginTime = document.createElement("BeginTime");
        beginTime.appendChild(document.createTextNode("08/1/2016 13:30"));
        appointment.appendChild(beginTime);

        Element endTime = document.createElement("endTime");
        endTime.appendChild(document.createTextNode("08/1/2016 15:00"));
        appointment.appendChild(endTime);

        appointments.appendChild(appointment);
        appointmentBookRoot.appendChild(appointments);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {
            transformer = transformerFactory.newTransformer();
        }
        catch (TransformerConfigurationException e) {
            System.err.println("TransformerConfigurationException");
        }

        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(dumpFile);

        try{
            transformer.transform(domSource, streamResult);
        }

        catch(TransformerException e) {
            System.err.println("TransformerException!");
        }

        /*
        <appointmentBook>
                <owner> </owner>
                <appointments>
                    <appointment>
                        <beginTime> </beginTime>
                        <endTime> </endTime>
                        <description> </description>
                    </appointment>
                </appointments>
        </appointmentBook>
        */
    }

}
