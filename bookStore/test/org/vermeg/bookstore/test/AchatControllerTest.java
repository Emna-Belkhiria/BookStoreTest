package org.vermeg.bookstore.test;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vermeg.bookstore.controller.AchatController;
import org.vermeg.bookstore.model.Achat;
import org.vermeg.bookstore.model.DocumentAchat;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Utilisateur;
import org.vermeg.bookstore.service.AchatService;


class AchatControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private AchatService mockedAchatService;
	@InjectMocks
	private AchatController achatController;
	Achat achat;
	Achat achat1;
	Livre livre;
	DocumentAchat documentAchat;
	Utilisateur user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
			MockitoAnnotations.initMocks(this);
			this.mockMvc = MockMvcBuilders.standaloneSetup(achatController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAchats() throws Exception {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		achat1 = new Achat(2,20,livre,documentAchat);
		int orderid=documentAchat.getId();
		List <Achat>listAchat= new ArrayList<Achat>();
		listAchat.add(achat);
		listAchat.add(achat1);
		when(mockedAchatService.getAllAchats(orderid)).thenReturn(listAchat);
		this.mockMvc.perform(get("/api/achat/getAllAchats/"+orderid))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testGetAchatById() throws Exception {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		int achatid=achat.getNumLigne();
		when(mockedAchatService.getAchat(achatid)).thenReturn(achat);
		this.mockMvc.perform(get("/api/achat/getAchat/"+achatid))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testAddAchat() {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		mockedAchatService.addAchat(achat);
		verify(mockedAchatService,times(1)).addAchat(achat);
	}

	@Test
	void testUpdateAchat() {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		mockedAchatService.updateAchat(achat);
		verify(mockedAchatService,times(1)).updateAchat(achat);
	}

	@Test
	void testDeleteAchat() {
		user=new Utilisateur(1,699875,"rr","yy",22);
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		documentAchat = new DocumentAchat(1,"2020-12-15",user);
		achat = new Achat(1,15,livre,documentAchat);
		int achatid=achat.getNumLigne();
		mockedAchatService.deleteAchat(achatid);;
		verify(mockedAchatService,times(1)).deleteAchat(achatid);
		
	}

}
