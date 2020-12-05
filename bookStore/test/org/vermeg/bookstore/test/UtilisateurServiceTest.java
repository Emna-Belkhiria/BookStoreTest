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
import org.vermeg.bookstore.interfaces.UtilisateurInterface;
import org.vermeg.bookstore.model.DocumentAchat;
import org.vermeg.bookstore.model.Utilisateur;

class UtilisateurServiceTest {
Utilisateur user1;
Utilisateur user2;
UtilisateurInterface userInterface = mock(UtilisateurInterface.class);
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetAllUtilisateurs() {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		user2=new Utilisateur(2,6933245,"imen","benamor",30);
		List <Utilisateur>listusers= new ArrayList<Utilisateur>();
		listusers.add(user1);
		listusers.add(user2);
		when(userInterface.getAllUtilisateurs()).thenReturn(listusers);
		assertEquals(user1,listusers.get(0) ," un utilisateur différent");
		assertEquals(user2,listusers.get(1)," un utilisateurt différent");
	}

	@Test
	void testGetUtilisateur() {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		int iduser = user1.getId();
		when(userInterface.getUtilisateur(iduser)).thenReturn(user1);
		assertEquals(user1,userInterface.getUtilisateur(iduser)," un utilisateur différent");
		
	}

	@Test
	void testAddUtilisateur() {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		userInterface.addUtilisateur(user1);
		verify(userInterface,times(1)).addUtilisateur(user1);
	}

	@Test
	void testUpdateUtilisateur() {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		userInterface.updateUtilisateur(user1);
		verify(userInterface,times(1)).updateUtilisateur(user1);
	}

	@Test
	void testDeleteUtilisateur() {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		int iduser = user1.getId();
		userInterface.deleteUtilisateur(iduser);
		verify(userInterface,times(1)).deleteUtilisateur(iduser);
	}

}
