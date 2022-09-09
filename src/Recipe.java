import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private int peopleToServe;
    private String name;
    private List<Ingredient> ingredients;
    private double totalWeightOfRecipe;
    private double totalEnergyOfRecipe;

    public Recipe (String name, int people) {
        this.name = name;
        this.peopleToServe = people;
        ingredients = new ArrayList<>();
    }

    public void peopleToServe(int amountOfPeopleServed) {
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.get(i).setServings(this.peopleToServe);
            ingredients.get(i).setServingAmount(amountOfPeopleServed);
            ingredients.get(i).weightPrUnit();
            ingredients.get(i).energyPrServing();
        }
    }

    public double getTotalWeightOfRecipe(){
        for (int i = 0; i < ingredients.size(); i++) {
            totalWeightOfRecipe += ingredients.get(i).getServingWeight();
        }
        return totalWeightOfRecipe;
    }

    public double getTotalEnergyOfRecipe(){
        for (int i = 0; i < ingredients.size(); i++) {
            totalEnergyOfRecipe += ingredients.get(i).getServingEnergy();
        }
        return totalEnergyOfRecipe;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return ingredients.size();
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addIngredients(List<Ingredient> ingredientList) {
        for (int i = 0; i < ingredientList.size(); i++) {
            this.ingredients.add(ingredientList.get(i));
        }
    }

    public double getAverageWeight(){
        double averageWeight = totalWeightOfRecipe/ ingredients.size();
        return averageWeight;
    }

    public double getAverageEnergy(){
        double averageEnergy = totalEnergyOfRecipe/ ingredients.size();
        return averageEnergy;
    }

    public String toString() {
        String printRecipe = "";
        for (int i = 0; i < ingredients.size(); i++) {
            printRecipe += (ingredients.get(i).toString() + "\n");
        }
        return printRecipe;
    }

}
