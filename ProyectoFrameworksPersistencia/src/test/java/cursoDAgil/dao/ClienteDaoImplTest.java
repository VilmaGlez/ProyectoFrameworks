package cursoDAgil.dao;

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

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.dao.cliente.ClienteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ClienteDaoImplTest {
	@Inject
	ClienteDao clienteDao;
	

	@Ignore
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todos los clientes");
		try{
			List<Cliente> lista = clienteDao.listarTodosClientes();
			reg=lista.size();
			assertEquals(lista.size(),reg);
		}catch(Exception ex){
			System.out.println("error"+ ex);
		}
	}
	
	@Ignore
	public void consultarClientePorId(){
		Cliente cliente = new Cliente();
	
		try{
			cliente=clienteDao.obtenerClientePorId(1);
			assertNotNull(cliente);
			System.out.println("\n\nTest consultar cliente por id");
			System.out.println("id: "+ cliente.getId());
			System.out.println("nombre:"+ cliente.getNombre());
			System.out.println("apellido:"+cliente.getApellido());
			System.out.println("email:"+cliente.getEmail());
			System.out.println("sexo"+cliente.getSexo());
			System.out.println("IdDireccion"+cliente.getIddireccion());
			System.out.println("Datos de la Direccion-------------");
			System.out.println("idDireccion"+cliente.getDireccion().getIdDireccion());
			System.out.println("calle: "+ cliente.getDireccion().getCalle());
			System.out.println("numero: "+ cliente.getDireccion().getNumero());
			System.out.println("colonia: "+ cliente.getDireccion().getColonia() );
			System.out.println("ciudad: "+ cliente.getDireccion().getCiudad());
			System.out.println("estado: "+ cliente.getDireccion().getEstado());
			System.out.println("pais: "+ cliente.getDireccion().getPais());
			System.out.println("codigo Postal: "+ cliente.getDireccion().getCodigoPostal());

		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
	
	@Ignore
	public void eliminar(){
		Map<String, Integer>mapCliente = new HashMap<>();
		mapCliente.put("id",5);
		try{
			clienteDao.eliminarCliente(mapCliente);
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
			Cliente cli = new Cliente();
			cli.setId(10);
			cli.setNombre("Fernando");
			cli.setApellido("Martinez");
			cli.setEmail("f@gmail.com");
			cli.setSexo("M");
			cli.setIddireccion(7);
			clienteDao.modificarCliente(cli);
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
	
	@Ignore
	public void nuevoRegistro(){
		Cliente cliente = new Cliente();
		
		System.out.println("Test nuevo registro");
		try{
			cliente.setNombre("Alondra");
			cliente.setApellido("Martinez");
			cliente.setEmail("Alo@gmail.com");
			cliente.setSexo("Femenino");
			cliente.setIddireccion(3);
			clienteDao.nuevoCliente(cliente);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
}


