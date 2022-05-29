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
import backend.jpa.Racun;
import backend.repository.ClanRepository;
import backend.repository.RacunRepository;

@RestController
public class RacunRestController {
	
	@Autowired
	private RacunRepository racunRepository;
	
	@Autowired
	private ClanRepository clanRepository;
	
	@GetMapping("racun")
	public Collection<Racun> getRacuni(){
		return racunRepository.findAll();
	}
	
	@GetMapping("racun/{id}")
	public Racun getRacun(@PathVariable("id")Integer id) {
		return racunRepository.getOne(id);
	}
	
	@GetMapping("racunZaClanaId/{id}")
	public Collection<Racun> racunPoClanu(@PathVariable("id")Integer id){
		Clan c = clanRepository.getOne(id);
		return racunRepository.findByClan(c);
	}
	
	@PostMapping("racun")
	 public ResponseEntity<Racun> insertRacun(@RequestBody Racun racun){
		 if(!racunRepository.existsById(racun.getId())) {
			 racunRepository.save(racun);
			 return new ResponseEntity<Racun>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Racun>(HttpStatus.CONFLICT);
	 }
	 
	 @PutMapping("racun")
	 public ResponseEntity<Racun> updateRacun(@RequestBody Racun racun){
		 if(!racunRepository.existsById(racun.getId())) {
			 return new ResponseEntity<Racun>(HttpStatus.NO_CONTENT);
		 }
		 racunRepository.save(racun);
		 return new ResponseEntity<Racun>(HttpStatus.OK);
	 }
	 
	 
	 @DeleteMapping("racun/{id}")
	 public ResponseEntity<Racun> deleteRacun(@PathVariable("id") Integer id){
		 if(!racunRepository.existsById(id)) {
			 return new ResponseEntity<Racun>(HttpStatus.NO_CONTENT);
		 }
		racunRepository.deleteById(id);
		return new ResponseEntity<Racun>(HttpStatus.OK);
	 }

}
