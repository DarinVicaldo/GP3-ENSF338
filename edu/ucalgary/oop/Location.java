package edu.ucalgary.oop;

public class Location {
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    // Constructor
    public Location(String name, String address){
        this.name = name;
        this.address = address;
        this.occupants = null;
        this.supplies = null;
    } 

    // ADDITIONAL METHODS
    public void addOccupant(DisasterVictim occupant){
        // If occupants[] array is empty add the occupant.
        if(occupants == null){
            occupants = new DisasterVictim[1];
            occupants[0] = occupant;
        }
        // Else, make room for an extra space.
        else{
            DisasterVictim[] newOccupantsArray = new DisasterVictim[occupants.length + 1];
            System.arraycopy(occupants, 0, newOccupantsArray, 0, occupants.length);
            newOccupantsArray[occupants.length] = occupant;
            occupants = newOccupantsArray;
        }
    }

    public void removeOccupant(DisasterVictim occupant){
        // Will only perform method if the occupants array is not empty.
        if (occupants != null && occupants.length > 0) {
            int removeIndex = -1;
            // Find the index to remove.
            for (int i = 0; i < occupants.length; i++) {
                if (occupants[i] == occupant) {
                    removeIndex = i;
                    break;
                }
            }
            if (removeIndex != -1) {
                DisasterVictim[] newoccupantsArray = new DisasterVictim[occupants.length - 1];
                System.arraycopy(occupants, 0, newoccupantsArray, 0, removeIndex);
                System.arraycopy(occupants, removeIndex + 1, newoccupantsArray, removeIndex, occupants.length - removeIndex - 1);
                occupants = newoccupantsArray;
            }
        }
    }

    public void addSupply(Supply supply){
        // If occupants[] array is empty add the occupant.
        if(supplies == null){
            supplies = new Supply[1];
            supplies[0] = supply;
        }
        // Else, make room for an extra space.
        else{
            Supply[] newSuppliesArray = new Supply[occupants.length + 1];
            System.arraycopy(supplies, 0, newSuppliesArray, 0, supplies.length);
            newSuppliesArray[supplies.length] = supply;
            supplies = newSuppliesArray;
        }
    }

    public void removeSupply(Supply supply){
        // Will only perform method if the supplies array is not empty.
        if (supplies != null && supplies.length > 0) {
            int removeIndex = -1;
            // Find the index to remove.
            for (int i = 0; i < supplies.length; i++) {
                if (supplies[i] == supply) {
                    removeIndex = i;
                    break;
                }
            }
            if (removeIndex != -1) {
                Supply[] newSuppliesArray = new Supply[supplies.length - 1];
                System.arraycopy(supplies, 0, newSuppliesArray, 0, removeIndex);
                System.arraycopy(supplies, removeIndex + 1, newSuppliesArray, removeIndex, supplies.length - removeIndex - 1);
                supplies = newSuppliesArray;
            }
        }
    }

    // Getters
    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public DisasterVictim[] getOccupants(){
        return this.occupants;
    }

    public Supply[] getSupplies(){
        return this.supplies;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setOccupants(DisasterVictim[] occupants){
        this.occupants = occupants;
    }

    public void setSupplies(Supply[] supplies){
        this.supplies = supplies;
    }

}