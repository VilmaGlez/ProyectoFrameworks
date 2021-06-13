/******************************/
/* Equipo 4 */
/* Gonzalez Ruiz Vilma Denisse */
/* Sanchez Morales Fernando */
/* 27/05/21 */
/*****************************/
package cursoDAgil.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Producto;
import cursoDAgil.service.producto.ProductoService;

@Named
public class ProductoConverter implements Converter{
	@Inject 
	ProductoService productoService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && (value.trim().length() > 0)) {
			try {
				return productoService.obtenerProductoPorId(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				return null;
			}
		} 
		else{
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (((value != null) && ((Producto) value).getIdProducto()!= null)){
			return ((Producto) value).getIdProducto().toString();
		} else 
		{
			return null;
		}
	}
	

}
