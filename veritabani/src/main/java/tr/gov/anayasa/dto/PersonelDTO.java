package tr.gov.anayasa.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PersonelDTO {
	private int id;
	private String adi;
	private String email;
	private Date dogumTarihi;
	private BolumDTO bolum;
}
