package Luke932.First_Project_With_SpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderManager {
	private List<OrderItem> orderItems = new ArrayList<>();
	@Value("${restaurant.coperto}")
	private double coperto;
	@Value("${restaurant.numero-max-coperti}")
	private int numeroMaxCoperti;

	private Order order1;
	private Order order2;

	@Autowired
	public void setTable1(Table table1) {
		order1 = new Order(4, table1);
	}

	@Autowired
	public void setTable2(Table table2) {
		order2 = new Order(2, table2);
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}

	public int getOrderCount() {
		return orderItems.size();
	}

	public void printOrders() {
		System.out.println("---------- Ordini ------------");
		if (order1 != null) {
			printOrderDetails(order1);
			System.out.println("------------------------");
		}

		if (order2 != null) {
			printOrderDetails(order2);
			System.out.println("------------------------");
		}
	}

	private void printOrderDetails(Order order) {
		System.out.println("Numero Ordine: " + order.getOrderNumber());
		System.out.println("Stato: " + order.getStatus());
		System.out.println("Numero di Coperti: " + order.getNumberOfSeats());
		System.out.println("Pietanze ordinate: pizza Margherita");
		System.out.println("Massimo numero coperti: " + numeroMaxCoperti);
		System.out.println("Orario di Acquisizione: " + order.getAcquisitionTime());
		System.out.println("Numero Tavolo: " + order.getTable().getTableNumber());
		System.out.println("Tavolo Occupato: " + order.getTable().isOccupied());

		double totalAmount = calculateOrderTotal(order) * order.getNumberOfSeats();
		double finalAmount = totalAmount + coperto * order.getNumberOfSeats();

		System.out.println("Conto Totale: " + formatAmount(finalAmount) + " €");
	}

	private double calculateOrderTotal(Order order) {
		return 6.0;
	}

	private String formatAmount(double amount) {
		return String.format("%.2f", amount);
	}
}
