package Task1;

import java.util.ArrayList;
import java.util.Objects;

public interface Coupon {
    public ShoppingCart applyCoupon();
}
//class NoDiscount implements Task1.Coupon{
//    private ArrayList<Task1.Item> cart;
//    public NoDiscount(ArrayList<Task1.Item> cart) {
//        this.cart = cart;
//    }
//    @Override
//    public Task1.ShoppingCart applyCoupon() {
//        return cart;
//    }
//}

class DiscountByPercentDecorator implements Coupon{
    double percent;
    ShoppingCart shoppingCart;
    ArrayList<Item> cart = ShoppingCart.getCart();
    public DiscountByPercentDecorator(ShoppingCart cart,double percent){
        this.percent = percent;
        this.shoppingCart = cart;
    }
    public ShoppingCart applyCoupon(){
        Item discount = new Item("Discount:1:"+(ShoppingCart.calculateTotal()-ShoppingCart.getDeliveryFee())*(percent)/-100);
        cart.add(discount);
        shoppingCart.setCart(cart);
        return shoppingCart;
    }
}
class DiscountByAmountDecorator implements Coupon{
    float amt;
    ShoppingCart shoppingCart;
    public DiscountByAmountDecorator(ShoppingCart cart, float amt){
        this.shoppingCart = cart;
        this.amt = amt;
    }
    public ShoppingCart applyCoupon() {
        ArrayList<Item> cart = ShoppingCart.getCart();
        Item discount = new Item("Discount:1:" + amt);
        cart.add(discount);
        shoppingCart.setCart(cart);
        return shoppingCart;
    }
}
class FreeDeliveryDecorator implements Coupon{
    ShoppingCart shoppingCart;
    public FreeDeliveryDecorator(ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
    }
    ArrayList<Item> cart = ShoppingCart.getCart();
    public ShoppingCart applyCoupon(){
        for (int i = cart.size()-1; i >= 0; i--) {
            if(Objects.equals(cart.get(i).getItemName(), "Delivery Fee")){
                cart.remove(i);
                break;
            }
        }
        shoppingCart.setCart(cart);
        return shoppingCart;
    }
}