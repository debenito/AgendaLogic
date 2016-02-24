package junta.agenda.editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import junta.agenda.Agenda;
import junta.agenda.agrupacion.Agrupacion;
import junta.agenda.agrupacion.Grupo;

/**
 * Metodo para ver si la pulsacion esta dentro del areaContenida
 * 
 * @param x
 * @param y
 * @return true si esta false sino
 */
public class Panel {
	/**
	 * Parametros de inicializacion
	 */
	public static final int numeroFilas = 3;
	List<AreaDelContenido> areaContenido = new ArrayList<AreaDelContenido>();
	private int tamañoAltoPanel;
	private int tamañoAnchoPanel;
	private Agenda agenda;

	/**
	 * Contructor con los tamaños del panel
	 * 
	 * @param tamañoAltoPanel
	 * @param tamañoAnchoPanel
	 */
	public Panel(int tamañoAltoPanel, int tamañoAnchoPanel) {
		this.tamañoAltoPanel = tamañoAltoPanel;
		this.tamañoAnchoPanel = tamañoAnchoPanel;
	}

	/**
	 * Contructor principal pasando ademas la agenda
	 * 
	 * @param tamañoAltoPanel
	 * @param tamañoAnchoPanel
	 * @param agenda
	 */
	public Panel(int tamañoAltoPanel, int tamañoAnchoPanel, Agenda agenda) {
		this.tamañoAltoPanel = tamañoAltoPanel;
		this.tamañoAnchoPanel = tamañoAnchoPanel;
		this.agenda = agenda;
		this.añadirAreas((Grupo) agenda.getAgrupacion());
	}

	/**
	 * Devuelve el alto del panel
	 * 
	 * @return
	 */
	public int getTamañoAltoPanel() {
		return tamañoAltoPanel;
	}

	/**
	 * Modifica el alto del panel
	 * 
	 * @param tamañoAltoPanel
	 */
	public void setTamañoAltoPanel(int tamañoAltoPanel) {
		this.tamañoAltoPanel = tamañoAltoPanel;
	}

	/**
	 * Devuelve el ancho del panel
	 * 
	 * @return
	 */
	public int getTamañoAnchoPanel() {
		return tamañoAnchoPanel;
	}

	/**
	 * Modifica el ancho del panel
	 * 
	 * @param tamañoAnchoPanel
	 */
	public void setTamañoAnchoPanel(int tamañoAnchoPanel) {
		this.tamañoAnchoPanel = tamañoAnchoPanel;
	}

	/**
	 * Metodo para añadir a la lista un area nueva
	 * 
	 * @param agrupacion
	 */
	public void añadirAreas(Grupo agrupacion) {
		// Para cada lista dentro de la agrupacion se crea un area
		// nueva con el tamaño del ancho y alto divido entre el numero
		// de filas, cada uno y se añaden los paneles al array
		// de areaContenido
		for (int i = 0; i < agrupacion.getAgrupacion().size(); i++)
			areaContenido.add(new AreaDelContenido(tamañoAltoPanel
					/ numeroFilas, tamañoAnchoPanel / numeroFilas, agrupacion
					.getAgrupacion().get(i), this, new Point(
					(tamañoAltoPanel * i), (tamañoAnchoPanel * i))));

	}

	/**
	 * Borrar un area
	 * 
	 * @param area
	 */
	public void borrarArea(AreaDelContenido area) {
		areaContenido.remove(area);
	}

	/**
	 * Buscar un area en el array por un indice
	 * 
	 * @param i
	 * @return
	 */
	public AreaDelContenido getArea(int i) {
		return areaContenido.get(i);
	}

	/**
	 * Metodo que sabe en que area se ha pulsado dependiendo de la posicion y
	 * realiza diferentes acciones dependiendo de esta.
	 * 
	 * @param x
	 * @param y
	 */
	public void clickon(int x, int y) {
		for (AreaDelContenido Area : areaContenido) {
			Area.pinchar(x, y);
		}
	}

	/**
	 * Metodo para rehacer los datos mostrados en la pantalla con unos nuevos.
	 * Esto se realiza solamente si es un grupo ya que se cambiarian todos los
	 * icionos y las divisiones por las nuevas.
	 * 
	 * @param agrupacion
	 */
	public void cambiarPantalla(Agrupacion agrupacion) {
		this.areaContenido = new ArrayList<AreaDelContenido>();
		this.añadirAreas((Grupo) agrupacion);
		this.dibujar();

	}

	/**
	 * Metodo que dibuja el lienzo o panel del tamaño indicado por el usuario.
	 * 
	 * @return
	 */
	public String dibujar() {
		String cadena = "";
		cadena += "Tamaño Panel : " + tamañoAltoPanel + ":" + tamañoAnchoPanel
				+ "\n";
		for (AreaDelContenido areaDelContenido : areaContenido) {
			cadena += areaDelContenido.dibujar();
		}
		return cadena;
	}

	/**
	 * Metodo que retorna la agenda
	 * 
	 * @return agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}

}
