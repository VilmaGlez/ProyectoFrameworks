package cursoDAgil.dao.ganancias;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.mappers.GananciasMapper;

@Named
public class GananciasDaoImpl implements GananciasDao {
	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Ganancias> listarTodasGanancias() {
		List<Ganancias> list = null;
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			list = gananciasMapper.listarTodasGanancias();
			for (Ganancias c : list) {
				System.out.println("Id: " + c.getIdGanancia());
				System.out.println("VentaId: " + c.getVentaId());
				System.out.println("Total: " + c.getTotalGanancias());
				System.out.println("Fecha: " + c.getFecha());
			}
			return list;
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevaGanancia(Ganancias ganancias) {
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			System.out.println("ganancia creada con éxito");
			return gananciasMapper.nuevaGanancia(ganancias);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Ganancias> obtenerGananciasPorFecha(Date fecha) {
		List<Ganancias> lista = null;
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			lista = gananciasMapper.obtenerGananciasPorFecha(fecha);
			for (Ganancias c : lista) {
				System.out.println("Id: " + c.getIdGanancia());
				System.out.println("VentaId: " + c.getVentaId());
				System.out.println("Total: " + c.getTotalGanancias());
				System.out.println("Fecha: " + c.getFecha());
			}

			return lista;
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer eliminarGanancia(Integer idGanancia) {
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			System.out.println("ganancia eliminada con éxito");
			return gananciasMapper.eliminarGanancia(idGanancia);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer modificarGanancia(double totalGanancias, Integer idGanancia) {
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			System.out.println("ganancia modificada con éxito");
			return gananciasMapper.modificarGanancia(totalGanancias, idGanancia);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Ganancias obtenerGananciasPorId(Map<String, Integer> mapGanancias) {
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);

			return gananciasMapper.obtenerGananciasPorId(mapGanancias);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}


}
