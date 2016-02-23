package benito.agenda.editor;

import benito.agenda.agrupacion.Agrupacion;

public interface Contenedor {
	public void execute(AreaDelContenido p);
	public void dibujar(Agrupacion a);
	void clickon(int x, int y, Agrupacion e) ;
	Contenedor createContenedor();
}
