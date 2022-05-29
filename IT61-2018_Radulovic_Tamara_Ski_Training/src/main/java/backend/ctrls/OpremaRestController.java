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

import backend.jpa.Oprema;
import backend.jpa.Proizvodjac;
import backend.jpa.Tipopreme;
import backend.repository.OpremaRepository;
import backend.repository.ProizvodjacRepository;
import backend.repository.TipOpremeRepository;

@RestController
public class OpremaRestController {
	
	@Autowired
	private OpremaRepository opremaRepository;
	
	@Autowired 
	private TipOpremeRepository tipOpremeRepository;
	
	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	
	@GetMapping("oprema")
	public Collection<Oprema> getOpreme(){
		return opremaRepository.findAll();
	}
	
	@GetMapping("oprema/{id}")
	public Oprema getOprema(@PathVariable ("id")Integer id) {
		return opremaRepository.getOne(id);
	}
	
	@GetMapping("opremaPoTipuId/{id}")
	public Collection<Oprema> opremaPoTipu(@PathVariable("id") Integer id){
		Tipopreme t = tipOpremeRepository.getOne(id);
		return opremaRepository.findByTipopreme(t);
	}
	
	@GetMapping("opremaPoProizvodjacuId/{id}")
	public Collection<Oprema> opremaPoProizvodjacu(@PathVariable("id") Integer id){
		Proizvodjac p = proizvodjacRepository.getOne(id);
		return opremaRepository.findByProizvodjac(p);
	}
	
	
	@GetMapping("opremaNaziv/{naziv_opreme}")
	public Collection<Oprema> getOpremaByNaziv(@PathVariable("naziv_opreme") String naziv_opreme){
		return opremaRepository.findByNazivOpremeContainingIgnoreCase(naziv_opreme);
	}
	
	@PostMapping("oprema")
	 public ResponseEntity<Oprema> insertprema(@RequestBody Oprema oprema){
		 if(!opremaRepository.existsById(oprema.getId())) {
			 opremaRepository.save(oprema);
			 return new ResponseEntity<Oprema>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Oprema>(HttpStatus.CONFLICT);
	 }
	 
	 @PutMapping("oprema")
	 public ResponseEntity<Oprema> updateOprema(@RequestBody Oprema oprema){
		 if(!opremaRepository.existsById(oprema.getId())) {
			 return new ResponseEntity<Oprema>(HttpStatus.NO_CONTENT);
		 }
		 opremaRepository.save(oprema);
		 return new ResponseEntity<Oprema>(HttpStatus.OK);
	 }
	 
	 
	 @DeleteMapping("oprema/{id}")
	 public ResponseEntity<Oprema> deleteOprema(@PathVariable("id") Integer id){
		 if(!opremaRepository.existsById(id)) {
			 return new ResponseEntity<Oprema>(HttpStatus.NO_CONTENT);
		 }
		opremaRepository.deleteById(id);
		return new ResponseEntity<Oprema>(HttpStatus.OK);
	 }

}
