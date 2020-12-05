package org.vermeg.bookstore.test;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vermeg.bookstore.controller.UtilisateurController;
import org.vermeg.bookstore.model.Utilisateur;
import org.vermeg.bookstore.service.UtilisateurService;

class UtilisateurControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private UtilisateurService mockedUserService;
	@InjectMocks
	private UtilisateurController userController;
	Utilisateur user1;
	Utilisateur user2;
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	void testGetUtilisateurs() throws Exception {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		user2=new Utilisateur(2,6933245,"imen","benamor",30);
		List <Utilisateur>listusers= new ArrayList<Utilisateur>();
		listusers.add(user1);
		listusers.add(user2);
		when(mockedUserService.getAllUtilisateurs()).thenReturn(listusers);
		this.mockMvc.perform(get("/api/utilisateur/getAllUtilisateurs"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2)))
		.andDo(print());
	}

	@Test
	void testGetUtilisateurById() throws Exception {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		int iduser = user1.getId();
		when(mockedUserService.getUtilisateur(iduser)).thenReturn(user1);
		this.mockMvc.perform(get("/api/utilisateur/getUtilisateur/"+iduser))
		.andExpect(status().isOk())
		.andDo(print());	
	}

	@Test
	void testAddUtilisateur() throws Exception {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		mockedUserService.addUtilisateur(user1);
		verify(mockedUserService,times(1)).addUtilisateur(user1);
		this.mockMvc.perform(post("/api/utilisateur/addUtilisateur"))
		.andExpect(status().isOk())
		.andDo(print());
		
	}

	@Test
	void testUpdateUtilisateur() throws Exception {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		int iduser = user1.getId();
		mockedUserService.updateUtilisateur(user1);
		verify(mockedUserService,times(1)).updateUtilisateur(user1);
		this.mockMvc.perform(put("/api/utilisateur/updateUtilisateur/"+iduser))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testDeleteUtilisateur() throws Exception {
		user1=new Utilisateur(1,6991245,"emna","blk",23);
		int iduser = user1.getId();
		mockedUserService.deleteUtilisateur(iduser);
		verify(mockedUserService,times(1)).deleteUtilisateur(iduser);
		this.mockMvc.perform(delete("/api/utilisateur/deleteUtilisateur/"+iduser))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
