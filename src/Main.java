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
        int userAnswer;
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
                        6. Client.
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
                    ApartmentFactory apartmentFactory = new ApartmentFactory();
                    strategy = new ContextStrategy();
                    if(built.equals("Wood")){
                        strategy.setStrategy(new WoodenHouseStrategy());
                    } else {
                        strategy.setStrategy(new BrickHouseStrategy());
                    }
                    IHouse apartmentHouse = apartmentFactory.buildHouse(address, cost);
                    apartmentHouse.setBuilt(strategy.showMaterials());
                    System.out.println("Do you want additional features like warranty of built-in furniture?(Y/N)");
                    if(scanner.next().equals("Y")){
                        IHouse decorator = new HouseDecorator(apartmentHouse);
                        System.out.println("Do you want a warranty? It will add a cost of 2000(Y/N)");
                        if (scanner.next().equals("Y")){
                            decorator = new WarrantyDecorator(decorator);
                        }
                        System.out.println("Do you want a furniture? It will add a cost of 500(Y/N)");
                        if (scanner.next().equals("Y")){
                            decorator = new FurnitureDecorator(decorator);
                        }
                        constructionCompany.addHouse(decorator);
                        System.out.println("House was added to house plans. And costs " + decorator.getCost() + "$");
                        decorator.description();
                    }
                    else {
                        constructionCompany.addHouse(apartmentHouse);
                        System.out.println(apartmentHouse.toString() + " was added to house plans. ");
                        apartmentHouse.description();
                    }
                    break;
                case 2:
                    System.out.println("In what address you want to build a house?");
                    address = scanner.next();
                    System.out.println("How much funds you ready to invest?");
                    cost = scanner.nextInt();
                    System.out.println("Which material you want your house to be made of: Wood, Brick.");
                    built = scanner.next();
                    CottageFactory cottageFactory = new CottageFactory();
                    strategy = new ContextStrategy();
                    if(built.equals("Wood")){
                        strategy.setStrategy(new WoodenHouseStrategy());
                    } else {
                        strategy.setStrategy(new BrickHouseStrategy());
                    }
                    IHouse cottageHouse = cottageFactory.buildHouse(address, cost);
                    cottageHouse.setBuilt(strategy.showMaterials());
                    System.out.println("Do you want additional features like warranty of built-in furniture?(Y/N)");
                    if(scanner.next().equals("Y")){
                        IHouse decorator = new HouseDecorator(cottageHouse);
                        System.out.println("Do you want a warranty? It will add a cost of 2000(Y/N)");
                        if (scanner.next().equals("Y")){
                            decorator = new WarrantyDecorator(decorator);
                        }
                        System.out.println("Do you want a furniture? It will add a cost of 500(Y/N)");
                        if (scanner.next().equals("Y")){
                            decorator = new FurnitureDecorator(decorator);
                        }
                        constructionCompany.addHouse(decorator);
                        System.out.println(decorator.toString() + " was added to house plans. ");
                        decorator.description();
                    }
                    else {
                        constructionCompany.addHouse(cottageHouse);
                        System.out.println(cottageHouse.toString() + " was added to house plans. ");
                        cottageHouse.description();
                    }
                    break;
                case 3:
                    constructionCompany.showHousePlans();
                    break;
                case 4:
                    System.out.println("What's clients name to be added?");
                    String answer = scanner.next();
                    Observer addClient = new Client(answer);
                    constructionCompany.addObserver(addClient);
                    break;
                case 5:
                    System.out.println("What's clients name to be removed?");
                    Observer removeClient = new Client(scanner.next());
                    constructionCompany.removeObserver(removeClient);
                    break;
                case 6:
                    constructionCompany.showObservers();
                    break;

                case 9:
                    return;
            }
        }
    }
}
