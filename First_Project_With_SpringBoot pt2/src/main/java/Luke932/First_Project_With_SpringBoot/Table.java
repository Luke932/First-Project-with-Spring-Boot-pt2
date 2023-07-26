package Luke932.First_Project_With_SpringBoot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Table {
	private int tableNumber;
	private int numberOfSeats;
	private boolean isOccupied;

	public Table(int tableNumber, int numberOfSeats) {
		this.tableNumber = tableNumber;
		this.numberOfSeats = numberOfSeats;
		this.isOccupied = true;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
}
