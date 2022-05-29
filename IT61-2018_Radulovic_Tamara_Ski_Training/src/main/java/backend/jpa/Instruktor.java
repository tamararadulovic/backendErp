package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the instruktor database table.
 * 
 */
@Entity
@NamedQuery(name="Instruktor.findAll", query="SELECT i FROM Instruktor i")
public class Instruktor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INSTRUKTOR_ZAPOSLENI_GENERATOR", sequenceName="INSTRUKTOR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUKTOR_ZAPOSLENI_GENERATOR")
	private Integer zaposleni;

	private String licenca;

	private String zvanje;

	//bi-directional one-to-one association to Zaposleni
	@OneToOne
	@JoinColumn(name="zaposleni")
	private Zaposleni zaposleniI;

	public Instruktor() {
	}

	public Integer getZaposleni() {
		return this.zaposleni;
	}

	public void setZaposleni(Integer zaposleni) {
		this.zaposleni = zaposleni;
	}

	public String getLicenca() {
		return this.licenca;
	}

	public void setLicenca(String licenca) {
		this.licenca = licenca;
	}

	public String getZvanje() {
		return this.zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

}