package fr.adaming.model;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "proprietaires")
public class Proprietaire extends Personne {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_p")
	private int id;
	private String telPro;

	// Transformations de l'association UML en JAVA
	@Embedded
	private Adresse adresse;

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "proprietaire", fetch = FetchType.EAGER)
	private List<BienImmobilierAVendre> listeBienImmobilierAVendre;

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "proprietaire", fetch = FetchType.EAGER)
	private List<BienImmobilierALouer> listeBienImmobilierALouer;

	// Constructeurs
	public Proprietaire() {
		super();
	}

	public Proprietaire(String nom, String telPerso, String mail, String telPro, Adresse adresse) {
		super(nom, telPerso, mail);
		this.telPro = telPro;
		this.adresse = adresse;
	}

	public Proprietaire(String nom, String telPerso, String mail, int id, String telPro, Adresse adresse) {
		super(nom, telPerso, mail);
		this.id = id;
		this.telPro = telPro;
		this.adresse = adresse;
	}

	// Getter/Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelPro() {
		return telPro;
	}

	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@JsonIgnoreProperties("proprietaire")
	public List<BienImmobilierAVendre> getListeBienImmobilierAVendre() {
		return listeBienImmobilierAVendre;
	}

	public void setListeBienImmobilierAVendre(List<BienImmobilierAVendre> listeBienImmobilierAVendre) {
		this.listeBienImmobilierAVendre = listeBienImmobilierAVendre;
	}

	@JsonIgnoreProperties("proprietaire")
	public List<BienImmobilierALouer> getListeBienImmobilierALouer() {
		return listeBienImmobilierALouer;
	}

	public void setListeBienImmobilierALouer(List<BienImmobilierALouer> listeBienImmobilierALouer) {
		this.listeBienImmobilierALouer = listeBienImmobilierALouer;
	}

	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", telPro=" + telPro + "]";
	}

}
