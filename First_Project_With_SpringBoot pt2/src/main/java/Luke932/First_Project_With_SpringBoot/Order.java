package Luke932.First_Project_With_SpringBoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private static int nextOrderNumber = 1;

	private int orderNumber;
	private LocalDateTime acquisitionTime;
	private List<OrderItem> orderItems;
	private Table table;
	private OrderStatus status;
	private int numberOfSeats;

	public Order(int numberOfSeats, Table table) {
		this.orderNumber = nextOrderNumber++;
		this.acquisitionTime = LocalDateTime.now();
		this.orderItems = new ArrayList<>();
		this.table = table;
		this.status = OrderStatus.IN_CORSO;
		this.numberOfSeats = numberOfSeats;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public LocalDateTime getAcquisitionTime() {
		return acquisitionTime;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public Table getTable() {
		return table;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}

	public void removeOrderItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
	}
}
