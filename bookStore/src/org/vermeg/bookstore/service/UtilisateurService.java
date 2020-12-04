package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.UtilisateurDAO;
import org.vermeg.bookstore.interfaces.UtilisateurInterface;
import org.vermeg.bookstore.model.Utilisateur;

@Service("utilisateurService")
public class UtilisateurService {
	
	@Autowired
	UtilisateurInterface utilisateurInterface;
	
	@Transactional
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurInterface.getAllUtilisateurs();
	}

	@Transactional
	public Utilisateur getUtilisateur(int id) {
		return utilisateurInterface.getUtilisateur(id);
	}

	@Transactional
	public void addUtilisateur(Utilisateur Utilisateur) {
		utilisateurInterface.addUtilisateur(Utilisateur);
	}

	@Transactional
	public void updateUtilisateur(Utilisateur Utilisateur) {
		utilisateurInterface.updateUtilisateur(Utilisateur);

	}

	@Transactional
	public void deleteUtilisateur(int id) {
		utilisateurInterface.deleteUtilisateur(id);
	}

}
