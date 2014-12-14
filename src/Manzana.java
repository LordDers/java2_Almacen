public class Manzana {

	//propiedades
	private String tipoManzana;
	private String procedencia;
	private String color;
	private Double eurosKilo;
	private Distribuidor distribuidor;
	private int codigoBarras;

	//métodos getter y setter
	public void setTipoManzana (String manzana) {

		this.tipoManzana = manzana;
	}

	public String getTipoManzana () {

		return tipoManzana;
	}

	public void setProcedencia (String procedencia) {

		this.procedencia = procedencia;
	}

	public String getProcedencia () {

		return procedencia;
	}

	public void setColor (String color) {

		this.color = color;
	}

	public String getColor () {

		return color;
	}

	public void setEurosKilo (Double eurokilo) {

		this.eurosKilo = eurokilo;
	}

	public Double getEurosKilo () {

		return eurosKilo;
	}

	public void setDistribuidor (Distribuidor distribuidor) {

		this.distribuidor = distribuidor;
	}

	public Distribuidor getDistribuidor () {

		return distribuidor;
	}

	public void setCodigoBarras (int codbarras) {

		this.codigoBarras = codbarras;
	}

	public int getCodigoBarras () {

		return codigoBarras;
	}
}
