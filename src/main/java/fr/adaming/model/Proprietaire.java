package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="proprietaires")
public class Proprietaire extends Personne {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private int id;
	private String telPro;
	
	//Transformations de l'association UML en JAVA
	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy="proprietaire")
	private List<BienImmobilierAVendre> listeBienImmobilierAVendre;
	
	@OneToMany(mappedBy="proprietaire")
	private List<BienImmobilierALouer> listeBienImmobilierALouer;
	
	//Constructeurs
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

	//Getter/Setter
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

	public List<BienImmobilierAVendre> getListeBienImmobilierAVendre() {
		return listeBienImmobilierAVendre;
	}
	public void setListeBienImmobilierAVendre(List<BienImmobilierAVendre> listeBienImmobilierAVendre) {
		this.listeBienImmobilierAVendre = listeBienImmobilierAVendre;
	}
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
