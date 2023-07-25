package Luke932.First_Project_With_SpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Margherita implements Pizza {
	private List<Topping> toppings = new ArrayList<>();
	private String size;
	private String name = "Margherita";
	private static final double FAMILY_SIZE_PRICE_MULTIPLIER = 1.8;
	private static final double FAMILY_SIZE_CALORIES_MULTIPLIER = 1.8;

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
		Margherita copiedPizza = new Margherita(includeCopySuffix ? name : name);
		copiedPizza.setSize(this.getSize());
		copiedPizza.setToppings(new ArrayList<>(this.getToppings()));
		return copiedPizza;
	}

	// Metodo per calcolare il prezzo in base alla dimensione della pizza
	private double calculatePrice() {
		double basePrice = 4.0;
		double totalToppingsPrice = 0.0;
		for (Topping topping : toppings) {
			totalToppingsPrice += topping.getPrice();
		}
		double finalPrice = basePrice + totalToppingsPrice;
		return size.equals("Familiare") ? finalPrice * FAMILY_SIZE_PRICE_MULTIPLIER : finalPrice;
	}

	// Metodo per calcolare le calorie in base alla dimensione della pizza
	private int calculateCalories() {
		int totalCalories = 90;
		for (Topping topping : toppings) {
			totalCalories += topping.nutritionInfo();
		}
		return size.equals("Familiare") ? (int) (totalCalories * FAMILY_SIZE_CALORIES_MULTIPLIER) : totalCalories;
	}

	@Override
	public int getTotalCalories() {
		return calculateCalories();
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
		return calculatePrice();
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

	public boolean isFamiliare() {
		return size.equals("Familiare");
	}

	@Override
	public int getNutritionInfo() {
		return getTotalCalories();
	}

}
