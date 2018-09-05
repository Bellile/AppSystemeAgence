package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vistes")
public class Visite {

	// attribus
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_v")
	private int id;
	private Date dateHeure;
	

	// association uml en java
	
	@ManyToOne
	@JoinColumn(name="cl-id", referencedColumnName="id_cl")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="b_id", referencedColumnName="id_b")
	private BienImmobilier bienImmobilier;
	
	@ManyToOne
	@JoinColumn(name="r_id", referencedColumnName="id_r")
	private Responsable responsable;
	
	// constructeurs

	public Visite() {
		super();
	}

	public Visite(int id, Date dateHeure) {
		super();
		this.id = id;
		this.dateHeure = dateHeure;
	}

	public Visite(Date dateHeure) {
		super();
		this.dateHeure = dateHeure;
	}

	// getter et setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	// to string

	@Override
	public String toString() {
		return "Visite [id=" + id + ", dateHeure=" + dateHeure + "]";
	}

}
