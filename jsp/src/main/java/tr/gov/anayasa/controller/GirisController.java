package tr.gov.anayasa.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import tr.gov.anayasa.model.GirisModel;
import tr.gov.anayasa.service.GirisService;

@Controller
public class GirisController {
	@Inject
	private GirisService girisService;

	@GetMapping
	String anaSayfa() {
		return "index";
	}

	@GetMapping("/cikis")
	ModelAndView cikis(HttpSession session) {
		session.invalidate();
		return new ModelAndView("index").addObject("mesaj", "Başarı ile çıkış yaptınız");
	}

	@PostMapping("/giris")
	ModelAndView girisYap(GirisModel model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		try {
			girisService.girisKontrol(model.getUsername(), model.getPassword());
			session.setAttribute("login", model.getUsername());
			mav.setViewName("menu");
			// giris basarili
		} catch (Exception ex) {
			// giris basarısız oldu
			mav.addObject("hata", ex.getMessage());
			mav.setViewName("index");
		}
		return mav;
	}
}
