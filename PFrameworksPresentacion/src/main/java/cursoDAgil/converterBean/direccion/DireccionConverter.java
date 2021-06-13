/*
 * Número de equipo: 4
 * Autores de la clase:
 *  Garcia Jocelyn Nohemi
 *  Martinez Quiroz Sayra
 *  Fecha: 28/05/2021
 * 
 */
package cursoDAgil.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import javax.inject.Inject;
import javax.inject.Named;


import cursoDAgil.service.direccion.DireccionService;
import cursoDAgil.bd.domain.Direccion;
@Named
public class DireccionConverter implements Converter {
	@Inject
	DireccionService direccionService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value){
		if(value != null && (value.trim().length()>0)){
			try{
				Map<String,Integer>mapDireccion =new HashMap<>();
				mapDireccion.put("idDireccion", Integer.parseInt(value));
				return direccionService.obtenerDireccionPorId(mapDireccion);
				
			}catch(NumberFormatException e){
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value){
		if(((value !=null)&& ((Direccion)value).getIdDireccion()!=null)){
			return ((Direccion)value).getIdDireccion().toString();
		}else
			return null;
	}
}


