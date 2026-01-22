package entities;

public class Room {
    private int roomNumber;
    private double pricePerNight;
    private boolean available;

    public Room(int roomNumber, double pricePerNight, boolean available){
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public int getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public double getPricePerNight(){
        return pricePerNight;
    }
    public void setPricePerNight(double pricePerNight){
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable(){
        return available;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }

    @Override
    public String toString(){
        if(available) {
            return "entities.Room #" + roomNumber + "($" + pricePerNight + " per night, is " + "available" + ")";
        }
        else{
            return "entities.Room #" + roomNumber + "($" + pricePerNight + " per night, is " + "not available" + ")";
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return roomNumber == room.roomNumber;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(roomNumber);
    }
}
