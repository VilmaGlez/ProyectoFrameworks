package cursoDAgil.service.cliente;
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

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.service.cliente.ClienteService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ClienteServiceImplTest {
	@Inject
	ClienteService clienteService;
	
	@Ignore
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("\n\nTest consultar todos los clientes");
		try{
			List<Cliente> lista = clienteService.listarTodosClientes();
			reg = lista.size();
			assertEquals(lista.size(),reg);
		}catch(Exception ex){
			System.out.println("eror"+ ex);
		}
	}
	
	@Test
	public void nuevoRegistro(){
		Cliente cliente = new Cliente();
		
		System.out.println("\n\nTest nuevo registro");
		try{
			cliente.setNombre("Andres");
			cliente.setApellido("Cruz");
			cliente.setEmail("Andres@gmail.com");
			cliente.setSexo("Masculino");
			cliente.setIddireccion(7);
			clienteService.nuevoCliente(cliente);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
	
	@Ignore
	public void consultarClientePorId(){
		Cliente cliente = new Cliente();
	
		try{
			cliente=clienteService.obtenerClientePorId(6);
			assertNotNull(cliente);
			System.out.println("\n\nTest consultar cliente por id");
			System.out.println("id: "+ cliente.getId());
			System.out.println("nombre:"+ cliente.getNombre());
			System.out.println("apellido:"+cliente.getApellido());
			System.out.println("email:"+cliente.getEmail());
			System.out.println("sexo: "+cliente.getSexo());
			System.out.println("IdDireccion: "+cliente.getIddireccion());
			System.out.println("Direccion:");
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
		mapCliente.put("id",4);
		try{
			clienteService.eliminarCliente(mapCliente);
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
			clienteService.modificarCliente("Roberto","Martinez","R@gmail.com","M",1);
			System.out.println(" ");
		}catch(Exception e){
			System.out.println("Error:"+ e);
		}
	}
}
