package Task1;

import java.lang.reflect.Array;

public class Item {
    private String itemName;
    private int quantity;
    private float price;
    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public Item(String s){
        String[] temp = s.split(":");
        this.itemName = temp[0];
        this.quantity= Integer.parseInt(temp[1]);
        this.price = Float.parseFloat(temp[2]);
    }



}
