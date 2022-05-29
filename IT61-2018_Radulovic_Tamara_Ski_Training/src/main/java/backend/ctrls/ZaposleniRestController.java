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

import backend.jpa.Zaposleni;
import backend.repository.ZaposleniRepository;

@RestController
public class ZaposleniRestController {
	
	@Autowired
	private ZaposleniRepository zaposleniRepository;
	
	@GetMapping("zaposleni")
	public Collection<Zaposleni> getZaposleni(){
		return zaposleniRepository.findAll();
	}
	
	@GetMapping("zaposleni/{id}")
	public Zaposleni getZaposleni(@PathVariable("id") Integer id) {
		return zaposleniRepository.getOne(id);
	}
	
	@GetMapping("zaposleniIme/{ime_zaposlenog}")
	public Collection<Zaposleni> getZaposleniByIme(@PathVariable("ime_zaposlenog") String ime_zaposlenog){
		return zaposleniRepository.findByImeZaposlenogContainingIgnoreCase(ime_zaposlenog);
	}
	
	@GetMapping("zaposleniPrezime/{prezime_zaposlenog}")
	public Collection<Zaposleni> getZaposleniByPrezime(@PathVariable("prezime_zaposlenog") String prezime_zaposlenog){
		return zaposleniRepository.findByPrezimeZaposlenogContainingIgnoreCase(prezime_zaposlenog);
	}
	
	@PostMapping("zaposleni")
	public ResponseEntity<Zaposleni> insertZaposleni(@RequestBody Zaposleni zaposleni){
		if(!zaposleniRepository.existsById(zaposleni.getId())) {
			zaposleniRepository.save(zaposleni);
			return new ResponseEntity<Zaposleni>(HttpStatus.OK);
		}
		return new ResponseEntity<Zaposleni>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("zaposleni")
	public ResponseEntity<Zaposleni> updateZaposleni(@RequestBody Zaposleni zaposleni){
		if(!zaposleniRepository.existsById(zaposleni.getId())) {
			return new ResponseEntity<Zaposleni>(HttpStatus.NO_CONTENT);
		}
		zaposleniRepository.save(zaposleni);
		return new ResponseEntity<Zaposleni>(HttpStatus.OK);
	}
	
	@DeleteMapping("zaposleni/{id}")
	public ResponseEntity<Zaposleni> deleteZaposleni(@PathVariable("id") Integer id){
		if(!zaposleniRepository.existsById(id)) {
			return new ResponseEntity<Zaposleni>(HttpStatus.NO_CONTENT);
		}
		zaposleniRepository.deleteById(id);
		return new ResponseEntity<Zaposleni>(HttpStatus.OK);
	}

}
