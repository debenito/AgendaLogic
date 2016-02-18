package benito.agenda.editor;

import java.awt.Point;

import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Grupo;

public class DibujaGrupo implements Contenedor {
	private int alto;
	private int ancho;
	private Point corner;
	private Panel editor;

	public DibujaGrupo(int alto, int ancho, Point corner) {
		
		this.corner= corner;
		this.alto = Math.abs(corner.x - alto);
		this.ancho = Math.abs(corner.y - ancho);
		this.editor = editor.getEditor();
	}

	@Override
	public void execute(AreaDelContenido p) {
		p.setAlto(alto);
		p.setAncho(ancho);
	}

	@Override
	public void clickon(int x, int y, Agrupacion e) {
		if (contiene(x,y)){
			editor.cambiarPantalla(e);
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
		System.out.println("Datos del contacto");
		System.out.println("==============================");
		System.out.println("Nombre:"+ a.getNombre());
		System.out.println("Imagen"+ ((Grupo)a).getImagen());
	
	}

	@Override
	public Contenedor createContenedor() {
		// TODO Auto-generated method stub
		return new DibujaGrupo(alto, ancho, corner);
	}
}
