package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Profile;

public class ProfileDao {

	EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("progamer-persistence-unit");
	EntityManager manager = factory.createEntityManager();
	
	public void create(Profile profile) {
		manager.getTransaction().begin();
		manager.persist(profile);
		manager.getTransaction().commit();
		
		manager.clear();
		
	}
	
	public List<Profile> listAll() {
		TypedQuery<Profile> query = 
				manager.createQuery("SELECT p FROM Profile p", Profile.class);
		return query.getResultList();
	}

}
