package main.java.edu.pdx.cs410J.pbt;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The main class for the CS410J appointment book Project
 * Performs parsing and error checking of the user inputted command line
 * options and arguments, upon successful parsing, it will create a
 * new appointment book and enter the user's appointment into it. Will optionally
 * print the appointment for the user if they use the -print command line
 * option or display a read me to the user if they use the -README option.
 *
 */
public class Project2 {

  public static void main(String[] args) {

      AppointmentBook appointmentBook = new AppointmentBook("Paul");
      TextDumper dumper = new TextDumper("PaulApptBook01");

      try {
          dumper.dump(appointmentBook);
      }
      catch(IOException e) {
          System.err.println("IOException!");
      }

      /*
      Class c = AbstractAppointmentBook.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath

      AppointmentBook appointmentBook = null;
      Appointment appointment = null;
      Date beginDate = null;
      Date endDate = null;
      int expectedArgs = 6;
      int firstAppointmentArg = 0;
      boolean printAppointment = false;

      // Look through the command line arugments to see if
      // -README or -print options were provided by the user.
      for(String arg : args) {

          if(arg.equals("-README")) {
              String readme = "Paul Thompson - CS 410J Project 1\n" +
              "This project allows the user to create an appointment book and an appointment\n" +
              "that will be placed into the appointment book. The user can optionally print out the newly created\n" +
              "appoint. The program supports the following optional command line arguments\n" +
              "and should be specified first if used:\n" +
              "-print         Prints a description of the new appointment.\n" +
              "-README        Prints a this README and exits.\n" +
              "Then command line appointment arguments should be placed in this order\n" +
              "owner          The person that owns the appointment book, should be opened and closed with double quotes.\n" +
              "description    A description of the appointment, should be opened and closed with double quotes.\n" +
              "begin date     When the appointment begins in the format of m(m)/d(d)/yyyy\n" +
              "begin time     The time the appointment begins in the format of HH:mm\n" +
              "end date       When the appointment ends in the format of m)m)/d(d)/yyyy\n" +
              "end time       The time the appoineent ends in the format of HH:mm\n";

              System.out.println(readme);
              System.exit(1);
          }

          if(arg.equals("-print")) {

              expectedArgs = expectedArgs + 1;
              printAppointment = true;
              firstAppointmentArg = 1;
          }
      }

      // Check to make sure there aren't too few command
      // line arguments.
      if(args.length < expectedArgs) {

          System.err.println("Missing command line arguments");
          System.exit(0);
      }

      // Check to make sure there aren't too many command line arguments.
      if (args.length > expectedArgs) {

          System.err.println("Extraneous command line arguments");
          System.exit(0);
      }

      String newOwner = args[firstAppointmentArg + 0];
      String newDescription = args[firstAppointmentArg + 1];
      String stringBeginDate = args[firstAppointmentArg + 2] + " " + args[firstAppointmentArg + 3];
      String stringEndDate = args[firstAppointmentArg + 4] + " " + args[firstAppointmentArg + 5];

      // Check to make sure the owner field is not blank.
      if(newOwner.length() == 0) {
          System.err.println("Owner cannot be blank.");
          System.exit(0);
      }

      // Check to make sure the description field is not blank.
      if(newDescription.length() == 0) {
          System.err.println("Description cannot be blank.");
          System.exit(0);
      }

      // Check to make sure the begin date format is correct.
      if(!args[firstAppointmentArg + 2].matches("\\d\\d?/\\d\\d?/\\d\\d\\d\\d")) {
          System.err.println("Begin date is incorrectly formatted!");
          System.exit(0);
      }

      // Check to make sure the begin time format is correct.
      if(!args[firstAppointmentArg + 3].matches("\\d\\d?:\\d\\d")) {
          System.err.println("Begin time is incorrectly formatted!");
          System.exit(0);
      }

      // Check to make sure the end date format is correct.
      if(!args[firstAppointmentArg + 4].matches("\\d\\d?/\\d\\d?/\\d\\d\\d\\d")) {
          System.err.println("End date is incorrectly formatted!");
          System.exit(0);
      }

      // Check to make sure the end time format is correct.
      if(!args[firstAppointmentArg + 5].matches("\\d\\d?:\\d\\d")) {
          System.err.println("End time is incorrectly formatted!");
          System.exit(0);
      }

      SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
      dateFormat.setLenient(false);

      // Attempt to parse the begin date and time to ensure that they
      // are valid dates and times.
      try {
          beginDate = dateFormat.parse(stringBeginDate);
      }
      catch (ParseException e) {
          System.err.println("Begin date and time format is incorrect.");
          System.exit(0);
      }

      // Attempt to parse the begin date and time to ensure that they
      // are valid dates and times.
      try {
          endDate = dateFormat.parse(stringEndDate);
      }
      catch (ParseException e) {
          System.err.println("End date and time format is incorrect.");
          System.exit(0);
      }

      // Create a new appointment book and appointment, and add
      // that appointment to the appointment book.
      appointmentBook = new AppointmentBook(newOwner);
      appointment = new Appointment(newDescription, beginDate.toString(), endDate.toString());
      appointmentBook.addAppointment(appointment);

      if(printAppointment) {
          System.out.println(appointment.toString());
      }

      System.exit(1);
      */
  }

}