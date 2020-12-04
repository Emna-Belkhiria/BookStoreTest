package org.vermeg.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class Utilisateur {
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	 @Column(name="cin",length = 8,unique=true)
		private double cin;
	 @Column(name = "lastname")
		private String nom;
	 @Column(name = "firstname")
		private String prenom;
	 @Column(name = "age")
		private int age;
	 @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	    private List<DocumentAchat> documentAchat;
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCin() {
		return cin;
	}
	public void setCin(double cin) {
		this.cin = cin;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Utilisateur(int id, double cin, String nom, String prenom, int age) {
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public Utilisateur() {
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}	

}
