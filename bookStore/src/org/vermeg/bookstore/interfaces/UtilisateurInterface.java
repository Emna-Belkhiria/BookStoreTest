package org.vermeg.bookstore.interfaces;

import java.util.List;

import org.vermeg.bookstore.model.Utilisateur;

public interface UtilisateurInterface {
	
	public List<Utilisateur> getAllUtilisateurs();
	
	public Utilisateur getUtilisateur(int id);
	
	public Utilisateur addUtilisateur(Utilisateur utilisateur);
	
	public void updateUtilisateur(Utilisateur utilisateur);
	
	public void deleteUtilisateur(int id);

}
