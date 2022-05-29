package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the obuka database table.
 * 
 */
@Entity
@NamedQuery(name="Obuka.findAll", query="SELECT o FROM Obuka o")
public class Obuka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBUKA_ID_GENERATOR", sequenceName="OBUKA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBUKA_ID_GENERATOR")
	private Integer id;

	@Column(name="broj_casova")
	private Integer brojCasova;

	@Column(name="broj_clanova")
	private Integer brojClanova;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_pocetka")
	private Date datumPocetka;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_zavrsetka")
	private Date datumZavrsetka;

	private String trajanje;

	//bi-directional many-to-many association to Clan
	@ManyToMany
	@JoinTable(
		name="clanobuka"
		, joinColumns={
			@JoinColumn(name="obuka")
			}
		, inverseJoinColumns={
			@JoinColumn(name="clan")
			}
		)
	private List<Clan> clans;

	//bi-directional many-to-one association to Zaposleni
	@ManyToOne
	@JoinColumn(name="zaposleni")
	private Zaposleni zaposleni;

	public Obuka() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrojCasova() {
		return this.brojCasova;
	}

	public void setBrojCasova(Integer brojCasova) {
		this.brojCasova = brojCasova;
	}

	public Integer getBrojClanova() {
		return this.brojClanova;
	}

	public void setBrojClanova(Integer brojClanova) {
		this.brojClanova = brojClanova;
	}

	public Date getDatumPocetka() {
		return this.datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumZavrsetka() {
		return this.datumZavrsetka;
	}

	public void setDatumZavrsetka(Date datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	public String getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}

	public List<Clan> getClans() {
		return this.clans;
	}

	public void setClans(List<Clan> clans) {
		this.clans = clans;
	}

	public Zaposleni getZaposleni() {
		return this.zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

}