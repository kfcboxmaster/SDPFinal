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
                        3. House Plans.
                        4. Add a client.
                        5. Remove a client
                        6. Clients.
                       
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
                    IHouse apartmentHouse = apartmentFactory.buildHouse(address, cost);
                    apartmentHouse.setBuilt(strategy.showMaterials());
                    constructionCompany.addHouse(apartmentHouse);
                    System.out.println(apartmentHouse.toString() + " was added to house plans. ");
                    break;
                case "2":
                    System.out.println("In what address you want to build a house?");
                    address = scanner.next();
                    System.out.println("How much funds you ready to invest?");
                    cost = scanner.nextInt();
                    System.out.println("Which material you want your house to be made of: Wood, Brick.");
                    built = scanner.nextLine();
                    CottageFactory cottageFactory = new CottageFactory();
                    strategy = new ContextStrategy();
                    if(built.equals("Wood")){
                        strategy.setStrategy(new WoodenHouseStrategy());
                    } else {
                        strategy.setStrategy(new BrickHouseStrategy());
                    }
                    IHouse cottageHouse = cottageFactory.buildHouse(address, cost);
                    cottageHouse.setBuilt(strategy.showMaterials());
                    constructionCompany.addHouse(cottageHouse);
                    System.out.println(cottageHouse.toString() + " was added to house plans. ");
                    break;
                case "3":
                    constructionCompany.showHousePlans();
                    break;
                case "4":
                    System.out.println("What's clients name to be added?");
                    String answer = scanner.nextLine();
                    Observer addClient = new Client(answer);
                    constructionCompany.addObserver(addClient);
                    break;
                case "5":
                    System.out.println("What's clients name to be removed?");
                    Observer removeClient = new Client(scanner.nextLine());
                    constructionCompany.removeObserver(removeClient);
                    break;
                case "6":
                    constructionCompany.showObservers();
                    break;
                case "9":
                    return;
            }
        }
    }
}
