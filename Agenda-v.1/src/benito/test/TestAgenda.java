package benito.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import benito.agenda.Agenda;
import benito.agenda.agrupacion.Contacto;
import benito.agenda.agrupacion.Grupo;

public class TestAgenda {
	
	Grupo grupoParlamentario = new Grupo("RXN0YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h", "Grupo Parlamentario");
	Agenda agenda = new Agenda(grupoParlamentario);
	Grupo Reins = new Grupo("RXN0YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h","Grupo Reins");
	Grupo asociacion = new Grupo("RXN0YSBlcyBsYSBub3RhIGRlIGVOFnaW5h","Asociacion Asede");
	Grupo representantes =new Grupo("YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h","Representantes");
	Grupo Favoritos = new Grupo ("BsYSBub3RhIGRlIGVzdGEgcOFnaW5h","Favoritos");
	Contacto Leo = new Contacto("RXN0YSBlcyBsYSIGRlIGVzdGEgcOFnaW5h","Leo","Martinez","523123879");
	@Before
	public void test() {
	//	fail("Not yet implemented");
		
		grupoParlamentario.add(Reins);
		Reins.add(asociacion);
		Reins.add(Leo);
		Reins.add(new Contacto("SBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h","Marta","Suarez","123432567"));
		asociacion.add(new Contacto("YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h", "Juanma", "Rodriguez", "345462967"));
		asociacion.add(representantes);
		representantes.add(new Contacto("XN0YSBlcyBsYSRhIGRlIGVzdGEgcOFnaW5h", "Presidente", "", "123432476"));
		representantes.add(new Contacto("RBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h", "Vicepresidente", "", "123452158"));
		Favoritos.add(new Grupo("0YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h", "Asociacion Reiquinats"));
		Favoritos.add(new Contacto("N0YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h", "Presidente Parlamento", "", "124322345"));
	//	agenda.añadirContactos(grupoParlamentario);
		agenda.añadirContactos(Favoritos);
		
		//RXN0YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h:0: Grupo Parlamentario;
		//RXN0YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h:Grupo Parlamentario: Grupo Reins;	
		//RXN0YSBlcyBsYSBub3RhIGRlIGVOFnaW5h:Grupo Reins:Asociacion Asede;
		//RXN0YSBlcyBsYSIGRlIGVzdGEgcOFnaW5h:Grupo Reins:Leo:523123879;
		//SBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h:Grupo Reins:Marta:123432567;
		//YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h:Asociacion Asede:Representantes;
		//YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h:Asociacion Asede:Juanma:345462967;
		//XN0YSBlcyBsYSRhIGRlIGVzdGEgcOFnaW5h:Representante:Presidente:123432476;
		//RBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h:Representantes:Vicepresidente:123452158
		//BsYSBub3RhIGRlIGVzdGEgcOFnaW5h:Grupo Parlamentario:Favoritos;
		//0YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h:Favoritos:Asociacion Reiquinats;
		//N0YSBlcyBsYSBub3RhIGRlIGVzdGEgcOFnaW5h:Favoritos:Presidente Parlamento:124322345;
	
	}
	
	@Test
	public void AgendaLista(){
	agenda.verContactos();
	assertEquals(agenda.verGrupos().size(),2);
	assertNotEquals(grupoParlamentario.getAgrupacion().size(),1);
	assertEquals(Reins.getAgrupacion().size(), 3);
	assertEquals(asociacion.getAgrupacion().size(),2);
	assertEquals(representantes.getAgrupacion().size(),2);
	assertEquals(representantes.getAgrupacion().size(),2);
	}
	
	@Test
	public void GruposYContactos(){
		assertEquals(Reins.getAgrupacion().get(1),Leo);
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).getTelefono(),Leo.getTelefono());
		assertEquals(((Contacto)Reins.getAgrupacion().get(2)).getNombre(),"Marta");
		assertEquals(((Contacto)Reins.getAgrupacion().get(2)).getApellidos(),"Suarez");
		assertEquals(Reins.getAgrupacion().get(0), asociacion);
		assertNotEquals(grupoParlamentario.getAgrupacion().get(0),null);
		assertNotEquals(asociacion.getAgrupacion().get(0),representantes);
		assertEquals(((Contacto)representantes.getAgrupacion().get(1)).getApellidos(), "");
		assertNotEquals(((Contacto)representantes.getAgrupacion().get(1)).getApellidos(), null);
	}
	
	@Test
	public void LLamadas(){
		
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).llamar(),"Llamando al telefono"+ Leo.getTelefono());
		assertEquals(((Contacto)Reins.getAgrupacion().get(2)).llamar(),"Llamando al telefono"+ "123432567");
		assertNotEquals(((Contacto)Reins.getAgrupacion().get(2)).llamar(),"Llamando al telefono"+ Leo.getTelefono());
		assertNotEquals(((Contacto)representantes.getAgrupacion().get(1)).llamar(),"Llamando al telefono"+ Leo.getTelefono());
		assertEquals(((Contacto)representantes.getAgrupacion().get(1)).llamar(),"Llamando al telefono"+ "123452158");

	}
	
	@Test
	public void ComprobacionNombre(){
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).getNombre(),"Leo");
		assertEquals(((Contacto)Reins.getAgrupacion().get(2)).getNombre(),"Marta");
		assertNotEquals(((Contacto)Reins.getAgrupacion().get(2)).getNombre(),"Juanma");
		assertNotEquals(((Contacto)representantes.getAgrupacion().get(1)).getNombre(),"Suarez");
		assertEquals(((Contacto)representantes.getAgrupacion().get(1)).getNombre(),"Vicepresidente");
		assertNotEquals(((Grupo)agenda.verGrupos().get(0)).getNombre_Grupo(),grupoParlamentario.getNombre_Grupo());
		assertEquals(((Grupo)Reins.getAgrupacion().get(0)).getNombre_Grupo(), "Asociacion Asede");
	}
	
	@Test
	public void ComprobacionApellidos(){
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).getApellidos(),"Martinez");
		assertEquals(((Contacto)Reins.getAgrupacion().get(2)).getApellidos(),"Suarez");
		assertNotEquals(((Contacto)Reins.getAgrupacion().get(2)).getApellidos(),"Juanma");
		assertNotEquals(((Contacto)representantes.getAgrupacion().get(1)).getApellidos(),"Suarez");
		assertEquals(((Contacto)representantes.getAgrupacion().get(1)).getApellidos(),"");
	}
	@Test
	public void removerContactos(){
		agenda.removeContactos(grupoParlamentario);
		assertEquals(agenda.verGrupos().size(), 2);
		assertNotEquals(agenda.verGrupos().get(0),Favoritos);
		Reins.remove(Reins.getAgrupacion().get(2));
		assertNotEquals(1,Reins.getAgrupacion().size());
		assertEquals(Reins.getAgrupacion().get(1),Leo);
		Reins.remove(Reins.getAgrupacion().get(0));
		assertEquals(1,Reins.getAgrupacion().size());
		assertEquals(Reins.getAgrupacion().get(0),Leo);
		agenda.removeContactos(Favoritos);
		agenda.removeContactos(Reins);
		assertEquals(true, agenda.verGrupos().isEmpty());
		
	}
	

}
