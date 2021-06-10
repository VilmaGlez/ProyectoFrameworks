package cursoDAgil.dao.producto;

import static org.junit.Assert.*;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProductoDaoImplTest {

	@Inject
	ProductoDao productoDao;

	@Test
	public void consultarProductoPorId() {
		Producto producto = new Producto();

		try {
			producto = productoDao.obtenerProductoPorId(1);
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
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("\n\nTest consultar todos los productos");
		try {
			List<Producto> lista = productoDao.obtenerProducto();
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
			List<Producto> lista = productoDao.obtenerProductosConMarca();
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
			
			producto.setNombre("Paleta");
			producto.setPrecio(12.33);
			producto.setPrecioVta(22.22);
			producto.setCantidad(20);
			producto.setMarcaId(3);

			productoDao.nuevoProducto(producto);

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void eliminarProductoPorId() {
		System.out.println("\n\nTest eliminar producto");
		Map<String, Integer> mapProducto = new HashMap<>();
		mapProducto.put("idProducto", 7);
		try {
			System.out.println("Producto eliminado con exito");
			productoDao.eliminarProducto(mapProducto);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

	@Ignore
	public void actualizarProducto() {
		Producto productos = new Producto();

		System.out.println("\n\nTest actualizar producto");
		try {
			productos.setIdProducto(3);
			productos.setNombre("Dulces");
			productos.setPrecio(2.0);
			productos.setPrecioVta(10.0);
			productos.setCantidad(3);

			productoDao.actualizarProducto(productos);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}
}
