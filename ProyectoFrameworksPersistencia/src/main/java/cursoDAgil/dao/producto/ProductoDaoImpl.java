package cursoDAgil.dao.producto;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.mappers.ProductoMapper;

@Named
public class ProductoDaoImpl implements ProductoDao{
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	@Override
	public Integer nuevoProducto(Producto producto) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			System.out.println("Producto creado con exito");
			return productoMapper.nuevoProducto(producto);
		}catch (Exception e){
			System.out.println("Error"+e);
		}
		return null;
	}
	@Override
	public Producto obtenerProductoPorId(Integer idProducto) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			return productoMapper.obtenerProductoPorId(idProducto);
		}catch (Exception e){
			System.out.println("Error"+e);
		}
		return null;
	}
	
	@Override
	public List<Producto> obtenerProducto() {
		List<Producto> list = null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list = productoMapper.obtenerProducto();
			for(Producto p:list){
				System.out.println("Id: " + p.getIdProducto());
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("Precio: " + p.getPrecio());
				System.out.println("Precio Venta: " + p.getPrecioVta());
				System.out.println("Cantidad: " + p.getCantidad());	
				System.out.println("Marca Id: " + p.getMarcaId());	
			}
			return list;
		}catch (Exception e){
			System.out.println("Error"+e);
		}
		return null;
	}
	@Override
	public List<Producto> obtenerProductosConMarca(){
		List<Producto> list = null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list = productoMapper.obtenerProductosConMarca();
			for(Producto p:list){
				System.out.println("Id: " + p.getIdProducto());
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("Precio: " + p.getPrecio());
				System.out.println("Precio Venta: " + p.getPrecioVta());
				System.out.println("Cantidad: " + p.getCantidad());	
				System.out.println("Marca Id: " + p.getMarcaId());
				System.out.println("Marca: " + p.getMarca().getNombreMarca());
			}
			return list;
		}catch (Exception e){
			System.out.println("Error"+e);
		}
		return null;
	}
	
	@Override
	public Integer eliminarProducto(Map<String, Integer> mapProducto) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			return productoMapper.eliminarProducto(mapProducto);
		}catch (Exception e){
			System.out.println("Error"+e);
		}
		return null;
	}

	
	@Override
	public Integer actualizarProducto(Producto productos) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			System.out.println("Producto modificado con éxito");
			return productoMapper.actualizarProducto(productos);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}

}
