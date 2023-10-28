package Task1;

public class DiscountDecorator {
    public ShoppingCart cart;
    public DiscountDecorator(ShoppingCart cart){
        this.cart = cart;
    }
}
//class DiscountByPercentDecorator2 extends Task1.DiscountDecorator{
//    public DiscountByPercentDecorator2(Task1.ShoppingCart cart, double percent){
//        ArrayList<Task1.Item> cartItem = cart.getCart();
//        Task1.Item discount = new Task1.Item("Discount:1:"+(Task1.ShoppingCart.calculateTotal()-Task1.ShoppingCart.getDeliveryFee())*(percent)/-100);
//        cartItem.add(discount);
//        cart.setCart(cartItem);
////        super(cart);
//    }
//}
