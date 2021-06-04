package cursoDAgil.managedBean.marcas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.service.marcas.MarcasService;


@Named
@ViewScoped
public class MarcasTBean implements Serializable {
	/**
	*
	*/
	private static final long serialVersionUID = 6472377493921731094L;
	@Inject
	MarcasService marcasService;
	private List<Marcas> listaMarcas;
	private Marcas marcas;

	@PostConstruct
	public void init() {
		if (listaMarcas== null)
			listaMarcas = new ArrayList<Marcas>();
		if (marcas == null) {
			marcas = new Marcas();

		}
		// se invoca el metodo del servicio para obtener los clientes

		// con su dirección

		setListaMarcas(marcasService.obtenerMarcas());
		// setlistaCliente(clienteService.findAllClientes());
	}

	/*
	 * metodo que registra nueva direccion public void registrar() { // invocar
	 * al servicio direccionService.nuevaDireccionCliente(getDireccion); //
	 * limpia los valores del objeto setDireccion(new Cliente()); // se
	 * actualiza los valores de la tabla
	 * 
	 * setlistaCliente(clienteService.listarTodosClientes()); //
	 * setlistaCliente(clienteService.findAllClientes()); getlistaCliente();
	 * FacesContext.getCurrentInstance().addMessage("null", new
	 * 
	 * FacesMessage("Registro exitoso!"));
	 * 
	 * } public void onRowEdit(RowEditEvent event) { Direccion cli =
	 * ((Direccion) event.getObject());
	 * cli.setDireccion(direccion.getDireccion());
	 * direccionService.modificarCliente(direccion.getNombre(),direccion.
	 * getApellido(),direccion.getEmail(), direccion.getSexo(),
	 * direccion.getId()); FacesMessage msg = new
	 * FacesMessage("Cliente editado",
	 * 
	 * cli.getId().toString());
	 * 
	 * FacesContext.getCurrentInstance().addMessage(null, msg); } public void
	 * onRowCancel(RowEditEvent event) { FacesMessage msg = new
	 * FacesMessage("Edicion cancelada",
	 * 
	 * ((Cliente) event.getObject()).getId().toString());
	 * 
	 * FacesContext.getCurrentInstance().addMessage(null, msg); } public void
	 * onCellEdit(CellEditEvent event) { Object oldValue = event.getOldValue();
	 * Object newValue = event.getNewValue(); System.out.println("verifica: " +
	 * newValue); if (newValue != null && !newValue.equals(oldValue)) {
	 * FacesMessage msg = new
	 * 
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente modificado", "Antes: "
	 * + oldValue + ", Ahora: " +
	 * 
	 * newValue);
	 * 
	 * FacesContext.getCurrentInstance().addMessage(null, msg); } }
	 */
	// setters y getters
	public Marcas getMarcas() {
		return marcas;
	}

	public void setDireccion(Marcas marcas) {
		this.marcas = marcas;
	}

	public List<Marcas> getListaDireccion() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marcas> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}
}