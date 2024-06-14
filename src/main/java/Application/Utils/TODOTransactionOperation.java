package Application.Utils;

import jakarta.persistence.EntityManager;

/**
 * Interface fonctionnelle permettant de définir une méthode abstraite
 * permettant d'exécuter une méthode dans un bloc
 * 
 * @param <T>
 */
@FunctionalInterface
public interface TODOTransactionOperation<T> {

	T execute(EntityManager entityManager);

}
