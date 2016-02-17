package benito.agenda.servidor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import benito.agenda.Agenda;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Clase abstracta creada para dar servicio a la petición
 *          sobre una Url, de la cual, recibiremos los datos para un futuro
 *          parseo.
 */
public abstract class HttpServicio {
	/**
	 * Atributos URL y conexion
	 */
	URL url;
	URLConnection con;

	/**
	 * Constructor en el que s ele pasa un String como parametro y genera un
	 * Objecto URL. Si surgiera algun problema en la transformacion saltaria la
	 * excepción.
	 * 
	 * @param url
	 *            : De tipo string
	 * @throws MalformedURLException
	 *             : Muestra mensaje de error si esta mal formada
	 */
	public HttpServicio(String url) throws MalformedURLException {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			throw new MalformedURLException(
					"Problema con la URL comprueba si esta bien escrita");
		}

	}

	/**
	 * Encargado de inicializar la conexion abrirla y llamar al metodo de parseo
	 * con la creacion de una nueva agenda.
	 * 
	 * @throws IOException
	 *             : Se recoge si existe algun problema a la hora de abrir la
	 *             conexion.
	 */
	public void AbrirConexion() throws IOException {
		try {
			this.con = this.url.openConnection();
			execute(new Agenda());
		} catch (IOException e) {
			throw new IOException("Problemas con acceso a servidor");
		}
	}

	/**
	 * Metodo de parseo de los datos recibidos.
	 * 
	 * @param agenda
	 *            : Objeto Agenda creado anteriormente en el metodo Abrir
	 * @throws IOException
	 */
	public abstract void execute(Agenda agenda) throws IOException;
}
