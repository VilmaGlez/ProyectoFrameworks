package cursoDAgil.dao.cliente;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.mappers.ClienteMapper;

import org.springframework.beans.factory.annotation.Autowired;

@Named
public class ClienteDaoImpl implements ClienteDao, Serializable {
/**
 * 
 */
	private static final long serialVersionUID = -6456965766968902300L;
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<Cliente> listarTodosClientes(){
		List<Cliente> list = null;
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list = clienteMapper.listarTodosClientes();
			for(Cliente c:list){
				System.out.println("Id: " + c.getId());
				System.out.println("Nombre: " + c.getNombre() );
				System.out.println("Datos de direccion ");
				System.out.println("calle: "+ c.getDireccion().getCalle());
				System.out.println("numero: "+ c.getDireccion().getNumero());
				System.out.println("colonia: "+ c.getDireccion().getColonia() );
				System.out.println("ciudad: "+ c.getDireccion().getCiudad());
				System.out.println("estado: "+ c.getDireccion().getEstado());
				System.out.println("pais: "+ c.getDireccion().getPais());
				System.out.println("codigo Postal: "+ c.getDireccion().getCodigoPostal());
				
			}
			return list;
		}catch (Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public Integer nuevoCliente(Cliente cliente) {
		try{
			ClienteMapper clienteMapper= sqlSession.getMapper(ClienteMapper.class);
			System.out.println("cliente nuevo creado con éxito");
			return clienteMapper.nuevoCliente(cliente);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public Cliente obtenerClientePorId(Integer id) {
		try{
			ClienteMapper clienteMapper= sqlSession.getMapper(ClienteMapper.class);
			return clienteMapper.obtenerClientePorId(id);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public Integer eliminarCliente(Map<String, Integer> mapCliente) {
		try{
			ClienteMapper clienteMapper= sqlSession.getMapper(ClienteMapper.class);
			System.out.println("cliente eliminado con éxito");
			return clienteMapper.eliminarCliente(mapCliente);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public Integer modificarCliente(String nombre, String apellido, String email, String sexo,int idDireccion, int id) {
		try{
			ClienteMapper clienteMapper= sqlSession.getMapper(ClienteMapper.class);
			System.out.println("cliente modificado con éxito");
			return clienteMapper.modificarCliente(nombre, apellido, email, sexo, idDireccion, id);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
}
