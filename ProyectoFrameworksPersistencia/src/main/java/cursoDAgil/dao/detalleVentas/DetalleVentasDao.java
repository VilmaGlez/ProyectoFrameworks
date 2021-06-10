package cursoDAgil.dao.detalleVentas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasDao {
	List<DetalleVentas>obtenerDetalleVentas();
	Integer nuevoDetalleVentas(DetalleVentas detalleventas);
	DetalleVentas obtenerDetalleVentasPorId(Map<String, Integer>mapDetalleVentas);
	

	

}
