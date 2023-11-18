package Factory;

import Strategy.BuiltStrategy;

public interface IHouseFactory {
    IHouse buildHouse(String address, double cost);
}
