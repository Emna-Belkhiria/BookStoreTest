package org.vermeg.bookstore.interfaces;

import java.util.List;

import org.vermeg.bookstore.model.DocumentAchat;

public interface DocumentAchatInterface {
	
    public List<DocumentAchat> getAllDocumentsAchat(int id);
	
	public DocumentAchat getDocumentAchat(int id);
	
	public DocumentAchat addDocumentAchat(DocumentAchat documentAchat);
	
	public void updateDocumentAchat(DocumentAchat documentAchat);
	
	public void deleteDocumentAchat(int id);

}
