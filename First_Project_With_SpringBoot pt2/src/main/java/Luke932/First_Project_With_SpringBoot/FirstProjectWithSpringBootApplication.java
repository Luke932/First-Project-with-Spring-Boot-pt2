package Luke932.First_Project_With_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan("Luke932.First_Project_With_SpringBoot")
@Slf4j
public class FirstProjectWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectWithSpringBootApplication.class, args);

		// Esercizio1
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				FirstProjectWithSpringBootApplication.class);
		log.info(ctx.getBean("getHth").toString());
		System.out.println();
		FirstProjectWithSpringBootApplication app = ctx.getBean(FirstProjectWithSpringBootApplication.class);
		app.run(ctx);

		ctx.close();
	}

	public void run(AnnotationConfigApplicationContext ctx) {
		Menu menu = ctx.getBean(Menu.class);

		Pizza margherita = ctx.getBean("margherita", Pizza.class);
		menu.addMenuItem(margherita);

		Margherita quattroGusti = ((Margherita) ctx.getBean("margherita", Pizza.class)).createCopyWithNewName("4Gusti",
				false);
		quattroGusti.addTopping(ctx.getBean("prosciutto", Topping.class));
		quattroGusti.addTopping(ctx.getBean("wurstel", Topping.class));
		quattroGusti.addTopping(ctx.getBean("funghi", Topping.class));
		menu.addMenuItem(quattroGusti);

		menu.printMenu();
	}

}
