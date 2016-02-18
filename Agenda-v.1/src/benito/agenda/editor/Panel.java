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
	private int tamañoAltoEditor;
	private int tamañoAnchoEditor;
	private Agenda a;
	public Panel(){
		
	}
	public Panel(int tamañoAltoEditor, int tamañoANchoEditor, Agenda a) throws CloneNotSupportedException{
		this.tamañoAltoEditor=tamañoAltoEditor;
		this.tamañoAnchoEditor = tamañoANchoEditor;
		this.a= a;
		setPanel(this);
	}
	
	private void setPanel(Panel panel2) {
	this.panel= panel2;
		
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

	public void añadirPizarras(AreaDelContenido p){
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
		int tamañoAgrupacion =((Grupo)agrupacion).getAgrupacion().size();
		int ancho =tamañoAnchoEditor/TRES;
		int alto = ancho;
		AreaDelContenido p = new AreaDelContenido(ancho,alto,a.buscarAgrupacion(agrupacion.getNombre()));
		this.añadirPizarras(p);
		
	}
	
	public void dibujar(){
		System.out.println("Tamaño Panel : "+ tamañoAltoEditor + "" + tamañoAnchoEditor);
		for (AreaDelContenido areaDelContenido : pizarras) {
			areaDelContenido.dibujar();
		}
	}
}
