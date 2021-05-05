package cursoDAgil.service.ventas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.dao.cliente.ClienteDao;
import cursoDAgil.dao.producto.ProductoDao;
import cursoDAgil.dao.ventas.VentasDao;
import jdk.nashorn.internal.ir.annotations.Ignore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})

public class VentasServiceImplTest {
	@Inject
	VentasDao ventasDao;
	
	@Inject
	ClienteDao clienteDao;
	
	@Inject
	ProductoDao productoDao;
	
	@Ignore
	public void consultarVentas(){
		int reg;
		System.out.println("\nTest obtener ventas");
		try{
			List<Ventas> lista = ventasDao.obtenerVenta();
			reg = lista.size();
			assertEquals(lista.size(),reg);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
	

	@Ignore
	public void consultarVentasPorId() {
		try {
			Ventas venta = new Ventas();
			venta=ventasDao.obtenerVentaPorId(4);
			assertNotNull(venta);	
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void nuevoRegistro() {
		Ventas ventas = new Ventas();
		List<Producto> carrito = new ArrayList<Producto>();
		Cliente cliente = new Cliente();
		Double totalVenta=0.0;
		
		System.out.println("Test nueva venta");
		try {
			cliente=clienteDao.obtenerClientePorId(2);
			for(int i=1; i<=1; i++){
				Producto producto = new Producto();
				producto=productoDao.obtenerProductoPorId(i);
				assertNotNull(producto);
				producto.setCantidad(1);
				totalVenta+=producto.getCantidad()*producto.getPrecioVta();
				carrito.add(producto);
			}
			ventas.setClienteId(2);
			ventas.setTotalVenta(totalVenta);
			ventas.setProductos(carrito);
			ventas.setFecha(new Date());
			ventasDao.nuevaVenta(ventas);
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void consultarVentasProductosPorId(){
		System.out.println("Obtener ventas con producto por id");
		try {
			Ventas venta = new Ventas();
			venta=ventasDao.obtenerVentasConProductosPorId(2);
			assertNotNull(venta);	
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}	

}
