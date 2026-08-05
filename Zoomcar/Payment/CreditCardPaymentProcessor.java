package Zoomcar.Payment;

public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // Implement credit card payment processing logic here
        return true; // Return true if payment is successful, false otherwise
    }
    
}
