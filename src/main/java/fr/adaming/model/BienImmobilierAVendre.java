package fr.adaming.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="biensimmobilieravendre")
public class BienImmobilierAVendre extends BienImmobilier{
	
	//declaration des attributs
	private double prix;
	private String etat;
	
	//transformation des associations UML en JAVA
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy="bienImmobilierAVendre")
	private List<Visite> listeVisite;
	@ManyToOne
	@JoinColumn(name="cs_id", referencedColumnName="id_cs")
	private ClasseStandard classeStandard;
	@ManyToOne
	@JoinColumn(name="p_id", referencedColumnName="id_p")
	private Proprietaire proprietaire;
	
	//declaration des constructeurs
	public BienImmobilierAVendre() {
		super();
	}

	public BienImmobilierAVendre(String typeBien, String statut, double revenuCadastre, Date dateSoumission,
			Date dateDisposition, byte[] listeImage, double prix, String etat, Adresse adresse,
			Proprietaire proprietaire) {
		super(typeBien, statut, revenuCadastre, dateSoumission, dateDisposition, listeImage);
		this.prix = prix;
		this.etat = etat;
		this.adresse = adresse;
		this.proprietaire = proprietaire;
	}


	public BienImmobilierAVendre(int id, String typeBien, String statut, double revenuCadastre, Date dateSoumission,
			Date dateDisposition, byte[] listeImage, double prix, String etat, Adresse adresse,
			Proprietaire proprietaire) {
		super(id, typeBien, statut, revenuCadastre, dateSoumission, dateDisposition, listeImage);
		this.prix = prix;
		this.etat = etat;
		this.adresse = adresse;
		this.proprietaire = proprietaire;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Visite> getListeVisite() {
		return listeVisite;
	}

	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "BienImmobilierAVendre [prix=" + prix + ", etat=" + etat + ", id=" + id + ", typeBien=" + typeBien
				+ ", statut=" + statut + ", revenuCadastre=" + revenuCadastre + ", dateSoumission=" + dateSoumission
				+ ", dateDisposition=" + dateDisposition + ", listeImage=" + Arrays.toString(listeImage) + "]";
	}


	
	

}
