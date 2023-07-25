package Luke932.First_Project_With_SpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Aggiungiamo l'annotazione @Component per rendere la classe un componente
			// gestito da Spring
public class Margherita implements Pizza {
	private List<Topping> toppings = new ArrayList<>();
	private String size;
	private String name = "Margherita";

	@Autowired
	public Margherita(Topping pomodoro, Topping mozzarella) {
		size = "Standard";
		addTopping(pomodoro);
		addTopping(mozzarella);
	}

	public Margherita(String name, Topping topping1, Topping topping2) {
		this(name);
		addTopping(topping1);
		addTopping(topping2);
	}

	public Margherita(String name) {
		this.name = name;
		size = "Standard";
	}

	public void addTopping(Topping topping) {
		toppings.add(topping);
	}

	public Margherita createCopyWithNewName(String name, boolean includeCopySuffix) {
		Margherita copiedPizza = new Margherita(includeCopySuffix ? name + " (copia)" : name);
		copiedPizza.setSize(this.getSize());
		copiedPizza.setToppings(new ArrayList<>(this.getToppings())); // Copia gli ingredienti senza ripetizioni
		return copiedPizza;
	}

	@Override
	public int getTotalCalories() {
		int totalCalories = 90;
		for (Topping topping : toppings) {
			totalCalories += topping.nutritionInfo();
		}
		return totalCalories;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return "Pomodoro e mozzarella";
	}

	@Override
	public double getPrice() {
		double basePrice = 6.0;
		double totalToppingsPrice = 0.0;
		for (Topping topping : toppings) {
			totalToppingsPrice += topping.getPrice();
		}
		return basePrice + totalToppingsPrice;
	}

	@Override
	public List<Topping> getToppings() {
		return toppings;
	}

	@Override
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}
}
