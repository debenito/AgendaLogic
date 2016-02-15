package benito.agenda.agrupacion;

public abstract class Agrupacion {
	private String nombre;
	public Agrupacion (String nombre){
		this.nombre = nombre;
	}
	public abstract String ver();
	protected abstract String clickOn();
	public String getNombre() {
		return nombre;
	}
	
}
