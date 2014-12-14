public class Lechuga {

	//propiedades
	private String tipoLechuga;
	private String procedencia;
	private String color;
	private Double eurosUnidad;
	private Distribuidor distribuidor;
	private int codigoBarras;	

	//métodos getter y setter
	public void setTipoLechuga (String lechuga) {

		this.tipoLechuga = lechuga;
	}

	public String getTipoLechuga () {

		return tipoLechuga;
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

	public void setEurosUnidad (Double eurounidad) {

		this.eurosUnidad = eurounidad;
	}

	public Double getEurosUnidad () {

		return eurosUnidad;
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
