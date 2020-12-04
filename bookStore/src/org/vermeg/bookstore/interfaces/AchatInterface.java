package org.vermeg.bookstore.interfaces;

import java.util.List;

import org.vermeg.bookstore.model.Achat;



public interface AchatInterface {
	
	public List<Achat> getAllAchats(int orderid);
	
	public Achat getAchat(int munligne);
	
	public void addAchat(Achat achat);
	
	public void updateAchat(Achat achat);
	
	public void deleteAchat(int munligne);
	
	

}
