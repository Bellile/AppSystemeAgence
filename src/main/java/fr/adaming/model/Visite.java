package fr.adaming.model;

import java.util.Date;

public class Visite {

	// attribus

	private int id;
	private Date dateHeure;

	// asociation uml en java

	// constructeurs

	public Visite() {
		super();
	}

	public Visite(int id, Date dateHeure) {
		super();
		this.id = id;
		this.dateHeure = dateHeure;
	}

	public Visite(Date dateHeure) {
		super();
		this.dateHeure = dateHeure;
	}

	// getter et setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	// to string

	@Override
	public String toString() {
		return "Visite [id=" + id + ", dateHeure=" + dateHeure + "]";
	}

}
