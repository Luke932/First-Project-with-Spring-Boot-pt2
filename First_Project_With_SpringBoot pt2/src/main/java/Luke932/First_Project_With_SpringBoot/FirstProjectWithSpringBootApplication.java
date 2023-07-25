package Luke932.First_Project_With_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class FirstProjectWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectWithSpringBootApplication.class, args);

		// Esercizio1
		ConfigurableApplicationContext ctx = SpringApplication.run(FirstProjectWithSpringBootApplication.class, args);
		log.info(ctx.getBean("getHth").toString());
		System.out.println();

		Menu menu = ctx.getBean(Menu.class);

		Pizza margherita = ctx.getBean("margherita", Pizza.class);
		menu.addMenuItem(margherita);

		Margherita quattroGusti = ((Margherita) ctx.getBean("margherita", Pizza.class)).createCopyWithNewName("4Gusti",
				false);
		quattroGusti.addTopping(ctx.getBean("prosciutto", Topping.class));
		quattroGusti.addTopping(ctx.getBean("wurstel", Topping.class));
		quattroGusti.addTopping(ctx.getBean("funghi", Topping.class));
		menu.addMenuItem(quattroGusti);

		Margherita guerra = ((Margherita) ctx.getBean("margherita", Pizza.class)).createCopyWithNewName("Guerra",
				false);
		guerra.addTopping(ctx.getBean("bufala", Topping.class));
		guerra.addTopping(ctx.getBean("funghi", Topping.class));
		guerra.addTopping(ctx.getBean("prosciutto", Topping.class));
		menu.addMenuItem(guerra);

		Pizza familiare = ((Margherita) ctx.getBean("margherita", Pizza.class)).createCopyWithNewName("Familiare",
				false);
		familiare.setSize("Familiare");
		menu.addMenuItem(familiare);

		menu.addDrink(ctx.getBean("coke", Drink.class));
		menu.addDrink(ctx.getBean("orangeJuice", Drink.class));
		menu.addDrink(ctx.getBean("water", Drink.class));

		menu.addItem(ctx.getBean("tShirt", Item.class));
		menu.addItem(ctx.getBean("glass", Item.class));

		menu.printMenu();

		ctx.close();
	}
}