package cursoDAgil.dao.ventas;
import java.util.List;
import cursoDAgil.bd.domain.Ventas;
public interface VentasDao { 
	List<Ventas>obtenerVenta();
	Integer nuevaVenta(Ventas ventas);
	Ventas obtenerVentaPorId(Integer idVenta);
	Ventas obtenerVentasConProductosPorId(Integer idVenta);
}
