package cursoDAgil.service.direccion;

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

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.service.direccion.DireccionService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DireccionServiceImplTest {
	
	@Inject
	DireccionService direccionservice;
	
	@Test
	public void pruebaConsultarTodo(){
		int reg;
		try{
			List<Direccion> lista = direccionservice.obtenerDirecciones();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: "+ reg);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
	@Ignore
	public void pruebaNuevaDireccionCliente(){
		Direccion direccion = new Direccion();
		System.out.println("Test nuevo registro");
		try{
			direccion.setCalle("Venustiano Carranza");
			direccion.setNumero(3);
			direccion.setColonia("La merced");
			direccion.setCiudad("Huajuapan");
			direccion.setEstado("Oaxaca");
			direccion.setPais("Mexico");
			direccion.setCodigoPostal(69000);
			direccionservice.nuevaDireccionCliente(direccion);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}

	@Ignore
	public void pruebaConsultarDireccionPorId(){
		Direccion direccion = new Direccion();
		Map<String, Integer>mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion",1);
		try{
			direccion=direccionservice.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			System.out.println("\n\nTest consultar direccion por id");
			System.out.println("id: "+ direccion.getIdDireccion());
			System.out.println("calle:"+ direccion.getCalle());
			System.out.println("numero:"+ direccion.getNumero());
			System.out.println("colonia:"+ direccion.getColonia());
			System.out.println("ciudad:"+ direccion.getCiudad());
			System.out.println("estado"+ direccion.getEstado());
			System.out.println("pais:"+ direccion.getPais());
			System.out.println("codigoPostal:"+ direccion.getCodigoPostal());
			System.out.println("********************** ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
		
	}
	
	@Ignore
	public void pruebaModificarDireccion(){
		System.out.println("Test modificar Direccion");
		try{
			direccionservice.modificarDireccion("Hidalgo",32,"Del Camen","Tlaxiaco","Oaxaca","México",69007,6);
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error: "+ e);
			
		}
	}
	
	@Ignore
	public void pruebaEliminarDireccion(){
		System.out.println("Test eliminar direccion");
		try{
			direccionservice.eliminarDireccion(6);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
}
