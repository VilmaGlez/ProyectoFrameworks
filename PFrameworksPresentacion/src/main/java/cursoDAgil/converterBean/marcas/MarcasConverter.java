package cursoDAgil.converterBean.marcas;


import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.service.marcas.MarcasService;

@Named

public class MarcasConverter implements Converter {
	@Inject
	MarcasService marcasService;
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Map<String, Integer>mapMarca = new HashMap<>();
		mapMarca.put("idMarca",Integer.parseInt(value));
		System.out.println("preuba2:"+mapMarca);
		if (value != null && (value.trim().length() > 0)) {
		try {

			return marcasService.obtenerMarcaPorId(mapMarca); 
					
		} catch (NumberFormatException e) {
		return null;
		}
		} else {
		return null;
		}
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (((value != null) && ((Marcas) value).getIdMarca()!= null)){
			return ((Direccion) value).getIdDireccion().toString();
		} else {
		return null;
		}
	}
}
