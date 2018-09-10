package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "contrats")
public class Contrat implements Serializable{

	// attribus
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_co")
	private int id;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date dateAcquisition;

	// associations uml en java

	
	//lien avec la visite
	@OneToOne
	@JoinColumn(name="v_id", referencedColumnName="id_v")
	private Visite visite;
	
	// constructeurs

	public Contrat() {
		super();
	}

	public Contrat(int id, String type, Date dateAcquisition) {
		super();
		this.id = id;
		this.type = type;
		this.dateAcquisition = dateAcquisition;
	}

	public Contrat(String type, Date dateAcquisition) {
		super();
		this.type = type;
		this.dateAcquisition = dateAcquisition;
	}

	// getter et setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(Date dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	
	@JsonIgnoreProperties("contrat")
	public Visite getVisite() {
		return visite;
	}

	public void setVisite(Visite visite) {
		this.visite = visite;
	}
	

	// to string

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", type=" + type + ", dateAcquisition=" + dateAcquisition + "]";
	}

}
