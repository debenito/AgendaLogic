package benito.agenda.editor;

import benito.agenda.agrupacion.Agrupacion;

/**
 * 
 * @author Jose Antonio de Benito Suarez
 * @version v17/02/2016 Interfaz con metodos implementados por los tipos de
 *          contenedor existente
 */
public interface Contenedor {
	/**
	 * Modificacion del ancho y el ancho de la pantalla para el siguiente
	 * puntero
	 * 
	 * @param p
	 */
	public void execute(AreaDelContenido p);

	/**
	 * Accion para dibujar los componentes necesarios de cada tipo de contenedor
	 * 
	 * @param a
	 * @return
	 */
	public String dibujar(Agrupacion a);

	/**
	 * Accion de pulsacion dependiendo de si es un contacto llamara sino
	 * cambiara la pantalla
	 * 
	 * @param x
	 * @param y
	 * @param e
	 */
	void clickon(int x, int y, Agrupacion e);

	/**
	 * Crea un contendor del tipo que se le indique
	 * 
	 * @return contenedor nuevo
	 */
	Contenedor createContenedor();
}
