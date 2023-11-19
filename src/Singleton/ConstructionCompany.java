package Singleton;

import Factory.IHouseFactory;
import Observer.*;
import Factory.IHouse;

import java.util.ArrayList;
import java.util.List;

public class ConstructionCompany {
    private static ConstructionCompany instance;
    public static List<IHouse> houses = new ArrayList<>();
    public static List<Observer> observers = new ArrayList<>();
    public static ConstructionCompany getInstance(){
        /*
            `getInstance()` function makes sure that the
            instance of this class won't be initialized more
            than once.
         */
        if (instance == null) { // checking if the Class was already initialized
            instance = new ConstructionCompany(); // if no, the instance will be created
        }
        return instance; // returning a variable which stores the instance of this Class
    }
    public void addObserver(Observer observer) {
        observers.add(observer); // Adding an observer (subscriber) into the ArrayList of Subscribers
    }
    public void removeObserver(Observer observer) {
        /*
            Removing an observer(subscriber) from the ArrayList of Subscribers
         */
        observers.removeIf(o -> o.getName().equals(observer.getName()));
    }
    public void notifyObservers(String message) {
        /*
            Function that notifies the observers
            once the changes happen in the
            `Observable class` (Constructor Company Class)
         */
        for (Observer observer : observers) {
            /*
            `For-Each` loop which iterates through the
            list of observers and invokes the `update()` method
            that they have
             */
            observer.update(message);
        }
    }
    public void showObservers(){
        /*
        Function displays the observer list
        in the CLI using `For-Loop`
         */
        for(int i = 0; i < observers.size(); i++){
            System.out.println(( i + 1 ) + ". " + observers.get(i).getName());
        }
    }
    public void showHousePlans(){
        /*
        Function displays the house plan list
        in the CLI using `For-Loop`
         */
        for(int i = 0; i < houses.size(); i++){
            System.out.println(( i + 1 ) + ". " + houses.get(i).getName());
        }
    }
    public void showHouseDescription(int index){ // Displays house description
        houses.get(index).description();
    }
    public void addHouse(IHouse house){ // Adds house into the `houses` ArrayList
        this.notifyObservers("New house plan was added to house plans.");
        houses.add(house);
    }
    public boolean isEmpty() { // Defines if the `houses` list is empty
        return houses.isEmpty();
    }
    public void removeHouse(IHouse house){ // Removes house with the reference
        houses.remove(house);
    }
    public void removeHouse(int index){ // Removes house with the index
        houses.remove(index);
    }

}
