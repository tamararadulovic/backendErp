package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the proizvodjac database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvodjac.findAll", query="SELECT p FROM Proizvodjac p")
public class Proizvodjac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROIZVODJAC_ID_GENERATOR", sequenceName="PROIZVODJAC_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROIZVODJAC_ID_GENERATOR")
	private Integer id;

	private String adresa;

	@Column(name="naziv_proizvodjaca")
	private String nazivProizvodjaca;

	private String telefon;

	//bi-directional many-to-one association to Oprema
	@JsonIgnore
	@OneToMany(mappedBy="proizvodjac")
	private List<Oprema> opremas;

	public Proizvodjac() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNazivProizvodjaca() {
		return this.nazivProizvodjaca;
	}

	public void setNazivProizvodjaca(String nazivProizvodjaca) {
		this.nazivProizvodjaca = nazivProizvodjaca;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Oprema> getOpremas() {
		return this.opremas;
	}

	public void setOpremas(List<Oprema> opremas) {
		this.opremas = opremas;
	}

	public Oprema addOprema(Oprema oprema) {
		getOpremas().add(oprema);
		oprema.setProizvodjac(this);

		return oprema;
	}

	public Oprema removeOprema(Oprema oprema) {
		getOpremas().remove(oprema);
		oprema.setProizvodjac(null);

		return oprema;
	}

}