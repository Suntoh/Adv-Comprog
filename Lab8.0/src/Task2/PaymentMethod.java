package Task2;

public interface PaymentMethod {
    public void processPayment(double amt);
}
interface PaymentMethodFactoryInterface{
    PaymentMethod createPaymentMethod(String s);
}
class PaymentMethodFactory implements PaymentMethodFactoryInterface{

    @Override
    public PaymentMethod createPaymentMethod(String s) {
        if(s.equals("credit card")){
            return new CreditCardPayment();
        }
        else if (s.equals("paypal")){
            return new PayPalPayment();
        }else if (s.equals("crypto")){
            return new CryptoPayment();
        }
        return new CashPayment();
    }
}
