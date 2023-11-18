package Decorator;

import Strategy.BuiltStrategy;

public class WarantyDecorator extends HouseDecorator{
    WarantyDecorator(BuiltStrategy strategy) {
        super(strategy);
    }

    @Override
    public String showMaterials(){
        return strategy.showMaterials() + addFurniture();
    }
    public String addFurniture() {
        return " After purchase house will have warranty for 20 years. ";
    }
}
