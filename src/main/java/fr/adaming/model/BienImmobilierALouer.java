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
@Table(name="biensimmobilieralouer")
public class BienImmobilierALouer extends BienImmobilier{
	
	//declaration des attributs
	private double caution;
	private double loyer;
	private double charges;
	private String typeBail;
	private String garniture;
	
	//transformation des associations UML en JAVA
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy="bienImmobilierALouer")
	private List<Visite> listeVisite;
	@ManyToOne
	@JoinColumn(name="cs_id", referencedColumnName="id_cs")
	private ClasseStandard classeStandard;
	@ManyToOne
	@JoinColumn(name="p_id", referencedColumnName="id_p")
	private Proprietaire proprietaire;

	
	//declaration des constructeurs
	public BienImmobilierALouer() {
		super();
	}

	public BienImmobilierALouer(String typeBien, String statut, double revenuCadastre, String description,
			Date dateSoumission, Date dateDisposition, byte[] listeImage, double caution, double loyer, double charges,
			String typeBail, String garniture, Adresse adresse, Proprietaire proprietaire) {
		super(typeBien, statut, revenuCadastre, description, dateSoumission, dateDisposition, listeImage);
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.typeBail = typeBail;
		this.garniture = garniture;
		this.adresse = adresse;
		this.proprietaire = proprietaire;
	}

	public BienImmobilierALouer(int id, String typeBien, String statut, double revenuCadastre, String description,
			Date dateSoumission, Date dateDisposition, byte[] listeImage, double caution, double loyer, double charges,
			String typeBail, String garniture, Adresse adresse, Proprietaire proprietaire) {
		super(id, typeBien, statut, revenuCadastre, description, dateSoumission, dateDisposition, listeImage);
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.typeBail = typeBail;
		this.garniture = garniture;
		this.adresse = adresse;
		this.proprietaire = proprietaire;
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
		return "BienImmobilierALouer [caution=" + caution + ", loyer=" + loyer + ", charges=" + charges + ", typeBail="
				+ typeBail + ", garniture=" + garniture + ", adresse=" + adresse + ", proprietaire=" + proprietaire
				+ ", id=" + id + ", typeBien=" + typeBien + ", statut=" + statut + ", revenuCadastre=" + revenuCadastre
				+ ", dateSoumission=" + dateSoumission + ", dateDisposition=" + dateDisposition + ", listeImage="
				+ Arrays.toString(listeImage) + "]";
	}



	
	
	

}
