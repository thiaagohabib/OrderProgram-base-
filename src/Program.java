import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
				for (int i = 1; i<=n; i++) {
					System.out.println("Enter the #" + i + "data: ");
					System.out.print("Product name: ");
					sc.nextLine();
					String productName = sc.nextLine();
					System.out.println("Product price: ");
					double productPrice = sc.nextDouble();
					Product product = new Product(productName, productPrice);
					System.out.println("Quantity: ");
					int quantity = sc.nextInt();
					OrderItem orderItem = new OrderItem(quantity, productPrice, product);
					
					order.addItem(orderItem);
					
					}
				System.out.println("ORDER SUMMARY: ");
				System.out.println(order);
				
		
		sc.close();
	}

}
