package benito.agenda.agrupacion;

import java.util.ArrayList;

public class Grupo extends Agrupacion{
	private ArrayList<Agrupacion> agrupacion = new ArrayList<>();	
	private String nuevo = "";
	private String Imagen;

	public Grupo(String imagen, String nombre_Grupo) {
		super(nombre_Grupo);
		Imagen = imagen;
		
	}
		
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	
	
	
	public void add(Agrupacion o) {
		agrupacion.add(o);
		
	}

	public void remove(Agrupacion o) {
		agrupacion.remove(o);
		
	}

	public String ver() {
		 nuevo +="Imagen Grupo :"+ Imagen + "|Nombre_Grupo :"+ super.getNombre()+"\n";
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

	public void añadirContactos(Agrupacion nueva, String nombre,int profundidad) {
		if(nombre.equals(getNombre())){
			agrupacion.add(nueva);
		}else{
			for(int i = 0; i<agrupacion.size();i++)
			if(agrupacion.get(i) instanceof Grupo)
				((Grupo)agrupacion.get(i)).añadirContactos(nueva, nombre, profundidad +1);
		}
		

	}

	
	
}
