package cursoDAgil.dao.ganancias;

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

public class GananciasDaoImplTest {
	@Inject
	GananciasDao gananciasDao;

	@Test
	public void pruebaListarTodasGanancias(){
		int reg;
		System.out.println("Test listar todas las ganancias");
		try{
			List <Ganancias> lista = gananciasDao.listarTodasGanancias();
			reg=lista.size();
			assertEquals(lista.size(), reg);
			gananciasDao.obtenerTotalGanancias();
			
		} catch(Exception ex){
			System.out.println("error " + ex);
		}
	}
	
	@Ignore
	public void obtenerTotalGanancias(){
		
		try{
			gananciasDao.obtenerTotalGanancias();
			
		} catch(Exception ex){
			System.out.println("error " + ex);
		}
	}
	
	@Test
	public void obtenerGananciasPorFecha() {
		
		try {
			String stringFecha = "17/04/2021";
			DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = date.parse(stringFecha);
			gananciasDao.obtenerGananciasPorFecha(fecha);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	
	}
	
	
	@Ignore
	public void nuevoRegistro() {
		Ganancias ganancia = new Ganancias();
		
		System.out.println("Test nueva ganancia");
		try {
			String stringFecha = "14/03/2021";
			ganancia.setVentaId(5);
			ganancia.setTotalGanancias(67.11);
			ganancia.setFecha(stringFecha);
			gananciasDao.nuevaGanancia(ganancia);
			System.out.println(ganancia.getFecha());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void eliminarGanancia() {
		
		System.out.println("Test eliminar ganancia");
		try {
			gananciasDao.eliminarGanancia(2);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	
	@Ignore
	public void modificarRegistro() {
		
		System.out.println("Test modificar ganancia");
		try {
			gananciasDao.modificarGanancia(9.62, 3);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	
	@Ignore
	public void obtenerGananciasPorId() {
		Ganancias ganancias = new Ganancias();
		Map<String, Integer> mapGanancias = new HashMap<>();
		mapGanancias.put("idGanancias", 2);
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
