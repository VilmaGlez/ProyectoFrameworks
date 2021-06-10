package cursoDAgil.dao.ventas;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.bd.mappers.VentasMapper;
import cursoDAgil.dao.detalleVentas.DetalleVentasDao;
import cursoDAgil.dao.ganancias.GananciasDao;
import cursoDAgil.dao.producto.ProductoDao;

@Named
public class VentasDaoImpl implements VentasDao, Serializable {

	private static final long serialVersionUID = -6456965766968902300L;

	SqlSession sqlSession;

	@Inject
	DetalleVentasDao detalleVentasDao;

	@Inject
	ProductoDao productoDao;

	@Inject
	GananciasDao gananciasDao;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Ventas> obtenerVenta() {
		// TODO Auto-generated method stub
		List<Ventas> list = null;
		try{
			VentasMapper ventasMapper = sqlSession.getMapper(VentasMapper.class);
			list = ventasMapper.obtenerVenta();
			System.out.println("\nListar todas las ventas\n\n ");
			for(Ventas v:list){
				System.out.println("DATOS DE LA VENTA Y DETALLES");
				System.out.println("ventaId: " + v.getIdVenta());
				System.out.println("clienteId: " + v.getCliente().getId());
				System.out.println("nombre: " + v.getCliente().getNombre()); //checar que esta mal
				System.out.println("venta total: " + v.getTotalVenta() );
				System.out.println("fecha: " + v.getFecha());
				System.out.println("\n***************");
			
			}
			return list;
		}catch (Exception e){
			System.out.println("Error: "+ e);
		}		
		return null;
	}

	@Transactional
	@Override
	public Integer nuevaVenta(Ventas ventas) {
		// TODO Auto-generated method stub
		try {
			int bandera = 1;
			Double ganancia = 0.0;
			
			VentasMapper ventasMapper = sqlSession.getMapper(VentasMapper.class);
			ventasMapper.nuevaVenta(ventas);
			// despues de obtener el registro de la venta obtenemos el id de la
			// cofiguracion en el mapper
			Integer idVenta = ventas.getIdVenta();

			List<Producto> productos = ventas.getProductos();
			Ganancias nganancia = new Ganancias();
			for (Producto prod : productos) {
				DetalleVentas detalleVenta = new DetalleVentas();
				detalleVenta.setVentaId(idVenta);
				detalleVenta.setProductoId(prod.getIdProducto());
				detalleVenta.setCantidad(prod.getCantidad());
				Producto productoExistente = new Producto();
				productoExistente = productoDao.obtenerProductoPorId(prod.getIdProducto());
				productoExistente.setCantidad(productoExistente.getCantidad() - prod.getCantidad());
				ganancia += prod.getCantidad() * (prod.getPrecioVta() - prod.getPrecio());
			
				
				
				if (productoExistente.getCantidad() > 0) {
					detalleVentasDao.nuevoDetalleVentas(detalleVenta);
					productoDao.actualizarProducto(productoExistente);
					
					
					} else {
						System.out.println("Ya no hay productos");
						bandera=1;
					}

			}
			if(bandera==1){
				nganancia.setVentaId(idVenta);
				nganancia.setTotalGanancias(ganancia);
				nganancia.setFecha(new Date());
				
				gananciasDao.nuevaGanancia(nganancia);
			}
			
			

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Ventas obtenerVentasConProductosPorId(Integer idVenta) {
		// TODO Auto-generated method stub
		Ventas venta = null;
		try {
			VentasMapper ventasMapper = sqlSession.getMapper(VentasMapper.class);
			venta =ventasMapper.obtenerVentasConProductosPorId(idVenta);
			System.out.println("idVenta: "+venta.getIdVenta());
			System.out.println("idCliente: "+ venta.getCliente().getId());
			System.out.println("nombreCliente: "+ venta.getCliente().getNombre());
			List<Producto> productos = venta.getProductos();
			for(Producto prod:productos){
				System.out.println("idProducto: "+ prod.getIdProducto());
				System.out.println("nombreProducto: "+ prod.getNombre());
				
			}
			return venta;
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		return null;
	}

	@Override
	public Ventas obtenerVentaPorId(Integer idVenta) {
		Ventas venta = null;
		try {
			VentasMapper ventasMapper = sqlSession.getMapper(VentasMapper.class);
			venta =ventasMapper.obtenerVentaPorId(idVenta);
			System.out.println("idVenta: "+venta.getIdVenta());
			System.out.println("idCliente: "+ venta.getCliente().getId());
			System.out.println("nombreCliente: "+ venta.getCliente().getNombre());
			return venta;
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

}
