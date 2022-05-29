package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oprema database table.
 * 
 */
@Entity
@NamedQuery(name="Oprema.findAll", query="SELECT o FROM Oprema o")
public class Oprema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OPREMA_ID_GENERATOR", sequenceName="OPREMA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPREMA_ID_GENERATOR")
	private Integer id;

	@Column(name="cena_iznajmljivanja")
	private BigDecimal cenaIznajmljivanja;

	@Temporal(TemporalType.DATE)
	private Date garancija;

	@Column(name="kolicina_na_stanju")
	private Integer kolicinaNaStanju;

	@Column(name="naziv_opreme")
	private String nazivOpreme;

	@Column(name="opis_opreme")
	private String opisOpreme;

	private String velicina;

	//bi-directional many-to-many association to Clan
	@ManyToMany
	@JoinTable(
		name="clanoprema"
		, joinColumns={
			@JoinColumn(name="oprema")
			}
		, inverseJoinColumns={
			@JoinColumn(name="clan")
			}
		)
	private List<Clan> clans;

	//bi-directional many-to-one association to Proizvodjac
	@ManyToOne
	@JoinColumn(name="proizvodjac")
	private Proizvodjac proizvodjac;

	//bi-directional many-to-one association to Tipopreme
	@ManyToOne
	@JoinColumn(name="tipopreme")
	private Tipopreme tipopreme;

	public Oprema() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCenaIznajmljivanja() {
		return this.cenaIznajmljivanja;
	}

	public void setCenaIznajmljivanja(BigDecimal cenaIznajmljivanja) {
		this.cenaIznajmljivanja = cenaIznajmljivanja;
	}

	public Date getGarancija() {
		return this.garancija;
	}

	public void setGarancija(Date garancija) {
		this.garancija = garancija;
	}

	public Integer getKolicinaNaStanju() {
		return this.kolicinaNaStanju;
	}

	public void setKolicinaNaStanju(Integer kolicinaNaStanju) {
		this.kolicinaNaStanju = kolicinaNaStanju;
	}

	public String getNazivOpreme() {
		return this.nazivOpreme;
	}

	public void setNazivOpreme(String nazivOpreme) {
		this.nazivOpreme = nazivOpreme;
	}

	public String getOpisOpreme() {
		return this.opisOpreme;
	}

	public void setOpisOpreme(String opisOpreme) {
		this.opisOpreme = opisOpreme;
	}

	public String getVelicina() {
		return this.velicina;
	}

	public void setVelicina(String velicina) {
		this.velicina = velicina;
	}

	public List<Clan> getClans() {
		return this.clans;
	}

	public void setClans(List<Clan> clans) {
		this.clans = clans;
	}

	public Proizvodjac getProizvodjac() {
		return this.proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public Tipopreme getTipopreme() {
		return this.tipopreme;
	}

	public void setTipopreme(Tipopreme tipopreme) {
		this.tipopreme = tipopreme;
	}

}