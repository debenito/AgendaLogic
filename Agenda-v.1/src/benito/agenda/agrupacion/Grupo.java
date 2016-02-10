package benito.agenda.agrupacion;

import java.util.ArrayList;

public class Grupo extends Agrupacion{
	private ArrayList<Agrupacion> agrupacion = new ArrayList<>();	
	String nuevo = "";
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
	
	public void add(Agrupacion o) {
		agrupacion.add(o);
		
	}

	public void remove(Agrupacion o) {
		agrupacion.remove(o);
		
	}

	public String ver() {
		 nuevo +="Imagen Grupo :"+ Imagen + "|Nombre_Grupo :"+ Nombre_Grupo+"\n";
			for (Agrupacion agrupacion2 : agrupacion) {
				nuevo += agrupacion2.ver();
				
			}
			return nuevo;
		
	}
	public ArrayList<Agrupacion> getAgrupacion() {
		return agrupacion;
	}
	@Override
	public String clickOn() {
		
		return getAgrupacion().toString();
	}
	
	
}
