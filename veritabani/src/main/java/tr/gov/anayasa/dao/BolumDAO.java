package tr.gov.anayasa.dao;

import java.util.List;

import javax.inject.Named;

import lombok.RequiredArgsConstructor;
import tr.gov.anayasa.entity.Bolum;
import tr.gov.anayasa.repository.BolumRepository;

@Named
@RequiredArgsConstructor
public class BolumDAO {
	private final BolumRepository bolumRepository;

	public List<Bolum> getTumBolumler() {
		return bolumRepository.findAll();
	}

}
