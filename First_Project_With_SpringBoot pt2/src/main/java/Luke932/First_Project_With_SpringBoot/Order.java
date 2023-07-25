package Luke932.First_Project_With_SpringBoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
	private static int nextOrderNumber = 1;

	private int orderNumber;
	private OrderStatus status;
	private int numberOfSeats;
	private LocalDateTime acquisitionTime;
	private List<OrderItem> items;
	private Table table;

	public Order(int numberOfSeats, Table table) {
		this.orderNumber = nextOrderNumber++;
		this.status = OrderStatus.IN_CORSO;
		this.numberOfSeats = numberOfSeats;
		this.acquisitionTime = LocalDateTime.now();
		this.items = new ArrayList<>();
		this.table = table;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
