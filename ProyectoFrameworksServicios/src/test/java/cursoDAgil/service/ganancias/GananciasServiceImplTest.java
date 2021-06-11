package cursoDAgil.service.ganancias;

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

import cursoDAgil.bd.domain.Ganancias;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class GananciasServiceImplTest {
	@Inject
	GananciasService gananciasService;
	
	@Test
	public void pruebaListarTodasGanancias(){
		System.out.println("\nTest listar ganancias");
		try {
			List<Ganancias> lista = gananciasService.listarTodasGanancias();
			int reg = lista.size();
			assertEquals(lista.size(), reg);
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}
	
	@Test
	public void obtenerTotalGanancias(){
		System.out.println("\nTest total Ganancias");
		try {
			gananciasService.obtenerTotalGanancias();
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}
	
	@Test
	public void obtenerGananciasPorFecha() {
		System.out.println("\nTest buscar ganancia por fecha");
		try {
			String stringFecha = "2021/05/19";
			gananciasService.obtenerGananciasPorFecha(stringFecha);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	
	}
		
	@Ignore
	public void nuevoRegistro() {
		Ganancias ganancia = new Ganancias();
		
		System.out.println("\nTest nueva ganancia");
		try {
			String stringFecha = "2021/05/21";
			ganancia.setVentaId(7);
			ganancia.setTotalGanancias(15.10);
			ganancia.setFecha(stringFecha);
			gananciasService.nuevaGanancia(ganancia);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void eliminarGanancia() {
		
		System.out.println("\nTest eliminar ganancia");
		try {
			gananciasService.eliminarGanancia(4);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void modificarRegistro() {
		
		System.out.println("\nTest modificar ganancia");
		try {
			gananciasService.modificarGanancia(10.25, 3);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void obtenerGananciasPorId() {
		System.out.println("\nTest buscar gannacia por id");
		Ganancias ganancias = new Ganancias();
		Map<String, Integer> mapGanancias = new HashMap<>();
		mapGanancias.put("idGanancias", 1);
		try {
			ganancias = gananciasService.obtenerGananciasPorId(mapGanancias);
			assertNotNull(ganancias);
			System.out.println("id:" + ganancias.getIdGanancia());
			System.out.println("totalGanancias:" + ganancias.getTotalGanancias());
			System.out.println("fecha:" + ganancias.getFecha());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
}
