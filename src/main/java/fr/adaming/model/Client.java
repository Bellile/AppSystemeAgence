package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client extends Personne {
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private int id;
	private boolean acquereur;
	private String numCompostage;
	
	//Associations UML en JAVA
	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy="client")
	private List<Contrat> contrat;
	
	@ManyToMany
	@JoinTable
	private List<ClasseStandard> listeClasseStandard;
	
	//Constructeurs
	public Client() {
		super();
	}
	public Client(String nom, String telPerso, String mail, boolean acquereur, String numCompostage, Adresse adresse) {
		super(nom, telPerso, mail);
		this.acquereur = acquereur;
		this.numCompostage = numCompostage;
		this.adresse = adresse;
	}
	public Client(String nom, String telPerso, String mail, int id, boolean acquereur, String numCompostage, Adresse adresse) {
		super(nom, telPerso, mail);
		this.id = id;
		this.acquereur = acquereur;
		this.numCompostage = numCompostage;
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", acquereur=" + acquereur + ", numCompostage=" + numCompostage + "]";
	}
	
	
}
