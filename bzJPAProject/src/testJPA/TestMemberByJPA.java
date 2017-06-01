package testJPA;

import javax.persistence.EntityManager;

import model.PersistenceManager;
import model.Member;

public class TestMemberByJPA {

	public static void main(String[] args)
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	    em.getTransaction()
	        .begin();
	    em.persist(new Member(6,"LEONHART","LEON","RIDDLE"));
	    em.getTransaction()
	        .commit();

	    em.close();
	    PersistenceManager.INSTANCE.close();
	}
	
	
	
}
