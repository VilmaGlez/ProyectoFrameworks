package cursoDAgil.bd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ventas {
	private Integer idVenta;
	private Integer clienteId;
	private Double totalVenta;
	private Date fecha;
	private DetalleVentas detalleventas;
	private Cliente cliente;
	private Ganancias ganancias;
	private List<Producto> productos;

	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
	public Double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	//Relacionar ventas con DetalleVentas y Cliente
	public Ventas(){
		setDetalleVentas (new DetalleVentas());
		setCliente (new Cliente());
		setGanancias(new Ganancias());
		setProductos(new ArrayList<Producto>());
	}
	 public DetalleVentas getDetalleVentas(){return detalleventas;}
	 public void setDetalleVentas(DetalleVentas detalleventas){this.detalleventas = detalleventas;}
	 
	 public Cliente getCliente(){return cliente;}
	 public void setCliente(Cliente cliente){this.cliente = cliente;}
	 
	public Ganancias getGanancias() {
		return ganancias;
	}
	public void setGanancias(Ganancias ganancias) {
		this.ganancias = ganancias;
	}
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	 
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	 

	    
}
