package main.java.edu.pdx.cs410J.pbt;

import edu.pdx.cs410J.AbstractAppointment;

public class Appointment extends AbstractAppointment {

    private String beginTime;
    private String endTime;
    private String description;

    public Appointment(String newDescription, String newBeginTime, String newEndTime) {

        this.description = newDescription;
        this.beginTime = newBeginTime;
        this.endTime = newEndTime;
    }

    @Override
    public String getBeginTimeString() {
        return this.beginTime;
    }

    @Override
    public String getEndTimeString() {
        return this.endTime;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
