package fr.adaming.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="biensimmobilieralouer")
public class BienImmobilierALouer extends BienImmobilier{
	
	//declaration des attributs
	private double caution;
	private double loyer;
	private double charges;
	private String typeBail;
	private String garniture;

	
	//declaration des constructeurs
	public BienImmobilierALouer() {
		super();
	}

	public BienImmobilierALouer(String typeBien, String statut, double revenuCadastre, Date dateSoumission,
			Date dateDisposition, byte[] listeImage, Adresse adresse, Proprietaire proprietaire, double caution,
			double loyer, double charges, String typeBail, String garniture) {
		super(typeBien, statut, revenuCadastre, dateSoumission, dateDisposition, listeImage, adresse, proprietaire);
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.typeBail = typeBail;
		this.garniture = garniture;
	}

	public BienImmobilierALouer(int id, String typeBien, String statut, double revenuCadastre, Date dateSoumission,
			Date dateDisposition, byte[] listeImage, Adresse adresse, Proprietaire proprietaire, double caution,
			double loyer, double charges, String typeBail, String garniture) {
		super(id, typeBien, statut, revenuCadastre, dateSoumission, dateDisposition, listeImage, adresse, proprietaire);
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.typeBail = typeBail;
		this.garniture = garniture;
	}
	

	//declaration des getter et setter
	public double getCaution() {
		return caution;
	}


	public void setCaution(double caution) {
		this.caution = caution;
	}


	public double getLoyer() {
		return loyer;
	}


	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}


	public double getCharges() {
		return charges;
	}


	public void setCharges(double charges) {
		this.charges = charges;
	}


	public String getTypeBail() {
		return typeBail;
	}


	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}


	public String getGarniture() {
		return garniture;
	}


	public void setGarniture(String garniture) {
		this.garniture = garniture;
	}


	@Override
	public String toString() {
		return "BienImmobilierALouer [caution=" + caution + ", loyer=" + loyer + ", charges=" + charges + ", typeBail="
				+ typeBail + ", garniture=" + garniture + ", id=" + id + ", typeBien=" + typeBien + ", statut=" + statut
				+ ", revenuCadastre=" + revenuCadastre + ", dateSoumission=" + dateSoumission + ", dateDisposition="
				+ dateDisposition + ", listeImage=" + Arrays.toString(listeImage) + "]";
	}

	
	
	

}
