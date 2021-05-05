package cursoDAgil.service.ventas;

import java.util.List;

import cursoDAgil.bd.domain.Ventas;

public interface VentasService {
	List<Ventas>obtenerVenta();
	Integer nuevaVenta(Ventas ventas);
	Ventas obtenerVentaPorId(Integer idVenta);
	Ventas obtenerVentasConProductosPorId(Integer idVenta);

}
