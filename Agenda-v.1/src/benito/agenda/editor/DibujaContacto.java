package benito.agenda.editor;

import java.awt.Point;

import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Contacto;

public class DibujaContacto implements Contenedor{
	private int alto;
	private int ancho;
	private Point corner;

	public DibujaContacto(int alto, int ancho, Point corner) {
		
		this.corner=corner;
		this.alto = alto;
		this.ancho = ancho;
	}

	@Override
	public void execute(AreaDelContenido p) {
		p.setAlto(corner.x);
		p.setAncho(corner.y);
	}

	@Override
	public void clickon(int x, int y, Agrupacion e) {
		if (contiene(x,y))
			llamar(e);

	}

	private void llamar(Agrupacion e) {
System.out.println("LLamado al telefono"+((Contacto)e).getTelefono());		
	}

	private boolean contiene(int x, int y){
		return (corner.x <= x && x <= corner.x + ancho) 
		&& (corner.y <= y && y <= corner.y + alto);
	}


	@Override
	public void dibujar(Agrupacion a) {
		System.out.println("Tamaño Pizarra:"+alto +" "+ ancho);
		System.out.println("Datos del contacto");
		System.out.println("Nombre:"+ a.getNombre());
		System.out.println("Imagen"+ ((Contacto)a).getImagen());
		System.out.println("Apellidos"+ ((Contacto)a).getApellidos());
		System.out.println("Imagen"+ ((Contacto)a).getTelefono());
		System.out.println("==============================");

	}

	@Override
	public Contenedor createContenedor() {
		// TODO Auto-generated method stub
		return new DibujaContacto(alto, ancho, corner);
	}
}
