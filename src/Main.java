import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private int reader;
    private Recipe recipe;

    public static void main(String[] args) {
        Main main = new Main();
        main.createRecipes("Recipe for Pork stew");
        main.scanner();
        main.recipeCalculations(main.recipe, main.reader);
    }

    public Main() {}

    private void scanner() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        reader  = scanner.nextInt();
    }

    private void createRecipes(String name) {
        Recipe recipe = new Recipe(name, 2);
        System.out.println("\n" + recipe.getName());
        System.out.print("How many people would you like to serve?: ");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Garlic", 2, "cloves of", 8, 3.32));
        ingredients.add(new Ingredient("Salt", 4, "tsp", 5, 0));
        ingredients.add(new Ingredient("Oil", 3.5, "tbsp", 15, 9));
        ingredients.add(new Ingredient("Ground pork", 400, "grams", 4));
        ingredients.add(new Ingredient("Tomatoes", 150, "grams", 0.56));
        ingredients.add(new Ingredient("Milk", 3, "dl", 100, 6.25));
        recipe.addIngredients(ingredients);
        this.recipe = recipe;
    }

    private void recipeCalculations(Recipe recipe, int people) {
        recipe.peopleToServe(people);

        System.out.println(recipe);
        System.out.println("\nThe total weight of this recipe is: " +
                decimalFormat.format(recipe.getTotalWeightOfRecipe()) + " grams.");
        System.out.println("This means that the average weight for an ingredient is: " + (recipe.getAverageWeight()));
        System.out.println("\nThe total energy in this recipe is: " +
                decimalFormat.format(recipe.getTotalEnergyOfRecipe()) + " KJ.");
        System.out.println("This means that the average energy for an ingredient is: " + (recipe.getAverageEnergy()));
    }

}