package benito.agenda;

import java.util.List;

import benito.agenda.agrupacion.Agrupacion;
import benito.agenda.agrupacion.Grupo;

public class Agenda {
	
	private Agrupacion agrupacion;
	public Agenda(Agrupacion agrupacion){
		this.agrupacion= agrupacion;
	}
	public void añadirContactos(Agrupacion o){
		agrupacion.add(o);
	}
	public void verContactos(){
		agrupacion.ver();
	}
	public void removeContactos(Agrupacion o){
		agrupacion.remove(o);
	}
	
	public List<Agrupacion> verGrupos(){
		return ((Grupo)agrupacion).getAgrupacion();
	}
	
}
