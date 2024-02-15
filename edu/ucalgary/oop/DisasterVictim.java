package edu.ucalgary.oop;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String comments;
    private final int ASSIGNED_SOCIAL_ID;
    private MedicalRecord[] medicalRecords;
    private FamilyRelation[] familyConnections;
    private final String ENTRY_DATE;
    private Supply[] personalBelongings;
    private String gender;
    private static int counter;

    // Constructor
    public DisasterVictim(String firstName, final String ENTRY_DATE){
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        
        this.ASSIGNED_SOCIAL_ID = 0;
        this.medicalRecords = null;
        this.personalBelongings = null;
        counter++;
    }

    // ADDITIONAL METHODS
    
    public void addPersonalBelonging(Supply supply){
        // If personalBelongings[] array is empty add the supply.
        if(personalBelongings == null){
            personalBelongings = new Supply[1];
            personalBelongings[0] = supply;
        }
        // Else, make room for an extra space.
        else{
            Supply[] newBelongingsArray = new Supply[personalBelongings.length + 1];
            System.arraycopy(personalBelongings, 0, newBelongingsArray, 0, personalBelongings.length);
            newBelongingsArray[personalBelongings.length] = supply;
            personalBelongings = newBelongingsArray;
        }
    }

    public void removePersonalBelonging(Supply supply){
        // If personalBelongings[] array is not empty, do the method.
        if(personalBelongings != null){
            for(int i = 0; i < personalBelongings.length; i++){
                if(personalBelongings[i] == supply){
                    for(int j = i; j < personalBelongings.length; j++){
                        personalBelongings[j] = personalBelongings[j+1];
                    }
                    personalBelongings[personalBelongings.length - 1] = null;
                    break;
                }
            }
        }
    }

    public void addFamilyConnection(FamilyRelation familyConnection){
        // If famillyConnections[] array is empty add the familyConnection.
        if(familyConnections == null){
            familyConnections = new FamilyRelation[1];
            familyConnections[0] = familyConnection;
        }
        else {
            FamilyRelation[] newFamilyConnectionsArray = new FamilyRelation[familyConnections.length + 1];
            System.arraycopy(familyConnections, 0, newFamilyConnectionsArray, 0, familyConnections.length);
            newFamilyConnectionsArray[familyConnections.length] = familyConnection;
            familyConnections = newFamilyConnectionsArray;
        }

    }

    public void removeFamilyConnection(FamilyRelation familyConnection){
        // If familyConnections[] array is not empty, do the method.
        if(familyConnections != null){
            for(int i = 0; i < familyConnections.length; i++){
                if(familyConnections[i] == familyConnection){
                    for(int j = i; j < familyConnections.length; j++){
                        familyConnections[j] = familyConnections[j+1];
                    }
                    familyConnections[familyConnections.length - 1] = null;
                    break;
                }
            }
        }
    }

    public void addMedicalRecord(MedicalRecord medicalRecord){
        // ..Same logic for add methods.
        if(medicalRecords == null){
            medicalRecords = new MedicalRecord[1];
            medicalRecords[0] = medicalRecord; 
        }
        else {
            MedicalRecord[] newMedicalRecordsArray = new MedicalRecord[medicalRecords.length + 1];
            System.arraycopy(medicalRecords, 0, newMedicalRecordsArray, 0, medicalRecords.length);
            newMedicalRecordsArray[medicalRecords.length] = medicalRecord;
            medicalRecords = newMedicalRecordsArray;
        }
    }

    // Getters
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public String getComments(){
        return this.comments;
    }

    public MedicalRecord[] getMedicalRecords(){
        return this.medicalRecords;
    }

    public String getEntryDate(){
        return this.ENTRY_DATE;
    }

    public int getAssignedSocialID(){
        return this.ASSIGNED_SOCIAL_ID;
    }

    public Supply[] getPersonalBelongings(){
        return this.personalBelongings;
    }

    public FamilyRelation[] getFamilyConnections(){
        return this.familyConnections;
    }

    public String getGender(){
        return this.gender;
    }

    public static int getCounter() {
        return counter;
    }

    // Setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void setComments(String comments){
        this.comments = comments;
    }

    public void setMedicalRecords(MedicalRecord[] medicalRecords){
        this.medicalRecords = medicalRecords;
    }

    // Since this is composition, I'm not sure how to implement this.. 
    public void setPersonalBelongings(Supply[] supplies){
        this.personalBelongings = new Supply[supplies.length];
        
        for (int i = 0; i < supplies.length; i++){
            this.personalBelongings[i] = supplies[i];
        }
    }

    public void setFamilyConnections(FamilyRelation[] relation){
        this.familyConnections = relation;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
}
