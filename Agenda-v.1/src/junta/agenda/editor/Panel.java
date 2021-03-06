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
	private int tamaņoAltoPanel;
	private int tamaņoAnchoPanel;
	private Agenda agenda;

	/**
	 * Contructor con los tamaņos del panel
	 * 
	 * @param tamaņoAltoPanel
	 * @param tamaņoAnchoPanel
	 */
	public Panel(int tamaņoAltoPanel, int tamaņoAnchoPanel) {
		this.tamaņoAltoPanel = tamaņoAltoPanel;
		this.tamaņoAnchoPanel = tamaņoAnchoPanel;
	}

	/**
	 * Contructor principal pasando ademas la agenda
	 * 
	 * @param tamaņoAltoPanel
	 * @param tamaņoAnchoPanel
	 * @param agenda
	 */
	public Panel(int tamaņoAltoPanel, int tamaņoAnchoPanel, Agenda agenda) {
		this.tamaņoAltoPanel = tamaņoAltoPanel;
		this.tamaņoAnchoPanel = tamaņoAnchoPanel;
		this.agenda = agenda;
		this.aņadirAreas((Grupo) agenda.getAgrupacion());
	}

	/**
	 * Devuelve el alto del panel
	 * 
	 * @return
	 */
	public int getTamaņoAltoPanel() {
		return tamaņoAltoPanel;
	}

	/**
	 * Modifica el alto del panel
	 * 
	 * @param tamaņoAltoPanel
	 */
	public void setTamaņoAltoPanel(int tamaņoAltoPanel) {
		this.tamaņoAltoPanel = tamaņoAltoPanel;
	}

	/**
	 * Devuelve el ancho del panel
	 * 
	 * @return
	 */
	public int getTamaņoAnchoPanel() {
		return tamaņoAnchoPanel;
	}

	/**
	 * Modifica el ancho del panel
	 * 
	 * @param tamaņoAnchoPanel
	 */
	public void setTamaņoAnchoPanel(int tamaņoAnchoPanel) {
		this.tamaņoAnchoPanel = tamaņoAnchoPanel;
	}

	/**
	 * Metodo para aņadir a la lista un area nueva
	 * 
	 * @param agrupacion
	 */
	public void aņadirAreas(Grupo agrupacion) {
		// Para cada lista dentro de la agrupacion se crea un area
		// nueva con el tamaņo del ancho y alto divido entre el numero
		// de filas, cada uno y se aņaden los paneles al array
		// de areaContenido
		for (int i = 0; i < agrupacion.getAgrupacion().size(); i++)
			areaContenido.add(new AreaDelContenido(tamaņoAltoPanel
					/ numeroFilas, tamaņoAnchoPanel / numeroFilas, agrupacion
					.getAgrupacion().get(i), this, new Point(
					(tamaņoAltoPanel * i), (tamaņoAnchoPanel * i))));

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
		this.aņadirAreas((Grupo) agrupacion);
		this.dibujar();

	}

	/**
	 * Metodo que dibuja el lienzo o panel del tamaņo indicado por el usuario.
	 * 
	 * @return
	 */
	public String dibujar() {
		String cadena = "";
		cadena += "Tamaņo Panel : " + tamaņoAltoPanel + ":" + tamaņoAnchoPanel
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
