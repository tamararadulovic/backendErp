package backend.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.jpa.Clan;
import backend.repository.ClanRepository;

@RestController
public class ClanRestController {
	
	@Autowired
	private ClanRepository clanRepository;
	
	@GetMapping("clan")
	public Collection<Clan> getClanovi(){
		return clanRepository.findAll();
	}
	
	@GetMapping("clan/{id}")
	public Clan getClan(@PathVariable("id") Integer id) {
		return clanRepository.getOne(id);
	}
	
	@GetMapping("clanIme/{ime_clana}")
	public Collection<Clan> getClanByIme(@PathVariable("ime_clana") String ime_clana){
		return clanRepository.findByImeClanaContainingIgnoreCase(ime_clana);
	}
	
	@GetMapping("clanPrezime/{prezime_clana}")
	public Collection<Clan> getClanByPrezime(@PathVariable("prezime_clana") String prezime_clana){
		return clanRepository.findByPrezimeClanaContainingIgnoreCase(prezime_clana);
	}
	
	@PostMapping("clan")
	public ResponseEntity<Clan> insertClan(@RequestBody Clan clan){
		if(!clanRepository.existsById(clan.getId())) {
			clanRepository.save(clan);
			return new ResponseEntity<Clan>(HttpStatus.OK);
		}
		return new ResponseEntity<Clan>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("clan")
	public ResponseEntity<Clan> updateClan(@RequestBody Clan clan) {
		if (!clanRepository.existsById(clan.getId()))
			return new ResponseEntity<Clan>(HttpStatus.CONFLICT);
		clanRepository.save(clan);
		return new ResponseEntity<Clan>(HttpStatus.OK);
	}
	
	@DeleteMapping("clan/{id}")
	public ResponseEntity<Clan> deleteClan(@PathVariable Integer id)  {
		if (!clanRepository.existsById(id))
			return new ResponseEntity<Clan>(HttpStatus.NO_CONTENT);
		clanRepository.deleteById(id);
		return new ResponseEntity<Clan>(HttpStatus.OK);
	}

}
