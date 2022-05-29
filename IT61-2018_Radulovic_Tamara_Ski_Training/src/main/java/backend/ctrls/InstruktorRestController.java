package backend.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.jpa.Instruktor;
import backend.repository.InstruktorRepository;

@RestController
public class InstruktorRestController {
	
	@Autowired
	private InstruktorRepository instruktorRepository;
	
	@GetMapping("instruktor")
	public Collection<Instruktor> getInstruktori(){
		return instruktorRepository.findAll();
	}
	
	@GetMapping("instruktor/{zaposleni}")
	public Instruktor getInstruktor(@PathVariable("zaposleni")Integer zaposleni) {
		return instruktorRepository.getOne(zaposleni);
	}
	
	
	/* @PostMapping("instruktor")
	 public ResponseEntity<Instruktor> insertInstruktor(@RequestBody Instruktor instruktor){
		 if(!instruktorRepository.existsById(instruktor.getZaposleni())) {
			 instruktorRepository.save(instruktor);
			 return new ResponseEntity<Instruktor>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Instruktor>(HttpStatus.CONFLICT);
	 }
	 
	 @PutMapping("instruktor")
	 public ResponseEntity<Instruktor> updateInstruktor(@RequestBody Instruktor instruktor){
		 if(!instruktorRepository.existsById(instruktor.getZaposleni())) {
			 return new ResponseEntity<Instruktor>(HttpStatus.NO_CONTENT);
		 }
		 instruktorRepository.save(instruktor);
		 return new ResponseEntity<Instruktor>(HttpStatus.OK);
	 }*/
	 
	 
	 @DeleteMapping("instruktor/{zaposleni}")
	 public ResponseEntity<Instruktor> deleteInstruktor(@PathVariable("zaposleni") Integer zaposleni){
		 if(!instruktorRepository.existsById(zaposleni)) {
			 return new ResponseEntity<Instruktor>(HttpStatus.NO_CONTENT);
		 }
		instruktorRepository.deleteById(zaposleni);
		return new ResponseEntity<Instruktor>(HttpStatus.OK);
	 }
	

}
