package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "agences")
public class Agence implements Serializable{

	// attribus
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_a")
	private int id;
	private String nom;

	// association uml en java
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy="agence", fetch=FetchType.EAGER)
	private List<Responsable> listeResponsable;
	
	@Embedded
	private Adresse adresse;

	// constructeurs

	public Agence() {
		super();
	}

	public Agence(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Agence(String nom) {
		super();
		this.nom = nom;
	}

	// getter et setter	

	public int getId() {
		return id;
	}
	@JsonIgnoreProperties("agence")
	public List<Responsable> getListeResponsable() {
		return listeResponsable;
	}

	public void setListeResponsable(List<Responsable> listeResponsable) {
		this.listeResponsable = listeResponsable;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// to string

	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + "]";
	}

}
