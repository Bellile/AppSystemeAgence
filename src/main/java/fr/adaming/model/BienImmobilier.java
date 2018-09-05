package fr.adaming.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
abstract class BienImmobilier {
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_b")
	protected int id;
	protected String typeBien;
	protected String statut;
	protected double revenuCadastre;
	protected String description;
	@Temporal(TemporalType.DATE)
	protected Date dateSoumission;
	@Temporal(TemporalType.DATE)
	protected Date dateDisposition;
	@Lob
	protected byte[] listeImage;
	
	
	//declaration des constructeurs
	public BienImmobilier() {
		super();
	}

	public BienImmobilier(String typeBien, String statut, double revenuCadastre, String description,
			Date dateSoumission, Date dateDisposition, byte[] listeImage) {
		super();
		this.typeBien = typeBien;
		this.statut = statut;
		this.revenuCadastre = revenuCadastre;
		this.description = description;
		this.dateSoumission = dateSoumission;
		this.dateDisposition = dateDisposition;
		this.listeImage = listeImage;
	}

	public BienImmobilier(int id, String typeBien, String statut, double revenuCadastre, String description,
			Date dateSoumission, Date dateDisposition, byte[] listeImage) {
		super();
		this.id = id;
		this.typeBien = typeBien;
		this.statut = statut;
		this.revenuCadastre = revenuCadastre;
		this.description = description;
		this.dateSoumission = dateSoumission;
		this.dateDisposition = dateDisposition;
		this.listeImage = listeImage;
	}

	//declaration des getters et setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeBien() {
		return typeBien;
	}


	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public double getRevenuCadastre() {
		return revenuCadastre;
	}


	public void setRevenuCadastre(double revenuCadastre) {
		this.revenuCadastre = revenuCadastre;
	}


	public Date getDateSoumission() {
		return dateSoumission;
	}


	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}


	public Date getDateDisposition() {
		return dateDisposition;
	}


	public void setDateDisposition(Date dateDisposition) {
		this.dateDisposition = dateDisposition;
	}


	public byte[] getListeImage() {
		return listeImage;
	}


	public void setListeImage(byte[] listeImage) {
		this.listeImage = listeImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", typeBien=" + typeBien + ", statut=" + statut + ", revenuCadastre="
				+ revenuCadastre + ", dateSoumission=" + dateSoumission + ", dateDisposition=" + dateDisposition
				+ ", listeImage=" + Arrays.toString(listeImage) + "]";
	}



}
