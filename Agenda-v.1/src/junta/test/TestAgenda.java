package junta.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import junta.agenda.Agenda;
import junta.agenda.agrupacion.Contacto;
import junta.agenda.agrupacion.Grupo;

import org.junit.Before;
import org.junit.Test;

public class TestAgenda {
	
	Agenda agenda;
	Grupo Reins ;
	Grupo asociacion;
	Grupo representantes;
	Grupo Favoritos;
	Contacto Leo ;
	@Before
	public void test() throws IOException {
		
		agenda = cargardatos();
	//	fail("Not yet implemented");
	}
		

	public Agenda cargardatos() throws IOException{
		agenda = new Agenda();
		agenda.interpretar("FicheroREST.txt");
		Reins = ((Grupo)agenda.verGrupos().get(0));
		asociacion = ((Grupo)Reins.getAgrupacion().get(2));
		representantes = ((Grupo)asociacion.getAgrupacion().get(1));
		Favoritos = ((Grupo)agenda.verGrupos().get(1));
		Leo = (Contacto)Reins.getAgrupacion().get(0);
		return agenda;
	}
	@Test
	public void AgendaLista(){
	//agenda.verContactos();
	assertEquals(agenda.verGrupos().size(),2);
	assertEquals(Reins.getAgrupacion().size(), 3);
	assertEquals(asociacion.getAgrupacion().size(),2);
	assertEquals(representantes.getAgrupacion().size(),2);
	assertEquals(representantes.getAgrupacion().size(),2);
	}
	
	@Test
	public void GruposYContactos(){
		assertEquals(Reins.getAgrupacion().get(0),Leo);
		assertEquals(((Contacto)Reins.getAgrupacion().get(0)).getTelefono(),Leo.getTelefono());
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).getNombre(),"Marta");
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).getApellidos(),"Suarez");
		assertEquals(Reins.getAgrupacion().get(2), asociacion);
		assertNotEquals(asociacion.getAgrupacion().get(0),representantes);
		assertEquals(((Contacto)representantes.getAgrupacion().get(1)).getApellidos(), "");
		assertNotEquals(((Contacto)representantes.getAgrupacion().get(1)).getApellidos(), null);
	}
	
	@Test
	public void LLamadas(){
		
		assertEquals(((Contacto)Reins.getAgrupacion().get(0)).getTelefono(), Leo.getTelefono());
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).getTelefono(), "123432567");
		assertNotEquals(((Contacto)Reins.getAgrupacion().get(1)).getTelefono(), Leo.getTelefono());
		assertNotEquals(((Contacto)representantes.getAgrupacion().get(1)).getTelefono(), Leo.getTelefono());
		assertEquals(((Contacto)representantes.getAgrupacion().get(1)).getTelefono(), "123452158");

	}
	
	@Test
	public void ComprobacionNombre(){
		assertEquals(((Contacto)Reins.getAgrupacion().get(0)).getNombre(),"Leo");
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).getNombre(),"Marta");
		assertNotEquals(((Grupo)asociacion.getAgrupacion().get(1)).getNombre(),"Juanma");
		assertNotEquals(((Contacto)representantes.getAgrupacion().get(1)).getNombre(),"Suarez");
		assertEquals(((Contacto)representantes.getAgrupacion().get(1)).getNombre(),"Vicepresidente");
		assertEquals(((Grupo)Reins.getAgrupacion().get(2)).getNombre(), "Asociacion Asede");
	}
	
	@Test
	public void ComprobacionApellidos(){
		assertEquals(((Contacto)Reins.getAgrupacion().get(0)).getApellidos(),"Martinez");
		assertEquals(((Contacto)Reins.getAgrupacion().get(1)).getApellidos(),"Suarez");
		assertNotEquals(((Contacto)Reins.getAgrupacion().get(1)).getApellidos(),"Juanma");
		assertNotEquals(((Contacto)representantes.getAgrupacion().get(1)).getApellidos(),"Suarez");
		assertEquals(((Contacto)representantes.getAgrupacion().get(1)).getApellidos(),"");
	}
	@Test
	public void borrarrContactos(){
		assertEquals(agenda.verGrupos().size(), 2);
		assertNotEquals(agenda.verGrupos().get(0),Favoritos);
		Reins.borrar(Reins.getAgrupacion().get(2));
		assertNotEquals(1,Reins.getAgrupacion().size());
		assertEquals(Reins.getAgrupacion().get(0),Leo);
		Reins.borrar(Reins.getAgrupacion().get(1));
		assertEquals(1,Reins.getAgrupacion().size());
		assertEquals(Reins.getAgrupacion().get(0),Leo);
		agenda.borrarContactos(Favoritos);
		agenda.borrarContactos(Reins);
		assertEquals(true, agenda.verGrupos().isEmpty());

	}
	
	@Test
	public void ComprobacionSalida() throws IOException{
	
		@SuppressWarnings("resource")
		BufferedReader read =new BufferedReader(new FileReader("FicheroSalida.txt"));
		String sCurrentLine = "" ;

		while (read.readLine() != null) {
			sCurrentLine += read.readLine()+"\n";
		}
		assertEquals(agenda.verContactos(),sCurrentLine);
	}
	

}
