package cursoDAgil.dao.detalleVentas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.mappers.DetalleVentasMapper;

@Named
public class DetalleVentasDaoImpl implements DetalleVentasDao, Serializable {
	
	private static final long serialVersionUID = -6456965766968902300L;
	
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	
	@Override
	public List<DetalleVentas> obtenerDetalleVentas() {
		// TODO Auto-generated method stub
		List<DetalleVentas> list = null;
		try{
			DetalleVentasMapper detalleVentasMapper = sqlSession.getMapper(DetalleVentasMapper.class);
			list = detalleVentasMapper.obtenerDetalleVentas();
			System.out.println("\nListar todas las ventas\n\n ");
			for(DetalleVentas dv:list){
				System.out.println("DATOS DE DETALLES");
				System.out.println("ventaId: " +dv.getVentaId());
				System.out.println("productoId: "+ dv.getProductoId());
				System.out.println("cantidad: "+dv.getCantidad());
				System.out.println("\nDATOS DE PRODUCTOS");
				System.out.println("IdProducto: " + dv.getProducto().getIdProducto() );
				System.out.println("nombre: " + dv.getProducto().getNombre());
				System.out.println("precio: " + dv.getProducto().getPrecio());
				System.out.println("precioVta: " + dv.getProducto().getPrecioVta());
				System.out.println("cantidad: " + dv.getProducto().getCantidad());
				System.out.println("marcaId: " + dv.getProducto().getMarcaId());
				System.out.println("marca: " + dv.getProducto().getMarca().getNombreMarca());
				
				System.out.println("\n***************");
			
			}
			return list;
		}catch (Exception e){
			System.out.println("Error: "+ e);
		}		
		return null;
	}
	

	@Override
	public Integer nuevoDetalleVentas(DetalleVentas detalleventas) {
		// TODO Auto-generated method stub
		try{
			DetalleVentasMapper detalleVentasMapper = sqlSession.getMapper(DetalleVentasMapper.class);
			System.out.println("Detalle de venta creado con éxito");
			return detalleVentasMapper.nuevoDetalleVentas(detalleventas);
			
		}catch(Exception e){
			System.out.println("Error "+ e);
		}
		return null;
	}

	@Override
	public DetalleVentas obtenerDetalleVentasPorId(Map<String, Integer> mapDetalleVentas) {
		// TODO Auto-generated method stub
		try{
			DetalleVentasMapper detalleventasMapper = sqlSession.getMapper(DetalleVentasMapper.class);
			return detalleventasMapper.obtenerDetalleVentasPorId(mapDetalleVentas);
		}catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
		return null;
	}
	
}
