package benito.agenda.editor;

import java.awt.Point;

import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Grupo;

public class AreaDelContenido {
	private int alto;
	private int ancho;
	private Contenedor c ;
	private Agrupacion a;
	private Panel panel;
	private Point point;
	public AreaDelContenido(int ancho, int alto, Agrupacion a, Panel panel,Point point) {
		this.alto = alto;
		this.ancho = ancho;
		this.a= a;
		this.panel = panel;
		this.point=point;
		setC(c);
		

	}

	public Agrupacion getA() {
		return a;
	}

	public Contenedor getC() {
		return c;
	}

	public void setC(Contenedor c) {
		if(a instanceof Grupo)
			this.c =new DibujaGrupo(alto, ancho, point,panel);
		else
			this.c =new DibujaContacto(alto, ancho, point);

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
	
	public void pinchar (int x , int y ) {
		c.clickon(x, y,a);
	}
	public void dibujar(){
		c.dibujar(a);
	}
	
}
