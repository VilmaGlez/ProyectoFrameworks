package cursoDAgil.managedBean.cliente;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.service.cliente.ClienteService;

@Named
@ViewScoped
public class ClienteBean {
	@Inject
	ClienteService clienteService;
	private List<Cliente> clienteList;

	public List<Cliente> getClienteList() {
		if (clienteList == null)
			setClienteList(clienteService.listarTodosClientes());
		System.out.println("lista de clientes:" + clienteList.size());
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public void onRowEdit(RowEditEvent event) {
		Cliente cliente = ((Cliente) event.getObject());
		System.out.println("datos cliente: " + cliente.getId());
		clienteService.modificarCliente(cliente.getNombre(), cliente.getApellido(), cliente.getEmail(),
				cliente.getSexo(),cliente.getIddireccion(), cliente.getId());
		FacesMessage msg = new FacesMessage("Cliente editado",

				cliente.getId().toString());

		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion cancelada", ((Cliente) event.getObject()).getId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		System.out.println("verifica: " + newValue);
		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new

			FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente modificado", "Antes: " + oldValue + ", Ahora: " +

					newValue);

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}