public class Direccion {

	//añadid las propiedades convenientes
	private String pais;
	private String provincia;
	private String ciudad;
	private String calle;
	private int piso;
	private char letra;
	private int codigoPostal;

	//métodos getter y setter
	public void setPais (String pais) {

		this.pais = pais;
	}

	public String getPais () {

		return pais;
	}

	public void setProvincia (String provincia) {

		this.provincia = provincia;
	}

	public String getProvincia () {

		return provincia;
	}

	public void setCiudad (String ciudad) {

		this.ciudad = ciudad;
	}

	public String getCiudad () {

		return ciudad;
	}

	public void setCalle (String calle) {

		this.calle = calle;
	}

	public String getCalle () {

		return calle;
	}

	public void setPiso (int piso) {

		this.piso = piso;
	}

	public int getPiso () {

		return piso;
	}

	public void setLetra (char letra) {

		this.letra = letra;
	}

	public char getLetra () {

		return letra;
	}

	public void setCodigoPostal (int cp) {

		this.codigoPostal = cp;
	}

	public int getCodigoPostal () {

		return codigoPostal;
	}
}
