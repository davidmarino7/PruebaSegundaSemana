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
		
		
		// clase que permite leer los datos que el usuario introduce por scanner
		try (Scanner scanner = new Scanner(System.in)) {
			

			// variable de tipo Coche
			Coche coche; 
			
			//Objeto entity para crear conexión a base de datos
			EntityManager entity = JPAPersistence.getEntityManagerFactory().createEntityManager();
			
			//hacemos un loop mientras se vayan ingresando el n�mero de opciones
			while (opcion!=5) {
				
				//Opciones disponibles
				System.out.println("1. Guardar nuevo Coche en la BD"); 
				System.out.println("2. Buscar Coche");
				System.out.println("3. Salir");
				System.out.println("Elija una opcion:");

				opcion = scanner.nextInt();
				
				switch (opcion) { //realizamos el switch de acuerdo a la opción ingresada
				case 1:
					//instaciamos al objeto Coche y le pasamos los datos
					coche = new Coche("Verde","Chevrolet","40000","5454ASF","4"); 
				
					//A traves de objeto entity
					entity.getTransaction().begin(); //aqui le digo que inicie la transacción
					entity.persist(coche); //en este paso lo guardamos en la Base de Datos
					entity.getTransaction().commit(); //aqui le indico que culmine
					
					System.out.println("Coche registrado..");
					
					break;

				case 2:
					System.out.println("Digite el id del coche a buscar:");
					
					//con el método find realiza una búsqueda por id en la tabla
					//le pasamos dos parametros, la clase Producto y el ID a través del scanner					
					coche = entity.find(Coche.class, scanner.nextLong()); 
					
					//validamos si existe el coche, si existe imprímelo, si no imprime el sysOut
					if (coche != null) { 
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


