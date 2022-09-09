import java.text.DecimalFormat;

public class Ingredient {
    final static DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private String name;
    private double amount;
    private String measurement;
    private double weightPrUnit;
    private double energyPrUnit;
    private double servingAmount;
    private double servingWeight;
    private double servingEnergy;
    private int servings;

    public Ingredient(String name, double amount, String measurement, double energyPrUnit) {
        this.name = name;
        this.amount = amount;
        this.measurement = measurement;
        this.weightPrUnit = 1;
        this.energyPrUnit = energyPrUnit;
    }
    public Ingredient(String name, double amount, String measurement, double grams, double energyPrUnit) {
        this.name = name;
        this.amount = amount;
        this.measurement = measurement;
        this.weightPrUnit = grams;
        this.energyPrUnit = energyPrUnit;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setServingAmount(int people) {
        this.servingAmount = this.amount / this.servings * people;
    }

    public void weightPrUnit() {
        this.servingWeight = this.weightPrUnit * this.servingAmount;
    }

    public void energyPrServing() {
        this.servingEnergy = this.energyPrUnit * this.servingWeight;
    }

    public double getServingWeight() {
        return this.servingWeight;
    }

    public double getServingEnergy() {
        return this.servingEnergy;
    }

    public String toString() {
        String ingredient = decimalFormat.format(this.servingAmount) + " " + this.measurement +
                " " + this.name + " is " + decimalFormat.format(this.servingWeight) +
                " grams. Which is: " + decimalFormat.format(servingEnergy) + "KJ.";
        return ingredient;
    }

}
