package main.java.edu.pdx.cs410J.pbt;

import edu.pdx.cs410J.AbstractAppointment;
import edu.pdx.cs410J.AbstractAppointmentBook;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Paul on 7/4/2016.
 */
public class AppointmentBook extends AbstractAppointmentBook {

    String owner;
    ArrayList<AbstractAppointment> appointments;

    public AppointmentBook(String newOwner) {
        this.owner = newOwner;
        this.appointments = new ArrayList<AbstractAppointment>();
    }

    public String getOwnerName() {
        return this.owner;
    }

    public Collection getAppointments() {
        return this.appointments;
    }

    public void addAppointment(AbstractAppointment var1) {
        this.appointments.add(var1);
    }
}
