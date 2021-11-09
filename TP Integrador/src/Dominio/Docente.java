package Dominio;

public class Docente {
	private int legajo;
	private String dni;	
	private String nombre;
	private String apellido;
	private String fechanacimiento;
	private String direccion;
	private String localidad;
	private String nacionalidad;
	private String email;
	private String telefono;
	private static int cont=9999;
	
	public Docente() {
		
	}

	public Docente( String dni, String nombre, String apellido, String fechanacimiento, String direccion,
			String localidad, String nacionalidad, String email, String telefono) {
		super();		
		this.legajo = devuelveProximoLegajo();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.telefono = telefono;
	}
	
	public static int devuelveProximoLegajo() {
		return cont++;

		}


	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
	
}
