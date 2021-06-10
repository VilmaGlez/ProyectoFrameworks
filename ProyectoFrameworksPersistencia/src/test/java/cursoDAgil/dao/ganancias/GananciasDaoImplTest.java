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
	
	@Ignore
	public void pruebaListarTodasGanancias(){
		System.out.println("Test listar todas las ganancias");
		try{
			List <Ganancias> lista = gananciasDao.listarTodasGanancias();
			assertEquals(lista.size(), 1);
			
		} catch(Exception ex){
			System.out.println("error " + ex);
		}
	}
	
	@Test
	public void obtenerGananciasPorFecha() {
		
		try {
			String stringFecha = "01/04/2021";
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
			String stringFecha = "03/02/2021";
			DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
			Date date = fecha.parse(stringFecha);
			ganancia.setVentaId(5);
			ganancia.setTotalGanancias(4.11);
			ganancia.setFecha(date);
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
			gananciasDao.modificarGanancia(16.54, 1);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	
	@Ignore
	public void obtenerGananciasPorId() {
		Ganancias ganancias = new Ganancias();
		Map<String, Integer> mapGanancias = new HashMap<>();
		mapGanancias.put("idGanancia", 1);
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
