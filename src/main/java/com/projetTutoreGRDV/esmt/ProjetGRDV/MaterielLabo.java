package com.projetTutoreGRDV.esmt.ProjetGRDV;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiel")
public class MaterielLabo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private String etat;

	
	public MaterielLabo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MaterielLabo(int id, String nom, String etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.etat = etat;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	@Override
	public String toString() {
		return "MaterielLabo [id=" + id + ", nom=" + nom + ", etat=" + etat + "]";
	}


	
	
}
