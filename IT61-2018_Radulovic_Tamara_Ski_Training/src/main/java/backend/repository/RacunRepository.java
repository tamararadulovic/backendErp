package backend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.jpa.Clan;
import backend.jpa.Racun;

public interface RacunRepository extends JpaRepository<Racun, Integer>{

	Collection<Racun> findByClan(Clan c);
}
