//*******************************
/*Equipo 4*/
/*Gónzalez Ruiz Vilma Denisse*/
/*Sánchez Morales Fernando*/
/*28/05/21*/
//*******************************
package cursoDAgil.managedBean.ventas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.service.detalleventas.DetalleVentasService;
import cursoDAgil.service.ventas.VentasService;

@Named
@ViewScoped
public class VentasBean implements Serializable {
	private static final long serialVersionUID = 4026759715748301912L;
	@Inject
	VentasService ventasService;
	@Inject
	DetalleVentasService detalleVentasService;
	private List<DetalleVentas> listaDetalleVentas;
	private DetalleVentas detalleVentas;
	private Ventas ventaSe;
	private List<Ventas> ventasList;
	private Ventas ventas;
	private List<Producto> productoList;
	private Producto producto;
	private Cliente cliente;
	private Integer cant;
	private Double total;
	
	@PostConstruct
	public void init() {
		if (ventasList == null)
			ventasList = new ArrayList<Ventas>();
		if (ventas == null) {
			ventas = new Ventas();
			cliente = new Cliente();
			producto = new Producto();
			productoList = new ArrayList<Producto>();
			cant=0;
			total=0.0;
		}
		setVentasList(ventasService.obtenerVenta());
	}
	
	public void registrar() {
		Cliente cli = getCliente();
		ventas.setCliente(cli);
		ventas.setTotalVenta(getTotal());
		ventas.setProductos(productoList);
		ventas.setFecha(new Date());
		// invocar al servicio
		ventasService.nuevaVenta(getVentas());
		// limpia los valores del objeto
		setVentas(new Ventas());
		setCliente(new Cliente());
		setProducto(new Producto());
		setProductoList(new ArrayList<Producto>());
		setCant(0);
		setTotal(0.0);
		// se actualiza los valores de la tabla
		setVentasList(ventasService.obtenerVenta());
		getVentasList();
		System.out.println( " Limpia " + getProductoList());
		FacesContext.getCurrentInstance().addMessage("null", new
		FacesMessage("Registro exitoso!"));
	}
	
	public void obtener(){	
		Ventas venta = getVentas();
		System.out.println("id"+venta.getIdVenta());
		ventaSe = ventasService.obtenerVentasConProductosPorId
				(venta.getIdVenta());
		setProductoList(ventaSe.getProductos());
		
		for(Producto product:productoList){
			System.out.println("ID"+ product.getIdProducto());
		}
	}
	
	public void agregarCarrito()
	{
		Producto prod = getProducto();
		prod.setCantidad(getCant());
		System.out.println(getCant() + " Productos" + prod.getIdProducto() + "agregados a carrito " );
		total+=prod.getPrecioVta()*prod.getCantidad();
		productoList.add(prod);
		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Agregados al carrito"));
	}
	
	public void cancelar()
	{
		setVentas(new Ventas());
		setCliente(new Cliente());
		setProducto(new Producto());
		setProductoList(new ArrayList<Producto>());
		setCant(0);
		setTotal(0.0);
		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Venta cancelada"));
	}
	
	public List<Ventas> getVentasList() {
		return ventasList;
	}

	public void setVentasList(List<Ventas> ventasList) {
		this.ventasList = ventasList;
	}

	public Ventas getVentas() {
		return ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}
	
	public List<Producto> getProductoList() {
		return productoList;
	}

	public void setProductoList(List<Producto> productoList) {
		this.productoList = productoList;
	}
	public Producto getProducto(){
		return producto;
	}
	public void setProducto(Producto producto){
		this.producto = producto;
	}
	
	public void setCant(Integer cant){
		this.cant = cant;
	}
	
	public Integer getCant()
	{
		return cant;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	public Double getTotal()
	{
		return total;
	}
	public void setTotal(Double total)
	{
		this.total = total;
	}
	
	public Ventas getVentaSe() {
		return ventaSe;
	}

	public void setVentaSe(Ventas ventaSe) {
		this.ventaSe = ventaSe;
	}
	
	public DetalleVentas getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(DetalleVentas detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	public void  setListaDetalleVenta(List<DetalleVentas> listaDetalleVentas){
		this.listaDetalleVentas= listaDetalleVentas;
	}
	
	public List<DetalleVentas> getListaDetalleVentas(){
		return listaDetalleVentas;
	}
	
}
