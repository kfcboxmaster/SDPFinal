package Decorator;

import Factory.IHouse;

public class FurnitureDecorator extends HouseDecorator {
    public FurnitureDecorator(IHouse decoratedHouse) {
        super(decoratedHouse);
    }

    @Override
    public void description() {
        decoratedHouse.description();
        System.out.println("Built-in furniture"); //enhancing description
    }
    @Override
    public double getCost(){
        return decoratedHouse.getCost() + 500;
    } //getting this wrapper makes cost more
}
