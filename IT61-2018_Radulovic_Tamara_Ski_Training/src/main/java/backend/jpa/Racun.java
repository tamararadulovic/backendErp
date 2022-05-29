package backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the racun database table.
 * 
 */
@Entity
@NamedQuery(name="Racun.findAll", query="SELECT r FROM Racun r")
public class Racun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RACUN_ID_GENERATOR", sequenceName="RACUN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RACUN_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_placanja")
	private Date datumPlacanja;

	private BigDecimal iznos;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="clan")
	private Clan clan;

	public Racun() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatumPlacanja() {
		return this.datumPlacanja;
	}

	public void setDatumPlacanja(Date datumPlacanja) {
		this.datumPlacanja = datumPlacanja;
	}

	public BigDecimal getIznos() {
		return this.iznos;
	}

	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}

	public Clan getClan() {
		return this.clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

}