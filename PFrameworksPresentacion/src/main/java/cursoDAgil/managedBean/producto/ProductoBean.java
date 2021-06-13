/******************************/
/* Equipo 4 */
/* Gonzalez Ruiz Vilma Denisse */
/* Sanchez Morales Fernando */
/* 28/05/21 */
/*****************************/
package cursoDAgil.managedBean.producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import cursoDAgil.bd.domain.Producto;
import cursoDAgil.service.producto.ProductoService;

@Named
@ViewScoped
public class ProductoBean implements Serializable{
	
	private static final long serialVersionUID = 6472377493921731094L;
	
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
		setlistaProducto(productoService.obtenerProductosConMarca());
	}


	// metodo que registra nuevo producto
	public void registrar() {
		//invocar al servicio
		productoService.nuevoProducto(getProducto());
		// limpia los valores del objeto
		setProducto(new Producto());
		// se actualiza los valores de la tabla
		setlistaProducto(productoService.obtenerProductosConMarca());
		getlistaProducto();
		FacesContext.getCurrentInstance().addMessage("null", new
		FacesMessage("Registro exitoso!"));		
	}
	
	public void eliminar(){
		//invocar servicio 
		Map<String, Integer>mapProducto = new HashMap<>();
		
	
		Producto prod = getProducto();
		mapProducto.put("idProducto",prod.getIdProducto());
		System.out.println("funcion eliminar "+prod.getIdProducto());
		
		//Map<String, Integer>mapCliente = new HashMap<>();
		productoService.eliminarProducto(mapProducto);
		setlistaProducto(productoService.obtenerProductosConMarca());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto eliminado ", prod.getIdProducto().toString()));

	     PrimeFaces.current().ajax().update("form:msgs", "form:tablaProductos");
	}
		
		
		
	

	public void onRowEdit(RowEditEvent event) {
		Producto prod = ((Producto) event.getObject());
		prod.setMarca(producto.getMarca());
		productoService.actualizarProducto(prod);
		FacesMessage msg = new FacesMessage("Producto modificado",

				prod.getIdProducto().toString());

		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion cancelada", ((Producto) event.getObject()).getIdProducto().toString());
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
	

	
	//setters y getters 
	public void setlistaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
		
	}
	public List<Producto> getlistaProducto() {
		return listaProducto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
		
	}

	public Producto getProducto() {
		return producto;
	}
}
