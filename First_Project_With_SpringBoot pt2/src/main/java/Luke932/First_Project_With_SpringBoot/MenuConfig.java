package Luke932.First_Project_With_SpringBoot;

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

}
