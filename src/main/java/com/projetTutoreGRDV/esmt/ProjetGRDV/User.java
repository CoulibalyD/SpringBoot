package com.projetTutoreGRDV.esmt.ProjetGRDV;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String sexe;
	@Column
	private int age;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String type;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public User(int id, String nom, String prenom, String sexe, int age, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
		this.email = email;
		this.password = password;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>0) {
			this.age = age;
		}else {
			System.out.println("Age incorrect");
		}
		
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", age=" + age + ", email="
				+ email + ", password=" + password + ", type=" + type + "]";
	}



	

	
	
	

}
