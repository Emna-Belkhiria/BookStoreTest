package org.vermeg.bookstore.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.interfaces.AchatInterface;
import org.vermeg.bookstore.model.Achat;
import org.vermeg.bookstore.model.DocumentAchat;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Utilisateur;
import org.vermeg.bookstore.service.AchatService;

class AchatServiceTest {
	Achat achat;
	Achat achat1;
	Livre livre;
	DocumentAchat documentAchat;
	AchatService achatService;
	Utilisateur user;
	AchatInterface achatInterface = mock(AchatInterface.class);

	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllAchats() {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		achat1 = new Achat(2,20,livre,documentAchat);
		int orderid=documentAchat.getId();
		List <Achat>listAchat= new ArrayList<Achat>();
		listAchat.add(achat);
		listAchat.add(achat1);
		when(achatInterface.getAllAchats(orderid)).thenReturn(listAchat);
		assertTrue(listAchat.get(0).getDocumentAchat() == documentAchat ,"ajouter avec un document achat différent que ajouté avec");
		assertTrue(listAchat.get(0).getLivre()== livre ,"ajouter avec un livre différent que ajouté avec");
		assertTrue(listAchat.get(0).getDocumentAchat() == documentAchat ,"ajouter avec un document achat différent que ajouté avec");
		assertTrue(listAchat.get(0).getQuantite() == 15,"ajouter avec une quantite différente que ajouté avec");
		assertTrue(listAchat.get(0).getPrixpd()== listAchat.get(0).getQuantite()* listAchat.get(0).getLivre().getPrixUnitaire(),"ajouter avec un prix de produit incorrect");
		assertTrue(listAchat.get(1).getDocumentAchat() == documentAchat ,"ajouter avec un document achat différent que ajouté avec");
		assertTrue(listAchat.get(1).getLivre()== livre ,"ajouter avec un livre différent que ajouté avec");
		assertTrue(listAchat.get(1).getDocumentAchat() == documentAchat ,"ajouter avec un document achat différent que ajouté avec");
		assertTrue(listAchat.get(1).getQuantite() == 20,"ajouter avec une quantite différente que ajouté avec");
		assertTrue(listAchat.get(1).getPrixpd()== listAchat.get(1).getQuantite()* listAchat.get(1).getLivre().getPrixUnitaire(),"ajouter avec un prix de produit incorrect");
		assertEquals(2,listAchat.size(),"size de liste incorrect");
		
	}

	@Test
	void testGetAchat() {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		int numLigne=achat.getNumLigne();
		when(achatInterface.getAchat(numLigne)).thenReturn(achat);
		assertTrue(achat.getDocumentAchat() == documentAchat ,"ajouter avec un document achat différent que ajouté avec");
		assertTrue(achat.getLivre()== livre ,"ajouter avec un livre différent que ajouté avec");
		assertTrue(achat.getDocumentAchat() == documentAchat ,"ajouter avec un document achat différent que ajouté avec");
		assertTrue(achat.getQuantite() == 15,"ajouter avec une quantite différente que ajouté avec");
		assertTrue(achat.getPrixpd()== achat.getQuantite()* achat.getLivre().getPrixUnitaire(),"ajouter avec un prix de produit incorrect");
		assertEquals(achat,achat,"c'est pas la meme instance");
		
	}

	@Test
	void testAddAchat() {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		achatInterface.addAchat(achat);
		verify(achatInterface,times(1)).addAchat(achat);
		
	}

	@Test
	void testUpdateAchat() {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		achatInterface.updateAchat(achat);
		verify(achatInterface,times(1)).updateAchat(achat);
	}

	@Test
	void testDeleteAchat() {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		achatInterface.deleteAchat(achat.getNumLigne());
		verify(achatInterface,times(1)).deleteAchat(achat.getNumLigne());
	}

}
