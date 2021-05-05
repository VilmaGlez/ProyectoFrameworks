package cursoDAgil.service.detalleventas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.dao.detalleVentas.DetalleVentasDao;

@Named
public class DetalleVentasServiceImpl implements DetalleVentasService, Serializable {
	
	private static final long serialVersionUID = -3636050252009531409L;

	@Inject
	DetalleVentasDao detalleventasDao;
	@Override
	public List<DetalleVentas> obtenerDetalleVentas() {
		// TODO Auto-generated method stub
		return detalleventasDao.obtenerDetalleVentas();
	}

	@Override
	public Integer nuevoDetalleVentas(DetalleVentas detalleventas) {
		// TODO Auto-generated method stub
		return detalleventasDao.nuevoDetalleVentas(detalleventas);
	}

	@Override
	public DetalleVentas obtenerDetalleVentasPorId(Map<String, Integer> mapDetalleVentas) {
		// TODO Auto-generated method stub
		return detalleventasDao.obtenerDetalleVentasPorId(mapDetalleVentas);
	}
	

}
