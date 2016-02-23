package benito.agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Contacto;
import benito.agenda.agrupacion.Grupo;
import benito.agenda.servidor.HttpServicio;
import benito.agenda.servidor.ParserHttp;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Clase Principal generación de una Agenda en la que se
 *          pueden añadir los contactos y los grupos.
 */
public class Agenda {
	/**
	 * Atributos principales Agrupacion y servicio para conexion
	 */
	private Agrupacion agrupacion;
	private HttpServicio service;
	private static int TRES = 3;
	/**
	 * Contructor de Agenda encargado de inicializacion de la agenda
	 */
	public Agenda() {
		this.agrupacion = new Grupo("0", "0");
	}

	/**
	 * Contructor encargado de inicalizacion de la agenda con un parametro
	 * agrupacion
	 * 
	 * @param agrupacion
	 */
	public Agenda(Agrupacion agrupacion) {
		this.agrupacion = agrupacion;

	}

	/**
	 * Metodo encargado de añadir los nuevos contactos a la agenda
	 * 
	 * @param o
	 *            : Agrupacion nueva que se quiere añadir.
	 */
	public void añadirContactos(Agrupacion o) {
		if (agrupacion instanceof Grupo)
			((Grupo) agrupacion).añadir(o);
	}

	/**
	 * Metodo para visualizar los contactos.
	 * 
	 * @return String con los datos de los contactos
	 */
	public String verContactos() {
		return agrupacion.ver();

	}

	/**
	 * Metodo para borrar un contacto en el caso de que fuera necesario.
	 * 
	 * @param o
	 *            : Agrupacion que se desee borrar.
	 */
	public void borrarContactos(Agrupacion o) {
		if (agrupacion instanceof Grupo)
			((Grupo) agrupacion).borrar(o);
	}

	/**
	 * Listado de los grupos que se deseen ver dentro de una agrupacion.
	 * 
	 * @return Listado de grupos .
	 */
	public List<Agrupacion> verGrupos() {
		return ((Grupo) agrupacion).getAgrupacion();
	}

	/**
	 * Metodo encargado de interpretar cada linea y crear los nuevos contactos y
	 * añadirlos
	 * 
	 * @param linea
	 * @throws IOException
	 * @throws Exception
	 */
	public void interpretarLinea(String linea) throws IOException {
		String partes[] = linea.split(":");

		Agrupacion nueva;
		if (comprobacionTrim(partes)) {
			// Si es 3 se crea un grupo sino se crea un contacto como mucho el
			// tamaño es 5
			if (partes.length == TRES)
				nueva = new Grupo(partes[0], partes[2].replace(";", ""));
			else
				nueva = new Contacto(partes[0], partes[2], partes[3],
						partes[4].replace(";", ""));
			// Si el nombre de la agrupacion es 0 es la primera agrupacion sino
			// llamamos al metodo añadir contactos en la clase grupo
			if (agrupacion.getNombre().equals("0"))
				agrupacion = nueva;
			else
				((Grupo) agrupacion).añadirContactos(nueva, partes[1]);
		} else
			throw new IOException("Existen espacios entre los datos pasados");
	}

	/**
	 * Metodo para comprobar si existen espacios entre los :
	 * 
	 * @param partes
	 */
	private boolean comprobacionTrim(String[] partes) {
		String parteVieja;
		boolean parte = false;
		for (int i = 0; i < partes.length; i++) {
			parteVieja = partes[i];
			if (partes[i].trim().equals(parteVieja))
				parte = true;

		}
		return parte;

	}

	/**
	 * Metodo encargado de la interpretacion del fichero se le pasan las lineas
	 * a otro metodo interpretarLinea
	 * 
	 * @param nombreFichero
	 * @throws IOException
	 * @throws Exception
	 */
	public void interpretar(String nombreFichero) throws IOException {
		BufferedReader read = null;
		String linea = null;
		try {
			read = new BufferedReader(new FileReader("FicheroREST.txt"));

			while ((linea = read.readLine()) != null) {
				interpretarLinea(linea);
			}
			read.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Problemas no encuentra el fichero");
		} catch (IOException io) {
			throw new IOException("Problemas en la carga del fichero");
		}

	}

	/**
	 * Metodo encargado de llamar a la URl y transformar los datos asi como
	 * añadirlos
	 * 
	 * @throws IOException
	 */
	public void sacarDatosServidor() throws IOException {
		this.service = new ParserHttp("");
		service.execute(this);

	}

	public Agrupacion getAgrupacion() {
		return agrupacion;
	}

	public Agrupacion pasarSiguiente(String nombre){
		return ((Grupo)agrupacion).buscarAgrupacion(nombre);
	}
	
	 
	
}
