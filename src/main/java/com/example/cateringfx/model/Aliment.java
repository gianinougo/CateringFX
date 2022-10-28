package com.example.cateringfx.model;

/**
 * Class defining what a food looks like
 * @author Ugo Gianino
 * @version 1.0
 *
 */

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

    /**
     * Gets the Aliment name.
     * @return Aliment name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Aliment name.
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
     * Set the Aliment description.
     * @param description
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Aliment frecuency.
     * @return
     */

    public String getFrecuency() {
        return frecuency;
    }

    /**
     * Set the Aliment frecuency.
     * @param frecuency
     */

    public void setFrecuency(String frecuency) {
        this.frecuency = frecuency;
    }

    /**
     * Gets the Aliment calories.
     * @return
     */

    @Override
    public double getCalories() {
        return this.calories;
    }

    /**
     * Get the Aliment carbohydrates.
     * @return carbohydrates
     */

    @Override
    public double getCarbohydrates() {
        return this.carbohydrates;
    }

    /**
     * Set the Aliment fat.
     * @return fat
     */
    @Override
    public double getFat() {
        return this.fat;
    }

    /**
     * Get the Aliment has milk.
     * @return milk
     */

    @Override
    public boolean hasMilk() {
        return this.milk;
    }

    /**
     * Get the Aliment has nuts.
     * @return has nuts
     */

    @Override
    public boolean hasNuts() {
        return this.nuts;
    }

    /**
     * Get the Aliment has eggs.
     * @return eggs
     */

    @Override
    public boolean hasEggs() {
        return this.eggs;
    }

    /**
     * Get the Aliment has gluten.
     * @return gluten
     */
    @Override
    public boolean hasGluten() {
        return this.gluten;
    }

    /**
     * Overrides toString method to get the aliment data
     * @return Aliment data
     */
    @Override
    public String toString() {
        return  name
                + ";" +description
                + ";" +frecuency
                + ";" +gluten
                + ";" +milk
                + ";" +nuts
                + ";" +eggs
                + ";" +calories
                + ";" + carbohydrates
                + ";" +fat
                ;
    }

}
