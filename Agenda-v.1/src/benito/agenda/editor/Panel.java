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
	private int tama�oAltoEditor;
	private int tama�oAnchoEditor;
	private Agenda agenda;

	public Panel() {

	}

	public Panel(int tama�oAltoEditor, int tama�oANchoEditor, Agenda agenda)
			throws CloneNotSupportedException {
		this.tama�oAltoEditor = tama�oAltoEditor;
		this.tama�oAnchoEditor = tama�oANchoEditor;
		this.agenda = agenda;
		this.cambiarPantalla(agenda.getAgrupacion(), agenda.getAgrupacion()
				.getNombre());
	}

	public int getTama�oAltoEditor() {
		return tama�oAltoEditor;
	}

	public void setTama�oAltoEditor(int tama�oAltoEditor) {
		this.tama�oAltoEditor = tama�oAltoEditor;
	}

	public int getTama�oAnchoEditor() {
		return tama�oAnchoEditor;
	}

	public void setTama�oAnchoEditor(int tama�oAnchoEditor) {
		this.tama�oAnchoEditor = tama�oAnchoEditor;
	}

	public void a�adirPizarras(Grupo agrupacion, int ancho, int alto) {
		
		for (int i = 0; i < agrupacion.getAgrupacion().size(); i++)
			pizarras.add(new AreaDelContenido((tama�oAnchoEditor * i) + ancho,
					(tama�oAnchoEditor * i) + alto, agrupacion.getAgrupacion()
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
		int ancho = tama�oAnchoEditor / TRES;
		int alto = ancho;
		Agrupacion nueva = agenda.pasarSiguiente(nombre);
		this.a�adirPizarras((Grupo) nueva, ancho, alto);

	}

	private void borrarPizarras() {
		for(int i= 0; i< pizarras.size();i++)
			this.borrarPizarra(pizarras.get(i));
		
	}

	public void dibujar() {
		System.out.println("Tama�o Panel : " + tama�oAltoEditor + ":"
				+ tama�oAnchoEditor);
		for (AreaDelContenido areaDelContenido : pizarras) {
			areaDelContenido.dibujar();
		}
	}
}
