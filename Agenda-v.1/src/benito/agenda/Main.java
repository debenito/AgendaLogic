package benito.agenda;

import java.io.IOException;

import benito.agenda.editor.Panel;

public class Main {

	public static void main(String[] args) throws IOException, CloneNotSupportedException {

	Agenda a = new Agenda();
	a.interpretar("FicheroRest.txt");
	Panel p = new Panel(100,200,a);
	p.dibujar();
	p.clickon(10, 10);
	}

}
