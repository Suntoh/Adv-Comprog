package Task2;

public class CreditCardPayment implements PaymentMethod{

    @Override
    public void processPayment(double amt) {
        System.out.println("Processing credit card payment of $" + amt);
    }
}
