package cursoDAgil.service.ganancias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		try {
			List<Ganancias> lista = gananciasService.listarTodasGanancias();
			assertEquals(lista.size(), 2);
			gananciasService.obtenerTotalGanancias();
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}
	
	@Ignore
	public void obtenerTotalGanancias(){
		try {
			gananciasService.obtenerTotalGanancias();
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}
	
	@Test
	public void obtenerGananciasPorFecha() {
		
		try {
			String stringFecha = "02/02/2021";
			DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = date.parse(stringFecha);
			gananciasService.obtenerGananciasPorFecha(fecha);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	
	}
		
	@Ignore
	public void nuevoRegistro() {
		Ganancias ganancia = new Ganancias();
		
		System.out.println("Test nueva ganancia");
		try {
			String stringFecha = "10/03/2021";
			DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
			Date date = fecha.parse(stringFecha);
			ganancia.setVentaId(4);
			ganancia.setTotalGanancias(15.10);
			ganancia.setFecha(date);
			gananciasService.nuevaGanancia(ganancia);
			System.out.println(ganancia.getFecha());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void eliminarGanancia() {
		
		System.out.println("Test eliminar ganancia");
		try {
			gananciasService.eliminarGanancia(2);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void modificarRegistro() {
		
		System.out.println("Test modificar ganancia");
		try {
			gananciasService.modificarGanancia(8.25, 3);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void obtenerGananciasPorId() {
		Ganancias ganancias = new Ganancias();
		Map<String, Integer> mapGanancias = new HashMap<>();
		mapGanancias.put("idGanancias", 1);
		try {
			ganancias = gananciasService.obtenerGananciasPorId(mapGanancias);
			assertNotNull(ganancias);
			System.out.println("id:" + ganancias.getIdGanancias());
			System.out.println("totalGanancias:" + ganancias.getTotalGanancias());
			System.out.println("fecha:" + ganancias.getFecha());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
}
