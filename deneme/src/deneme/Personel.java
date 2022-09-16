package deneme;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personel database table.
 * 
 */
@Entity
@NamedQuery(name="Personel.findAll", query="SELECT p FROM Personel p")
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String adi;

	@Temporal(TemporalType.DATE)
	@Column(name="dogum_tarihi")
	private Date dogumTarihi;

	private String email;

	//bi-directional many-to-one association to Bolum
	@ManyToOne
	private Bolum bolum;

	public Personel() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdi() {
		return this.adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public Date getDogumTarihi() {
		return this.dogumTarihi;
	}

	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Bolum getBolum() {
		return this.bolum;
	}

	public void setBolum(Bolum bolum) {
		this.bolum = bolum;
	}

}