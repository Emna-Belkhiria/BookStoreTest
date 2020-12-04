package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.interfaces.LivreInterface;
import org.vermeg.bookstore.model.Achat;
import org.vermeg.bookstore.model.Livre;

class LivreServiceTest {
	Livre livre;
	Livre livre1;
	LivreInterface livreInterface = mock(LivreInterface.class);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllLivres() {
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		livre1=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		List <Livre>listLivre= new ArrayList<Livre>();
		listLivre.add(livre);
		listLivre.add(livre1);
		when(livreInterface.getAllLivres()).thenReturn(listLivre);
		assertEquals(livre,listLivre.get(0) ," un livre différent");
		assertEquals(livre1,listLivre.get(1)," un livre différent");
	}

	@Test
	void testGetLivre() {
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		int idlivre=livre.getId();
		when(livreInterface.getLivre(idlivre)).thenReturn(livre);
		assertEquals(livre,livreInterface.getLivre(idlivre) ,"livre différent");
	}

	@Test
	void testAddLivre() {
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		livreInterface.addLivre(livre);
		verify(livreInterface,times(1)).addLivre(livre);
	}

	@Test
	void testUpdateLivre() {
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		livreInterface.updateLivre(livre);
		verify(livreInterface,times(1)).updateLivre(livre);
	}

	@Test
	void testDeleteLivre() {
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		int idlivre=livre.getId();
		livreInterface.deleteLivre(idlivre);
		verify(livreInterface,times(1)).deleteLivre(idlivre);
	}

}
