package model;

public class Fauna extends Species{
    private boolean migratory;
    private double maxWeight;
    public Fauna(String name, String scientificName, boolean migratory, double maxWeight){

        super(name, scientificName);
        this.migratory = migratory;
        this.maxWeight = maxWeight;

    }
    public boolean isMigratory() {
        return migratory;
    }
    public void setMigratory(boolean migratory) {
        this.migratory = migratory;
    }
    public double getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
    @Override
    public String toString() {
        return super.toString() + 
        "\n Migratory state: " + migratory + 
        "\n Max Weight: " + maxWeight;
    }

    
    
    
}
