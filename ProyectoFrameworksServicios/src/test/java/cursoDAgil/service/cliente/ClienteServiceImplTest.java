package cursoDAgil.service.cliente;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

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
	ClienteService clienteservice;
	
	@Test
	public void pruebaConsultarTodo(){
		try{
			List<Cliente> lista = clienteservice.listarTodosClientes();
			assertEquals(lista.size(),4);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
	}
	

}
