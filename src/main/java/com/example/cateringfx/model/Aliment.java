package com.example.cateringfx.model;

public class Aliment implements MenuElement , Nameable{

    private String name;
    private String description;
    private String frecuency;
    private double calories;
    private double fat;
    private double carbohydrates;
    private boolean nuts;
    private boolean milk;
    private boolean eggs;
    private boolean gluten;

    public Aliment(String name, String description, String frecuency,
                   boolean nuts, boolean milk, boolean eggs, boolean gluten,
                   double calories, double fat, double carbohydrates) {
        this.name = name;
        this.description = description;
        this.frecuency = frecuency;
        this.calories = calories;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.nuts = nuts;
        this.milk = milk;
        this.eggs = eggs;
        this.gluten = gluten;
    }

    public Aliment() {

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

    public String getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(String frecuency) {
        this.frecuency = frecuency;
    }

    @Override
    public double getCalories() {
        return this.calories;
    }

    @Override
    public double getCarbohydrates() {
        return this.carbohydrates;
    }

    @Override
    public double getFat() {
        return this.fat;
    }

    @Override
    public boolean hasMilk() {
        return this.milk;
    }

    @Override
    public boolean hasNuts() {
        return this.nuts;
    }

    @Override
    public boolean hasEggs() {
        return this.eggs;
    }

    @Override
    public boolean hasGluten() {
        return this.gluten;
    }


}
