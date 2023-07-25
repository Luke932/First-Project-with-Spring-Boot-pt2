package Luke932.First_Project_With_SpringBoot;

public class Drink {
	private String name;
	private int calories;
	private double price;

	public Drink(String name, int calories, double price) {
		this.name = name;
		this.calories = calories;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public double getPrice() {
		return price;
	}
}
