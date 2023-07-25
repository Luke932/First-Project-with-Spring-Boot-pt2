package Luke932.First_Project_With_SpringBoot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Table {
	private int tableNumber;
	private int maxSeats;
	private boolean isOccupied;
}
