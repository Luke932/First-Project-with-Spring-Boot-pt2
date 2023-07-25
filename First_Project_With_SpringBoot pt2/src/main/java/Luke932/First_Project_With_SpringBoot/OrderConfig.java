package Luke932.First_Project_With_SpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

	@Bean
	public StatoRistorante statoRistorante() {
		return StatoRistorante.APERTO;
	}

	@Bean
	public Table table1() {
		return new Table(1, 4);
	}

	@Bean
	public Table table2() {
		return new Table(2, 2);
	}
}
