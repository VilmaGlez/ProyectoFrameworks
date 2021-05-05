package cursoDAgil.service.marcas;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.dao.marcas.MarcasDao;

@Named
public class MarcasServiceImpl implements MarcasService, Serializable {
	private static final long serialVersionUID = -3636050252009531409L;
	@Inject
	MarcasDao marcasDao;
	@Override
	public List<Marcas> obtenerMarcas(){
		return marcasDao.obtenerMarcas();
	}
	@Override
	public Integer nuevaMarca(Marcas marcas) {
		return marcasDao.nuevaMarca(marcas);
	}
	@Override
	public Marcas obtenerMarcaPorId(Map<String, Integer> mapMarca) {
		return marcasDao.obtenerMarcaPorId(mapMarca);
	}
	@Override
	public Integer eliminarMarca(Map<String, Integer> mapMarca) {
		return marcasDao.eliminarMarca(mapMarca);
	}
	@Override
	public Integer modificarMarca(String nombreMarca, int idMarca) {
		return marcasDao.modificarMarca(nombreMarca, idMarca);
	}
}
