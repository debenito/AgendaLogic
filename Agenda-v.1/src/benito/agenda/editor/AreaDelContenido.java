package benito.agenda.editor;

import java.awt.Point;

import benito.agenda.agrupacion.Agrupacion;

public class AreaDelContenido {
	private int alto;
	private int ancho;
	private Contenedor c ;
	private Agrupacion a;
	public AreaDelContenido(int ancho, int alto, Agrupacion a) {
		this.alto = alto;
		this.ancho = ancho;
		this.a= a;
		
		setC(new DibujaGrupo(alto, ancho, new Point(0,0)));;

	}

	public Contenedor getC() {
		return c;
	}

	public void setC(Contenedor c) {
		this.c = c;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public void pinchar (int x , int y ){
		c.clickon(x, y,a);
	}
	public void dibujar(){
		c.dibujar(a);
	}
	
}
