package fr.adaming.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
abstract class BienImmobilier {
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_b")
	protected int id;
	protected String typeBien;
	protected String statut;
	protected double revenuCadastre;
	@Temporal(TemporalType.DATE)
	protected Date dateSoumission;
	@Temporal(TemporalType.DATE)
	protected Date dateDisposition;
	@Lob
	protected byte[] listeImage;
	
	//transformation des associations UML en JAVA
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy="bienImmobilier")
	private List<Visite> listeVisite;
	@ManyToOne
	@JoinColumn(name="cs_id", referencedColumnName="id_cs")
	private ClasseStandard classeStandard;
	@ManyToOne
	@JoinColumn(name="p_id", referencedColumnName="id_p")
	private Proprietaire proprietaire;
	
	
	//declaration des constructeurs
	public BienImmobilier() {
		super();
	}

	public BienImmobilier(String typeBien, String statut, double revenuCadastre, Date dateSoumission,
			Date dateDisposition, byte[] listeImage, Adresse adresse, Proprietaire proprietaire) {
		super();
		this.typeBien = typeBien;
		this.statut = statut;
		this.revenuCadastre = revenuCadastre;
		this.dateSoumission = dateSoumission;
		this.dateDisposition = dateDisposition;
		this.listeImage = listeImage;
		this.adresse = adresse;
		this.proprietaire = proprietaire;
	}

	public BienImmobilier(int id, String typeBien, String statut, double revenuCadastre, Date dateSoumission,
			Date dateDisposition, byte[] listeImage, Adresse adresse, Proprietaire proprietaire) {
		super();
		this.id = id;
		this.typeBien = typeBien;
		this.statut = statut;
		this.revenuCadastre = revenuCadastre;
		this.dateSoumission = dateSoumission;
		this.dateDisposition = dateDisposition;
		this.listeImage = listeImage;
		this.adresse = adresse;
		this.proprietaire = proprietaire;
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
		return "BienImmobilier [id=" + id + ", typeBien=" + typeBien + ", statut=" + statut + ", revenuCadastre="
				+ revenuCadastre + ", dateSoumission=" + dateSoumission + ", dateDisposition=" + dateDisposition
				+ ", listeImage=" + Arrays.toString(listeImage) + "]";
	}
	


}
