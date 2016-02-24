package junta.agenda.editor;

import java.awt.Point;

import junta.agenda.agrupacion.Agrupacion;
import junta.agenda.agrupacion.Grupo;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Clase el la que se va insertar como contenido los datos
 *          de un contacto o un grupo.
 */
public class AreaDelContenido {
	/**
	 * Parametros iniciales
	 */
	private int alto;
	private int ancho;
	private Contenedor contenedor;
	private Agrupacion agrupacion;
	private Panel panel;
	private Point point;

	/**
	 * Contructor con parametros iniciales
	 * 
	 * @param alto
	 * @param ancho
	 * @param agrupacion
	 * @param panel
	 * @param point
	 */
	public AreaDelContenido(int alto, int ancho, Agrupacion agrupacion,
			Panel panel, Point point) {
		this.alto = alto;
		this.ancho = ancho;
		this.agrupacion = agrupacion;
		this.panel = panel;
		this.point = point;
		setContendor(contenedor);

	}

	/**
	 * Retorngo de la agrupacion
	 * 
	 * @return agrupacion
	 */
	public Agrupacion getAgrupacion() {
		return agrupacion;
	}

	/**
	 * retorno del contenedor
	 * 
	 * @return contenedor
	 */
	public Contenedor getContenedor() {
		return contenedor;
	}

	/**
	 * Modificacion del contenedor
	 * 
	 * @param c
	 */
	public void setContendor(Contenedor c) {
		// Si la agrupacion es una instancia de grupo entonces se crea
		// un contenedor de Grupo sino se crea uno de Contacto
		if (agrupacion instanceof Grupo)
			this.contenedor = new ContenedorGrupo(alto, ancho, point, panel);
		else
			this.contenedor = new ContenedorContacto(alto, ancho, point);

	}

	/**
	 * Retorno del alto del area contendida
	 * 
	 * @return alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * Cambio del alto del area contenida
	 * 
	 * @param alto
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * Retorno del ancho del area contenida
	 * 
	 * @return ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Modificacion del ancho del area contenida
	 * 
	 * @param ancho
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * Accion de pulsacion realizada por el usuario
	 * 
	 * @param x
	 * @param y
	 */
	public void pinchar(int x, int y) {
		contenedor.clickon(x, y, agrupacion);
	}

	/**
	 * Accion que dibuja en el area contenida los datos provenientes del
	 * contenedor
	 * 
	 * @return
	 */
	public String dibujar() {
		return contenedor.dibujar(agrupacion);
	}

}
