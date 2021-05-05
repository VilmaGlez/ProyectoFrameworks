package cursoDAgil.service.ventas;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.dao.ventas.VentasDao;

@Named
public class VentasServiceImpl implements VentasService, Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6878610754135292818L;

	SqlSession sqlSession;

	@Inject
	VentasDao ventasDao;


	@Override
	public List<Ventas> obtenerVenta() {
			return ventasDao.obtenerVenta();
	}

	@Transactional
	@Override
	public Integer nuevaVenta(Ventas ventas) {
				return ventasDao.nuevaVenta(ventas);
	}

	@Override
	public Ventas obtenerVentasConProductosPorId(Integer idVenta) {
		
		return ventasDao.obtenerVentasConProductosPorId(idVenta);
	}

	@Override
	public Ventas obtenerVentaPorId(Integer idVenta) {
		return ventasDao.obtenerVentaPorId(idVenta);
	}

}
