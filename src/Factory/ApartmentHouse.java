package Factory;

import Strategy.BuiltStrategy;

public class ApartmentHouse implements IHouse{
    private String address;
    private double cost;
    private String built;
    ApartmentHouse(String address, double cost){
        this.address = address;
        this.cost = cost;
    }
    @Override
    public String getName(){
        return address;
    }
    @Override
    public void description(){
        System.out.println("House nestled within urban or suburban landscape, multi-story buildings. ");
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
