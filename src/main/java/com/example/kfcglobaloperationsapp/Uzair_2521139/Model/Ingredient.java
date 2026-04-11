package com.example.kfcglobaloperationsapp.Uzair_2521139.Model;

public class Ingredient {

    private int ingredientId;
    private String name;
    private int currentStock, minimumThreshold;
//    private boolean isAvailable;
    private String unit;

    public Ingredient(int ingredientId, String name, String unit,  int currentStock, int minimumThreshold) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.currentStock = currentStock;
        this.minimumThreshold = minimumThreshold;
        this.unit = unit;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(int minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
