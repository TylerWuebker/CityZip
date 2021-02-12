/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Feb 11, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CityZip;

/**
 * @author wuebk
 *
 */
public class CityZipAssist {
	static EntityManagerFactory emManager = Persistence.createEntityManagerFactory("CityZipCodeJPA");
	
	public void insertZip(CityZip CZ) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		em.persist(CZ);;
		em.getTransaction().commit();
		em.close();
	}
	public List<CityZip> showAllZip(){
		EntityManager em = emManager.createEntityManager();
		List<CityZip> allItems = em.createQuery("SELECT i FROM CityZip i").getResultList();
		return allItems;
	}
	public void deleteZip(CityZip toDelete) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CityZip> typedQuery = em.createQuery("select CZ from CityZip CZ where CZ.zipCode = :selectedzipCode", CityZip.class);
		
		typedQuery.setParameter("selectedzipCode", toDelete.getZipCode());
		
		typedQuery.setMaxResults(1);
		
		CityZip result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CityZip> lookForZip(String Zip){
		try {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CityZip> tQ = em.createNamedQuery("select CZ from CityZip CZ where CZ.zipCode = :selectedzipCode", CityZip.class);
		tQ.setParameter("selectedzipCode", Zip);
		List<CityZip> foundZip = tQ.getResultList();
		em.close();
		return foundZip;
		}
		catch(Exception IllegalArgumentException) {
			List<CityZip> notFoundZip = null;
			System.out.println("NO MATCHING VALUE FOUND!");
			return notFoundZip;
		}
		
	}
	
	public void update(List<CityZip> edit) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		em.merge(edit);
		em.getTransaction().commit();
		em.close();
	}
}
