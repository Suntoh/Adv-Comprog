package Task3;

public class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment(double amt) {
        System.out.println("Processing PayPal payment of $" + amt);
    }
}
