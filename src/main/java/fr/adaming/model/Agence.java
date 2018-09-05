package fr.adaming.model;

public class Agence {

	// attribus

	private int id;
	private String nom;

	// association uml en java

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

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//to string
	
	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + "]";
	}

}
