package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.interfaces.UtilisateurInterface;
import org.vermeg.bookstore.model.Utilisateur;

@Repository
public class UtilisateurDAO implements UtilisateurInterface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Utilisateur> getAllUtilisateurs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Utilisateur> utilisateurList = session.createQuery("from Utilisateur").list();
		
		for (Utilisateur u:utilisateurList) {
			System.out.println(u.toString());
		}
		
		return utilisateurList;
	}

	public Utilisateur getUtilisateur(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, new Integer(id));
		return utilisateur;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(utilisateur);
		return utilisateur;
	}

	public void updateUtilisateur(Utilisateur utilisateur) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(utilisateur);
	}

	public void deleteUtilisateur(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Utilisateur u = (Utilisateur) session.load(Utilisateur.class, new Integer(id));
		if (null != u) {
			session.delete(u);
		}
	}	

}
