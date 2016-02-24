package junta.agenda.editor;

import java.awt.Point;

import junta.agenda.agrupacion.Agrupacion;
import junta.agenda.agrupacion.Contacto;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Interfaz con metodos implementados por los tipos de
 *          contenedor existente
 */
public class ContenedorContacto implements Contenedor {
	/**
	 * Parametros de inicializacion
	 */
	private int alto;
	private int ancho;
	private Point corner;

	/**
	 * Contructor con parametros de inicializacion
	 * 
	 * @param alto
	 * @param ancho
	 * @param corner
	 */
	public ContenedorContacto(int alto, int ancho, Point corner) {

		this.corner = corner;
		this.alto = alto;
		this.ancho = ancho;

	}

	@Override
	public void execute(AreaDelContenido area) {
		area.setAlto(alto);
		area.setAncho(ancho);
	}

	@Override
	public void clickon(int x, int y, Agrupacion agrupacion) {
		if (contiene(x, y))
			System.out.println(llamar(agrupacion));

	}

	/**
	 * Metodo para realizar una llamada
	 * 
	 * @param agrupacion
	 * @return LLamda a telefono
	 */
	public String llamar(Agrupacion agrupacion) {
		return "LLamado al telefono" + ((Contacto) agrupacion).getTelefono();
	}

	/**
	 * Metodo para ver si la pulsacion esta dentro del areaContenida
	 * 
	 * @param x
	 * @param y
	 * @return true si esta false sino
	 */
	private boolean contiene(int x, int y) {
		return (corner.x <= x && x <= corner.x + ancho)
				&& (corner.y <= y && y <= corner.y + alto);
	}

	@Override
	public String dibujar(Agrupacion a) {
		String cadena = "";
		cadena += "Tamaño Pizarra:" + alto + " " + ancho + "\n";
		cadena += "Posicion Esquina:" + corner.x + " " + corner.y + "\n";
		cadena += "Datos del contacto" + "\n";
		cadena += "Nombre:" + a.getNombre() + "\n";
		cadena += "Imagen" + ((Contacto) a).getImagen() + "\n";
		cadena += "Apellidos" + ((Contacto) a).getApellidos() + "\n";
		cadena += "Imagen" + ((Contacto) a).getTelefono() + "\n";
		cadena += "==============================" + "\n";
		return cadena;
	}

	@Override
	public Contenedor createContenedor() {
		return new ContenedorContacto(alto, ancho, corner);
	}
}
