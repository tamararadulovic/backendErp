package backend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import backend.jpa.Zaposleni;

public interface ZaposleniRepository extends JpaRepository<Zaposleni, Integer>{

	Collection<Zaposleni> findByImeZaposlenogContainingIgnoreCase(@Param("ime_zaposlenog")String ime_zaposlenog);
	Collection<Zaposleni> findByPrezimeZaposlenogContainingIgnoreCase(@Param("prezime_zaposlenog") String prezime_zaposlenog);
}
