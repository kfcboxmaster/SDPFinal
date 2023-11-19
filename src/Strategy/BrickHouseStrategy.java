package Strategy;

public class BrickHouseStrategy implements BuiltStrategy{ // Concrete Strategy
    @Override
    public String showMaterials(){
        return "House is made of bricks";
    }
}
