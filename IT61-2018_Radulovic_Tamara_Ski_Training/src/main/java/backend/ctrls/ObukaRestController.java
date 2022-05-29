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


import backend.jpa.Obuka;
import backend.jpa.Zaposleni;
import backend.repository.ObukaRepository;
import backend.repository.ZaposleniRepository;

@RestController
public class ObukaRestController {
	
	@Autowired
	private ObukaRepository obukaRepository;
	
	@Autowired
	private ZaposleniRepository zaposleniRepository;
	
	@GetMapping("obuka")
	public Collection<Obuka> getObuke(){
		return obukaRepository.findAll();
	}
	
	@GetMapping("obuka/{id}")
	public Obuka getObuka(@PathVariable("id")Integer id) {
		return obukaRepository.getOne(id);
	}
	
	@GetMapping("obukaPoZaposlenomId/{id}")
	public Collection<Obuka> obukaPoZaposlenom(@PathVariable("id")Integer id){
		Zaposleni z = zaposleniRepository.getOne(id);
		return obukaRepository.findByZaposleni(z);
	}
	
	 @PostMapping("obuka")
	 public ResponseEntity<Obuka> insertObuka(@RequestBody Obuka obuka){
		 if(!obukaRepository.existsById(obuka.getId())) {
			 obukaRepository.save(obuka);
			 return new ResponseEntity<Obuka>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Obuka>(HttpStatus.CONFLICT);
	 }
	 
	 @PutMapping("obuka")
	 public ResponseEntity<Obuka> updateObuka(@RequestBody Obuka obuka){
		 if(!obukaRepository.existsById(obuka.getId())) {
			 return new ResponseEntity<Obuka>(HttpStatus.NO_CONTENT);
		 }
		 obukaRepository.save(obuka);
		 return new ResponseEntity<Obuka>(HttpStatus.OK);
	 }
	 
	 
	 @DeleteMapping("obuka/{id}")
	 public ResponseEntity<Obuka> deleteObuka(@PathVariable("id") Integer id){
		 if(!obukaRepository.existsById(id)) {
			 return new ResponseEntity<Obuka>(HttpStatus.NO_CONTENT);
		 }
		obukaRepository.deleteById(id);
		return new ResponseEntity<Obuka>(HttpStatus.OK);
	 }

}
