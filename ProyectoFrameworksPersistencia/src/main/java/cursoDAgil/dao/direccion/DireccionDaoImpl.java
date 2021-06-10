package cursoDAgil.dao.direccion;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.DireccionMapper;

@Named
public class DireccionDaoImpl implements DireccionDao {
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<Direccion> obtenerDirecciones() {
		List<Direccion> list = null;
		try{
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			list = direccionMapper.obtenerDirecciones();
			for(Direccion d:list){
				System.out.println("id: "+ d.getIdDireccion());
				System.out.println("calle:"+ d.getCalle());
				System.out.println("numero:"+ d.getNumero());
				System.out.println("colonia:"+ d.getColonia());
				System.out.println("ciudad:"+ d.getCiudad());
				System.out.println("estado"+ d.getEstado());
				System.out.println("pais:"+ d.getPais());
				System.out.println("codigo postal:"+ d.getCodigoPostal());
				System.out.println(" ");
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		} 
		return null;
	}
	
	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		try{
			DireccionMapper direccionMapper= sqlSession.getMapper(DireccionMapper.class);
			System.out.println("direccion creada con éxito");
			return direccionMapper.nuevaDireccionCliente(direccion);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion) {
		try{
			DireccionMapper direccionMapper= sqlSession.getMapper(DireccionMapper.class);
			return direccionMapper.obtenerDireccionPorId(mapDireccion);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	@Override
	public Integer eliminarDireccion(Integer id){
		try{
		DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
		System.out.println("Direccion eliminiada con éxito");
		return direccionMapper.eliminarDireccion(id);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	@Override
	public Integer modificarDireccion(String calle,Integer numero, String colonia, String ciudad, String estado, String pais, Integer codigoPostal,  Integer id){
		try{
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			System.out.println("Direccion modificada correctamente ");
			return direccionMapper.modificarDireccion(calle, numero, colonia, ciudad, estado, pais, codigoPostal, id);
		}catch(Exception e){
			System.out.println("Error: "+ e);
			
		}
		return null;
	}
	

}
