package tr.gov.anayasa.service;

import javax.inject.Named;

import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.jasypt.util.text.AES256TextEncryptor;

@Named
public class Security {
	private static AES256TextEncryptor textEncrypter = new AES256TextEncryptor();
	static {
		textEncrypter.setPassword("sdlkjfgdsakjfhgdsalk");
	}

	public String getEncrypted(String value) {
		return PropertyValueEncryptionUtils.encrypt(value, textEncrypter);
	}

	public String getDecrypted(String value) {
		return PropertyValueEncryptionUtils.decrypt(value, textEncrypter);
	}

	public static void main(String[] args) {
		System.out.println(new Security().getEncrypted("anayasa"));
	}
}
