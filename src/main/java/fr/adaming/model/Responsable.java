package fr.adaming.model;

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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="responsables")
public class Responsable extends Personne{

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_r")
	private int id;
	private String identifiant;
	private String mdp;
	
	//Associations UML en JAVA
	@ManyToOne
	@JoinColumn(name="a_id", referencedColumnName="id_a")
	private Agence agence;
	

	@OneToMany(mappedBy="responsable")
	private List<Visite> listeVisite;
	
	//Constructeurs
	public Responsable() {
		super();
	}
	public Responsable(String nom, String telPerso, String mail, String identifiant, String mdp) {
		super(nom, telPerso, mail);
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	public Responsable(String nom, String telPerso, String mail, int id, String identifiant, String mdp) {
		super(nom, telPerso, mail);
		this.id = id;
		this.identifiant = identifiant;
		this.mdp = mdp;
	}

	//Getter/Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
		
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Visite> getListeVisite() {
		return listeVisite;
	}
	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}
	@Override
	public String toString() {
		return "Responsable [id=" + id + ", identifiant=" + identifiant + ", mdp=" + mdp + "]";
	}

	
}
