# Design Patterns in this Project

## Adapter Pattern

The Adapter pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate. It's often used when you want to make your existing classes work with others without modifying their source code.

In this project, the Adapter pattern is used to adapt the interface of a third-party `CostEstimationService` to the `CostEstimator` interface used in the application.

```java
public interface CostEstimator {
    double estimateCost(IHouse house);
}

public class CostEstimationAdapter implements CostEstimator {
    private CostEstimationService costEstimationService;

    public CostEstimationAdapter(CostEstimationService costEstimationService) {
        this.costEstimationService = costEstimationService;
    }

    @Override
    public double estimateCost(IHouse house) {
        String houseBuilt = house.getBuilt();
        double baseCost = house.getCost();
        return costEstimationService.estimateCost(houseBuilt, baseCost);
    }
}
```

## Observer Pattern

The Observer pattern is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.

In this project, the Observer pattern is used to notify `Client` objects about updates in the `ConstructionCompany`.

```java
public interface Observer {
    void update(String message);
    String getName();
}

public class Client implements Observer{
    private String name;
    public Client(String name){
        this.name = name;
    }
    @Override
    public void update(String message){
        System.out.println(name + " was updated about: " + message);
    }
    @Override
    public String getName(){
        return name;
    }
}
```

## Factory Pattern

The Factory Method pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

In this project, the Factory pattern is used to create different types of `IHouse` objects.

```java
public interface IHouseFactory {
    IHouse buildHouse(String address, double cost);
}

public class ApartmentFactory implements IHouseFactory{
    @Override
    public IHouse buildHouse(String address, double cost){
        return new ApartmentHouse(address, cost);
    }
}
```

## Decorator Pattern

The Decorator pattern is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

In this project, the Decorator pattern is used to add additional features to `IHouse` objects.

```java
public class HouseDecorator implements IHouse{
    protected IHouse decoratedHouse;

    public HouseDecorator(IHouse decoratedHouse) {
        this.decoratedHouse = decoratedHouse;
    }

    @Override
    public String getName() {
        return decoratedHouse.getName();
    }

    @Override
    public void description() {
        decoratedHouse.description();
        System.out.println("This house also has additional features like: ");
    }

    @Override
    public double getCost(){
        return decoratedHouse.getCost();
    }
}
```

## Strategy Pattern

The Strategy pattern is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

In this project, the Strategy pattern is used to select the materials used to build a house.

```java
public interface BuiltStrategy {
    String showMaterials();
}

public class WoodenHouseStrategy implements BuiltStrategy{
    @Override
    public String showMaterials(){
        return "House is made of wood";
    }
}
```
## Singleton Pattern

The Singleton pattern is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

In this project, the Singleton pattern is used in the `ConstructionCompany` class. This class represents a construction company that manages houses and observers (clients). The Singleton pattern ensures that there is only one instance of the `ConstructionCompany` class in the application, providing a global point of access to it.

Here is the relevant code snippet from `ConstructionCompany.java`:

```java
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
    // Other methods...
}
```

In this code, the `ConstructionCompany` class has a private static variable `instance` that holds the single instance of the class. The `getInstance()` method returns this instance, creating it if it doesn't exist. This ensures that there is only one `ConstructionCompany` instance in the application.

## Installation
- Required JDK 21.0.1
- Open terminal
- `git clone https://github.com/kfcboxmaster/SDPFinal/`
- `cd SDPFinal`
- `Open in IntelliJ IDEA`
- `Run Main.java`