package tr.gov.anayasa.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import tr.gov.anayasa.entity.Personel;
import tr.gov.anayasa.repository.PersonelRepository;

@Named
public class PersonelDAO {
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private PersonelRepository personelRepository;

	public List<Personel> getTumPersoneller() {
		return personelRepository.findAll();
	}
}
