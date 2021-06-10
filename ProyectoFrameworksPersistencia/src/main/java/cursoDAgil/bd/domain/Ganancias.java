package cursoDAgil.bd.domain;

import java.util.Date;

public class Ganancias {
	private Integer idGanancia;
	private Integer ventaId;
	private double totalGanancias;
	private Date fecha;
	//private Ventas ventas;
	


	public Integer getIdGanancia() {
		return idGanancia;
	}
	public void setIdGanancia(Integer idGanancia) {
		this.idGanancia = idGanancia;
	}
	public Integer getVentaId() {
		return ventaId;
	}
	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	public double getTotalGanancias() {
		return totalGanancias;
	}
	public void setTotalGanancias(double totalGanancias) {
		this.totalGanancias = totalGanancias;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
