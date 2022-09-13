package tr.gov.anayasa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonelConfig {
	@Bean
	Personel personelYarat() {
		Personel p = new Personel();
		p.setAdi("Abuzer");
		return p;
	}
}
