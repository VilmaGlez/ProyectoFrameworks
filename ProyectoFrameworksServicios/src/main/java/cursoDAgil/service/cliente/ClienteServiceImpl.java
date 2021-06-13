package cursoDAgil.service.cliente;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.dao.cliente.ClienteDao;

@Named
public class ClienteServiceImpl implements ClienteService, Serializable {
	private static final long serialVersionUID = -1395305282711791357L;
	@Inject
	ClienteDao clienteDao;
	@Override
	public List<Cliente> listarTodosClientes() {
		return clienteDao.listarTodosClientes();
	}
	@Override
	public Integer nuevoCliente(Cliente cliente) {
		return clienteDao.nuevoCliente(cliente);
	}
	@Override
	public Cliente obtenerClientePorId(Integer id) {
		return clienteDao.obtenerClientePorId(id);
	}
	@Override
	public Integer eliminarCliente(Map<String, Integer> mapCliente) {
		return clienteDao.eliminarCliente(mapCliente);
	}
	@Override
	public Integer modificarCliente(Cliente cliente) {
		return clienteDao.modificarCliente(cliente);
	}

}
