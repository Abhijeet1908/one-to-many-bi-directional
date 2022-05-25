package com.ty.one_to_many_bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalAndBranch {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital = new Hospital();
		hospital.setName("Wellness HealthCare");
		hospital.setWebsite("www.WellnessHealthCare.org");
		hospital.setGstNo("124578aasa");
		
		Branch branch1 = new Branch();
		branch1.setName("Gangtok Branch");
		branch1.setAddress(" Sikkim, India");
		branch1.setPhone(32145665);
		branch1.setHospital(hospital);
		
		Branch branch2 = new Branch();
		branch2.setName("Delhi Branch");
		branch2.setAddress("Delhi, India");
		branch2.setPhone(32145665);
		branch2.setHospital(hospital);
		
		
		
		entityTransaction.begin();
		
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		
		entityTransaction.commit();
		
		System.out.println("Regestration Sucessfull");
		
	}

}




