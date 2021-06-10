package cursoDAgil.dao.direccion;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

public interface DireccionDao {
	List<Direccion> obtenerDirecciones();
	Integer nuevaDireccionCliente(Direccion direccion);
	Direccion obtenerDireccionPorId(Map<String, Integer>mapDireccion);
	Integer eliminarDireccion(Integer id);
	Integer modificarDireccion(String calle,Integer numero, String colonia, String ciudad, String estado, String pais, Integer codigoPostal,  Integer id);

}
