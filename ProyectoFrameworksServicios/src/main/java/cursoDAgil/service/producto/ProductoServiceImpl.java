package cursoDAgil.service.producto;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.dao.producto.ProductoDao;
@Named
public class ProductoServiceImpl implements ProductoService, Serializable {
	private static final long serialVersionUID = 6851374893943163998L;
	@Inject 
	ProductoDao productoDao; 
	@Override
	public List<Producto> obtenerProducto() {
		return productoDao.obtenerProducto();
	}

	@Override
	public List<Producto> obtenerProductosConMarca() {
		return productoDao.obtenerProductosConMarca();
	}

	@Override
	public Integer nuevoProducto(Producto producto) {
		return productoDao.nuevoProducto(producto);
	}

	@Override
	public Producto obtenerProductoPorId(Integer idProducto) {
		return productoDao.obtenerProductoPorId(idProducto);
	}

	@Override
	public Integer eliminarProducto(Map<String, Integer> mapProducto) {
		return productoDao.eliminarProducto(mapProducto);
	}

	@Override
	public Integer actualizarProducto(Producto productos) {
		return productoDao.actualizarProducto(productos);
	}

}
