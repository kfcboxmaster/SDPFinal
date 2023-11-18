package Strategy;

public class ContextStrategy {
    BuiltStrategy strategy;
    public ContextStrategy(){
        this.strategy = null;
    }

    public void setStrategy(BuiltStrategy strategy){
        this.strategy = strategy;
    }
    public String showMaterials(){
        return strategy.showMaterials();
    }
}
