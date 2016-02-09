package benito.agenda.agrupacion;

public class Contacto extends Agrupacion {
	String Imagen;
	String Nombre;
	String Apellidos;
	String Telefono;
	
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
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

	public String llamar(){
		return "Llamando al telefono"+ Telefono;
	}
	@Override
	public void add(Agrupacion o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(Agrupacion o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ver() {
		System.out.println("Imagen :"+ Imagen + "|Nombre y Apellidos : "+ Nombre + "&"+ Apellidos+"|Telefono :"+Telefono);
;
	}
	public Contacto(String imagen, String nombre, String apellidos,
			String telefono) {
		super();
		Imagen = imagen;
		Nombre = nombre;
		Apellidos = apellidos;
		Telefono = telefono;
	}
	
	
	
}
