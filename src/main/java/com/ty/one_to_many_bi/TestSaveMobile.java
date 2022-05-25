package com.ty.one_to_many_bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobile {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Sim s1 = new Sim();
		s1.setProvider("Airtel");
		s1.setType("4G");
		s1.setImei("aassadad5");

		Sim s2 = new Sim();
		s2.setProvider("Jio");
		s2.setType("4G");
		s2.setImei("1245");

		Mobile mobile = new Mobile();
		mobile.setName("Samsung");
		mobile.setCost(18000);

		List<Sim> sims = new ArrayList<Sim>();
		sims.add(s1);
		sims.add(s2);
		
		s1.setMobile(mobile);
		s2.setMobile(mobile);
		
		mobile.setSim(sims);

		entityTransaction.begin();

		entityManager.persist(mobile);
		entityManager.persist(s1);
		entityManager.persist(s2);

		entityTransaction.commit();

		System.out.println("Sims added sucessfully");

	}

}
