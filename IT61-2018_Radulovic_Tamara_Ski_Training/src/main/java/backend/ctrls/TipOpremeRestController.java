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

import backend.jpa.Tipopreme;
import backend.jpa.Zaposleni;
import backend.repository.TipOpremeRepository;

@RestController
public class TipOpremeRestController {
	
	@Autowired
	private TipOpremeRepository tipOpremeRepository;
	
	@GetMapping("tipopreme")
	public Collection<Tipopreme> getTipoviOpreme(){
		return tipOpremeRepository.findAll();
	}
	
	@GetMapping("tipopreme/{id}")
	public Tipopreme getTipOpreme(@PathVariable("id") Integer id) {
		return tipOpremeRepository.getOne(id);
	}
	
	@GetMapping("tipopremeNaziv/{naziv_tipa}")
	public Collection<Tipopreme> getTipOpremeByNaziv(@PathVariable("naziv_tipa") String naziv_tipa){
		return tipOpremeRepository.findByNazivTipaContainingIgnoreCase(naziv_tipa);
	}
	
	@PostMapping("tipopreme")
	public ResponseEntity<Tipopreme> insertTipOpreme(@RequestBody Tipopreme tipOpreme){
		if(!tipOpremeRepository.existsById(tipOpreme.getId())) {
			tipOpremeRepository.save(tipOpreme);
			return new ResponseEntity<Tipopreme>(HttpStatus.OK);
		}
		return new ResponseEntity<Tipopreme>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("tipopreme")
	public ResponseEntity<Tipopreme> updateTipOpreme(@RequestBody Tipopreme tipOpreme){
		if(!tipOpremeRepository.existsById(tipOpreme.getId())) {
			return new ResponseEntity<Tipopreme>(HttpStatus.NO_CONTENT);
		}
		tipOpremeRepository.save(tipOpreme);
		return new ResponseEntity<Tipopreme>(HttpStatus.OK);
	}
	
	@DeleteMapping("tipopreme/{id}")
	public ResponseEntity<Tipopreme> deleteTipOpreme(@PathVariable("id") Integer id){
		if(!tipOpremeRepository.existsById(id)) {
			return new ResponseEntity<Tipopreme>(HttpStatus.NO_CONTENT);
		}
		tipOpremeRepository.deleteById(id);
		return new ResponseEntity<Tipopreme>(HttpStatus.OK);
	}
}
