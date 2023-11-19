package Factory;

import Strategy.BuiltStrategy;

public class CottageFactory implements IHouseFactory{
    /*
    Creation of cottage house
     */
    @Override
    public IHouse buildHouse(String address, double cost){
        return new CottageHouse(address, cost);
    }
}
