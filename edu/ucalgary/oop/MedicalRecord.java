package edu.ucalgary.oop;

import java.util.regex.*;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;

    // regex for validating the date format (YYYY-MM-DD)
    private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";

    // Constructor
    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment){
        // Validate date for constructor.
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(dateOfTreatment);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid date format.");
        }

        this.location = location;
        this.treatmentDetails = treatmentDetails;
        this.dateOfTreatment = dateOfTreatment;
    }

    // Getters
    public Location getLocation(){
        return this.location;
    }

    public String getTreatmentDetails(){
        return this.treatmentDetails;
    }

    public String getDateOfTreatment(){
        return this.dateOfTreatment;
    }

    // Setters
    public void setLocation(Location location){
        this.location = location;
    }

    public void setTreatmentDetails(String treatmentDetails){
        this.treatmentDetails = treatmentDetails;
    }

    public void setDateOfTreatment(String dateOfTreatment){
        // Validate date for setter.
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(dateOfTreatment);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid date format.");
        }
        this.dateOfTreatment = dateOfTreatment;
    }
}
