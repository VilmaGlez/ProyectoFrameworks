package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasMapper {
	List<DetalleVentas> obtenerDetalleVentas();
	Integer nuevoDetalleVentas(DetalleVentas detalleventas);
	DetalleVentas obtenerDetalleVentasPorId(Map<String, Integer>mapDetalleVentas);
	

}
