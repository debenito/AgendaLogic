package benito.agenda.editor;

import java.awt.Point;

import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Grupo;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Interfaz con metodos implementados por los tipos de
 *          contenedor existente
 */
public class ContenedorGrupo implements Contenedor {
	/**
	 * Parametros de inicializacion
	 */
	private int alto;
	private int ancho;
	private Point corner;
	private Panel panel;

	/**
	 * Contructor con parametros de inicializacion
	 * 
	 * @param alto
	 * @param ancho
	 * @param corner
	 * @param panel
	 */
	public ContenedorGrupo(int alto, int ancho, Point corner, Panel panel) {
		this.corner = corner;
		this.alto = alto;
		this.ancho = ancho;
		this.panel = panel;
	}

	@Override
	public void execute(AreaDelContenido p) {
		p.setAlto(alto);
		p.setAncho(ancho);
	}

	@Override
	public void clickon(int x, int y, Agrupacion e) {
		if (contiene(x, y)) {
			panel.cambiarPantalla(e);
		}
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
		cadena += "Datos del Grupo" + "\n";
		cadena += "Nombre:" + a.getNombre() + "\n";
		cadena += "Imagen" + ((Grupo) a).getImagen() + "\n";
		cadena += "==============================" + "\n";
		return cadena;

	}

	@Override
	public Contenedor createContenedor() {
		return new ContenedorGrupo(alto, ancho, corner, panel);
	}
}
