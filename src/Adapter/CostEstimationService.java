package Adapter;

public class CostEstimationService {
    public double estimateCost(String houseType, double baseCost) {
        // Здесь подхватываем информацию с сервиса по оценке
        return baseCost * 1.2; // Типо подхватили с сервиса
    }
}
