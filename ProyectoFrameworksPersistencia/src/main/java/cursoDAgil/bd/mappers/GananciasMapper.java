package cursoDAgil.bd.mappers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cursoDAgil.bd.domain.Ganancias;
//import cursoDAgil.bd.domain.Ventas;

public interface GananciasMapper {
	List<Ganancias> listarTodasGanancias();

	List<Ganancias> obtenerGananciasPorFecha(Date fecha);
	
	Ganancias obtenerGananciasPorId(Map<String,Integer> mapGanancias);

	Integer nuevaGanancia(Ganancias ganancias);
	
	Integer eliminarGanancia(Integer idGanancia);
	
	Integer modificarGanancia(@Param("totalGanancias") double totalGanancias, @Param("idGanancia") Integer idGanancias);
	
}
