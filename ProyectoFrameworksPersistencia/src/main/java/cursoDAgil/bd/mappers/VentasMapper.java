package cursoDAgil.bd.mappers;

import java.util.List;
import cursoDAgil.bd.domain.Ventas;
public interface VentasMapper {
	List<Ventas> obtenerVenta();
	Integer nuevaVenta(Ventas ventas);
	Ventas obtenerVentaPorId(Integer idVenta);
	Ventas obtenerVentasConProductosPorId(Integer idVenta);
}
