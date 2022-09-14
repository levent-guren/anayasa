package tr.gov.anayasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.anayasa.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {

}
