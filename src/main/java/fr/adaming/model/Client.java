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
@Table(name = "clients")
public class Client extends Personne {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private int id;
	private boolean acquereur;
	private String numCompostage;

	// Associations UML en JAVA
	@Embedded
	private Adresse adresse;

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)	
	private List<Visite> listeVisite;

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<Contrat> contrat;



	// Constructeurs
	public Client() {
		super();
	}

	public Client(String nom, String telPerso, String mail, boolean acquereur, String numCompostage, Adresse adresse) {
		super(nom, telPerso, mail);
		this.acquereur = acquereur;
		this.numCompostage = numCompostage;
		this.adresse = adresse;
	}

	public Client(String nom, String telPerso, String mail, int id, boolean acquereur, String numCompostage,
			Adresse adresse) {
		super(nom, telPerso, mail);
		this.id = id;
		this.acquereur = acquereur;
		this.numCompostage = numCompostage;
		this.adresse = adresse;
	}

	// Getter/Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAcquereur() {
		return acquereur;
	}

	public void setAcquereur(boolean acquereur) {
		this.acquereur = acquereur;
	}

	public String getNumCompostage() {
		return numCompostage;
	}

	public void setNumCompostage(String numCompostage) {
		this.numCompostage = numCompostage;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	@JsonIgnoreProperties("client")
	public List<Contrat> getContrat() {
		return contrat;
	}

	public void setContrat(List<Contrat> contrat) {
		this.contrat = contrat;
	}
	

	
	@JsonIgnoreProperties({"client","bienImmobilierALouer","bienImmobilierAVendre","responsable"})
	public List<Visite> getListeVisite() {
		return listeVisite;
	}

	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}

	// ToString
	@Override
	public String toString() {
		return "Client [id=" + id + ", acquereur=" + acquereur + ", numCompostage=" + numCompostage + "]";
	}

}
