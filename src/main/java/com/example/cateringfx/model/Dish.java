package com.example.cateringfx.model;

/*
Cambiar for por stream;
hacer parte optavia new dish;
 */
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

/*        double calories = 0;

        int n = this.ingredients.size();

        for (Ingredient ingredient : this.ingredients){
            calories += (ingredient.getQuantity() * ingredient.getCalories());
        }
        return calories;*/

        return ingredients.stream().mapToDouble(p-> p.getAliment().getCalories()).sum();

        //Stream


    }

    /**
     * Get an carbohydrates to the Aliment.
     * @return carbohydrates.
     */
    @Override
    public double getCarbohydrates() {
        return ingredients.stream().mapToDouble(p-> p.getAliment().getCarbohydrates()).sum();
    }

    /**
     * Get fat to the Aliment.
     * @return fat.
     */
    @Override
    public double getFat() {
        return ingredients.stream().mapToDouble(p-> p.getAliment().getFat()).sum();
    }

    /**
     * Get milk to the Aliment.
     * @return milk
     */
    @Override
    public boolean hasMilk() {
        return ingredients.stream().anyMatch(p-> p.getAliment().hasMilk());
    }

    /**
     * Get nuts to the Aliment.
     * @return nuts
     */
    @Override
    public boolean hasNuts() {
        return ingredients.stream().anyMatch(p-> p.getAliment().hasNuts());
    }

    /**
     * Get egg to the Aliment.
     * @return eggs
     */
    @Override
    public boolean hasEggs() {
        return ingredients.stream().anyMatch(p-> p.getAliment().hasEggs());
    }

    /**
     * Get gluten to the Aliment.
     * @return hasGluten
     */
    @Override
    public boolean hasGluten() {

        return ingredients.stream().anyMatch(p-> p.getAliment().hasGluten());
        
    }

    /**
     * Get add to the Aliment.
     * @param ingredient
     */
    public void addIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }




    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getName() + ";" + getDescription()+";");
        for (Ingredient ingredient: ingredients) {
            result.append(ingredient.toString());
        }
        return result.toString();
    }
}
