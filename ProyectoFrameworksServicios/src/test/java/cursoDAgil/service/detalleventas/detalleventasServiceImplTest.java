package cursoDAgil.service.detalleventas;

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

import  cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.service.detalleventas.DetalleVentasService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class detalleventasServiceImplTest {
	
	@Inject 
	DetalleVentasService detalleventasService;
	
	@Test
	public void testConsultarDetalleventas(){
		int reg;
		try{
			List<DetalleVentas> lista= detalleventasService.obtenerDetalleVentas();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: "+ reg);
			
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void testConsultarDetalleVentasPorId(){
		DetalleVentas detalleventas = new DetalleVentas();
		Map<String, Integer>mapDetalleVentas = new HashMap<>();
		mapDetalleVentas.put("ventaId",2);
		try{
			detalleventas = detalleventasService.obtenerDetalleVentasPorId(mapDetalleVentas);
			assertNotNull(detalleventas);
			System.out.println("\n\nTest consultar detalle ventas por id");
			System.out.println("id venta: "+ detalleventas.getVentaId());
			System.out.println("productoId:"+ detalleventas.getProductoId());
			System.out.println("cantidad:"+ detalleventas.getCantidad());
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}

	@Ignore
	public void testNuevoRegistro(){
DetalleVentas detalleventas = new DetalleVentas();
		
		System.out.println("Test nuevo detalle de ventas");
		try{
			detalleventas.setVentaId(4);
			detalleventas.setProductoId(22);
			detalleventas.setCantidad(100);
			
			detalleventasService.nuevoDetalleVentas(detalleventas);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
	
}
