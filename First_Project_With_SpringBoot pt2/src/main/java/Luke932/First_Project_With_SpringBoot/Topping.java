package Luke932.First_Project_With_SpringBoot;

public class Topping {
	private String name;
	private double price;
	private int nutritionInfo;

	public Topping(String name, double price, int nutritionInfo) {
		this.name = name;
		this.price = price;
		this.nutritionInfo = nutritionInfo;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int nutritionInfo() {
		return nutritionInfo;
	}

}
