package Factory;

import Strategy.BuiltStrategy;

public class CottageFactory implements IHouseFactory{
    @Override
    public IHouse buildHouse(String address, double cost){
        return new CottageHouse(address, cost);
    }
}
