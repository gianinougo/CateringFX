package com.example.cateringfx.model;

import java.util.ArrayList;
import java.util.List;

public class Dish implements MenuElement, Nameable{

    private String name;
    private String description;
    private List<Ingredient> ingredients;

    public Dish(String name, String description) {
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public double getCalories() {

        double calories = 0;

        int n = this.ingredients.size();

        for (Ingredient ingredient : this.ingredients){
            calories += (ingredient.getQuantity() * ingredient.getCalories());
        }
        return calories;
    }

    @Override
    public double getCarbohydrates() {
        double carbohydrates = 0;

        int n = this.ingredients.size();

        for (Ingredient ingredient : this.ingredients){
            carbohydrates += (ingredient.getQuantity() * ingredient.getCarbohydrates());
        }
        return carbohydrates;
    }

    @Override
    public double getFat() {
        double Fat = 0;

        int n = this.ingredients.size();

        for (Ingredient ingredient : this.ingredients){
            Fat += (ingredient.getQuantity() * ingredient.getFat());
        }
        return Fat;
    }

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

    public void addIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
