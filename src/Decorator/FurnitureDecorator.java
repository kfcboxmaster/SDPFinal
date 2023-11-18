package Decorator;

import Strategy.BuiltStrategy;

public class FurnitureDecorator extends HouseDecorator{
    FurnitureDecorator(BuiltStrategy strategy) {
        super(strategy);
    }

    @Override
    public String showMaterials(){
        return strategy.showMaterials() + addFurniture();
    }
    public String addFurniture() {
        return " This house also has a builder company's furniture.";
    }
}
