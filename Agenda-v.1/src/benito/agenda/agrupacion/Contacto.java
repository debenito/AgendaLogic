package benito.agenda.agrupacion;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Clase encargada del contacto
 */
public class Contacto extends Agrupacion {
	/**
	 * Tres atributos principales Imagen, Apellidos, Telefono de tipo String
	 */
	String Imagen;
	String Apellidos;
	String Telefono;

	/**
	 * Metodo que retorna la imagen que tiene el contacto
	 * 
	 * @return Imagen
	 */
	public String getImagen() {
		return Imagen;
	}

	/**
	 * Metodo que cambia una Imagen por otro
	 * 
	 * @param imagen
	 */
	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	/**
	 * Metodo que retorna los apellidos.
	 * 
	 * @return Apellidos
	 */
	public String getApellidos() {
		return Apellidos;
	}

	/**
	 * Metodo que cambia los apellidos.
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	/**
	 * Metodo que retorna el telefono.
	 * 
	 * @return Telefono
	 */
	public String getTelefono() {
		return Telefono;
	}

	/**
	 * Metodo que modifica el telefono.
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	/**
	 * Metodo que muestra los parametros del Contacto
	 */
	@Override
	public String ver() {
		return "Imagen :" + Imagen + "|Nombre y Apellidos : "
				+ super.getNombre() + "&" + Apellidos + "|Telefono :"
				+ Telefono + "\n";

	}

	/**
	 * Contructor que le pasa los parametros del contacto para su creacion.
	 * 
	 * @param imagen
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 */
	public Contacto(String imagen, String nombre, String apellidos,
			String telefono) {
		super(nombre);
		Imagen = imagen;
		Apellidos = apellidos;
		Telefono = telefono;
	}

}
