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
		if(agrupacion instanceof Grupo)
		((Grupo)agrupacion).add(o);
	}
	public String verContactos(){
		 return agrupacion.ver();
		 
	}
	public void removeContactos(Agrupacion o){
		if(agrupacion instanceof Grupo)
		((Grupo)agrupacion).remove(o);
	}
	
	public List<Agrupacion> verGrupos(){
		return ((Grupo)agrupacion).getAgrupacion();
	}
	
}
