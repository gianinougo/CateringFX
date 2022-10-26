package com.example.cateringfx.model;

import java.time.LocalDate;
import java.util.List;

public class Menu {
    private LocalDate date;
    private List<MenuElement> elements;

    public Menu(LocalDate date, List<MenuElement> elements) {
        this.date = date;
        this.elements = elements;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<MenuElement> getElements() {
        return elements;
    }

    public void setElements(List<MenuElement> elements) {
        this.elements = elements;
    }
}


