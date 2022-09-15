package tr.gov.anayasa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "bolum")
@EqualsAndHashCode(exclude = "bolum")
@Table(name = "personel")
public class Personel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adi;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dogumTarihi;
	@ManyToOne
	private Bolum bolum;
}
