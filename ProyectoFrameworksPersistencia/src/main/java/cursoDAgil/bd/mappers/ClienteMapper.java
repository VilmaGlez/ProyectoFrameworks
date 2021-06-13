package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;
import cursoDAgil.bd.domain.Cliente;

public interface ClienteMapper {
	List<Cliente> listarTodosClientes();
	Integer nuevoCliente(Cliente cliente);
	Cliente obtenerClientePorId(Integer id);
	Integer eliminarCliente(Map<String, Integer>mapCliente);
	Integer modificarCliente(Cliente cliente);
}
