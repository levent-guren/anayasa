package deneme;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bolum database table.
 * 
 */
@Entity
@NamedQuery(name="Bolum.findAll", query="SELECT b FROM Bolum b")
public class Bolum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String adi;

	//bi-directional many-to-one association to Personel
	@OneToMany(mappedBy="bolum")
	private List<Personel> personels;

	public Bolum() {
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

	public List<Personel> getPersonels() {
		return this.personels;
	}

	public void setPersonels(List<Personel> personels) {
		this.personels = personels;
	}

	public Personel addPersonel(Personel personel) {
		getPersonels().add(personel);
		personel.setBolum(this);

		return personel;
	}

	public Personel removePersonel(Personel personel) {
		getPersonels().remove(personel);
		personel.setBolum(null);

		return personel;
	}

}