package main.java.edu.pdx.cs410J.pbt;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.ParserException;

/**
 * Created by Paul on 7/7/2016.
 */
public class TextParser implements edu.pdx.cs410J.AppointmentBookParser {

    public AbstractAppointmentBook parse() throws ParserException {

        return new AppointmentBook("placeholder");
    }

}
