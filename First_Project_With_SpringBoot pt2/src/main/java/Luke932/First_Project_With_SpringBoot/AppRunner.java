package Luke932.First_Project_With_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

	private final OrderManager orderManager;

	@Autowired
	public AppRunner(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	@Override
	public void run(String... args) {
		orderManager.printOrders();
	}
}
