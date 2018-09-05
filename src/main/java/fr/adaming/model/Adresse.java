package fr.adaming.model;

public class Adresse {
	// attributs
	private int numRue;
	private String rue;
	private String cp;
	private String localite;
	private String pays;
	
	// constructeurs
	public Adresse() {
		super();
	}
	public Adresse(int numRue, String rue, String cp, String localite, String pays) {
		super();
		this.numRue = numRue;
		this.rue = rue;
		this.cp = cp;
		this.localite = localite;
		this.pays = pays;
	}
	
	// getters et setters
	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	// toString
	@Override
	public String toString() {
		return "Adresse [numRue=" + numRue + ", rue=" + rue + ", cp=" + cp + ", localite=" + localite + ", pays=" + pays
				+ "]";
	}
	
}
