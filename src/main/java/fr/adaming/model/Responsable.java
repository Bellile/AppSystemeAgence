package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	//
	
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
	@Override
	public String toString() {
		return "Responsable [id=" + id + ", identifiant=" + identifiant + ", mdp=" + mdp + "]";
	}

	
}
