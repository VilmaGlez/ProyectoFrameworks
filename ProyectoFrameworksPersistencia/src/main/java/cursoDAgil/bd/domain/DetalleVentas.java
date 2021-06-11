package cursoDAgil.bd.domain;

public class DetalleVentas {
	private Integer ventaId;
	private Integer productoId;
	private Integer cantidad;
	
	private Producto producto;
	
	public Integer getVentaId() {
		return ventaId;
	}
	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public DetalleVentas(){
		setProducto (new Producto());
	}
	
	public boolean equals(Object object){
		if(!(object instanceof DetalleVentas)){
			return false;
		}
		DetalleVentas  regDetalleVentas = (DetalleVentas)object;
		return (this.ventaId == regDetalleVentas.ventaId);
	}
}
