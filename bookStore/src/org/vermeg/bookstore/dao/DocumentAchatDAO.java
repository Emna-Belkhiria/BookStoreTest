package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.interfaces.DocumentAchatInterface;
import org.vermeg.bookstore.model.DocumentAchat;

@Repository
public class DocumentAchatDAO implements DocumentAchatInterface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<DocumentAchat> getAllDocumentsAchat(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<DocumentAchat> documentAchatList = session.createQuery("from DocumentAchat where iduser =:"+id).list();
		
		for (DocumentAchat da:documentAchatList) {
			System.out.println(da.toString());
		}
		
		return documentAchatList;
	}

	public DocumentAchat getDocumentAchat(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DocumentAchat documentAchat = (DocumentAchat) session.get(DocumentAchat.class, new Integer(id));
		return documentAchat;
	}

	public DocumentAchat addDocumentAchat(DocumentAchat documentAchat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(documentAchat);
		return documentAchat;
	}

	public void updateDocumentAchat(DocumentAchat documentAchat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(documentAchat);
	}

	public void deleteDocumentAchat(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DocumentAchat da = (DocumentAchat) session.load(DocumentAchat.class, new Integer(id));
		if (null != da) {
			session.delete(da);
		}
	}	

}
