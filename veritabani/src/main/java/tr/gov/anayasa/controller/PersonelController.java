package tr.gov.anayasa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
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
		List<PersonelDTO> sonuc = personelService.getTumPersoneller().stream()
				.map(p -> modelMapper.map(p, PersonelDTO.class)).collect(Collectors.toList());
		sonuc.sort((p1, p2) -> {
			return Integer.valueOf(p1.getId()).compareTo(p2.getId());
		});
		return ResponseEntity.ok(sonuc);
	}

	@GetMapping("/personel/adi/{personelAdi}")
	public ResponseEntity<List<PersonelDTO>> personelSorgulaAdaGore(
			@PathVariable(name = "personelAdi") String adi) {
		return ResponseEntity.ok(personelService.getPersonellerAdaGore(adi).stream()
				.map(p -> modelMapper.map(p, PersonelDTO.class)).collect(Collectors.toList()));
	}

	@GetMapping("/personel/bolum-adi/{bolumAdi}")
	public ResponseEntity<List<PersonelDTO>> personelSorgulaBolumAdinaGore(
			@PathVariable String bolumAdi) {
		return ResponseEntity.ok(personelService.getPersonellerBolumAdinaGore(bolumAdi).stream()
				.map(p -> modelMapper.map(p, PersonelDTO.class)).collect(Collectors.toList()));
	}

	@PostMapping("/personel")
	public ResponseEntity<Personel> personelKaydet(@RequestBody Personel personel) {
		return ResponseEntity.ok(personelService.kaydet(personel));
	}

	@DeleteMapping(value = "/personel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> personelSil(@PathVariable int id) throws JSONException {
		personelService.personelSil(id);
		JSONObject sonuc = new JSONObject();
		sonuc.put("sonuc", "Başarılı");
		return ResponseEntity.ok(sonuc.toString());
	}

	@DeleteMapping(value = "/personel", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> personelleriSil(@RequestBody String data)
			throws JSONException, ParseException {
		JSONObject json = (JSONObject) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(data);
		JSONArray idlerJson = (JSONArray) json.get("idler");
		List<Integer> idler = new ArrayList<>();
		idlerJson.forEach(id -> idler.add((Integer) id));
		personelService.personelleriSil(idler);
		JSONObject sonuc = new JSONObject();
		sonuc.put("sonuc", "Başarılı");
		return ResponseEntity.ok(sonuc.toString());
	}
}
