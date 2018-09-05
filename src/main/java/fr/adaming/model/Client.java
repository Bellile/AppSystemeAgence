package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	//Constructeurs
	public Client() {
		super();
	}
	public Client(String nom, String telPerso, String mail, boolean acquereur, String numCompostage) {
		super(nom, telPerso, mail);
		this.acquereur = acquereur;
		this.numCompostage = numCompostage;
	}
	public Client(String nom, String telPerso, String mail, int id, boolean acquereur, String numCompostage) {
		super(nom, telPerso, mail);
		this.id = id;
		this.acquereur = acquereur;
		this.numCompostage = numCompostage;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", acquereur=" + acquereur + ", numCompostage=" + numCompostage + "]";
	}
	
	
}
