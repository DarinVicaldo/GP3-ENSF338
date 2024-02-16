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

    // regex for validating the date format (YYYY-MM-DD)
    private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";

    // Constructor
    public DisasterVictim(String firstName, final String ENTRY_DATE){
        // Validate date for constructor.
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(ENTRY_DATE);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid date format.");
        }

        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = ++counter;
        
        // To fix the null errors I keep getting.
        this.familyConnections = new FamilyRelation[1];
        this.personalBelongings = new Supply[1];
    }

    // ADDITIONAL METHODS
    // Note: The "remove" and "add" methods have the same implementation and logic all throughout, just different variable names. (In other files too)
    public void addPersonalBelonging(Supply supply){
        // If personalBelongings[] array is empty add the supply.
        if (personalBelongings == null) {
            personalBelongings = new Supply[]{supply};
        } 
        // Else, make room for an extra space.
        else {
            Supply[] newBelongingsArray = new Supply[personalBelongings.length + 1];
            System.arraycopy(personalBelongings, 0, newBelongingsArray, 0, personalBelongings.length);
            newBelongingsArray[personalBelongings.length] = supply;
            personalBelongings = newBelongingsArray;
        }
    }


    public void removePersonalBelonging(Supply supply){
        // Will only performt he method if the supplies array is not empty.
        if (personalBelongings != null && personalBelongings.length > 0) {
            int removeIndex = -1;
            // Find the index to remove.
            for (int i = 0; i < personalBelongings.length; i++) {
                if (personalBelongings[i] == supply) {
                    removeIndex = i;
                    break;
                }
            }
            if (removeIndex != -1) {
                Supply[] newBelongingsArray = new Supply[personalBelongings.length - 1];
                System.arraycopy(personalBelongings, 0, newBelongingsArray, 0, removeIndex);
                System.arraycopy(personalBelongings, removeIndex + 1, newBelongingsArray, removeIndex, personalBelongings.length - removeIndex - 1);
                personalBelongings = newBelongingsArray;
            }
        }
    }

    public void addFamilyConnection(FamilyRelation familyConnection){
        // If familyConnections[] array is empty add the supply.
        if (familyConnections == null) {
             familyConnections = new FamilyRelation[1];
             familyConnections[1] = familyConnection;
        } 
        // Else, make room for an extra space.
        else {
            FamilyRelation[] newRelationsArray = new FamilyRelation[familyConnections.length + 1];
            System.arraycopy(familyConnections, 0, newRelationsArray, 0, familyConnections.length);
            newRelationsArray[personalBelongings.length] = familyConnection;
            familyConnections = newRelationsArray;
            }
    }

    public void removeFamilyConnection(FamilyRelation familyConnection){
        // Will only perform method if the familyConnections array is not empty.
        if (familyConnections != null && familyConnections.length > 0) {
            int removeIndex = -1;
            // Find the index to remove.
            for (int i = 0; i < familyConnections.length; i++) {
                if (familyConnections[i] == familyConnection) {
                    removeIndex = i;
                    break;
                }
            }
            if (removeIndex != -1) {
                FamilyRelation[] newFamilyConnectionsArray = new FamilyRelation[familyConnections.length - 1];
                System.arraycopy(familyConnections, 0, newFamilyConnectionsArray, 0, removeIndex);
                System.arraycopy(familyConnections, removeIndex + 1, newFamilyConnectionsArray, removeIndex, familyConnections.length - removeIndex - 1);
                familyConnections = newFamilyConnectionsArray;
            }
        }
    }

    public void addMedicalRecord(MedicalRecord medicalRecord){
        // If medicalRecord[] array is empty add the supply.
        if (medicalRecords == null){
            medicalRecords = new MedicalRecord[1];
            medicalRecords[1] = medicalRecord;
        }
        // Else, make room for an extra space.
        else{
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
        // Validate date for setting date of birth.
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(dateOfBirth);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid date format.");
        }

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