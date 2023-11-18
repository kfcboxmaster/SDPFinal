import Decorator.*;
import Factory.*;
import Singleton.*;
import Observer.*;
import Strategy.*;

import java.sql.SQLOutput;
import java.util.Scanner;
//import Adapter.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer;
        String address;
        double cost;
        String built;
        ContextStrategy strategy;
        ConstructionCompany constructionCompany = ConstructionCompany.getInstance();
        while(true){
            System.out.println("""
                        User Menu:
                        1. Make a plan for apartment.
                        2. Make a plan for cottage.
                        3. Add a client.
                        4. Clients.
                        5. House Plans.
                        9. Exit.""");
            userAnswer = scanner.nextLine();
            switch(userAnswer){
                case "1":
                    System.out.println("In what address you want to build a house?");
                    address = scanner.next();
                    System.out.println("How much funds you ready to invest?");
                    cost = scanner.nextInt();
                    System.out.println("Which material you want your house to be made of: Wood, Brick. ");
                    built = scanner.nextLine();
                    ApartmentFactory apartmentFactory = new ApartmentFactory();
                    strategy = new ContextStrategy();
                    if(built.equals("Wood")){
                        strategy.setStrategy(new WoodenHouseStrategy());
                    } else {
                        strategy.setStrategy(new BrickHouseStrategy());
                    }
                    System.out.println(strategy.showMaterials());
                    constructionCompany.addHouse(apartmentFactory.buildHouse(address, cost));
                    break;
                case "2":
                    System.out.println("In what address you want to build a house?");
                    address = scanner.next();
                    System.out.println("How much funds you ready to invest?");
                    cost = scanner.nextInt();
                    System.out.println("Which material you want your house to be made of: Wood, Brick. ");
                    built = scanner.nextLine();
                    CottageFactory cottageFactory = new CottageFactory();
                    strategy = new ContextStrategy();
                    if(built.equals("Wood")){
                        strategy.setStrategy(new WoodenHouseStrategy());
                    } else {
                        strategy.setStrategy(new BrickHouseStrategy());
                    }
                    System.out.println(strategy.showMaterials());
                    constructionCompany.addHouse(cottageFactory.buildHouse(address, cost));
                    break;
                case "3":
                    System.out.println("What's client's name?");
                    String answer = scanner.nextLine();
                    Observer observer = new Client(answer);
                    constructionCompany.addObserver(observer);
                    break;
                case "4":
                    constructionCompany.showObservers();
                    break;
                case "5":
                    constructionCompany.showHousePlans();
                    break;
            }
        }
    }
}
