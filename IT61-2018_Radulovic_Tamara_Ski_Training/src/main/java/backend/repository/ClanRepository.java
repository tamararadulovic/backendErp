package backend.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import backend.jpa.Clan;

public interface ClanRepository extends JpaRepository<Clan,Integer>{
	
	Collection<Clan> findByImeClanaContainingIgnoreCase(@Param("ime_clana")String ime_clana);
	Collection<Clan> findByPrezimeClanaContainingIgnoreCase(@Param("prezime_clana") String prezime_clana);
	

}
