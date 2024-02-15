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
    
    // addOccupant(occupant:DisasterVictim)
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

    // removeOccupant(occupant: DisasterVictim)
    public void removeOccupant(DisasterVictim occupant){
        for (int i = 0; i < occupants.length; i++){
            if(occupants[i] == occupant){
                for (int j = i; j < occupants.length; j++){
                    occupants[j] = occupants[j+1];
                }
                occupants[occupants.length - 1] = null;
                break;
            }
        }
    }

    // addSupply(supply: Supply)
    public void addSupply(Supply supply){
        for (int i = 0; i < supplies.length; i++){
            if(supplies[i] == null){
                supplies[i] = supply;
            }
        }
    }

    //  removeSupply(supply:Supply)
    public void removeSupply(Supply supply){
        for (int i = 0; i < supplies.length; i++){
            if(supplies[i] == supply){
                for (int j = i; j < supplies.length; j++){
                    supplies[j] = supplies[j + 1];
                }
                supplies[supplies.length - 1] = null;
                break;
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