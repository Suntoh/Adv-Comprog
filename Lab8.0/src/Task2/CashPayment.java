package Task2;

public class CashPayment implements PaymentMethod{
    @Override
    public void processPayment(double amt) {
        System.out.println("Processing cash payment of $" + amt);
    }
}
