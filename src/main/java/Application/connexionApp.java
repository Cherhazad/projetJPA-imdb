package Application;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class connexionApp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("appMovie");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		
		Acteur acteur1 = new Acteur("1", "Blabla Blablou", LocalDate.of(2019, 10, 18), 1.70, ":/jnkjnlj");
		em.persist(acteur1);
		System.out.println(acteur1);
		
		
		transaction.commit();
		em.close();
		
	}
}
