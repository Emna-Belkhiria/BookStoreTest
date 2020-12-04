package org.vermeg.bookstore.interfaces;

import java.util.List;

import org.vermeg.bookstore.model.Livre;

public interface LivreInterface {
	
	public List<Livre> getAllLivres();
	
	public Livre getLivre(int id);
	
	public Livre addLivre(Livre livre);
	
	public void updateLivre(Livre livre);
	
	public void deleteLivre(int id);

}
