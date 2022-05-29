package backend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import backend.jpa.Proizvodjac;

public interface ProizvodjacRepository extends JpaRepository<Proizvodjac, Integer> {
	
	Collection<Proizvodjac> findByNazivProizvodjacaContainingIgnoreCase(@Param("naziv_proizvodjaca")String naziv_proizvodjaca);
}
