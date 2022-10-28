package com.example.cateringfx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to define Dishes
 * @author Ugo Gianino
 */
public class Dish implements MenuElement, Nameable{

    private String name;
    private String description;
    private List<Ingredient> ingredients;

    public Dish(String name, String description) {
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<>();
    }

    /**
     * Gets the Aliment name.
     * @return Aliment name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Aliment name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Aliment description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Aliment description.
     * @param description
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Aliment ingredients.
     * @return List of ingredients
     */

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Sets the Aliment ingredients.
     * @param ingredients
     */

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Get an calories to the Aliment.
     * @return calories.
     */
    @Override
    public double getCalories() {

        double calories = 0;

        int n = this.ingredients.size();

        for (Ingredient ingredient : this.ingredients){
            calories += (ingredient.getQuantity() * ingredient.getCalories());
        }
        return calories;
    }

    /**
     * Get an carbohydrates to the Aliment.
     * @return carbohydrates.
     */
    @Override
    public double getCarbohydrates() {
        double carbohydrates = 0;

        int n = this.ingredients.size();

        for (Ingredient ingredient : this.ingredients){
            carbohydrates += (ingredient.getQuantity() * ingredient.getCarbohydrates());
        }
        return carbohydrates;
    }

    /**
     * Get fat to the Aliment.
     * @return fat.
     */
    @Override
    public double getFat() {
        double Fat = 0;

        int n = this.ingredients.size();

        for (Ingredient ingredient : this.ingredients){
            Fat += (ingredient.getQuantity() * ingredient.getFat());
        }
        return Fat;
    }

    /**
     * Get milk to the Aliment.
     * @return milk
     */
    @Override
    public boolean hasMilk() {
        boolean hasMilk = false;
        int n = this.ingredients.size();

        for (int i = 0; i < n && !hasMilk; i++) {
            Ingredient ingredient = this.ingredients.get(i);
            if (ingredient.hasGluten()){
                hasMilk = true;

            }
        }
        return hasMilk;
    }

    /**
     * Get nuts to the Aliment.
     * @return nuts
     */
    @Override
    public boolean hasNuts() {
        boolean hasNuts = false;
        int n = this.ingredients.size();

        for (int i = 0; i < n && !hasNuts; i++) {
            Ingredient ingredient = this.ingredients.get(i);
            if (ingredient.hasGluten()){
                hasNuts = true;

            }
        }
        return hasNuts;
    }

    /**
     * Get egg to the Aliment.
     * @return eggs
     */
    @Override
    public boolean hasEggs() {
        boolean hasEggs = false;
        int n = this.ingredients.size();

        for (int i = 0; i < n && !hasEggs; i++) {
            Ingredient ingredient = this.ingredients.get(i);
            if (ingredient.hasGluten()){
                hasEggs = true;

            }
        }
        return hasEggs;
    }

    /**
     * Get gluten to the Aliment.
     * @return hasGluten
     */
    @Override
    public boolean hasGluten() {

        boolean hasGluten = false;
        int n = this.ingredients.size();

        for (int i = 0; i < n && !hasGluten; i++) {
            Ingredient ingredient = this.ingredients.get(i);
            if (ingredient.hasGluten()){
                hasGluten = true;

            }
        }
        return hasGluten;
        
    }

    /**
     * Get add to the Aliment.
     * @param ingredient
     */
    public void addIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
