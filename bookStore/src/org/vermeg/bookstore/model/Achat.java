package org.vermeg.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lineorder")
public class Achat {

	@Id
	@Column(name="linenumber")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numLigne;
	@Column(name = "quantity")
	private double quantite;
	@Column(name = "lineprice")
	private double prixpd;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id")
	private Livre livre;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="orderid")
	private DocumentAchat documentAchat;
	
	
	public int getNumLigne() {
		return numLigne;
	}
	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public double getPrixpd() {
		return prixpd;
	}
	public void setPrixpd(double prixpd) {
		this.prixpd = prixpd;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public DocumentAchat getDocumentAchat() {
		return documentAchat;
	}
	public void setDocumentAchat(DocumentAchat documentAchat) {
		this.documentAchat = documentAchat;
	}
	
	
	public Achat(int numLigne, double quantite, Livre livre, DocumentAchat documentAchat) {
		this.numLigne = numLigne;
		this.quantite = quantite;
		this.livre = livre;
		this.prixpd = this.quantite*this.livre.getPrixUnitaire();
		this.documentAchat = documentAchat;
	}
	
	public Achat() {
	}
	@Override
	public String toString() {
		return "Achat [numLigne=" + numLigne + livre.toString() + ", quantite=" + quantite + ", prixpd=" + prixpd + "]";
	}
	
	
	
}
