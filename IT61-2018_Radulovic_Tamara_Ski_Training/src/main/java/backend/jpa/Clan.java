package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clan database table.
 * 
 */
@Entity
@NamedQuery(name="Clan.findAll", query="SELECT c FROM Clan c")
public class Clan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLAN_ID_GENERATOR", sequenceName="CLAN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLAN_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_rodjenja")
	private Date datumRodjenja;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_uclanjenja")
	private Date datumUclanjenja;

	@Column(name="ime_clana")
	private String imeClana;

	@Column(name="korisnicko_ime")
	private String korisnickoIme;

	private String lozinka;

	@Column(name="prezime_clana")
	private String prezimeClana;

	private String telefon;

	//bi-directional many-to-many association to Obuka
	@JsonIgnore
	@ManyToMany(mappedBy="clans")
	private List<Obuka> obukas;

	//bi-directional many-to-many association to Oprema
	@JsonIgnore
	@ManyToMany(mappedBy="clans")
	private List<Oprema> opremas;

	//bi-directional many-to-one association to Kartica
	@JsonIgnore
	@OneToMany(mappedBy="clan")
	private List<Kartica> karticas;

	//bi-directional many-to-one association to Racun
	@JsonIgnore
	@OneToMany(mappedBy="clan")
	private List<Racun> racuns;

	public Clan() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Date getDatumUclanjenja() {
		return this.datumUclanjenja;
	}

	public void setDatumUclanjenja(Date datumUclanjenja) {
		this.datumUclanjenja = datumUclanjenja;
	}

	public String getImeClana() {
		return this.imeClana;
	}

	public void setImeClana(String imeClana) {
		this.imeClana = imeClana;
	}

	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getPrezimeClana() {
		return this.prezimeClana;
	}

	public void setPrezimeClana(String prezimeClana) {
		this.prezimeClana = prezimeClana;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Obuka> getObukas() {
		return this.obukas;
	}

	public void setObukas(List<Obuka> obukas) {
		this.obukas = obukas;
	}

	public List<Oprema> getOpremas() {
		return this.opremas;
	}

	public void setOpremas(List<Oprema> opremas) {
		this.opremas = opremas;
	}

	public List<Kartica> getKarticas() {
		return this.karticas;
	}

	public void setKarticas(List<Kartica> karticas) {
		this.karticas = karticas;
	}

	public Kartica addKartica(Kartica kartica) {
		getKarticas().add(kartica);
		kartica.setClan(this);

		return kartica;
	}

	public Kartica removeKartica(Kartica kartica) {
		getKarticas().remove(kartica);
		kartica.setClan(null);

		return kartica;
	}

	public List<Racun> getRacuns() {
		return this.racuns;
	}

	public void setRacuns(List<Racun> racuns) {
		this.racuns = racuns;
	}

	public Racun addRacun(Racun racun) {
		getRacuns().add(racun);
		racun.setClan(this);

		return racun;
	}

	public Racun removeRacun(Racun racun) {
		getRacuns().remove(racun);
		racun.setClan(null);

		return racun;
	}

}