package tr.gov.anayasa.dao;

import java.util.List;

import javax.inject.Named;

import lombok.RequiredArgsConstructor;
import tr.gov.anayasa.entity.Personel;
import tr.gov.anayasa.repository.PersonelRepository;

@Named
@RequiredArgsConstructor
public class PersonelDAO {
//	@SuppressWarnings("cdi-ambiguous-dependency")
//	@Inject
	private final PersonelRepository personelRepository;

	public List<Personel> getTumPersoneller() {
		return personelRepository.findAll();
	}

	public Personel kaydet(Personel personel) {
		return personelRepository.save(personel);
	}

	public List<Personel> getPersonellerAdaGore(String adi) {
		return personelRepository.findByAdiContainingIgnoreCase(adi);
	}

	public List<Personel> getPersonellerBolumAdinaGore(String bolumAdi) {
		return personelRepository.findByBolumAdi(bolumAdi);
	}

}
