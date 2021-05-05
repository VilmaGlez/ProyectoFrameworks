package cursoDAgil.service.marcas;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Marcas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class MarcasServiceImplTest {
	
	@Inject
	MarcasService marcasService;

	@Test
	public void pruebaConsultarTodo(){
		try{
			System.out.println("Test consultar todas las marcas service");
			List<Marcas> lista = marcasService.obtenerMarcas();
			assertEquals(lista.size(),4);
		}catch(Exception e){
			System.out.println("error" + e);
		}
	}
	@Test
	public void pruebaConsultarPorId(){
		Marcas marcas=new Marcas();
		Map<String,Integer> mapMarca=new HashMap<>();
		mapMarca.put("idMarca", 3);
		System.out.println("\n\nTest consultar marca por id");
		
		try{
			marcas=marcasService.obtenerMarcaPorId(mapMarca);
			System.out.println("id:"+marcas.getIdMarca());
			System.out.println("nombre:"+marcas.getNombreMarca());
			
		}catch(Exception e){
			System.out.println("Error"+e);
		}
	}
	@Test
	public void pruebaNuevoRegistro(){
		Marcas marcas = new Marcas();
		System.out.println("\n\nTest nueva marca");
		try{
			marcas.setNombreMarca("Asus");
			marcasService.nuevaMarca(marcas);
			
		}catch(Exception e){
			System.out.println("error"+e);
		}
	}
	@Test
	public void pruebaEliminar(){
		Map<String,Integer> mapMarca = new HashMap<>();
		mapMarca.put("IdMarca", 8);
		System.out.println("\n\n Test eliminar\n ");
		try{
			
			marcasService.eliminarMarca(mapMarca);
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	@Test
	public void pruebaModificar(){
		System.out.println("\n\n Test modificar");
		try{
			marcasService.modificarMarca("Picafresas",7);
			System.out.println(" ");
			
		}catch(Exception e){
			System.out.println("error"+e);
		}
	}
}
