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

import backend.jpa.Proizvodjac;
import backend.repository.ProizvodjacRepository;

@RestController
public class ProizvodjacRestController {

	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	
	@GetMapping("proizvodjac")
	public Collection<Proizvodjac> getProizvodjaci(){
		return proizvodjacRepository.findAll();
	}
	
	@GetMapping("proizvodjac/{id}")
	public Proizvodjac getProizvodjac(@PathVariable("id") Integer id) {
		return proizvodjacRepository.getOne(id);
	}
	
	@GetMapping("proizvodjacNaziv/{naziv_proizvodjaca}")
	public Collection<Proizvodjac> getProizvodjacByNaziv(@PathVariable("naziv_proizvodjaca") String naziv_proizvodjaca){
		return proizvodjacRepository.findByNazivProizvodjacaContainingIgnoreCase(naziv_proizvodjaca);
	}
	
	@PostMapping("proizvodjac")
	public ResponseEntity<Proizvodjac> insertProizvodjac(@RequestBody Proizvodjac proizvodjac){
		if(!proizvodjacRepository.existsById(proizvodjac.getId())) {
			proizvodjacRepository.save(proizvodjac);
			return new ResponseEntity<Proizvodjac>(HttpStatus.OK);
		}
		return new ResponseEntity<Proizvodjac>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("proizvodjac")
	public ResponseEntity<Proizvodjac> updateProizvodjac(@RequestBody Proizvodjac proizvodjac){
		if(!proizvodjacRepository.existsById(proizvodjac.getId())) {
			return new ResponseEntity<Proizvodjac>(HttpStatus.NO_CONTENT);
		}
		proizvodjacRepository.save(proizvodjac);
		return new ResponseEntity<Proizvodjac>(HttpStatus.OK);
	}
	
	@DeleteMapping("proizvodjac/{id}")
	public ResponseEntity<Proizvodjac> deleteProizvodjac(@PathVariable("id") Integer id){
		if(!proizvodjacRepository.existsById(id)) {
			return new ResponseEntity<Proizvodjac>(HttpStatus.NO_CONTENT);
		}
		proizvodjacRepository.deleteById(id);
		return new ResponseEntity<Proizvodjac>(HttpStatus.OK);
	}
}
