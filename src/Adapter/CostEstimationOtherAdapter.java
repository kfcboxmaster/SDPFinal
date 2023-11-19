package Adapter;

import Factory.IHouse;

public class CostEstimationOtherAdapter implements CostEstimator{

    private final CostEstimationOtherService costEstimationOtherService;

    public CostEstimationOtherAdapter(CostEstimationOtherService costEstimationService) {
        this.costEstimationOtherService = costEstimationService;
    }

    @Override
    public double estimateCost(IHouse house) {
        String built = house.getBuilt();
        if(built.equals("House is made of wood")) {
            built = "Wood";
        } else {
            built = "Brick";
        }
        System.out.println("Estimating cost for " + built + " with base cost " + house.getCost() + "$");
        return costEstimationOtherService.getCost(built, house.getCost());
    }
}
