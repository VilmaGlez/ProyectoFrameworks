package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cursoDAgil.bd.domain.Ganancias;

public interface GananciasMapper {
	List<Ganancias> listarTodasGanancias();

	List<Ganancias> obtenerGananciasPorFecha(String fecha);

	Ganancias obtenerGananciasPorId(Map<String, Integer> mapGanancias);

	Integer nuevaGanancia(Ganancias ganancias);

	Integer eliminarGanancia(Integer idGanancia);

	Integer modificarGanancia(@Param("totalGanancias") double totalGanancias, @Param("idGanancias") Integer idGanancias);


}
