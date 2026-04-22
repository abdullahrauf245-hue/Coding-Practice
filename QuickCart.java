import java.util.Scanner;

public class QuickCart {

	// Step 4: Main Method (User Interaction)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== QuickCart Checkout ===");
		System.out.print("Enter Item ID: ");
		String itemId = sc.next();
		System.out.print("Enter Quantity: ");
		int quantity = sc.nextInt();
		System.out.print("Enter Total Price: ");
		double price = sc.nextDouble();

		try {
			processOrder(itemId, quantity, price);
		} catch (OrderNotProcessedException e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

	// Step 2: Implement Payment Processing
	static boolean processPayment(double amount) throws PaymentFailedException {
		// Simulate 70% success rate
		boolean success = Math.random() > 0.3;
		if (!success) {
			throw new PaymentFailedException("Payment rejected.");
		}
		return true;
	}

	static boolean isItemInStock(String itemId, int quantity) {
		// Simulate random stock (50% chance of being in stock)
		return Math.random() > 0.5;
	}

	// Step 3: Implement Order Processing
	static void processOrder(String itemId, int quantity, double price)
			throws OrderNotProcessedException {
		try {
			processPayment(price);
			if (!isItemInStock(itemId, quantity)) {
				throw new OrderNotProcessedException("Item '" + itemId + "' is out of stock.");
			}
			System.out.println("Order placed successfully");
		} catch (PaymentFailedException e) {
			throw new OrderNotProcessedException("Order failed: " + e.getMessage());
		}
	}
}

// Step 1: Define Checked Exceptions

// PaymentFailedException: Thrown when payment processing fails.
class PaymentFailedException extends Exception {
	public PaymentFailedException(String message) {
		super(message);
	}
}

// OrderNotProcessedException: Thrown when the order cannot be fulfilled.
class OrderNotProcessedException extends Exception {
	public OrderNotProcessedException(String message) {
		super(message);
	}
}
