package tr.gov.anayasa.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.anayasa.entity.Personel;
import tr.gov.anayasa.service.PersonelService;

@RestController
public class PersonelController {
	@Inject
	private PersonelService personelService;

	@GetMapping("/personeller")
	public ResponseEntity<List<Personel>> getTumPersoneller() {
		return ResponseEntity.ok(personelService.getTumPersoneller());
	}
}
