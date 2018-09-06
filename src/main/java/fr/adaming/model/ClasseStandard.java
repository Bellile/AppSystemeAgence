package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "classesstandard")
public class ClasseStandard implements Serializable {
	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cs")
	private int id;
	private String typeBien;
	private String modeOffre;
	private double prixMax;
	private double superficieMin;

	// transfo de l'association
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "classeStandard", fetch = FetchType.EAGER)
	private List<BienImmobilierAVendre> listeBienImmobilierVendre;

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "classeStandard", fetch = FetchType.EAGER)
	private List<BienImmobilierALouer> listeBienImmobilierLouer;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(mappedBy = "listeClasseStandard", fetch=FetchType.EAGER)
	private List<Client> listeClient;

	// constructeurs
	public ClasseStandard() {
		super();
	}

	public ClasseStandard(String typeBien, String modeOffre, double prixMax, double superficieMin) {
		super();
		this.typeBien = typeBien;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
	}

	public ClasseStandard(int id, String typeBien, String modeOffre, double prixMax, double superficieMin) {
		super();
		this.id = id;
		this.typeBien = typeBien;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
	}

	// getters et setters
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

	public String getModeOffre() {
		return modeOffre;
	}

	public void setModeOffre(String modeOffre) {
		this.modeOffre = modeOffre;
	}

	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public double getSuperficieMin() {
		return superficieMin;
	}

	public void setSuperficieMin(double superficieMin) {
		this.superficieMin = superficieMin;
	}
	
	@JsonIgnoreProperties("classeStandard")
	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	@JsonIgnoreProperties("classeStandard")
	public List<BienImmobilierAVendre> getListeBienImmobilierVendre() {
		return listeBienImmobilierVendre;
	}

	public void setListeBienImmobilierVendre(List<BienImmobilierAVendre> listeBienImmobilierVendre) {
		this.listeBienImmobilierVendre = listeBienImmobilierVendre;
	}

	@JsonIgnoreProperties("classeStandard")
	public List<BienImmobilierALouer> getListeBienImmobilierLouer() {
		return listeBienImmobilierLouer;
	}

	public void setListeBienImmobilierLouer(List<BienImmobilierALouer> listeBienImmobilierLouer) {
		this.listeBienImmobilierLouer = listeBienImmobilierLouer;
	}

	// toString
	@Override
	public String toString() {
		return "ClasseStandard [id=" + id + ", typeBien=" + typeBien + ", modeOffre=" + modeOffre + ", prixMax="
				+ prixMax + ", superficieMin=" + superficieMin + "]";
	}
}
