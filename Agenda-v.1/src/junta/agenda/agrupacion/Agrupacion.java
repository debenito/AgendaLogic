package junta.agenda.agrupacion;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Clase abstracta creada para la agregacion de contactos y
 *          grupos.
 */
public abstract class Agrupacion {
	/**
	 * Nombre de la agrupacion general
	 */
	private String nombre;

	/**
	 * Constructor de agrupacion pasando como parametro el nombre
	 * 
	 * @param nombre
	 */
	public Agrupacion(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Muestra los Contactos y grupos existente en la agrupación
	 * 
	 * @return Nombres agrupaciones y atributos
	 */
	public abstract String ver();

	/**
	 * Muestra el nombre de la agrupación
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

}
