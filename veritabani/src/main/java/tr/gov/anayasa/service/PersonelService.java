package tr.gov.anayasa.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import tr.gov.anayasa.dao.PersonelDAO;
import tr.gov.anayasa.entity.Personel;

@Named
public class PersonelService {
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private PersonelDAO personelDAO;

	public List<Personel> getTumPersoneller() {
		return personelDAO.getTumPersoneller();
	}

	public Personel kaydet(Personel personel) {
		return personelDAO.kaydet(personel);
	}

	public List<Personel> getPersonellerAdaGore(String adi) {
		return personelDAO.getPersonellerAdaGore(adi);
	}

	public List<Personel> getPersonellerBolumAdinaGore(String bolumAdi) {
		return personelDAO.getPersonellerBolumAdinaGore(bolumAdi);
	}

	public void personelSil(int id) {
		personelDAO.sil(id);
	}

	public void personelleriSil(List<Integer> idler) {
		personelDAO.personelleriSil(idler);
	}
}
