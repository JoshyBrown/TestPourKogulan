package org.formation.jpa.lanceur;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.jpa.entity.FourWheeler;
import org.formation.jpa.entity.TwoWheeler;
import org.formation.jpa.entity.UserDetails;
import org.formation.jpa.entity.Vehicle;

public class MainTest {

	public static void createTestUsers() {
//////////////////////////////////////////////////////////////////////////////////////////////////
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persotp0jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		
		List<UserDetails> users = new ArrayList<>();
		
		try {
			tnx.begin();
		
			for (int i = 0; i <= 10 ; i++) {
				UserDetails user = new UserDetails("Name #" + i);
				
				List<Vehicle> vehicles = new ArrayList<>();
				for (int j = 0; j < 3; j++) {
					int r = (int) (Math.random()*2 + 1);
					Vehicle v = (r%2 == 0) ? new FourWheeler() : new TwoWheeler();
					vehicles.add(v); 
				}	
				
				user.setVehicles(vehicles);
				users.add(user);
			}
			// boucle for each
			for (UserDetails u : users) {
				em.persist(u);
			} 
			
			tnx.commit();
			
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persotp0jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		
		createTestUsers();
		
		try {
			
			tnx.begin();
			
			// 1. tester les persistances 
			
//			Vehicle vehicle = new Vehicle("Citroen");
//			UserDetails user = new UserDetails("Toto");
//			
//			em.persist(user);
//			em.persist(vehicle);
			
			// 2. TypedQuery<TypeAttendu> query plutôt que Query query
		
			TypedQuery<UserDetails> query = em.createQuery("from UserDetails where userId > 5", UserDetails.class); 
			// langage HQL UserDetails.class = on lui dit la classe qu'on attend. select m from Vehicule 
			List<UserDetails> resultList = query.getResultList(); 
			
			System.out.println("Size of list result = " + resultList.size());
			System.out.println(resultList);
			
			tnx.commit();
			
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
