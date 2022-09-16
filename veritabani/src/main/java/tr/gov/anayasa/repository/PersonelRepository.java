package tr.gov.anayasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tr.gov.anayasa.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {
	public List<Personel> findByAdiContainingIgnoreCase(String adi);

	@Query(value = "from Personel p where p.adi = ?1")
	public List<Personel> personelBul(String adi);

	@Query(value = "select * from personel where adi = ?1", nativeQuery = true)
	public List<Object[]> personelBul2(String adi);

	public List<Personel> findByBolumAdi(String bolumAdi);

	@Query(value = "from Personel p where p.bolum.adi = ?1")
	public List<Personel> personelBulBolumAdinaGore(String bolumAdi);

	@Query(value = "select p,b from Personel p join p.bolum b")
	public List<Object[]> getPersonelveBolumler();
}
