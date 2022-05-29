package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tipopreme database table.
 * 
 */
@Entity
@NamedQuery(name="Tipopreme.findAll", query="SELECT t FROM Tipopreme t")
public class Tipopreme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOPREME_ID_GENERATOR", sequenceName="TIPOPREME_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOPREME_ID_GENERATOR")
	private Integer id;

	@Column(name="naziv_tipa")
	private String nazivTipa;

	@Column(name="opis_tipa")
	private String opisTipa;

	//bi-directional many-to-one association to Oprema
	@JsonIgnore
	@OneToMany(mappedBy="tipopreme")
	private List<Oprema> opremas;

	public Tipopreme() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNazivTipa() {
		return this.nazivTipa;
	}

	public void setNazivTipa(String nazivTipa) {
		this.nazivTipa = nazivTipa;
	}

	public String getOpisTipa() {
		return this.opisTipa;
	}

	public void setOpisTipa(String opisTipa) {
		this.opisTipa = opisTipa;
	}

	public List<Oprema> getOpremas() {
		return this.opremas;
	}

	public void setOpremas(List<Oprema> opremas) {
		this.opremas = opremas;
	}

	public Oprema addOprema(Oprema oprema) {
		getOpremas().add(oprema);
		oprema.setTipopreme(this);

		return oprema;
	}

	public Oprema removeOprema(Oprema oprema) {
		getOpremas().remove(oprema);
		oprema.setTipopreme(null);

		return oprema;
	}

}