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
	private int tama�oAltoPanel;
	private int tama�oAnchoPanel;
	private Agenda agenda;

	/**
	 * Contructor con los tama�os del panel
	 * 
	 * @param tama�oAltoPanel
	 * @param tama�oAnchoPanel
	 */
	public Panel(int tama�oAltoPanel, int tama�oAnchoPanel) {
		this.tama�oAltoPanel = tama�oAltoPanel;
		this.tama�oAnchoPanel = tama�oAnchoPanel;
	}

	/**
	 * Contructor principal pasando ademas la agenda
	 * 
	 * @param tama�oAltoPanel
	 * @param tama�oAnchoPanel
	 * @param agenda
	 */
	public Panel(int tama�oAltoPanel, int tama�oAnchoPanel, Agenda agenda) {
		this.tama�oAltoPanel = tama�oAltoPanel;
		this.tama�oAnchoPanel = tama�oAnchoPanel;
		this.agenda = agenda;
		this.a�adirAreas((Grupo) agenda.getAgrupacion());
	}

	/**
	 * Devuelve el alto del panel
	 * 
	 * @return
	 */
	public int getTama�oAltoPanel() {
		return tama�oAltoPanel;
	}

	/**
	 * Modifica el alto del panel
	 * 
	 * @param tama�oAltoPanel
	 */
	public void setTama�oAltoPanel(int tama�oAltoPanel) {
		this.tama�oAltoPanel = tama�oAltoPanel;
	}

	/**
	 * Devuelve el ancho del panel
	 * 
	 * @return
	 */
	public int getTama�oAnchoPanel() {
		return tama�oAnchoPanel;
	}

	/**
	 * Modifica el ancho del panel
	 * 
	 * @param tama�oAnchoPanel
	 */
	public void setTama�oAnchoPanel(int tama�oAnchoPanel) {
		this.tama�oAnchoPanel = tama�oAnchoPanel;
	}

	/**
	 * Metodo para a�adir a la lista un area nueva
	 * 
	 * @param agrupacion
	 */
	public void a�adirAreas(Grupo agrupacion) {
		// Para cada lista dentro de la agrupacion se crea un area
		// nueva con el tama�o del ancho y alto divido entre el numero
		// de filas, cada uno y se a�aden los paneles al array
		// de areaContenido
		for (int i = 0; i < agrupacion.getAgrupacion().size(); i++)
			areaContenido.add(new AreaDelContenido(tama�oAltoPanel
					/ numeroFilas, tama�oAnchoPanel / numeroFilas, agrupacion
					.getAgrupacion().get(i), this, new Point(
					(tama�oAltoPanel * i), (tama�oAnchoPanel * i))));

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
		this.a�adirAreas((Grupo) agrupacion);
		this.dibujar();

	}

	/**
	 * Metodo que dibuja el lienzo o panel del tama�o indicado por el usuario.
	 * 
	 * @return
	 */
	public String dibujar() {
		String cadena = "";
		cadena += "Tama�o Panel : " + tama�oAltoPanel + ":" + tama�oAnchoPanel
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
