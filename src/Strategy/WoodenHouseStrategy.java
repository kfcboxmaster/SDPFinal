package Strategy;

public class WoodenHouseStrategy implements BuiltStrategy{  // Concrete Strategy
    @Override
    public String showMaterials(){
        return "House is made of wood";
    } // Outputs the concrete strategy
}
