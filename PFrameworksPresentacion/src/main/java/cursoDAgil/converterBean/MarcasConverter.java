package cursoDAgil.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.service.marcas.MarcasService;

@Named
public class MarcasConverter implements Converter{

	@Inject 
	MarcasService marcasService;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && (value.trim().length() > 0)) {
			try {
				return marcasService.obtenerMarcaPorId(Integer.parseInt(value));
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
		if (((value != null) && ((Marcas) value).getIdMarca()!= null)){
			return ((Marcas) value).getIdMarca().toString();
		} else 
		{
			return null;
		}
	}
}
