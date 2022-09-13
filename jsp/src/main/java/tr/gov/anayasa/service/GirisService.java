package tr.gov.anayasa.service;

import javax.inject.Named;

@Named
public class GirisService {
	public boolean girisKontrol(String username, String password) throws Exception {
		if (username != null && new StringBuilder(username).reverse().toString().equals(password)) {
			return true;
		} else {
			throw new Exception("Kullanıcı adı / şifre hatalıdır");
		}
	}
}
