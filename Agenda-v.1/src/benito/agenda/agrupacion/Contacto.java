package benito.agenda.agrupacion;

public class Contacto extends Agrupacion {
	String Imagen;
	String Apellidos;
	String Telefono;
	
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	private String llamar(){
		return "Llamando al telefono"+ Telefono;
	}

	@Override
	public String ver() {
		return "Imagen :"+ Imagen + "|Nombre y Apellidos : "+ super.getNombre() + "&"+ Apellidos+"|Telefono :"+Telefono +"\n";

	}
	public Contacto(String imagen, String nombre, String apellidos,
			String telefono) {
		super(nombre);
		Imagen = imagen;
		Apellidos = apellidos;
		Telefono = telefono;
	}
	@Override
	public String clickOn() {
		return llamar();
	}
	
	
	
}
