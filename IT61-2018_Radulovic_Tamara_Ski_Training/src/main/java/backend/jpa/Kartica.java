package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kartica database table.
 * 
 */
@Entity
@NamedQuery(name="Kartica.findAll", query="SELECT k FROM Kartica k")
public class Kartica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KARTICA_ID_GENERATOR", sequenceName="KARTICA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KARTICA_ID_GENERATOR")
	private Integer id;

	@Column(name="broj_racuna")
	private String brojRacuna;

	private String ccv;

	@Temporal(TemporalType.DATE)
	@Column(name="vazi_do")
	private Date vaziDo;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="clan")
	private Clan clan;

	public Kartica() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return this.brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getCcv() {
		return this.ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	public Date getVaziDo() {
		return this.vaziDo;
	}

	public void setVaziDo(Date vaziDo) {
		this.vaziDo = vaziDo;
	}

	public Clan getClan() {
		return this.clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

}