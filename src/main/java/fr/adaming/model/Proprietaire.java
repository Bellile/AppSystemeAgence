package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proprietaires")
public class Proprietaire extends Personne {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private int id;
	private String telPro;
	
	//Constructeurs
	public Proprietaire() {
		super();
	}
	public Proprietaire(String nom, String telPerso, String mail, String telPro) {
		super(nom, telPerso, mail);
		this.telPro = telPro;
	}
	public Proprietaire(String nom, String telPerso, String mail, int id, String telPro) {
		super(nom, telPerso, mail);
		this.id = id;
		this.telPro = telPro;
	}

	//Getter/Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelPro() {
		return telPro;
	}

	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}
	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", telPro=" + telPro + "]";
	}
	
	
}
