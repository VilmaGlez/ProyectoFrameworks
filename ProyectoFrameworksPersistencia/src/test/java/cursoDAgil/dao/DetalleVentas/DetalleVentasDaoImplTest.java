package cursoDAgil.dao.DetalleVentas;

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

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.dao.detalleVentas.DetalleVentasDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml" })

public class DetalleVentasDaoImplTest {
	
	@Inject
	DetalleVentasDao detalleventasDao;
	
	@Ignore
	public void consultarDetalleVentasPorId(){
		DetalleVentas detalleventas = new DetalleVentas();
		Map<String, Integer>mapDetalleVentas = new HashMap<>();
		mapDetalleVentas.put("ventaId",1);
		try{
			detalleventas = detalleventasDao.obtenerDetalleVentasPorId(mapDetalleVentas);
			assertNotNull(detalleventas);
			System.out.println("\n\nTest consultar detalle ventas por id");
			System.out.println("id: "+ detalleventas.getVentaId());
			System.out.println("productoId:"+ detalleventas.getProductoId());
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
	
	@Test
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todos los detalles de venta");
		try{
			List<DetalleVentas> lista= detalleventasDao.obtenerDetalleVentas();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: "+ reg);
		}catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
	}
	
	@Ignore
	public void nuevoRegistro(){
		DetalleVentas detalleventas = new DetalleVentas();
		
		System.out.println("Test nuevo detalle de ventas");
		try{
			detalleventas.setVentaId(4);
			detalleventas.setProductoId(22);
			detalleventas.setCantidad(100);
			
			detalleventasDao.nuevoDetalleVentas(detalleventas);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}

}
