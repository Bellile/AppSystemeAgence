package fr.adaming.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Personne {
	
	//Attributs
	protected String nom;
	protected String telPerso;
	protected String mail;
	
	//Constructeurs
	public Personne() {
		super();
	}
	public Personne(String nom, String telPerso, String mail) {
		super();
		this.nom = nom;
		this.telPerso = telPerso;
		this.mail = mail;
	}

	//Getter/Setter
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelPerso() {
		return telPerso;
	}

	public void setTelPerso(String telPerso) {
		this.telPerso = telPerso;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", telPerso=" + telPerso + ", mail=" + mail + "]";
	}

	
}
