package Adapter;
import Factory.IHouse;

public interface CostEstimator {
    double estimateCost(IHouse house);
}

