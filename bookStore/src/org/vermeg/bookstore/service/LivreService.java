package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.LivreDAO;
import org.vermeg.bookstore.interfaces.LivreInterface;
import org.vermeg.bookstore.model.Livre;

@Service("livreService")
public class LivreService {
	
	@Autowired
	LivreInterface livreInterface;
	
	@Transactional
	public List<Livre> getAllLivres() {
		return livreInterface.getAllLivres();
	}

	@Transactional
	public Livre getLivre(int id) {
		return livreInterface.getLivre(id);
	}

	@Transactional
	public void addLivre(Livre livre) {
		livreInterface.addLivre(livre);
	}

	@Transactional
	public void updateLivre(Livre livre) {
		livreInterface.updateLivre(livre);

	}

	@Transactional
	public void deleteLivre(int id) {
		livreInterface.deleteLivre(id);
	}

}
