package tr.gov.anayasa.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.anayasa.dto.PersonelDTO;
import tr.gov.anayasa.entity.Personel;
import tr.gov.anayasa.service.PersonelService;

@RestController
public class PersonelController {
	@Inject
	private PersonelService personelService;
	@Inject
	private ModelMapper modelMapper;

	@GetMapping("/personeller")
	public ResponseEntity<List<PersonelDTO>> getTumPersoneller() {
		return ResponseEntity.ok(personelService.getTumPersoneller().stream()
				.map(p -> modelMapper.map(p, PersonelDTO.class)).collect(Collectors.toList()));
	}

	@GetMapping("/personel/adi/{personelAdi}")
	public ResponseEntity<List<Personel>> personelSorgulaAdaGore(
			@PathVariable(name = "personelAdi") String adi) {
		return ResponseEntity.ok(personelService.getPersonellerAdaGore(adi));
	}

	@GetMapping("/personel/bolum-adi/{bolumAdi}")
	public ResponseEntity<List<Personel>> personelSorgulaBolumAdinaGore(
			@PathVariable String bolumAdi) {
		return ResponseEntity.ok(personelService.getPersonellerBolumAdinaGore(bolumAdi));
	}

	@PostMapping("/personel")
	public ResponseEntity<Personel> personelKaydet(@RequestBody Personel personel) {
		return ResponseEntity.ok(personelService.kaydet(personel));
	}
}
