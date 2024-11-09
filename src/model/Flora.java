package model;

public class Flora extends Species{

    private boolean flowes;
    private boolean fruits;
    private double maxHeight;
    public Flora(String name, String scientificName, boolean flowes, boolean fruits, double maxHeight){

        super(name, scientificName);
        this.flowes = flowes;
        this.fruits = fruits;
        this.maxHeight = maxHeight;
    }
    public boolean isFlowes() {
        return flowes;
    }
    public void setFlowes(boolean flowes) {
        this.flowes = flowes;
    }
    public boolean isFruits() {
        return fruits;
    }
    public void setFruits(boolean fruits) {
        this.fruits = fruits;
    }
    public double getMaxHeight() {
        return maxHeight;
    }
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }
    @Override
    public String toString() {
        return super.toString() + 
        "\n It has flowers?: " + flowes + 
        "\n It has fruits?: " + fruits + 
        "\n Max Height: " + maxHeight;
    }

    

    
}
