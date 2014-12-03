public class Distribuidor {

	//propiedades
	private String nombre;
	private String CIF;
	private Direccion direccion;
	private Contacto personaContacto;

	//metodos getter y setter
	public void setNombre (String nombre) {

		this.nombre = nombre;
	}

	public String getNombre () {

		return nombre;
	}

	public void setCif (String cif) {

		this.CIF = cif;
	}

	public String getCif () {

		return CIF;
	}

	public void setDireccion (Direccion direccion) {

		this.direccion = direccion;
	}

	public Direccion getDireccion () {

		return direccion;
	}

	public void setPersonaContacto (Contacto contactopersona) {

		this.personaContacto = contactopersona;
	}

	public Contacto getPersonaContacto () {

		return personaContacto;
	}
}
