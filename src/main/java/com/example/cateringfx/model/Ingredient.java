package com.example.cateringfx.model;

public class Ingredient implements MenuElement{
    private double quantity;
    private Aliment aliment;

    public Ingredient(double quantity, Aliment aliment) {
        this.quantity = quantity;
        this.aliment = aliment;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Aliment getAliment() {
        return aliment;
    }

    public void setAliment(Aliment aliment) {
        this.aliment = aliment;
    }

    @Override
    public double getCalories() {
        return aliment.getCalories();
    }

    @Override
    public double getCarbohydrates() {
        return aliment.getCarbohydrates();
    }

    @Override
    public double getFat() {
        return aliment.getFat();
    }

    @Override
    public boolean hasMilk() {
        return aliment.hasMilk();
    }

    @Override
    public boolean hasNuts() {
        return aliment.hasNuts();
    }

    @Override
    public boolean hasEggs() {
        return aliment.hasEggs();
    }

    @Override
    public boolean hasGluten() {
        return aliment.hasGluten();
    }
}
