package cursoDAgil.dao.ganancias;

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

public class GananciasDaoImplTest {
	@Inject
	GananciasDao gananciasDao;

	@Test
	public void pruebaListarTodasGanancias(){
		int reg;
		System.out.println("\n Test listar todas las ganancias");
		try{
			List <Ganancias> lista = gananciasDao.listarTodasGanancias();
			reg=lista.size();
			assertEquals(lista.size(), reg);
			
		} catch(Exception ex){
			System.out.println("error " + ex);
		}
	}
	
	@Test
	public void obtenerTotalGanancias(){
		System.out.println("\n Test obtener total de ganancias");
		try{
			gananciasDao.obtenerTotalGanancias();
			
		} catch(Exception ex){
			System.out.println("error " + ex);
		}
	}
	
	@Test
	public void obtenerGananciasPorFecha() {
		System.out.println("\n Test obtener ganancias por fecha");
		
		try {
			String stringFecha = "2021/04/17";
			gananciasDao.obtenerGananciasPorFecha(stringFecha);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	
	}
	
	
	@Ignore
	public void nuevaGanancia() {
		Ganancias ganancia = new Ganancias();
		
		System.out.println("\n Test nueva ganancia");
		try {
			String stringFecha = "2021/05/19";
			ganancia.setVentaId(6);
			ganancia.setTotalGanancias(16.12);
			ganancia.setFecha(stringFecha);
			gananciasDao.nuevaGanancia(ganancia);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void eliminarGanancia() {
		
		System.out.println("\nTest eliminar ganancia");
		try {
			gananciasDao.eliminarGanancia(5);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	
	@Ignore
	public void modificarRegistro() {
		
		System.out.println("\nTest modificar ganancia");
		try {
			gananciasDao.modificarGanancia(19.62, 5);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	
	@Test
	public void obtenerGananciasPorId() {
		System.out.println("\n Test obtener ganancias por ID");
		Ganancias ganancias = new Ganancias();
		Map<String, Integer> mapGanancias = new HashMap<>();
		mapGanancias.put("idGanancias", 3);
		try {
			ganancias = gananciasDao.obtenerGananciasPorId(mapGanancias);
			assertNotNull(ganancias);
			System.out.println("id:" + ganancias.getIdGanancia());
			System.out.println("totalGanancias:" + ganancias.getTotalGanancias());
			System.out.println("fecha:" + ganancias.getFecha());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	
}
