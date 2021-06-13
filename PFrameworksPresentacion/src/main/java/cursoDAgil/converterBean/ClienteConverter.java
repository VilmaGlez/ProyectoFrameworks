/******************************/
/* Equipo 4 */
/* Gonzalez Ruiz Vilma Denisse */
/* Sanchez Morales Fernando */
/* 07/06/21 */
/*****************************/
package cursoDAgil.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.service.cliente.ClienteService;

@Named
public class ClienteConverter implements Converter{
	@Inject
	ClienteService clienteService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && (value.trim().length() > 0)) {
			try {
				return clienteService.obtenerClientePorId(Integer.parseInt(value));
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
		if (((value != null) && ((Cliente) value).getId()!= null)){
			return ((Cliente) value).getId().toString();
		} else 
		{
			return null;
		}
	}

}
