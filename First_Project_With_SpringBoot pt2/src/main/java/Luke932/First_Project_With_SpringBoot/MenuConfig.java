package Luke932.First_Project_With_SpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuConfig {

	// Esercizio2
	@Bean
	public Topping prosciutto() {
		return new Topping("Prosciutto", 1.00, 20);
	}

	@Bean
	public Topping wurstel() {
		return new Topping("Wurstel", 1.00, 45);
	}

	@Bean
	public Topping patatine() {
		return new Topping("Patatine", 1.50, 55);
	}

	@Bean
	public Topping funghi() {
		return new Topping("Funghi", 0.50, 15);
	}

	@Bean
	public Topping bufala() {
		return new Topping("Bufala", 2.00, 70);
	}

	@Bean
	public Topping pomodoro() {
		return new Topping("Pomodoro", 0.50, 15);
	}

	@Bean
	public Topping mozzarella() {
		return new Topping("Mozzarella", 1.50, 50);
	}

	@Bean
	public String margheritaName() {
		return "Margherita";
	}

	@Bean(name = "Margherita")
	public Pizza Margherita() {
		return createMargherita(margheritaName(), pomodoro(), mozzarella());
	}

	@Bean
	public Pizza createMargherita(@Qualifier("margheritaName") String name, Topping pomodoro, Topping mozzarella) {
		return new Margherita(name, pomodoro, mozzarella);
	}

	@Bean
	public List<Topping> allToppings() {
		List<Topping> toppings = new ArrayList<>();
		toppings.add(prosciutto());
		toppings.add(wurstel());
		toppings.add(patatine());
		toppings.add(funghi());
		toppings.add(bufala());
		toppings.add(pomodoro());
		toppings.add(mozzarella());
		return toppings;
	}

	@Bean
	public Drink coke() {
		return new Drink("Coke", 100, 2.5);
	}

	@Bean
	public Drink orangeJuice() {
		return new Drink("Orange Juice", 120, 3.0);
	}

	@Bean
	public Drink water() {
		return new Drink("Water", 0, 1.0);
	}

	@Bean
	public Item tShirt() {
		return new Item("T-Shirt", 25.00);
	}

	@Bean
	public Item glass() {
		return new Item("Glass", 10.00);
	}

}
