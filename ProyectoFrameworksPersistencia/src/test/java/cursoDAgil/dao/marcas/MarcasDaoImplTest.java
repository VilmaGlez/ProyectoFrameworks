package cursoDAgil.dao.marcas;

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

import cursoDAgil.bd.domain.Marcas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class MarcasDaoImplTest {
	
	@Inject
	MarcasDao marcasDao;
	
	@Ignore
	public void consultarMarcaPorId(){
		Marcas marcas = new Marcas();
		Map<String, Integer>mapMarca = new HashMap<>();
		mapMarca.put("idMarca",3);
		try{
			marcas=marcasDao.obtenerMarcaPorId(mapMarca);
			assertNotNull(marcas);
			System.out.println("\n\nTest consultar marca por id");
			System.out.println("id: "+ marcas.getIdMarca());
			System.out.println("nombre:"+ marcas.getNombreMarca());
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}

	@Ignore
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todas las marcas");
		try{
			List<Marcas> lista= marcasDao.obtenerMarcas();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: "+ reg);
		}catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
	}
	
	
	@Ignore
	public void nuevoRegistro(){
		Marcas marcas = new Marcas();
		
		System.out.println("Test nueva marca");
		try{
			marcas.setNombreMarca("Asus");
			marcasDao.nuevaMarca(marcas);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
	
	@Ignore
	public void eliminar(){
		Map<String, Integer>mapMarca = new HashMap<>();
		mapMarca.put("idMarca",8);
		try{
			marcasDao.eliminarMarca(mapMarca);
			System.out.println("\n\nTest eliminar");
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
	
	@Test
	public void modificar(){
		System.out.println("\n\nTest modificar");
		try{
			marcasDao.modificarMarca("Picafresas",7);
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
}

