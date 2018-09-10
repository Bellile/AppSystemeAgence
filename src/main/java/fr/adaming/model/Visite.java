package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "visites")
public class Visite implements Serializable{

	// attribus
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_v")
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateHeure;
	

	// association uml en java
	@ManyToOne
	@JoinColumn(name="cl_id", referencedColumnName="id_cl")
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
	
	// lien avec le contrat
	@Fetch(FetchMode.SELECT)
	@OneToOne(mappedBy = "visite", fetch = FetchType.EAGER)
	private Contrat contrat;
	
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
	
	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	
	// to string

	@Override
	public String toString() {
		return "Visite [id=" + id + ", dateHeure=" + dateHeure + "]";
	}

}
