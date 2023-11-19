package Decorator;

import Factory.IHouse;

public class HouseDecorator implements IHouse{
    protected IHouse decoratedHouse;

    public HouseDecorator(IHouse decoratedHouse) {
        this.decoratedHouse = decoratedHouse;
    }

    @Override
    public String getName() {
        return decoratedHouse.getName();
    }

    @Override
    public void description() {
        decoratedHouse.description();
        System.out.println("This house also has additional features like: ");
    }

    @Override
    public void setBuilt(String built) {
        decoratedHouse.setBuilt(built);
    }

    @Override
    public String toString() {
        return decoratedHouse.toString();
    }
    @Override
    public double getCost(){
        return decoratedHouse.getCost();
    }
}
