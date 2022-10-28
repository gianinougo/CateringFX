package com.example.cateringfx.model;

/**
 * Class Ingredients
 * @author Ugo Gianino
 */
public class Ingredient implements MenuElement{
    private double quantity;
    private Aliment aliment;

    public Ingredient(double quantity, Aliment aliment) {
        this.quantity = quantity;
        this.aliment = aliment;
    }

    /**
     * Get the quantity
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity
     * @param quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the aliment
     * @return aliment
     */
    public Aliment getAliment() {
        return aliment;
    }

    /**
     * Set the aliment
     * @param aliment
     */
    public void setAliment(Aliment aliment) {
        this.aliment = aliment;
    }

    /**
     * Get the calories
     * @return calories
     */
    @Override
    public double getCalories() {
        return aliment.getCalories();
    }

    /**
     * Get the getCarbohydrates
     * @return Carbohydrates
     */
    @Override
    public double getCarbohydrates() {
        return aliment.getCarbohydrates();
    }

    /**
     * Get the Fat
     * @return getFat
     */
    @Override
    public double getFat() {
        return aliment.getFat();
    }

    /**
     * Get the Milk
     * @return hasMilk
     */
    @Override
    public boolean hasMilk() {
        return aliment.hasMilk();
    }

    /**
     * Get the Nuts
     * @return nuts
     */
    @Override
    public boolean hasNuts() {
        return aliment.hasNuts();
    }

    /**
     * Get the eggs
     * @return eggs
     */
    @Override
    public boolean hasEggs() {
        return aliment.hasEggs();
    }

    /**
     * Get the gluten
     * @return gluten
     */
    @Override
    public boolean hasGluten() {
        return aliment.hasGluten();
    }
}
