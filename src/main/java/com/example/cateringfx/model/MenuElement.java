package com.example.cateringfx.model;

/**
 * Interface MenuElent
 * @author Ugo Gianino
 * @version 1.0
 */
public interface MenuElement {

    public double getCalories();
    public double getCarbohydrates();
    public double getFat();
    public boolean hasMilk();
    public boolean hasNuts();
    public boolean hasEggs();
    public boolean hasGluten();

}
