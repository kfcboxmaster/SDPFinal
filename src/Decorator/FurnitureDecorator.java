package Decorator;

import Factory.IHouse;

public class FurnitureDecorator extends HouseDecorator {
    public FurnitureDecorator(IHouse decoratedHouse) {
        super(decoratedHouse);
    }

    @Override
    public void description() {
        decoratedHouse.description();
        System.out.println("Built-in furniture");
    }
    @Override
    public double getCost(){
        return decoratedHouse.getCost() + 500;
    }
}
