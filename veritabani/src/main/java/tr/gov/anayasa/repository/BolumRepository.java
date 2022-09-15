package tr.gov.anayasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.anayasa.entity.Bolum;

public interface BolumRepository extends JpaRepository<Bolum, Integer> {
}
