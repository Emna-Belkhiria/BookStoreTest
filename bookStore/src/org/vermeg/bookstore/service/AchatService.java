package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.interfaces.AchatInterface;
import org.vermeg.bookstore.model.Achat;

@Service("achatService")
public class AchatService {
	
	@Autowired
	AchatInterface achatInterface;
	
	@Transactional
	public List<Achat> getAllAchats(int orderid) {
		return achatInterface.getAllAchats(orderid);
	}
	
	@Transactional
	public Achat getAchat(int id) {
		return achatInterface.getAchat(id);
	}

	@Transactional
	public void addAchat(Achat livre) {
		achatInterface.addAchat(livre);
	}

	@Transactional
	public void updateAchat(Achat livre) {
		achatInterface.updateAchat(livre);

	}

	@Transactional
	public void deleteAchat(int id) {
		achatInterface.deleteAchat(id);
	}

	public double calculeTotal(List<Achat> listOfAchats) {
		double somme=0;
		int i=0;
		do {
			somme = somme+listOfAchats.get(i).getPrixpd();
			i++;
		}
		while(i<listOfAchats.size());
		return somme;
	}

}
