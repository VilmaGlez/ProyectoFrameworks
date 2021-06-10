package cursoDAgil.dao.marcas;
import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Marcas;

public interface MarcasDao {
	List<Marcas> obtenerMarcas();
	Integer nuevaMarca(Marcas marcas);
	Marcas obtenerMarcaPorId(Map<String, Integer> mapMarca);
	Integer eliminarMarca(Map<String, Integer>mapMarca);
	Integer modificarMarca(String nombreMarca, int idMarca);
}
