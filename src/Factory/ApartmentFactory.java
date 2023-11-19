package Factory;

import Strategy.BuiltStrategy;

public class ApartmentFactory implements IHouseFactory{
    /*
    Creation of CottageHouse in Factory pattern
     */
    @Override
    public IHouse buildHouse(String address, double cost){
        return new ApartmentHouse(address, cost);
    }
}
