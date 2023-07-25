package Luke932.First_Project_With_SpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Menu {
	private List<Pizza> menuItems = new ArrayList<>();

	public void addMenuItem(Pizza item) {
		if (item instanceof Margherita) {
			Margherita margherita = (Margherita) item;
			Margherita copiedPizza = margherita.createCopyWithNewName(margherita.getName(), false);
			menuItems.add(copiedPizza);
		} else {
			menuItems.add(item);
		}
	}

	public void printMenu() {
		for (Pizza pizza : menuItems) {
			System.out.print(pizza.getName());
			List<Topping> toppings = pizza.getToppings();
			if (!toppings.isEmpty()) {
				List<String> toppingNames = new ArrayList<>();
				for (Topping topping : toppings) {
					toppingNames.add(topping.getName());
				}
				System.out.print(" (" + String.join(", ", toppingNames) + ")");
			}
			if (pizza instanceof Margherita) {
				Margherita margherita = (Margherita) pizza;
				System.out.println("    " + margherita.getTotalCalories() + " calorie   " + pizza.getPrice() + " €");
			} else {
				System.out.println("    " + "Calorie non disponibili" + "   " + pizza.getPrice() + " €");
			}
		}
	}

}
