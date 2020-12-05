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
import org.vermeg.bookstore.controller.DocumentAchatController;
import org.vermeg.bookstore.model.DocumentAchat;
import org.vermeg.bookstore.model.Utilisateur;
import org.vermeg.bookstore.service.DocumentAchatService;

class DocumentAchatControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private DocumentAchatService mockedDocAchatService;
	@InjectMocks
	private DocumentAchatController docAchatController;
	DocumentAchat doc1;
	DocumentAchat doc2;
	Utilisateur user;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(docAchatController).build();
	}

	@Test
	void testGetDocumentAchats() throws Exception {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		doc2=new DocumentAchat(2,"2020-12-02",user);
		int iduser = user.getId();
		List <DocumentAchat>listdocAchat= new ArrayList<DocumentAchat>();
		listdocAchat.add(doc1);
		listdocAchat.add(doc2);
		when(mockedDocAchatService.getAllDocumentAchats(iduser)).thenReturn(listdocAchat);
		this.mockMvc.perform(get("/api/documentDocumentAchat/getAllDocumentAchats/"+iduser))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2)))
		.andDo(print());
	}

	@Test
	void testGetDocumentAchatById() throws Exception {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		int iddoc = doc1.getId();
		when(mockedDocAchatService.getDocumentAchat(iddoc)).thenReturn(doc1);
		this.mockMvc.perform(get("/api/documentDocumentAchat/getDocumentAchat/"+iddoc))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testAddDocumentAchat() throws Exception {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		mockedDocAchatService.addDocumentAchat(doc1);
		verify(mockedDocAchatService,times(1)).addDocumentAchat(doc1);
		this.mockMvc.perform(post("/api/documentDocumentAchat/addDocumentAchat"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testUpdateDocumentAchat() throws Exception {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		int iddoc = doc1.getId();
		mockedDocAchatService.updateDocumentAchat(doc1);
		verify(mockedDocAchatService,times(1)).updateDocumentAchat(doc1);
		this.mockMvc.perform(put("/api/documentDocumentAchat/updateDocumentAchat/"+iddoc))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testDeleteDocumentAchat() throws Exception {
		user=new Utilisateur(1,6991245,"emna","blk",23);
		doc1=new DocumentAchat(1,"2020-12-05",user);
		int iddoc = doc1.getId();
		mockedDocAchatService.deleteDocumentAchat(iddoc);
		verify(mockedDocAchatService,times(1)).deleteDocumentAchat(iddoc);
		this.mockMvc.perform(delete("/api/documentDocumentAchat/deleteDocumentAchat/"+iddoc))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
