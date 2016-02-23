package benito.agenda.editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import benito.agenda.Agenda;
import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Grupo;

public class Panel {
	public static final int TRES = 3;
	List<AreaDelContenido> pizarras = new ArrayList<AreaDelContenido>();
	private int tamañoAltoEditor;
	private int tamañoAnchoEditor;
	private Agenda agenda;

	public Panel() {

	}

	public Panel(int tamañoAltoEditor, int tamañoANchoEditor, Agenda agenda)
			throws CloneNotSupportedException {
		this.tamañoAltoEditor = tamañoAltoEditor;
		this.tamañoAnchoEditor = tamañoANchoEditor;
		this.agenda = agenda;
		this.cambiarPantalla(agenda.getAgrupacion(), agenda.getAgrupacion()
				.getNombre());
	}

	public int getTamañoAltoEditor() {
		return tamañoAltoEditor;
	}

	public void setTamañoAltoEditor(int tamañoAltoEditor) {
		this.tamañoAltoEditor = tamañoAltoEditor;
	}

	public int getTamañoAnchoEditor() {
		return tamañoAnchoEditor;
	}

	public void setTamañoAnchoEditor(int tamañoAnchoEditor) {
		this.tamañoAnchoEditor = tamañoAnchoEditor;
	}

	public void añadirPizarras(Grupo agrupacion, int ancho, int alto) {
		
		for (int i = 0; i < agrupacion.getAgrupacion().size(); i++)
			pizarras.add(new AreaDelContenido((tamañoAnchoEditor * i) + ancho,
					(tamañoAnchoEditor * i) + alto, agrupacion.getAgrupacion()
							.get(i), this,new Point( i * ancho,i*alto)));

	}

	public void borrarPizarra(AreaDelContenido p) {
		pizarras.remove(p);
	}

	public AreaDelContenido getPizarra(int i) {
		return pizarras.get(i);
	}

	public void clickon(int x, int y) {
		for (AreaDelContenido pizarra : pizarras) {
			pizarra.pinchar(x, y);
		}
	}

	public void cambiarPantalla(Agrupacion agrupacion, String nombre) {
	borrarPizarras();
		int ancho = tamañoAnchoEditor / TRES;
		int alto = ancho;
		Agrupacion nueva = agenda.pasarSiguiente(nombre);
		this.añadirPizarras((Grupo) nueva, ancho, alto);

	}

	private void borrarPizarras() {
		for(int i= 0; i< pizarras.size();i++)
			this.borrarPizarra(pizarras.get(i));
		
	}

	public void dibujar() {
		System.out.println("Tamaño Panel : " + tamañoAltoEditor + ":"
				+ tamañoAnchoEditor);
		for (AreaDelContenido areaDelContenido : pizarras) {
			areaDelContenido.dibujar();
		}
	}
}
