package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.interfaces.AchatInterface;
import org.vermeg.bookstore.model.Achat;
import org.vermeg.bookstore.model.DocumentAchat;
import org.vermeg.bookstore.model.Livre;

@Repository
public class AchatDAO implements AchatInterface{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Achat> getAllAchats(int orid) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Achat> achatList = session.createQuery("from Achat where orderid =: "+orid).list();
		
		for (Achat a:achatList) {
			System.out.println(a.toString());
		}
		
		return achatList;
	}
	
	public Achat getAchat(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Achat achat = (Achat) session.get(Achat.class, new Integer(id));
		return achat;
	}
	
	public void addAchat(Achat achat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(achat);
	}

	public void updateAchat(Achat achat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(achat);
	}

	public void deleteAchat(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Achat a = (Achat) session.load(Achat.class, new Integer(id));
		if (null != a) {
			session.delete(a);
		}
	}	
}
