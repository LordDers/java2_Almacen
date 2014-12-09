public class Cliente {

	//propiedades

	private String nombre;
	private String apellidos;
	private String DNI;
	private Direccion direccion;
	private Double num_socio;
	private Double dto;

	//métodos getter y setter
	public void setNombre (String nombre) {

		this.nombre = nombre;
	}

	public String getNombre () {

		return nombre;
	}

	public void setApellidos (String apellidos) {

		this.apellidos = apellidos;
	}

	public String getApellidos () {

		return apellidos;
	}

	public void setDni (String dni) {

		this.DNI = dni;
	}

	public String getDni () {

		return DNI;
	}

	public void setDireccion (Direccion direccion) {

		this.direccion = direccion;
	}

	public Direccion getDireccion () {

		return direccion;
	}

	public void setNumSocio (Double socio) {

		this.num_socio = socio;
	}

	public Double getNumSocio () {

		return num_socio;
	}

	public void setDescuento (Double descuento) {

		this.dto = descuento;
	}

	public Double getDescuento () {

		return dto;
	}
}