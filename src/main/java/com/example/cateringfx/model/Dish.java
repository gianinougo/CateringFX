package com.example.cateringfx.model;

import java.util.List;

public class Dish implements MenuElement, Nameable{

    private String name;
    private String description;
    private List<Ingredient> ingredients;

    public Dish(String name, String description, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public Dish(String name, String description) {
        this.name = name;
        this.description = description;
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
        return 0;
    }

    @Override
    public double getCarbohydrates() {
        return 0;
    }

    @Override
    public double getFat() {
        return 0;
    }

    @Override
    public boolean hasMilk() {
        return false;
    }

    @Override
    public boolean hasNuts() {
        return false;
    }

    @Override
    public boolean hasEggs() {
        return false;
    }

    @Override
    public boolean hasGluten() {
        return false;
    }

    public void addIngredients(Ingredient ingredient) {
    }
}
