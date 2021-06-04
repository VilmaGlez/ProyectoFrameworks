package cursoDAgil.managedBean.producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import cursoDAgil.bd.domain.Producto;
import cursoDAgil.service.producto.ProductoService;

@Named
@ViewScoped
public class ProductoMarca2Bean implements Serializable {

	private static final long serialVersionUID = 8794919270230881220L;
	/**
	 * 
	 */
	
	@Inject
	ProductoService productoService;
	private List<Producto> listaProducto;
	private Producto producto;

	@PostConstruct
	public void init() {
		if (listaProducto == null)
			listaProducto = new ArrayList<Producto>();
		if (producto == null) {
			producto = new Producto();
			producto.setMarca(null);

		}
		// se invoca el metodo del servicio para obtener los productos

		// con sus marcas

		setlistaProducto(productoService.obtenerProductosConMarca());
		// setlistaCliente(clienteService.findAllClientes());
	}

	// metodo que registra nuevo cliente
	public void registrar() {
		// invocar al servicio
		productoService.nuevoProducto(getProducto());
		// limpia los valores del objeto
		setProducto(new Producto());
		// se actualiza los valores de la tabla
		setlistaProducto(productoService.obtenerProductosConMarca());
		// setlistaCliente(clienteService.findAllClientes());
		getlistaProducto();
		FacesContext.getCurrentInstance().addMessage("null", new

		FacesMessage("Registro exitoso!"));

	}

	public void onRowEdit(RowEditEvent event) {
		Producto pro = ((Producto) event.getObject());
		pro.setMarca(producto.getMarca());
		productoService.actualizarProducto(producto);
		FacesMessage msg = new FacesMessage("Producto editado",

				pro.getIdProducto().toString());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion cancelada",

				((Producto) event.getObject()).getIdProducto().toString());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		System.out.println("verifica: " + newValue);
		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new

			FacesMessage(FacesMessage.SEVERITY_INFO, "Producto modificado", "Antes: " + oldValue + ", Ahora: " +

					newValue);

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// setters y getters
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getlistaProducto() {
		return listaProducto;
	}

	public void setlistaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
}
