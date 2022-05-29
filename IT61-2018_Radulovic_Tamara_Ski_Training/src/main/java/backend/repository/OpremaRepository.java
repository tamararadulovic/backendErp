package backend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import backend.jpa.Oprema;
import backend.jpa.Proizvodjac;
import backend.jpa.Tipopreme;

public interface OpremaRepository extends JpaRepository<Oprema, Integer>{
	
	Collection<Oprema> findByNazivOpremeContainingIgnoreCase(@Param("naziv_opreme")String naziv_opreme);
	Collection<Oprema> findByTipopreme(Tipopreme t);
	Collection<Oprema> findByProizvodjac(Proizvodjac p);

}
