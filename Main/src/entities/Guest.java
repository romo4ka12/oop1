package entities;

public class Guest {
    private String name;
    private String secondName;

    public Guest(String name, String secondName){
        this.name = name;
        this.secondName = secondName;
    }
    public String getName(){
        return name;
    }

    public String getSecondName(){
        return secondName;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSecondName(String secondName){
        this.secondName = secondName;
    }
    @Override
    public String toString(){
        return "entities.Guest: " + name + " " + secondName;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        else if(!(o instanceof Guest)){
            return false;
        }
        Guest guest = (Guest) o;
        return guest.name == name && guest.secondName == secondName;
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(name,secondName);
    }
}
