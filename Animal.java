//Class
public class Animal {

    //Constants
    public enum Type { DOG, CAT } 

    //Constructor
    private String name;
    private Type type;
    private long arrivalTime; 

    public Animal(String name, Type type, long arrivalTime) {
        this.name = name;
        this.type = type;
        this.arrivalTime = arrivalTime;
    }
    
    //Get
    public String getName() { return name; }
    public Type getType() { return type; }
    public long getArrivalTime() { return arrivalTime; }

}

