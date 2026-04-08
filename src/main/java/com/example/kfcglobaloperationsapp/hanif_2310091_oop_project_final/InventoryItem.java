package com.example.hanif_2310091_oop_project_final;

public class InventoryItem {
    private String id;
    private String name;
    private int stock;

    // Constructor (this creates a new row item)
    public InventoryItem(String id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    // Getters (JavaFX NEEDS these to read the data for the columns!)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }
}