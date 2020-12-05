package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
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
import org.vermeg.bookstore.controller.LivreController;
import org.vermeg.bookstore.model.Achat;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.service.AchatService;
import org.vermeg.bookstore.service.LivreService;

class LivreControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private LivreService mockedLivreService;
	@InjectMocks
	private LivreController livreController;
	Livre livre;
	Livre livre1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(livreController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetLivres() throws Exception{
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		livre1=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		List <Livre>listLivre= new ArrayList<Livre>();
		listLivre.add(livre);
		listLivre.add(livre1);
		when(mockedLivreService.getAllLivres()).thenReturn(listLivre);
		this.mockMvc.perform(get("/api/livre/getAllLivres"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2)))
		.andDo(print());
	}

	@Test
	void testGetLivreById() throws Exception{
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		int idlivre=livre.getId();
		when(mockedLivreService.getLivre(idlivre)).thenReturn(livre);
		this.mockMvc.perform(get("/api/livre/getLivre/"+idlivre))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testAddLivre() throws Exception{
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		mockedLivreService.addLivre(livre);
		verify(mockedLivreService,times(1)).addLivre(livre);
		this.mockMvc.perform(post("/api/livre/addLivre"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testUpdateLivre() throws Exception{
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		int idlivre=livre.getId();
		mockedLivreService.updateLivre(livre);
		verify(mockedLivreService,times(1)).updateLivre(livre);
		this.mockMvc.perform(put("/api/livre/updateLivre/"+idlivre))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testDeleteLivre() throws Exception {
		livre=new Livre(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		int idlivre=livre.getId();
		mockedLivreService.deleteLivre(idlivre);
		verify(mockedLivreService,times(1)).deleteLivre(idlivre);
		this.mockMvc.perform(delete("/api/livre/deleteLivre/"+idlivre))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
