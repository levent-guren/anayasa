package tr.gov.anayasa;

import javax.inject.Inject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;

@SpringBootApplication
public class IlkProjeApplication implements CommandLineRunner, Ordered {
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	// @Qualifier("personelB")
	private Personel personel;

	public static void main(String[] args) {
		SpringApplication.run(IlkProjeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(personel);
	}

	@Override
	public int getOrder() {
		return 0;
	}

}
