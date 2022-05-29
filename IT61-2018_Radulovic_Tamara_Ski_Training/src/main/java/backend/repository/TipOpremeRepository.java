package backend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import backend.jpa.Tipopreme;

public interface TipOpremeRepository extends JpaRepository<Tipopreme, Integer> {

	Collection<Tipopreme> findByNazivTipaContainingIgnoreCase(@Param("naziv_tipa")String naziv_tipa);
}
