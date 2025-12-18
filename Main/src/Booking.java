public class Booking {
    private Room room;
    private Guest guest;
    private int nights;

    public Booking(Room room,Guest guest, int nights){
        this.room = room;
        this.guest = guest;
        this.nights = nights;
    }

    public double calculateTotalPrice(){
        return room.getPricePerNight() * nights;
    }

    public Room getRoom(){
        return room;
    }

    public Guest getGuest(){
        return guest;
    }

    public int getNights(){
        return nights;
    }
}
