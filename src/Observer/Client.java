package Observer;

public class Client implements Observer{ // Observer
    private String name;
    public Client(String name){
        this.name = name;
    }
    @Override
    /*
        Outputs that the subscriber (observer) was notified
        and sends an update
     */
    public void update(String message){
        System.out.println(name + " was updated about: " + message);
    }
    @Override
    public String getName(){
        return name;
    }
}
