import java.util.Scanner;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Оплачено банковской картой: " + amount + " ₸");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Оплачено через PayPal: " + amount + " ₸");
    }
}

class CryptoPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Оплачено криптовалютой: " + amount + " ₸");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        if (strategy == null) {
            System.out.println("⚠ Способ оплаты не выбран!");
        } else {
            strategy.pay(amount);
        }
    }
}

public class Strategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму оплаты: ");
        double amount = scanner.nextDouble();

        System.out.println("\nВыберите способ оплаты:");
        System.out.println("1 - Банковская карта");
        System.out.println("2 - PayPal");
        System.out.println("3 - Криптовалюта");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                context.setPaymentStrategy(new CreditCardPayment());
                break;
            case 2:
                context.setPaymentStrategy(new PayPalPayment());
                break;
            case 3:
                context.setPaymentStrategy(new CryptoPayment());
                break;
            default:
                System.out.println("Некорректный выбор!");
                return;
        }

        context.pay(amount);

        scanner.close();
    }
}
