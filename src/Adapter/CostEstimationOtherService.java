package Adapter;

public class CostEstimationOtherService {

    public double getCost(String houseType, double baseCost) {
        //estimates price based on houseType
        return switch (houseType) {
            case "Wood" -> baseCost * 1.2;
            case "Brick" -> baseCost * 1.5;
            default -> 0;
        };
    }
}
