package com.projetTutoreGRDV.esmt.ProjetGRDV;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anwser")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nomDocteur;
	@Column
	private String nomPatient;
	@Column
	private String date;
	@Column
	private String recommandation;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int id, String nomDocteur, String nomPatient, String date, String recommandation) {
		super();
		this.id = id;
		this.nomDocteur = nomDocteur;
		this.nomPatient = nomPatient;
		this.date = date;
		this.recommandation = recommandation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomDocteur() {
		return nomDocteur;
	}

	public void setNomDocteur(String nomDocteur) {
		this.nomDocteur = nomDocteur;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRecommandation() {
		return recommandation;
	}

	public void setRecommandation(String recommandation) {
		this.recommandation = recommandation;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", nomDocteur=" + nomDocteur + ", nomPatient=" + nomPatient + ", date=" + date
				+ ", recommandation=" + recommandation + "]";
	}
	
	
	
}
