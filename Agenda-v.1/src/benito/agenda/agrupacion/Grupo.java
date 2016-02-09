package benito.agenda.agrupacion;

import java.util.ArrayList;

public class Grupo extends Agrupacion{
	private ArrayList<Agrupacion> agrupacion = new ArrayList<>();	
	public Grupo(String imagen, String nombre_Grupo) {
		super();
		Imagen = imagen;
		Nombre_Grupo = nombre_Grupo;
	}
	private String Imagen;
	private String Nombre_Grupo;
	

	
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	public String getNombre_Grupo() {
		return Nombre_Grupo;
	}
	public void setNombre_Grupo(String nombre_Grupo) {
		Nombre_Grupo = nombre_Grupo;
	}
	@Override
	public void add(Agrupacion o) {
		agrupacion.add(o);
		
	}
	@Override
	public void remove(Agrupacion o) {
		agrupacion.remove(o);
		
	}
	@Override
	public void ver() {
		System.out.println("Imagen Grupo :"+ Imagen + "|Nombre_Grupo :"+ Nombre_Grupo);
			for (Agrupacion agrupacion2 : agrupacion) {
				agrupacion2.ver();
				
			}
		
	}
	public ArrayList<Agrupacion> getAgrupacion() {
		return agrupacion;
	}
	
	
}
