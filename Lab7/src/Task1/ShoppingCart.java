package Task1;

import java.util.ArrayList;
import java.util.Objects;

public class ShoppingCart {
    private static ShoppingCart instance;
    private static ArrayList<Item> cart = new ArrayList<>();
    private static int deliveryFee = 0;
    public static int fee =0;
    Coupon discount;
    public static double calculateTotal(){
        boolean cal = false;
        float total = 0;
        for(int i = 0; i< cart.size(); i++) {
            if (!Objects.equals(cart.get(i).getItemName(), "Discount")) {
                total += cart.get(i).getQuantity() * cart.get(i).getPrice();
            }
            if (Objects.equals(cart.get(i).getItemName(), "Delivery Fee")){
                cal = true;
            }
        }
        if (!cal){
            total += ShoppingCart.fee;
        }
        return total;
    }
    public void addDeliveryFee(int fee){
        Item deliveryFee = new Item("Delivery Fee:1:"+fee);
        cart.add(deliveryFee);
        ShoppingCart.deliveryFee = fee;
        ShoppingCart.fee =fee;
    }
    public void addItem(String s){
        Item i = new Item(s);
        cart.add(i);
    }
    public static int getDeliveryFee(){
        return deliveryFee;
    }
    public void setDiscount(Coupon c){
        this.discount = c;
    }
    public double getNetPrice(){
        float total = 0;
        for(int i = 0; i< cart.size(); i++) {
            total += cart.get(i).getQuantity() * cart.get(i).getPrice();
        }
        return total;
    }
    public static ArrayList<Item> getCart(){
        return cart;
    }
    public void setCart(ArrayList<Item> cart){
        this.cart = cart;
    }
}

