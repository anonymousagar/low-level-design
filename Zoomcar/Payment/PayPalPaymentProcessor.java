package Zoomcar.Payment;

public class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // Implement PayPal payment processing logic here
        return true; // Return true if payment is successful, false otherwise
    }
    
}
