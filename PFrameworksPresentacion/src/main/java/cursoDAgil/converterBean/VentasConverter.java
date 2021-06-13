/******************************/
/* Equipo 4 */
/* Gonzalez Ruiz Vilma Denisse */
/* Sanchez Morales Fernando */
/* 26/05/21 */
/*****************************/
package cursoDAgil.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.service.ventas.VentasService;

@Named
public class VentasConverter implements Converter{
	
	@Inject 
	VentasService ventasService;
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && (value.trim().length() > 0)) {
			try {
				return ventasService.obtenerVentaPorId(Integer.parseInt(value));
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
		if (((value != null) && ((Ventas) value).getIdVenta()!= null)){
			return ((Ventas) value).getIdVenta().toString();
		} else 
		{
			return null;
		}
	}

}
