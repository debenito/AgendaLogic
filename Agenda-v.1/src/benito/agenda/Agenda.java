package benito.agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Contacto;
import benito.agenda.agrupacion.Grupo;

public class Agenda {

	private Agrupacion agrupacion;

	public Agenda(){
	this.agrupacion= new Grupo("0","0");
	}
	public Agenda(Agrupacion agrupacion) {
		this.agrupacion = agrupacion;
		
	}
	public void añadirContactos(Agrupacion o) {
		if (agrupacion instanceof Grupo)
			((Grupo) agrupacion).add(o);
	}

	public String verContactos() {
		return agrupacion.ver();

	}

	public void removeContactos(Agrupacion o) {
		if (agrupacion instanceof Grupo)
			((Grupo) agrupacion).remove(o);
	}

	public List<Agrupacion> verGrupos() {
		return ((Grupo) agrupacion).getAgrupacion();
	}

	public void interpretarLinea(String linea) {
		String partes[]= linea.split(":");
		Agrupacion nueva;

		if (partes.length== 3)
			nueva = new Grupo(partes[0], partes[2].replace(";", ""));
		else
			nueva =  new Contacto(partes[0], partes[2], partes[3], partes[4].replace(";", ""));
		if(agrupacion.getNombre().equals("0"))
			agrupacion = nueva;
		else
		((Grupo) agrupacion).añadirContactos(nueva , partes[1],0);
	}			

	
	public void interpretar(String nombreFichero) throws IOException  {
		BufferedReader read = null;
		String linea = null ;
		try {
			read = new BufferedReader(new FileReader("FicheroREST.txt"));
		
			while ((linea= read.readLine()) != null) {
			interpretarLinea(linea);
			}
		read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problemas en la carga del fichero");
		}
		
	}
}
