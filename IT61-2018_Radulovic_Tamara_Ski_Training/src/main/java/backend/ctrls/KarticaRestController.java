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
import backend.jpa.Kartica;
import backend.repository.ClanRepository;
import backend.repository.KarticaRepository;

@RestController
public class KarticaRestController {

	@Autowired
	private KarticaRepository karticaRepository;
	
	@Autowired
	private ClanRepository clanRepository;
	
	@GetMapping("kartica")
	public Collection<Kartica> getKartice(){
		return karticaRepository.findAll();
	}
	
	@GetMapping("kartica/{id}")
	public Kartica getKartica(@PathVariable("id") Integer id) {
		return karticaRepository.getOne(id);
	}
	
	@GetMapping("karticaZaClanaId/{id}")
	public Collection<Kartica> karticaPoClanu(@PathVariable("id") Integer id){
		Clan c = clanRepository.getOne(id);
		return karticaRepository.findByClan(c);
	}
	
	 @PostMapping("kartica")
	 public ResponseEntity<Kartica> insertKartica(@RequestBody Kartica kartica){
		 if(!karticaRepository.existsById(kartica.getId())) {
			 karticaRepository.save(kartica);
			 return new ResponseEntity<Kartica>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Kartica>(HttpStatus.CONFLICT);
	 }
	 
	 @PutMapping("kartica")
	 public ResponseEntity<Kartica> updateKartica(@RequestBody Kartica kartica){
		 if(!karticaRepository.existsById(kartica.getId())) {
			 return new ResponseEntity<Kartica>(HttpStatus.NO_CONTENT);
		 }
		 karticaRepository.save(kartica);
		 return new ResponseEntity<Kartica>(HttpStatus.OK);
	 }
	 
	 
	 @DeleteMapping("kartica/{id}")
	 public ResponseEntity<Kartica> deleteKartica(@PathVariable("id") Integer id){
		 if(!karticaRepository.existsById(id)) {
			 return new ResponseEntity<Kartica>(HttpStatus.NO_CONTENT);
		 }
		karticaRepository.deleteById(id);
		return new ResponseEntity<Kartica>(HttpStatus.OK);
	 }
}
