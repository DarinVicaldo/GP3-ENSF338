package edu.ucalgary.oop;

public class Inquirer{
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String INFO;
    private final String SERVICES_PHONE;

    // Constructor
    public Inquirer(String FIRST_NAME, String LAST_NAME, String INFO, String SERVICES_PHONE){
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.INFO = INFO;
        this.SERVICES_PHONE = SERVICES_PHONE;
    }

    // Getters
    public String getFirstName(){
        return this.FIRST_NAME;
    }

    public String getLastName(){
        return this.LAST_NAME;
    }

    public String getInfo(){
        return this.INFO;
    }

    public String getServicesPhone(){
        return this.SERVICES_PHONE;
    }
}