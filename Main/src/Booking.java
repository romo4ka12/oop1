public class Booking {
    private Room room;
    private Guest guest;
    private int nights;

    public Booking(Room room,Guest guest, int nights){
        this.room = room;
        this.guest = guest;
        if(isValidNights(nights)) {
            this.nights = nights;
        }
        else{
            this.nights = 0;
        }
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

    private boolean isValidNights(int nights){
        return nights > 0 && nights <= 31;
    }

    public double calculateTotalPrice(){
        double price = room.getPricePerNight() * nights;
        if(guest instanceof VIPGuest){
            VIPGuest vip = (VIPGuest) guest;
            price = price * (1 - vip.getDiscount());
        }
        return price;
    }

    @Override
    public String toString(){
        return "Booking details: \n" + guest.toString() +"\n" + room.toString() + "\n" + "Duration:" + nights + "nights \n" + "Total Price: " + calculateTotalPrice() + " Tenge";
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Booking)){
            return false;
        }
        Booking booking = (Booking) o;
        return nights == booking.nights && java.util.Objects.equals(room, booking.room) && java.util.Objects.equals(guest, booking.guest);
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(room, guest, nights);
    }
}
