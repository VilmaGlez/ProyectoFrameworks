package cursoDAgil.managedBean.producto;

import java.util.List;

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
public class ProductoBean {

	@Inject
	ProductoService productoService;
	private List<Producto> productoList;

	public List<Producto> getProductoList() {
		if (productoList == null)
			setProductoList(productoService.obtenerProducto());
		return productoList;
	}

	public void setProductoList(List<Producto> productoList) {
		this.productoList = productoList;
	}

	public void onRowEdit(RowEditEvent event) {
		Producto producto = ((Producto) event.getObject());
		System.out.println("datos del producto: " + producto.getIdProducto());
		productoService.actualizarProducto(producto);
		FacesMessage msg = new FacesMessage("Cliente editado",

				producto.getIdProducto().toString());

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

}
