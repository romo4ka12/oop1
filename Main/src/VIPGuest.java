public class VIPGuest extends Guest {
    private double discount;

    public VIPGuest(String name, String secondName, double discount){
        super(name, secondName);
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }

    @Override
    public String toString(){
        return super.toString() + "(VIP, Discount:" + (discount * 100) + "%)";
    }
}
