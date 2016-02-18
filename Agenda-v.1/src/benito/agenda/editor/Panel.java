package benito.agenda.editor;

import java.util.ArrayList;
import java.util.List;

import benito.agenda.Agenda;
import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Grupo;

public class Panel {
	 public static final int TRES =3;  
	List<AreaDelContenido> pizarras = new ArrayList<AreaDelContenido>();
	private Panel panel = new Panel();
	private int tama�oAltoEditor;
	private int tama�oAnchoEditor;
	private Agenda a;
	public Panel(){
		
	}
	public Panel(int tama�oAltoEditor, int tama�oANchoEditor, Agenda a) throws CloneNotSupportedException{
		this.tama�oAltoEditor=tama�oAltoEditor;
		this.tama�oAnchoEditor = tama�oANchoEditor;
		this.a= a;
		setPanel(this);
	}
	
	private void setPanel(Panel panel2) {
	this.panel= panel2;
		
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

	public void a�adirPizarras(AreaDelContenido p){
		pizarras.add(p);
	}
	public void borrarPizarra(AreaDelContenido p){
		pizarras.remove(p);
	}
	public AreaDelContenido getPizarra(int i){
		return pizarras.get(i);
	}
	public void clickon(int x, int y) {
	for (AreaDelContenido pizarra : pizarras) {
		pizarra.pinchar(x, y);
		}
	}
	public Panel getEditor(){
		return panel;
	}
	public void cambiarPantalla(Agrupacion agrupacion) {
		int tama�oAgrupacion =((Grupo)agrupacion).getAgrupacion().size();
		int ancho =tama�oAnchoEditor/TRES;
		int alto = ancho;
		AreaDelContenido p = new AreaDelContenido(ancho,alto,a.buscarAgrupacion(agrupacion.getNombre()));
		this.a�adirPizarras(p);
		
	}
	
	public void dibujar(){
		System.out.println("Tama�o Panel : "+ tama�oAltoEditor + "" + tama�oAnchoEditor);
		for (AreaDelContenido areaDelContenido : pizarras) {
			areaDelContenido.dibujar();
		}
	}
}
