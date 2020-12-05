package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.interfaces.DocumentAchatInterface;
import org.vermeg.bookstore.model.DocumentAchat;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Utilisateur;

class DocumentAchatServiceTest {
	DocumentAchat doc1;
	DocumentAchat doc2;
	Utilisateur user;
	DocumentAchatInterface docAchatInterface=mock(DocumentAchatInterface.class);

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetAllDocumentAchats() {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		doc2=new DocumentAchat(2,"2020-12-02",user);
		int iduser = user.getId();
		List <DocumentAchat>listdocAchat= new ArrayList<DocumentAchat>();
		listdocAchat.add(doc1);
		listdocAchat.add(doc2);
		when(docAchatInterface.getAllDocumentsAchat(iduser)).thenReturn(listdocAchat);
		assertEquals(doc1,listdocAchat.get(0) ," un document Achat différent");
		assertEquals(doc2,listdocAchat.get(1)," un document Achat différent");
	}

	@Test
	void testGetDocumentAchat() {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		int iddoc = doc1.getId();
		when(docAchatInterface.getDocumentAchat(iddoc)).thenReturn(doc1);
		assertEquals(doc1,docAchatInterface.getDocumentAchat(iddoc) ,"document Achat différent");
	}

	@Test
	void testAddDocumentAchat() {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		docAchatInterface.addDocumentAchat(doc1);
		verify(docAchatInterface,times(1)).addDocumentAchat(doc1);
		
		
	}

	@Test
	void testUpdateDocumentAchat() {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		docAchatInterface.updateDocumentAchat(doc1);
		verify(docAchatInterface,times(1)).updateDocumentAchat(doc1);
	}

	@Test
	void testDeleteDocumentAchat() {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		int iddoc = doc1.getId();
		docAchatInterface.deleteDocumentAchat(iddoc);
		verify(docAchatInterface,times(1)).deleteDocumentAchat(iddoc);
	}

}
