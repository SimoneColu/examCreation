package it.polito.temperatureControl;

public class Parking {
    private String name;
    private int parkingSlots;
   
    public Parking(String name, int parkingSlots) {
        this.name = name;
        this.parkingSlots = parkingSlots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(int parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    

}
