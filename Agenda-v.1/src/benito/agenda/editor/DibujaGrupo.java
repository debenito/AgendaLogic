package benito.agenda.editor;

import java.awt.Point;

import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Grupo;

public class DibujaGrupo implements Contenedor {
	private int alto;
	private int ancho;
	private Point corner;
	private Panel editor;

	public DibujaGrupo(int alto, int ancho, Point corner, Panel editor) {
		this.corner = corner;
		this.alto = alto;
		this.ancho = ancho;
		this.editor = editor;
	}

	@Override
	public void execute(AreaDelContenido p) {
		p.setAlto(alto);
		p.setAncho(ancho);
	}

	@Override
	public void clickon(int x, int y, Agrupacion e)  {
		if (contiene(x,y)){
			editor.cambiarPantalla(e,e.getNombre());
		}
	}

	private boolean contiene(int x, int y){
		return (corner.x <= x && x <= corner.x + ancho) 
		&& (corner.y <= y && y <= corner.y + alto);
	}

	@Override
	public void dibujar(Agrupacion a) {
		System.out.println("Tamaño Pizarra:"+alto +" "+ ancho);
		System.out.println("Posicion Esquina:"+corner.x +" "+ corner.y);
		System.out.println("Datos del Grupo");
		System.out.println("Nombre:"+ a.getNombre());
		System.out.println("Imagen"+ ((Grupo)a).getImagen());
		System.out.println("==============================");

	
	}

	@Override
	public Contenedor createContenedor() {
		// TODO Auto-generated method stub
		return new DibujaGrupo(alto, ancho, corner,editor);
	}
}
