package Decorator;

import Factory.IHouse;

public class WarrantyDecorator extends HouseDecorator{

    public WarrantyDecorator(IHouse decoratedHouse) {
        super(decoratedHouse);
    }

    @Override
    public void description() {
        decoratedHouse.description();
        System.out.println("Long-term warranty(50 years)"); //enhancing description
    }
    @Override
    public double getCost(){
        return decoratedHouse.getCost() + 2000; //getting this wrapper makes cost more
    }
}
