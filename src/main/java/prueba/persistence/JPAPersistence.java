package prueba.persistence;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

/**
 * 
 * @author David
 * 
 *
 */

public class JPAPersistence {
	
	//definimos el nombre de la unidad de persistencia
	private static final String PERSISTENCE_UNIT_NAME= "PERSISTENCE";
	
	//definimos un EntityManagerFactory
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME); //Creamos la unidad de persistencia
		}
		return factory;
	}
	
	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}

	public JPAPersistence() {
		// TODO Auto-generated constructor stub
	}

}

