package cursoDAgil.dao.producto;
import java.util.List;
import java.util.Map;


import cursoDAgil.bd.domain.Producto;
public interface ProductoDao {
	List<Producto> obtenerProducto();
	List<Producto> obtenerProductosConMarca();
	Integer nuevoProducto(Producto producto);
	Producto obtenerProductoPorId(Integer idProducto);
	Integer eliminarProducto(Map<String,Integer> mapProducto);
	Integer actualizarProducto(Producto productos);
}
