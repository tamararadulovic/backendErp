package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the zaposleni database table.
 * 
 */
@Entity
@NamedQuery(name="Zaposleni.findAll", query="SELECT z FROM Zaposleni z")
public class Zaposleni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ZAPOSLENI_ID_GENERATOR", sequenceName="ZAPOSLENI_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ZAPOSLENI_ID_GENERATOR")
	private Integer id;

	private String adresa;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_rodjenja")
	private Date datumRodjenja;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_zaposlenja")
	private Date datumZaposlenja;

	@Column(name="ime_zaposlenog")
	private String imeZaposlenog;

	@Column(name="korisnicko_ime")
	private String korisnickoIme;

	private String lozinka;

	@Column(name="prezime_zaposlenog")
	private String prezimeZaposlenog;

	@Column(name="strucna_sprema")
	private String strucnaSprema;

	private String telefon;

	//bi-directional one-to-one association to Instruktor
	@JsonIgnore
	@OneToOne(mappedBy="zaposleniI")
	private Instruktor instruktor;

	//bi-directional many-to-one association to Obuka
	@JsonIgnore
	@OneToMany(mappedBy="zaposleni")
	private List<Obuka> obukas;

	public Zaposleni() {
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

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Date getDatumZaposlenja() {
		return this.datumZaposlenja;
	}

	public void setDatumZaposlenja(Date datumZaposlenja) {
		this.datumZaposlenja = datumZaposlenja;
	}

	public String getImeZaposlenog() {
		return this.imeZaposlenog;
	}

	public void setImeZaposlenog(String imeZaposlenog) {
		this.imeZaposlenog = imeZaposlenog;
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

	public String getPrezimeZaposlenog() {
		return this.prezimeZaposlenog;
	}

	public void setPrezimeZaposlenog(String prezimeZaposlenog) {
		this.prezimeZaposlenog = prezimeZaposlenog;
	}

	public String getStrucnaSprema() {
		return this.strucnaSprema;
	}

	public void setStrucnaSprema(String strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Instruktor getInstruktor() {
		return this.instruktor;
	}

	public void setInstruktor(Instruktor instruktor) {
		this.instruktor = instruktor;
	}

	public List<Obuka> getObukas() {
		return this.obukas;
	}

	public void setObukas(List<Obuka> obukas) {
		this.obukas = obukas;
	}

	public Obuka addObuka(Obuka obuka) {
		getObukas().add(obuka);
		obuka.setZaposleni(this);

		return obuka;
	}

	public Obuka removeObuka(Obuka obuka) {
		getObukas().remove(obuka);
		obuka.setZaposleni(null);

		return obuka;
	}

}