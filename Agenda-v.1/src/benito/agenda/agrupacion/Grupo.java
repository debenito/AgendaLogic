package benito.agenda.agrupacion;

import java.util.ArrayList;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Clase encargada de un grupo
 */
public class Grupo extends Agrupacion {
	/**
	 * Atributos de un Grupo contenido de otros Grupos, Imagenes,
	 */
	private ArrayList<Agrupacion> agrupacion = new ArrayList<>();
	// String creado para guardar todos los elementos de una agrupacion
	private String nuevo = "";
	private String Imagen;

	/**
	 * Contructor con los dos parametros para la inicializacion del Grupo
	 * 
	 * @param imagen
	 * @param nombre_Grupo
	 */
	public Grupo(String imagen, String nombre_Grupo) {
		super(nombre_Grupo);
		Imagen = imagen;

	}

	/**
	 * Metodo que muestra una imagen
	 * 
	 * @return Imagen
	 */
	public String getImagen() {
		return Imagen;
	}

	/**
	 * Metodo para cambiar una imagen
	 * 
	 * @param imagen
	 */
	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	/**
	 * Metodo para añadir una agrupacion
	 * 
	 * @param o
	 *            : Se le pasa una nueva agrupacion por parametro la cual sera
	 *            añadida.
	 */
	public void añadir(Agrupacion o) {
		agrupacion.add(o);

	}

	/**
	 * Metodo para borrar una agrupacion si asi lo desea
	 * 
	 * @param o
	 *            : Se le pasa la agrupacion la cual se va a borrar
	 */
	public void borrar(Agrupacion o) {
		agrupacion.remove(o);

	}

	/**
	 * Metodo que muestra todos los elementos existentes dentro del array de
	 * agrupaciones
	 */
	public String ver() {
		nuevo += "Imagen Grupo :" + Imagen + "|Nombre_Grupo :"
				+ super.getNombre() + "\n";
		for (Agrupacion agrupacion2 : agrupacion) {
			nuevo += agrupacion2.ver();

		}
		return nuevo;

	}

	/**
	 * Metodo que devuelve los elementos del array de agrupaciones
	 * 
	 * @return
	 */
	public ArrayList<Agrupacion> getAgrupacion() {
		return agrupacion;
	}

	/**
	 * Metodo para buscar y añadir un Grupo o un contacto nuevo a la estructura
	 * en forma de arbol
	 * 
	 * @param nueva
	 * @param nombre
	 */
	public void añadirContactos(Agrupacion nueva, String nombre) {
		// Si nombre coincide con el de la clase añadelo a la agrupacion
		// Sino coincide recorre el array
		if (nombre.equals(getNombre())) {
			agrupacion.add(nueva);
		} else {
			for (int i = 0; i < agrupacion.size(); i++)
				// Si el objeto es una instacia de Grupo añade a ese grupo el
				// nuevo contacto o grupo haciendo una llamada recursiva
				if (agrupacion.get(i) instanceof Grupo)
					((Grupo) agrupacion.get(i)).añadirContactos(nueva, nombre);
		}

	}
	
	public Agrupacion buscarAgrupacion(String nombre){
		if(nombre.equals(getNombre()))
				return this;
		else
			for(int i = 0; i< agrupacion.size(); i++)
				if(agrupacion.get(i).getNombre().equals(nombre))
					return agrupacion.get(i);
		return null;
	}

}
