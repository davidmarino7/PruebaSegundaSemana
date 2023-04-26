package prueba.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import prueba.semana1.Coche;
import prueba.semana1.Vehiculo;

import prueba.persistence.JPAPersistence;

public class CocheController {

public static void main(String[] args) {
		
		int opcion = 0;  //inicializamos variable para las opciones 
		
		try (Scanner scanner = new Scanner(System.in)) {
			// clase que permite leer los datos que el
			//usuario introduce por teclado
			Vehiculo vehiculo;
			Coche coche; // variable de tipo Producto
			
			//Objeto entity para crear conexi�n a base
			EntityManager entity = JPAPersistence.getEntityManagerFactory().createEntityManager();
			
			//hacemos un loop mientras se vayan ingresando el n�mero de opciones
			while (opcion!=5) {
				
				//Opciones disponibles
				System.out.println("1. Guardar nuevo Coche en la BD"); 
				System.out.println("2. Buscar Coche");
				System.out.println("3. Salir");
				System.out.println("Elija una opcion:");

				opcion = scanner.nextInt();
				
				switch (opcion) { //realizamos el switch de acuerdo a la opci�n ingresada
				case 1:
					//instaciamos al objeto
					coche = new Coche("Verde","Chevrolet","40000","5454ASF","4"); 
				
					//A traves de objeto entity
					entity.getTransaction().begin(); //aqui le digo que inicie la transacci�n
					entity.persist(coche); //aqui le indico a trav�s del m�todo persidt que guarde en BD
					entity.getTransaction().commit(); //aqui le indico que culmine
					
					System.out.println("Coche registrado..");
					System.out.println();
					break;

				case 2:
					System.out.println("Digite el id del producto a buscar:");
					
					//con el m�todo find realiza una b�squeda por id en la tabla
					//le pasamos dos parametros, la clase Producto y el ID a trav�s del scanner
					
					coche = entity.find(Coche.class, scanner.nextLong()); 
					
					
					if (coche != null) { //aqui validamos si es diferente de null
						System.out.println(coche); //imprimimos el producto
						
					}else {
						
						System.out.println("No existe el coche");
					}

					break;
				}
			}

		}
}
}


