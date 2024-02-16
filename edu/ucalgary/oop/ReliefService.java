package edu.ucalgary.oop;

import java.util.regex.*;

public class ReliefService{
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    // regex for validating the date format (YYYY-MM-DD)
    private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";

    // Constructor
    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation){
        // Validate date for constructor.
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(dateOfInquiry);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid date format.");
        }

        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = dateOfInquiry;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }

    // Getters
    public Inquirer getInquirer(){
        return this.inquirer;
    }

    public DisasterVictim getMissingPerson(){
        return this.missingPerson;
    }

    public String getDateOfInquiry(){
        return this.dateOfInquiry;
    }

    public String getInfoProvided(){
        return this.infoProvided;
    }

    public Location getLastKnownLocation(){
        return this.lastKnownLocation;
    }

    public String getLogDetails(){
        StringBuilder logDetails = new StringBuilder();
        // I'm not sure what to put here, so I just returned a string with all the Info in this class.
        logDetails.append("Inquirer: ").append(inquirer.getFirstName()).append(" ").append(inquirer.getLastName()).append("\n");
        logDetails.append("Missing Person: ").append(missingPerson.getFirstName()).append(" ").append(missingPerson.getLastName()).append("\n");
        logDetails.append("Date of Inquiry: ").append(dateOfInquiry).append("\n");
        logDetails.append("Information Provided: ").append(infoProvided).append("\n");
        logDetails.append("Last Known Location: ").append(lastKnownLocation.getName()).append(", ").append(lastKnownLocation.getAddress()).append("\n");
        return logDetails.toString();
    }

    // Setters
    public void setInquirer(Inquirer inquirer){
        this.inquirer = inquirer;
    }

    public void setMissingPerson(DisasterVictim missingPerson){
        this.missingPerson = missingPerson;
    }

    public void setDateOfInquiry(String dateOfInquiry){
        // Validate date for constructor.
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(dateOfInquiry);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid date format.");
        }
        
        this.dateOfInquiry = dateOfInquiry;
    }

    public void setInfoProvided(String infoProvided){
        this.infoProvided = infoProvided;
    }

    public void setLastKnownLocation(Location lastKnownLocation){
        this.lastKnownLocation = lastKnownLocation;
    }
}