package org.vermeg.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderbook")
public class DocumentAchat {
	
	@Id
	@Column(name="orderid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numDocAchat;
	@Column(name="orderdate")
	private String DateAchat;
	@OneToMany(mappedBy = "documentAchat", cascade = CascadeType.ALL)
    private List<Achat> achat;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="userid")
	private Utilisateur utilisateur;
	
	
	public int getId() {
		return numDocAchat ;
	}
	public void setId(int id) {
		this.numDocAchat = id;
	}
	public String getDateAchat() {
		return DateAchat;
	}
	public void setDateAchat(String dateAchat) {
		DateAchat = dateAchat;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public DocumentAchat(int id, String dateAchat, Utilisateur utilisateur) {
		this.numDocAchat = id;
		DateAchat = dateAchat;
		this.utilisateur = utilisateur;
	}
	
	public DocumentAchat() {
	}
	@Override
	public String toString() {
		return utilisateur.toString() + "DocumentAchat [ id=" + numDocAchat + ", DateAchat=" + DateAchat + "]";
	}
	
	
	

}
