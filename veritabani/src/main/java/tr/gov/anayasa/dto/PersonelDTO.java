package tr.gov.anayasa.dto;

import lombok.Data;

@Data
public class PersonelDTO {
	private int id;
	private String adi;
	private String email;
	private BolumDTO bolum;
}
