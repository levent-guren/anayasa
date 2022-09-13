package tr.gov.anayasa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.anayasa.bean.Personel;

@RestController
public class MerhabaController {
	// @RequestMapping(value = "/merhaba", method = RequestMethod.GET)
	@GetMapping("/merhaba")
	public String merhaba(
			@RequestParam(value = "isim", required = false, defaultValue = "Mehmet") String adi) {
		System.out.println("Merhaba çağırıldı");
		return "Merhaba " + adi;
	}

	@GetMapping
	public String giris() {
		return "Giris";
	}

	@GetMapping("/ekle")
	String personelEkle(Personel personel) {
		System.out.println("Eklenen personel: " + personel);
		return "Personel eklenmiştir";
	}

	@PostMapping("/ekle")
	ResponseEntity<Personel> personelEkle2(@RequestBody Personel personel) {
		return ResponseEntity.status(HttpStatus.CREATED).header("mesaj", "Personel Yaratilmistir")
				.body(personel);
	}
}
