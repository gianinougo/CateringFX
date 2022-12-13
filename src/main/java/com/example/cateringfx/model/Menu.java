package com.example.cateringfx.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to define menu with local date and list of elements
 * @author Ugo Gianino
 * @version 1.0
 */

public class Menu implements MenuElement{
    private LocalDate date;
    private List<MenuElement> elements;

    public Menu(LocalDate date) {
        this.date = date;
        this.elements = new ArrayList<>();
    }

    /**
     * Get date
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * get value
     * @return value
     */
    public LocalDate getValue() {
        return date;
    }

    /**
     * Set date
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Get elements
     * @return elements
     */
    public List<MenuElement> getElements() {
        return elements;
    }

    /**
     * Set elements
     * @param elements
     */
    public void setElements(List<MenuElement> elements) {
        this.elements = elements;
    }

    public void addNewElement(MenuElement newMenuElement){
        elements.add(newMenuElement);
    }

    @Override
    public double getCalories() {
        return elements.stream().mapToDouble(MenuElement::getCalories).sum();
    }

    @Override
    public double getCarbohydrates() {
        return elements.stream().mapToDouble(MenuElement::getCarbohydrates).sum(); }

    @Override
    public double getFat() {
        return elements.stream().mapToDouble(MenuElement::getFat).sum(); }


    @Override
    public boolean hasMilk() {
        return elements.stream().anyMatch(MenuElement::hasMilk); }

    @Override
    public boolean hasNuts() {
        return elements.stream().anyMatch(MenuElement::hasNuts); }

    @Override
    public boolean hasEggs() {
        return elements.stream().anyMatch(MenuElement::hasEggs); }

    @Override
    public boolean hasGluten() {
        return elements.stream().anyMatch(MenuElement::hasGluten); }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuilder result= new StringBuilder(date.format(formatter)+";");
        for (MenuElement m: elements) {
            result.append(m.toString());
        }
        return result.toString();
    }
}


