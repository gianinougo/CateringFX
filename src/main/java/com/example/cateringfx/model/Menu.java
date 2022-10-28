package com.example.cateringfx.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to define menu with local date and list of elements
 * @author Ugo Gianino
 * @version 1.0
 */

public class Menu {
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
}


