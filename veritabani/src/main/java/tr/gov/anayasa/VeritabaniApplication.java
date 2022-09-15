package tr.gov.anayasa;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tr.gov.anayasa.dao.BolumDAO;
import tr.gov.anayasa.entity.Bolum;

@SpringBootApplication
public class VeritabaniApplication implements CommandLineRunner {
	@Inject
	private BolumDAO bolumDAO;

	public static void main(String[] args) {
		SpringApplication.run(VeritabaniApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		List<Bolum> bolumler = bolumDAO.getTumBolumler();
		bolumler.forEach(System.out::println);
		bolumler.get(0).getPersoneller().forEach(System.out::println);
		System.out.println("-------");
		bolumler.get(1).getPersoneller().forEach(System.out::println);
	}

}
