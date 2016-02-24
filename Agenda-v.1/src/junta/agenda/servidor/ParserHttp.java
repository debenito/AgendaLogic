package junta.agenda.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import junta.agenda.Agenda;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Clase encargada de la transformación del fichero del
 *          servidor en la estructura de datos de la Agenda.
 */
public class ParserHttp extends HttpServicio {
	/**
	 * Constructor extendido de HTTPSERVICIO
	 * 
	 * @param url
	 * @throws MalformedURLException
	 */
	public ParserHttp(String url) throws MalformedURLException {
		super(url);
	}

	/**
	 * Metodo de parseo refactorizado
	 */
	@Override
	public void execute(Agenda a) throws IOException {
		// Creacion del input donde se van a leer los datos
		InputStream is;
		try {
			// Inicialización
			is = con.getInputStream();
			// Creacion del buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			leerFicheroRetorno(br, a);
		} catch (IOException e) {
			throw new IOException("Problemas con las lecura del fichero");
		}

	}

	/**
	 * Lectura del buffer y creacion de la estructura principal de la agenda
	 * 
	 * @param br
	 *            : Buffer del que se lee
	 * @param a
	 *            : Aganda creada con anteriodad
	 * @throws IOException
	 */
	private void leerFicheroRetorno(BufferedReader br, Agenda a)
			throws IOException {
		while (br.readLine() != null) {
			a.interpretar(br.readLine());
		}

	}

}
