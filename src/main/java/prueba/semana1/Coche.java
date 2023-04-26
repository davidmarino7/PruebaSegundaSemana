package prueba.semana1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Coche.java Clase para el objecto Coche
 */

//Definimos la Entidad Coche y le decimos qué tabla es en la base de datos
@Entity
@Table(name="coche")
public class Coche extends Vehiculo {
	
	//Definimos la columna y su correspondiente nombre en la base de datos
	@Column(name="tipoMarchas")
    private String tipoMarchas;
	
	
    protected static final String TIPO = "Coche";

    /**
     * Constructor de la clase Coche.
     *
     * @param color       color del vehiculo
     * 
     * @param marca       marca del vehiculo
     * 
     * @param precio      precio del vehiculo
     * 
     * @param matricula   matricula del vehiculo
     * 
     * @param tipoMarchas tipo de marchas del coche
     * 
     */
    public Coche(String color, String marca, String precio, String matricula, String tipoMarchas) {
        super(color, marca, precio, matricula, 4); // Siempre tiene 4 ruedas si es un coche
        this.tipoMarchas = tipoMarchas;

    }
    
    public Coche() {
    	super(); 	
    }
    
  
    public String getTipoMarchas() {
        return tipoMarchas;
    }

    /**
     * imprime los datos del coche.
     *
     **/
    @Override
    public void imprimirDatos() {
        System.out.println("Este vehiculo es un coche");
        System.out.println("Este coche tiene una marcha " + tipoMarchas);
        super.imprimirDatos();
    }

	@Override
	public String toString() {
		return "Coche [tipoMarchas=" + tipoMarchas + ", color=" + color + ", marca=" + marca + ", precio=" + precio
				+ ", matricula=" + matricula + ", numRuedas=" + numRuedas + ", horaInicio=" + horaInicio
				+ ", distanciaRecorrida=" + distanciaRecorrida + "]";
	}
    
    

}
