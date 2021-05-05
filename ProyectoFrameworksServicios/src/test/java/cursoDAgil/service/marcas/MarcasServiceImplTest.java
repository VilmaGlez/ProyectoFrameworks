package cursoDAgil.service.marcas;

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

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.service.marcas.MarcasService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})


public class MarcasServiceImplTest {
	@Inject
	MarcasService marcasService;
	
	@Ignore
	public void consultarMarcaPorId(){
		Marcas marcas = new Marcas();
		Map<String, Integer>mapMarca = new HashMap<>();
		mapMarca.put("idMarca",5);
		try{
			marcas=marcasService.obtenerMarcaPorId(mapMarca);
			assertNotNull(marcas);
			System.out.println("\n\nTest consultar marca por id");
			System.out.println("id: "+ marcas.getIdMarca());
			System.out.println("nombre:"+ marcas.getNombreMarca());
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}

	@Test
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todas las marcas");
		try{
			List<Marcas> lista= marcasService.obtenerMarcas();
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
			marcasService.nuevaMarca(marcas);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
	
	@Ignore
	public void eliminar(){
		Map<String, Integer>mapMarca = new HashMap<>();
		mapMarca.put("idMarca",6);
		try{
			marcasService.eliminarMarca(mapMarca);
			System.out.println("\n\nTest eliminar");
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
	
	@Ignore
	public void modificar(){
		System.out.println("\n\nTest modificar");
		try{
			marcasService.modificarMarca("Picafresas",5);
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
	
	
	
}
