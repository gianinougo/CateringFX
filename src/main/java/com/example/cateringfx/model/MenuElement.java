package com.example.cateringfx.model;

public abstract interface MenuElement {

    public double getCalories();
    public double getCarbohydrates();
    public double getFat();
    public boolean hasMilk();
    public boolean hasNuts();
    public boolean hasEggs();
    public boolean hasGluten();

}
