import Adapter.*;
import Decorator.*;
import Factory.*;
import Singleton.*;
import Observer.*;
import Strategy.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userAnswer;
        String address;
        double cost;
        String built;
        ContextStrategy strategy;
        int showDescIndex;
        CostEstimationService costEstimationService = new CostEstimationService();
        CostEstimator costEstimator = new CostEstimationAdapter(costEstimationService);
        CostEstimationOtherService costEstimationOtherService = new CostEstimationOtherService();
        CostEstimator costEstimatorOther = new CostEstimationOtherAdapter(costEstimationOtherService);

        ConstructionCompany constructionCompany = ConstructionCompany.getInstance();
        while(true){
            System.out.println("""
                        User Menu:
                        1. Make a plan for apartment.
                        3. House Plans.
                        4. Show plan description.
                        5. Add a client.
                        6. Remove a client
                        7. Client.
                        9. Exit.""");
            userAnswer = scanner.nextInt();
            switch(userAnswer){
                case 1:
                    System.out.println("In what address you want to build a house?");
                    address = scanner.next();
                    System.out.println("How much funds you ready to invest?");
                    cost = scanner.nextInt();
                    System.out.println("Which material you want your house to be made of: Wood, Brick. ");
                    built = scanner.next();
                    IHouseFactory factory;
                    String houseType;
                    System.out.println("Enter a house type: Apartment, Cottage");
                    houseType = scanner.next();
                    if(houseType.equals("Apartment")){
                        factory = new ApartmentFactory();
                    } else {
                        factory = new CottageFactory();
                    }
                    strategy = new ContextStrategy();
                    if(built.equals("Wood")){
                        strategy.setStrategy(new WoodenHouseStrategy());
                    } else {
                        strategy.setStrategy(new BrickHouseStrategy());
                    }
                    IHouse house = factory.buildHouse(address, cost);
                    house.setBuilt(strategy.showMaterials());
                    System.out.println("Do you want additional features like warranty of built-in furniture?(Y/N)");
                    if(scanner.next().equals("Y")){
                        IHouse decorator = new HouseDecorator(house);
                        System.out.println("Do you want a warranty? It will add a cost of 2000(Y/N)");
                        if (scanner.next().equals("Y")){
                            decorator = new WarrantyDecorator(decorator);
                        }
                        System.out.println("Do you want a furniture? It will add a cost of 500(Y/N)");
                        if (scanner.next().equals("Y")){
                            decorator = new FurnitureDecorator(decorator);
                        }
                        constructionCompany.addHouse(decorator);
                        System.out.println("House was added to house plans.");
                        System.out.println(strategy.showMaterials());
                        System.out.println(costEstimator.estimateCost(decorator));
                        System.out.println(costEstimatorOther.estimateCost(decorator));
                        decorator.description();
                    }
                    else {
                        constructionCompany.addHouse(house);
                        System.out.println(house.toString() + " was added to house plans. ");
                        System.out.println(strategy.showMaterials());
                        System.out.println(costEstimator.estimateCost(house));
                        System.out.println(costEstimatorOther.estimateCost(house));
                        house.description();
                    }
                    break;
                case 3:
                    constructionCompany.showHousePlans();
                    break;
                case 4:
                    if (!constructionCompany.isEmpty()) {
                        System.out.println("Which house you want to see?");
                        constructionCompany.showHousePlans();
                        showDescIndex = scanner.nextInt();
                        constructionCompany.showHouseDescription(showDescIndex-1);
                    }
                    break;
                case 5:
                    System.out.println("What's clients name to be added?");
                    String answer = scanner.next();
                    Observer addClient = new Client(answer);
                    constructionCompany.addObserver(addClient);
                    break;
                case 6:
                    System.out.println("What's clients name to be removed?");
                    Observer removeClient = new Client(scanner.next());
                    constructionCompany.removeObserver(removeClient);
                    break;
                case 7:
                    constructionCompany.showObservers();
                    break;

                case 9:
                    return;
            }
        }
    }
}
