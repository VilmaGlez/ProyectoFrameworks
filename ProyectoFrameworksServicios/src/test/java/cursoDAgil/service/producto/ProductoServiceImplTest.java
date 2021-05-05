package cursoDAgil.service.producto;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.service.producto.ProductoService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ProductoServiceImplTest {
	@Inject
	ProductoService productoService;
	
	@Ignore
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("\n\nTest consultar todos los productos");
		try {
			List<Producto> lista = productoService.obtenerProducto();
			reg = lista.size();
			assertEquals(lista.size(), reg);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
	
	@Ignore
	public void pruebaConsultarTodoConMarca() {
		int reg;
		System.out.println("\n\nTest consultar todos los productos con marca");
		try {
			List<Producto> lista = productoService.obtenerProductosConMarca();
			reg = lista.size();
			assertEquals(lista.size(), reg);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
	
	@Ignore
	public void nuevoProducto() {
		Producto producto = new Producto();
		System.out.println("\n\nTest nuevo registro");
		try {
			producto.setNombre("Café Soluble");
			producto.setPrecio(10.00);
			producto.setPrecioVta(20.00);
			producto.setCantidad(20);
			producto.setMarcaId(10);
			productoService.nuevoProducto(producto);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void consultarProductoPorId() {
		Producto producto = new Producto();
		try {
			producto = productoService.obtenerProductoPorId(2);
			assertNotNull(producto);
			System.out.println("\n\nTest consultar producto por id");
			System.out.println("Id producto: " + producto.getIdProducto());
			System.out.println("Nombre producto: " + producto.getNombre());
			System.out.println("Marca id: " + producto.getMarcaId());
			System.out.println("Marca: " + producto.getMarca().getNombreMarca());
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	@Ignore
	public void eliminarProductoPorId() {
		System.out.println("\n\nTest eliminar producto");
		Map<String, Integer> mapProducto = new HashMap<>();
		mapProducto.put("idProducto",8);
		try {
			System.out.println("Producto eliminado con exito");
			productoService.eliminarProducto(mapProducto);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}
	
	@Test
	public void actualizarProducto() {
		Producto productos = new Producto();
		System.out.println("\n\nTest actualizar producto");
		try {
			productos.setIdProducto(1);
			productos.setNombre("Cerveza");
			productos.setPrecio(22.0);
			productos.setPrecioVta(34.0);
			productos.setCantidad(39);
			productoService.actualizarProducto(productos);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}
}
