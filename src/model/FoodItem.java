package model;

public class FoodItem {
    private int itemId;
    private int quantity;

    public FoodItem(int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}