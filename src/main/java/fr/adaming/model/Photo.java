package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="photos")
public class Photo implements Serializable{
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ph")
	private int id;
	@Lob
	private byte[] image;
	
	//transformation de l'association UML en JAVA
//	@ManyToOne
//	@JoinColumn(name="bl_id", referencedColumnName="id_b")
//	private BienImmobilierALouer bienImmoLouer;
	
	
	//declaration des constructeurs
	public Photo() {
		super();
	}

	public Photo(byte[] image) {
		super();
		this.image = image;
	}

	public Photo(int id, byte[] image) {
		super();
		this.id = id;
		this.image = image;
	}

	//declaration des getter et setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

//	public BienImmobilierALouer getBienImmoLouer() {
//		return bienImmoLouer;
//	}
//
//	public void setBienImmoLouer(BienImmobilierALouer bienImmoLouer) {
//		this.bienImmoLouer = bienImmoLouer;
//	}



}
