package Factory;

import Strategy.BuiltStrategy;

public class ApartmentFactory implements IHouseFactory{
    @Override
    public IHouse buildHouse(String address, double cost){
        return new ApartmentHouse(address, cost);
    }
}
