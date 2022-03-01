package com.projetTutoreGRDV.esmt.ProjetGRDV;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rendezVous")
public class Rdv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String date;
//	@Column
//	private String email;
	@Column
	private String maladieDesc;
	
	public Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Rdv(String nom, String prenom, String date, /*String email,*/ String maladieDesc) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		//this.email = email;
		this.maladieDesc = maladieDesc;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public String getMaladieDesc() {
		return maladieDesc;
	}

	public void setMaladieDesc(String maladieDesc) {
		this.maladieDesc = maladieDesc;
	}
	
}
