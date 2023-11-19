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
        if (instance == null) {
            instance = new ConstructionCompany();
        }
        return instance;
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    public void showObservers(){
        for(int i = 0; i < observers.size(); i++){
            System.out.println(( i + 1 ) + ". " + observers.get(i).getName());
        }
    }
    public void showHousePlans(){
        for(int i = 0; i < houses.size(); i++){
            System.out.println(( i + 1 ) + ". " + houses.get(i).getName());
        }
    }
    public void addHouse(IHouse house){
        houses.add(house);
    }
    public void removeHouse(IHouse house){
        houses.remove(house);
    }
    public void removeHouse(int index){
        houses.remove(index);
    }

}
