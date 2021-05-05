package cursoDAgil.service.direccion;

import java.util.List;
import java.util.Map;
import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.dao.direccion.DireccionDao;

@Named
public class DireccionServiceImpl implements DireccionService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3636050252009531409L;
	@Inject
	DireccionDao direccionDao;
	@Override
	public List<Direccion>obtenerDirecciones(){
		return direccionDao.obtenerDirecciones();
	}
	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		// TODO Auto-generated method stub
		return direccionDao.nuevaDireccionCliente(direccion);
	}
	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion) {
		// TODO Auto-generated method stub
		return direccionDao.obtenerDireccionPorId(mapDireccion);
	}
	@Override
	public Integer eliminarDireccion(Integer id) {
		// TODO Auto-generated method stub
		return direccionDao.eliminarDireccion(id);
	}
	@Override
	public Integer modificarDireccion(String calle, Integer numero, String colonia, String ciudad, String estado,
			String pais, Integer codigoPostal, Integer id) {
		// TODO Auto-generated method stub
		return direccionDao.modificarDireccion(calle, numero, colonia, ciudad, estado, pais, codigoPostal, id);
	}
}

