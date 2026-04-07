package com.dto;

public class CategorieDTO {
    
    private int id;       // This is for the Item ID
    private int catId;    // FIX: Add this for the Category ID
    private String name;

    // --- Getters and Setters ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatId() { // FIX: Add this getter
        return catId;
    }

    public void setCatId(int catId) { // FIX: Add this setter
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}