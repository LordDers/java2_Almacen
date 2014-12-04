public class Contacto {

	//añadid las propiedades convenientes
	private String DNI;
	private String nombre;
	private String apellido;
	private int edad;
	private String nacionalidad;
	private String fecha_nacimiento;
	private String sexo;
	private int telefono;
	private String email;

	//métodos getter y setter
	public void setDni (String dni) {

		this.DNI = dni;
	}

	public String getDni () {

		return DNI;
	}

	public void setNombre (String nombre) {

		this.nombre = nombre;
	}

	public String getNombre () {

		return nombre;
	}

	public void setApellido (String apellido) {

		this.apellido = apellido;
	}

	public String getApellido () {

		return apellido;
	}

	public void setEdad (int edad) {

		this.edad = edad;
	}

	public int getEdad () {

		return edad;
	}

	public void setNacionalidad (String nacionalidad) {

		this.nacionalidad = nacionalidad;
	}

	public String getNacionalidad () {

		return nacionalidad;
	}

	public void setNacimiento (String f_nacimiento) {

		this.fecha_nacimiento = f_nacimiento;
	}

	public String getNacimiento () {

		return fecha_nacimiento;
	}

	public void setSexo (String sexo) {

		this.sexo = sexo;
	}

	public String getSexo () {

		return sexo;
	}

	public void setTelefono (int tlf) {

		this.telefono = tlf;
	}

	public int getTelefono () {

		return telefono;
	}

	public void setEmail (String email) {

		this.email = email;
	}

	public String getEmail () {

		return email;
	}
}
