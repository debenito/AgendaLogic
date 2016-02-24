package junta.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import junta.agenda.Agenda;
import junta.agenda.agrupacion.Grupo;
import junta.agenda.editor.ContenedorContacto;
import junta.agenda.editor.ContenedorGrupo;
import junta.agenda.editor.Panel;

import org.junit.Before;
import org.junit.Test;

public class TestPantalla {

	Agenda agenda;
	Panel p;
	ContenedorGrupo GrupoReins;
	ContenedorGrupo Favoritos;
	ContenedorContacto Leo;
	ContenedorContacto Marta;
	ContenedorGrupo Asede;
	Grupo reins;

	@Before
	public void test() throws IOException {
		TestAgenda test = new TestAgenda();
		agenda = test.cargardatos();
		p = new Panel(600, 600, agenda);
		GrupoReins = (ContenedorGrupo) p.getArea(0).getContenedor();
		Favoritos = (ContenedorGrupo) p.getArea(1).getContenedor();
		// fail("Not yet implemented");
	}

	@Test
	public void PanelPrincipal() {
		assertEquals(p.getArea(0).getContenedor(), GrupoReins);
		assertEquals(p.getArea(1).getContenedor(), Favoritos);
		assertEquals(p.getArea(0).dibujar(),
				GrupoReins.dibujar(agenda.verGrupos().get(0)));
		assertEquals(p.getArea(1).dibujar(),
				Favoritos.dibujar(agenda.verGrupos().get(1)));
		assertEquals(p.getAgenda(), agenda);
	}

	@Test
	public void ClickOnPanelPrincipal() {
		p.clickon(10, 10);
		Leo = (ContenedorContacto) p.getArea(0).getContenedor();
		Marta = (ContenedorContacto) p.getArea(1).getContenedor();
		Asede = (ContenedorGrupo) p.getArea(2).getContenedor();
		reins = (Grupo) agenda.verGrupos().get(0);
		assertEquals(p.getArea(0).getContenedor(), Leo);
		assertEquals(p.getArea(1).getContenedor(), Marta);
		assertEquals(p.getArea(0).dibujar(),
				Leo.dibujar(reins.getAgrupacion().get(0)));
		assertEquals(p.getArea(1).dibujar(),
				Marta.dibujar(reins.getAgrupacion().get(1)));
		assertEquals(p.getArea(2).dibujar(),
				Asede.dibujar(reins.getAgrupacion().get(2)));
		assertEquals(p.getAgenda(), agenda);
		ClickOnPanelSecundario();
	}

	public void ClickOnPanelSecundario() {
		p.clickon(100, 200);
		Leo = (ContenedorContacto) p.getArea(0).getContenedor();
		assertEquals(p.getArea(0).getContenedor(), Leo);
		assertEquals(p.getArea(1).getContenedor(), Marta);
		assertEquals(p.getArea(2).getContenedor(), Asede);
	}

}
