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
}
