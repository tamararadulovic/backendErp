package backend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.jpa.Clan;
import backend.jpa.Kartica;

public interface KarticaRepository extends JpaRepository<Kartica, Integer>{

	Collection<Kartica> findByClan(Clan c);
}
