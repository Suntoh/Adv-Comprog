package Task3;

public class CryptoPayment implements PaymentMethod {
    @Override
    public void processPayment(double amt) {
        System.out.println("Processing cryptocurrency payment of $" + amt);
    }
}
