package Luke932.First_Project_With_SpringBoot;

import java.util.List;

public interface Pizza {
	String getName();

	String getDescription();

	double getPrice();

	int getTotalCalories();

	List<Topping> getToppings();

	String getSize();

	int getNutritionInfo();

	void setSize(String string);

	boolean isFamiliare();
}
