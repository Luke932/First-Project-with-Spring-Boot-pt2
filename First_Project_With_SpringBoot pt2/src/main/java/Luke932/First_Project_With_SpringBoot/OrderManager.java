package Luke932.First_Project_With_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderManager {

	private final double coperto;
	private final int numeroMaxCoperti;

	private Order order1;
	private Order order2;

	@Autowired
	public OrderManager(@Value("${restaurant.coperto}") double coperto,
			@Value("${restaurant.numero-max-coperti}") int numeroMaxCoperti) {
		this.coperto = coperto;
		this.numeroMaxCoperti = numeroMaxCoperti;
	}

	@Autowired
	public void setTable1(Table table1) {
		order1 = new Order(4, table1);
		// Aggiungi gli item dell'ordine 1 se necessario
	}

	@Autowired
	public void setTable2(Table table2) {
		order2 = new Order(2, table2);
		// Aggiungi gli item dell'ordine 2 se necessario
	}

	// Aggiungi altri metodi per la gestione degli ordini se necessario

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
		System.out.println("Massimo numero coperti: " + numeroMaxCoperti);
		System.out.println("Orario di Acquisizione: " + order.getAcquisitionTime());
		System.out.println("Numero Tavolo: " + order.getTable().getTableNumber());
		System.out.println("Tavolo Occupato: " + order.getTable().isOccupied());

		double totalAmount = calculateOrderTotal(order);
		double finalAmount = totalAmount + coperto * order.getNumberOfSeats();

		System.out.println("Conto Totale: " + formatAmount(finalAmount) + " €");
	}

	private double calculateOrderTotal(Order order) {
		// Implementa il calcolo del totale dell'ordine
		// Utilizza gli oggetti OrderItem per ottenere il prezzo degli item
		return 0.0; // Da implementare
	}

	private String formatAmount(double amount) {
		// Implementa il formattazione dell'importo con due decimali
		// Ad esempio: "12.50"
		return String.format("%.2f", amount);
	}
}
