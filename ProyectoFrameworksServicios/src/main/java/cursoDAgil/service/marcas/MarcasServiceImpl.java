package cursoDAgil.service.marcas;

import java.io.Serializable;  
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.dao.marcas.MarcasDao;
import cursoDAgil.service.marcas.MarcasService;

@Named
public class MarcasServiceImpl implements MarcasService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1395305282711791357L;
	@Inject
	MarcasDao marcasDao;
	
	
	@Override
	public List<Marcas> obtenerMarcas() {
		return marcasDao.obtenerMarcas();
	}


	@Override
	public Integer nuevaMarca(Marcas marcas) {
		// TODO Auto-generated method stub
		return marcasDao.nuevaMarca(marcas);
	}


	@Override
	public Marcas obtenerMarcaPorId(Map<String, Integer> mapMarca) {
		// TODO Auto-generated method stub
		return marcasDao.obtenerMarcaPorId(mapMarca);
	}


	@Override
	public Integer eliminarMarca(Map<String, Integer> mapMarca) {
		// TODO Auto-generated method stub
		return marcasDao.eliminarMarca(mapMarca);
	}


	@Override
	public Integer modificarMarca(String nombreMarca, int idMarca) {
		// TODO Auto-generated method stub
		return marcasDao.modificarMarca(nombreMarca, idMarca);
	}
	
}