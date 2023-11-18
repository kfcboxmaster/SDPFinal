package Decorator;

import Strategy.BuiltStrategy;

public abstract class HouseDecorator implements BuiltStrategy {
    protected BuiltStrategy strategy;
    HouseDecorator(BuiltStrategy strategy){
        this.strategy = strategy;
    }
    @Override
    public abstract String showMaterials();
}
