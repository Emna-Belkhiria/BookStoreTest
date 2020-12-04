package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.DocumentAchatDAO;
import org.vermeg.bookstore.interfaces.DocumentAchatInterface;
import org.vermeg.bookstore.model.Achat;
import org.vermeg.bookstore.model.DocumentAchat;

@Service("documentDocumentAchatService")
public class DocumentAchatService {
	@Autowired
	DocumentAchatInterface documentAchatInterface;
	
	@Transactional
	public List<DocumentAchat> getAllDocumentAchats(int orderid) {
		return documentAchatInterface.getAllDocumentsAchat(orderid);
	}
	
	@Transactional
	public DocumentAchat getDocumentAchat(int id) {
		return documentAchatInterface.getDocumentAchat(id);
	}

	@Transactional
	public void addDocumentAchat(DocumentAchat livre) {
		documentAchatInterface.addDocumentAchat(livre);
	}

	@Transactional
	public void updateDocumentAchat(DocumentAchat livre) {
		documentAchatInterface.updateDocumentAchat(livre);

	}

	@Transactional
	public void deleteDocumentAchat(int id) {
		documentAchatInterface.deleteDocumentAchat(id);
	}


}
