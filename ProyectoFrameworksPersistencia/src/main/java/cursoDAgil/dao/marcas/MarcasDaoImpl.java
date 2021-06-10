package cursoDAgil.dao.marcas;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.bd.mappers.MarcasMapper;

@Named
public class MarcasDaoImpl implements MarcasDao{
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	@Override
	public List<Marcas> obtenerMarcas() {
		List<Marcas> list = null;
			try{
				MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
				list = marcasMapper.obtenerMarcas();
				for(Marcas m:list){
				System.out.println("Marca Id: "+m.getIdMarca());
				System.out.println("Marca Nombre: "+m.getNombreMarca());
				}
				return list;
			}catch(Exception e){
				System.out.println("Error: "+ e);
			} 
			return null;
		}
		
		@Override
		public Integer nuevaMarca(Marcas marcas){
			try{
				MarcasMapper marcasMapper= sqlSession.getMapper(MarcasMapper.class);
				System.out.println("Marca creada con éxito");
				return marcasMapper.nuevaMarca(marcas);
			}catch(Exception e){
				System.out.println("Error: "+ e);
			}
			return null;
		}
		@Override
		public Marcas obtenerMarcaPorId(Map<String, Integer> mapMarca) {
			try{
				MarcasMapper marcasMapper= sqlSession.getMapper(MarcasMapper.class);
				return marcasMapper.obtenerMarcaPorId(mapMarca);
			}catch(Exception e){
				System.out.println("Error: "+ e);
			}
			return null;
		}
		@Override
		public Integer eliminarMarca(Map<String, Integer> mapMarca) {
			try{
				MarcasMapper marcasMapper= sqlSession.getMapper(MarcasMapper.class);
				System.out.println("marca eliminada con éxito");
				return marcasMapper.eliminarMarca(mapMarca);
			}catch(Exception e){
				System.out.println("Error: "+ e);
			}
			return null;
		}
		@Override
		public Integer modificarMarca(String nombreMarca, int idMarca) {
			try{
				MarcasMapper marcasMapper= sqlSession.getMapper(MarcasMapper.class);
				System.out.println("marca modificada con éxito");
				return marcasMapper.modificarMarca(nombreMarca, idMarca);
			}catch(Exception e){
				System.out.println("Error: "+ e);
			}
			return null;
		}
}
