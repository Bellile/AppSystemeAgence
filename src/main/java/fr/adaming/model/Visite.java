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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "visites")
public class Visite {

	// attribus
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_v")
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateHeure;
	

	// association uml en java
	
	@ManyToOne
	@JoinColumn(name="cl-id", referencedColumnName="id_cl")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="bl_id", referencedColumnName="id_b")
	private BienImmobilierALouer bienImmobilierALouer;
	
	@ManyToOne
	@JoinColumn(name="bv_id", referencedColumnName="id_b")
	private BienImmobilierAVendre bienImmobilierAVendre;
	
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	
	public BienImmobilierALouer getBienImmobilierALouer() {
		return bienImmobilierALouer;
	}

	public void setBienImmobilierALouer(BienImmobilierALouer bienImmobilierALouer) {
		this.bienImmobilierALouer = bienImmobilierALouer;
	}

	public BienImmobilierAVendre getBienImmobilierAVendre() {
		return bienImmobilierAVendre;
	}

	public void setBienImmobilierAVendre(BienImmobilierAVendre bienImmobilierAVendre) {
		this.bienImmobilierAVendre = bienImmobilierAVendre;
	}
	
	
	// to string

	@Override
	public String toString() {
		return "Visite [id=" + id + ", dateHeure=" + dateHeure + "]";
	}

}
