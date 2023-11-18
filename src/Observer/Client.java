package Observer;

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
