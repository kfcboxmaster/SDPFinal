package Adapter;

import Factory.IHouse;

public class CostEstimationAdapter implements CostEstimator {
    private CostEstimationService costEstimationService;

    public CostEstimationAdapter(CostEstimationService costEstimationService) {
        this.costEstimationService = costEstimationService;
    }

    @Override
    public double estimateCost(IHouse house) {
        String houseBuilt = house.getBuilt();
        double baseCost = house.getCost();
        System.out.println("Estimating cost for your house from PredictHouseCost.Service with base cost " + baseCost + "$");
        return costEstimationService.estimateCost(houseBuilt, baseCost);
    }
}
