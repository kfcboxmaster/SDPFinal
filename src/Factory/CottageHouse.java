package Factory;

public class CottageHouse implements IHouse{
    private String address;
    private double cost;
    private String built;
    CottageHouse(String address, double cost){
        this.address = address;
        this.cost = cost;
    }
    @Override
    public String getName(){
        return address;
    }
    @Override
    public void description(){
        System.out.println("House with its own land garden. Nestled within one-story building. ");
    }
    @Override
    public void setBuilt(String built){
        this.built = built;
    }
    @Override
    public String toString(){
        return address + " | " + cost + "$ | " + built;
    }
}
