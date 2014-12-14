import java.util.ArrayList;

public class Cesta {

	private Cliente vcliente;
	private ArrayList <Manzana> vmanzana;
	private ArrayList <Lechuga> vlechuga;
	private ArrayList <Leche> vleche;
	private Double vimporteCompra;

	public void setCliente (Cliente cliente) {

		this.vcliente = cliente;
	}

	public Cliente getCliente () {

		return vcliente;
	}

	public void setManzana (ArrayList <Manzana> manzana) {

		this.vmanzana = manzana;
	}

	public ArrayList <Manzana> getManzada () {

		return vmanzana;
	}

	public void setLechuga (ArrayList <Lechuga> lechuga) {

		this.vlechuga = lechuga;
	}

	public ArrayList <Lechuga> getLechuga () {

		return vlechuga;
	}

	public void setLeche (ArrayList <Leche> leche) {

		this.vleche = leche;
	}

	public ArrayList <Leche> getLeche () {

		return vleche;
	}

	public void setImporteCompra (Double euro, Double descuento) {

		this.vimporteCompra = euro - (euro * descuento) / 100;
	}

	public Double getImporteCompra () {

		return vimporteCompra;
	}
}