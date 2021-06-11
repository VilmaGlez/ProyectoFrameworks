package cursoDAgil.bd.domain;

public class Ganancias {
	private Integer idGanancia;
	private Integer ventaId;
	private double totalGanancias;
	private String fecha;
	


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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	public boolean equals (Object object){
		if(!(object instanceof 	Ganancias)){
			return false;
		}
		Ganancias regGanancias = (Ganancias) object;
		return (this.idGanancia == regGanancias.idGanancia);
	}
	
}
