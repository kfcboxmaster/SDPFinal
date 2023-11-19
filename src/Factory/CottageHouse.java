package Factory;
/*
Concrete Product in Factory pattern
 */
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
    /*
    This method will be modified through Decorator pattern
     */
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
    @Override
    public double getCost(){
        return cost;
    }

    @Override
    public String getBuilt() {
        return built;
    }
}
