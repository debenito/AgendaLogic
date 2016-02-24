package junta.agenda;

import java.io.IOException;

import junta.agenda.editor.Panel;

public class Main {

	public static void main(String[] args) throws IOException {

		Agenda a = new Agenda();
		a.interpretar("FicheroRest.txt");
		Panel p = new Panel(100, 200, a);
		System.out.println(p.dibujar());
		System.out.println("---------NUEVA PANTALLA--------");
		p.clickon(10, 10);
		System.out.println(p.dibujar());
		System.out.println("---------NUEVA PANTALLA--------");
		p.clickon(100, 200);
		System.out.println(p.dibujar());
	}

}
