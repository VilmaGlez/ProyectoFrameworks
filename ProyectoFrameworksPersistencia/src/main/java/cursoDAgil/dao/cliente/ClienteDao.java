package cursoDAgil.dao.cliente;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Cliente;

public interface ClienteDao {
	List <Cliente> listarTodosClientes();
	Integer nuevoCliente(Cliente cliente);
	Cliente obtenerClientePorId(Integer id);
	Integer eliminarCliente(Map<String, Integer>mapCliente);
	Integer modificarCliente(Cliente cliente);
}
