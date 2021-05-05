package cursoDAgil.service.ganancias;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.dao.ganancias.GananciasDao;

@Named
public class GananciasServiceImpl implements GananciasService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7944015921252756823L;
	
	@Inject
	GananciasDao gananciasDao;

	@Override
	public List<Ganancias> listarTodasGanancias() {
		return gananciasDao.listarTodasGanancias();
	}

	@Override
	public List<Ganancias> obtenerGananciasPorFecha(Date fecha) {
		return gananciasDao.obtenerGananciasPorFecha(fecha);
	}

	@Override
	public Ganancias obtenerGananciasPorId(Map<String, Integer> mapGanancias) {
		return gananciasDao.obtenerGananciasPorId(mapGanancias);
	}

	@Override
	public Integer nuevaGanancia(Ganancias ganancias) {
		return gananciasDao.nuevaGanancia(ganancias);
	}

	@Override
	public Integer eliminarGanancia(Integer idGanancia) {
		return gananciasDao.eliminarGanancia(idGanancia);
	}

	@Override
	public Integer modificarGanancia(double totalGanancias, Integer idGanancias) {
		return gananciasDao.modificarGanancia(totalGanancias, idGanancias);
	}


}
