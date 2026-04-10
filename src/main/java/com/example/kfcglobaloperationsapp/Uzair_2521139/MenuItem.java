package com.example.kfcglobaloperationsapp.Uzair_2521139;

public class MenuItem {
    private int menuItemID;
    private String name, category;
    private double price;
    private boolean isInStock;


    public MenuItem(int menuItemID, String name, String category, double price, boolean isInStock) {
        this.menuItemID = menuItemID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.isInStock = isInStock;
    }


    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuItemID=" + menuItemID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", isInStock=" + isInStock +
                '}';
    }
}
