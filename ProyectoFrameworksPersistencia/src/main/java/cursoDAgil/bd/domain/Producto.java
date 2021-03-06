package cursoDAgil.bd.domain;

public class Producto {
	private Integer idProducto;
	private String nombre;
	private Double precio;
	private Double precioVta;
	private Integer cantidad;
	private Integer marcaId;
	private Marcas marca;
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Double getPrecioVta() {
		return precioVta;
	}
	public void setPrecioVta(Double precioVta) {
		this.precioVta = precioVta;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer getMarcaId() {
		return marcaId;
	}
	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}
	public Producto(){
		setMarca(new Marcas());
	}
	public void setMarca(Marcas marca){
		this.marca = marca;
	}
	public Marcas getMarca(){
		return marca;
	}
	
	public boolean equals(Object object){
		if(!(object instanceof Producto)){
			return false;
		}
		Producto regProducto = (Producto) object;
		return (this.idProducto == regProducto.idProducto);
	}
}
