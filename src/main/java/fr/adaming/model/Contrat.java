package fr.adaming.model;

import java.util.Date;

public class Contrat {

	// attribus

	private int id;
	private String type;
	private Date dateAcquisition;

	// associations uml en java

	// constructeurs

	public Contrat() {
		super();
	}

	public Contrat(int id, String type, Date dateAcquisition) {
		super();
		this.id = id;
		this.type = type;
		this.dateAcquisition = dateAcquisition;
	}

	public Contrat(String type, Date dateAcquisition) {
		super();
		this.type = type;
		this.dateAcquisition = dateAcquisition;
	}

	// getter et setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(Date dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	//to string
	
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", type=" + type + ", dateAcquisition=" + dateAcquisition + "]";
	}

}
