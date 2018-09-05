package fr.adaming.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="biensimmobilieravendre")
public class BienImmobilierAVendre extends BienImmobilier{
	
	//declaration des attributs
	private double prix;
	private String etat;
	
	//declaration des constructeurs
	public BienImmobilierAVendre() {
		super();
	}
	
	public BienImmobilierAVendre(String typeBien, String statut, double revenuCadastre, Date dateSoumission,
			Date dateDisposition, byte[] listeImage, Adresse adresse, Proprietaire proprietaire, double prix,
			String etat) {
		super(typeBien, statut, revenuCadastre, dateSoumission, dateDisposition, listeImage, adresse, proprietaire);
		this.prix = prix;
		this.etat = etat;
	}

	public BienImmobilierAVendre(int id, String typeBien, String statut, double revenuCadastre, Date dateSoumission,
			Date dateDisposition, byte[] listeImage, Adresse adresse, Proprietaire proprietaire, double prix,
			String etat) {
		super(id, typeBien, statut, revenuCadastre, dateSoumission, dateDisposition, listeImage, adresse, proprietaire);
		this.prix = prix;
		this.etat = etat;
	}

	//declaration des getter et setter
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	
	@Override
	public String toString() {
		return "BienImmobilierAVendre [prix=" + prix + ", etat=" + etat + ", id=" + id + ", typeBien=" + typeBien
				+ ", statut=" + statut + ", revenuCadastre=" + revenuCadastre + ", dateSoumission=" + dateSoumission
				+ ", dateDisposition=" + dateDisposition + ", listeImage=" + Arrays.toString(listeImage) + "]";
	}
	
	

}
