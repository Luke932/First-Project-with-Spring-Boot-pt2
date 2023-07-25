package Luke932.First_Project_With_SpringBoot;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
	private Item item;
	private List<String> variations;
	private String note;

	public OrderItem(Item item) {
		this.item = item;
		this.variations = new ArrayList<>();
		this.note = "";
	}

	public void addVariation(String variation) {
		variations.add(variation);
	}

	public void removeVariation(String variation) {
		variations.remove(variation);
	}

	public void addNote(String note) {
		this.note += note;
	}

	public void removeNote() {
		this.note = "";
	}
}
