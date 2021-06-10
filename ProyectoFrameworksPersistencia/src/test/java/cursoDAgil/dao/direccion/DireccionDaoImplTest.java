package cursoDAgil.dao.direccion;

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

import cursoDAgil.bd.domain.Direccion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DireccionDaoImplTest {
	
	@Inject
	DireccionDao direccionDao;
	
	@Ignore
	public void consultarDireccionPorId(){
		Direccion direccion = new Direccion();
		Map<String, Integer>mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion",7);
		try{
			direccion=direccionDao.obtenerDireccionPorId(mapDireccion);
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
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
	
	@Ignore
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todas las direcciones");
		try{
			List<Direccion> lista= direccionDao.obtenerDirecciones();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: "+ reg);
		}catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
	}
	
	@Ignore
	public void nuevoRegistro(){
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
			direccionDao.nuevaDireccionCliente(direccion);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
	
	@Test
	public void eliminarRegistro(){
		System.out.println("Test eliminar direccion");
		try{
			direccionDao.eliminarDireccion(12);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void modificarRegistro(){
		System.out.println("Test modificar Direccion");
		try{
			direccionDao.modificarDireccion("Hidalgo",12,"Del Camen","Huajuapan","Oaxaca","México",69007,12);
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error: "+ e);
			
		}
		
	}
}
