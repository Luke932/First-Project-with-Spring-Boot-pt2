package Luke932.First_Project_With_SpringBoot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {
	private List<Pizza> menuItems = new ArrayList<>();
	private List<Drink> drinks = new ArrayList<>();
	private List<Item> items = new ArrayList<>();

	@Autowired
	private List<Topping> allToppings;

	public void addMenuItem(Pizza item) {
		if (item instanceof Margherita) {
			Margherita margherita = (Margherita) item;
			Margherita copiedPizza = margherita.createCopyWithNewName(margherita.getName(), true);
			menuItems.add(copiedPizza);
		} else {
			menuItems.add(item);
		}
	}

	public void addDrink(Drink drink) {
		drinks.add(drink);
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void addFamilySizePizza(Pizza pizza) {
		if (pizza instanceof Margherita) {
			Margherita margherita = (Margherita) pizza;
			Margherita familySizePizza = margherita.createCopyWithNewName(margherita.getName(), false);
			familySizePizza.setSize("Familiare");
			menuItems.add(familySizePizza);
		} else {
			// Inserire qui la gestione di altre pizze familiari se presenti
		}
	}

	public void printMenu() {
		System.out.println("----------Pizze------------");
		for (Pizza pizza : menuItems) {
			System.out.println(
					pizza.getName() + "    " + pizza.getTotalCalories() + " calorie   " + pizza.getPrice() + " €");
			System.out.println("    Toppings: " + getPizzaToppings(pizza));
		}

		System.out.println("\n-------------Toppings---------------");
		DecimalFormat df = new DecimalFormat("#.##");
		for (Topping topping : allToppings) {
			System.out.println(topping.getName() + " " + topping.nutritionInfo() + " calorie   "
					+ df.format(topping.getPrice()) + " €");
		}

		System.out.println("\n-------------Drinks---------------");
		for (Drink drink : drinks) {
			System.out
					.println(drink.getName() + "    " + drink.getCalories() + " calorie   " + drink.getPrice() + " €");
		}

		System.out.println("\n-------------Franchise---------------");
		for (Item item : items) {
			System.out.println(item.getName() + "    " + item.getPrice() + " €");
		}
	}

	private String getPizzaToppings(Pizza pizza) {
		List<String> toppingNames = pizza.getToppings().stream().map(Topping::getName).collect(Collectors.toList());
		return String.join(", ", toppingNames);
	}
}