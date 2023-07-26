package Luke932.First_Project_With_SpringBoot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderManagerTest {

	@Autowired
	private OrderManager orderManager;

	@BeforeEach
	public void setup() {
		// Qui puoi eventualmente inizializzare l'ambiente di test o effettuare altre
		// operazioni necessarie prima di ogni test.
	}

	@Test
	public void testAddOrder() {
		// Crea alcuni oggetti Margherita e aggiungili all'OrderManager
		Margherita margherita1 = new Margherita("Margherita 1");
		margherita1.addTopping(new Topping("Prosciutto", 1.00, 20));
		margherita1.addTopping(new Topping("Funghi", 0.50, 15));
		orderManager.setTable1(new Table(1, 4));
		orderManager.addOrderItem(new OrderItem(margherita1, 4));

		Margherita margherita2 = new Margherita("Margherita 2");
		margherita2.addTopping(new Topping("Bufala", 2.00, 70));
		margherita2.addTopping(new Topping("Prosciutto", 1.00, 20));
		orderManager.setTable2(new Table(2, 2));
		orderManager.addOrderItem(new OrderItem(margherita2, 2));

		// Verifica che gli ordini siano stati correttamente aggiunti
		assertEquals(2, orderManager.getOrderCount());
	}

	@Test
	public void testPrintMenu() {
		// Esegui il metodo printMenu e verifica che non ci siano eccezioni o errori
		// durante l'esecuzione
		orderManager.printOrders();
	}

	// Aggiungi altri test per gli altri scenari di test che desideri verificare.

}
