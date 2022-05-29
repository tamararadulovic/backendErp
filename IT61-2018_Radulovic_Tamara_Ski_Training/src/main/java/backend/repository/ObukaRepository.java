package backend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.jpa.Obuka;
import backend.jpa.Zaposleni;

public interface ObukaRepository extends JpaRepository<Obuka,Integer>{

	Collection<Obuka> findByZaposleni(Zaposleni z);
}