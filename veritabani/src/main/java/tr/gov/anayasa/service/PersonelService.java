package tr.gov.anayasa.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import tr.gov.anayasa.dao.PersonelDAO;
import tr.gov.anayasa.entity.Personel;

@Named
public class PersonelService {
	@Inject
	private PersonelDAO personelDAO;

	public List<Personel> getTumPersoneller() {
		return personelDAO.getTumPersoneller();
	}
}
