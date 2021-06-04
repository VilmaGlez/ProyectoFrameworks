package cursoDAgil.managedBean.direccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.service.direccion.DireccionService;

@Named
@ViewScoped
public class DireccionTBean implements Serializable {
/**
*
*/
private static final long serialVersionUID = 6472377493921731094L;
@Inject
DireccionService direccionService;
private List<Direccion> listaDireccion;
private Direccion direccion;
@PostConstruct
public void init() {
	if (listaDireccion == null)
	listaDireccion = new ArrayList<Direccion>();
	if (direccion == null) {
		direccion = new Direccion();
		
	}
	// se invoca el metodo del servicio para obtener los clientes
	
	//con su dirección
	
	setListaDireccion(direccionService.obtenerDirecciones());
	// setlistaCliente(clienteService.findAllClientes());
}
/* metodo que registra nueva direccion
public void registrar() {
	// invocar al servicio
	direccionService.nuevaDireccionCliente(getDireccion); 
	// limpia los valores del objeto
	setDireccion(new Cliente());
	// se actualiza los valores de la tabla
	
	setlistaCliente(clienteService.listarTodosClientes());
	// setlistaCliente(clienteService.findAllClientes());
	getlistaCliente();
	FacesContext.getCurrentInstance().addMessage("null", new
	
	FacesMessage("Registro exitoso!"));

}
public void onRowEdit(RowEditEvent event) {
	Direccion cli = ((Direccion) event.getObject());
	cli.setDireccion(direccion.getDireccion());
	direccionService.modificarCliente(direccion.getNombre(),direccion.getApellido(),direccion.getEmail(), direccion.getSexo(), direccion.getId());
	FacesMessage msg = new FacesMessage("Cliente editado",
	
	cli.getId().toString());
	
	FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void onRowCancel(RowEditEvent event) {
	FacesMessage msg = new FacesMessage("Edicion cancelada",
	
	((Cliente) event.getObject()).getId().toString());
	
	FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void onCellEdit(CellEditEvent event) {
	Object oldValue = event.getOldValue();
	Object newValue = event.getNewValue();
	System.out.println("verifica: " + newValue);
	if (newValue != null && !newValue.equals(oldValue)) {
	FacesMessage msg = new
	
	FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente modificado",
	"Antes: " + oldValue + ", Ahora: " +
	
	newValue);
	
	FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}*/
// setters y getters
public Direccion getDireccion() {
return direccion;
}
public void setDireccion(Direccion direccion) {
this.direccion = direccion;
}
public List<Direccion> getListaDireccion() {
return listaDireccion;
}
public void setListaDireccion(List<Direccion> listaDireccion) {
this.listaDireccion = listaDireccion;
}
}