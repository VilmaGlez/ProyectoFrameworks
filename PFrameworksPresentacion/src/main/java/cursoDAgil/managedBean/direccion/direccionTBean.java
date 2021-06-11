package cursoDAgil.managedBean.direccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;


import cursoDAgil.bd.domain.Direccion;

import cursoDAgil.service.direccion.DireccionService;

@Named
@ViewScoped
public class direccionTBean {
	@Inject
	DireccionService direccionService;
	private List<Direccion> listaDireccion;
	private Direccion direccion;
	
	@PostConstruct
	public void init(){
		if(listaDireccion == null)
			listaDireccion = new ArrayList<Direccion>();
		if(direccion == null){
			direccion = new Direccion();
		}
		
		setlistaDireccion(direccionService.obtenerDirecciones());
		
	}
	
	
	 
	  public void registrar(){
		//invocar al servicio
		direccionService.nuevaDireccionCliente(getDireccion());
		//limpia los valores del objeto
		setDireccion(new Direccion());
		//se actualizan los valores de la tabla
		setlistaDireccion(direccionService.obtenerDirecciones());
		getlistaDireccion();
		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Registro exitoso!"));
	}
	
	  
		//metodo que elimina una direccion
		public void eliminar(){
			//invocar servicio 
		//	Map<String, Integer>mapDireccion = new HashMap<>();
			Integer direc;
		
			Direccion dir = getDireccion();
			//mapDireccion.put("id",dir.getIdDireccion());
			direc= dir.getIdDireccion();
			System.out.println("funcion eliminar "+direc);
			
			//Map<String, Integer>mapCliente = new HashMap<>();
			direccionService.eliminarDireccion(direc);
			setlistaDireccion(direccionService.obtenerDirecciones());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Direccion eliminado ",dir.getIdDireccion().toString()));
		    // PrimeFaces.current().ajax().update("form:msgs", "form:tablaCliente");
			
		}
	  
	  
	  

	public void onRowEdit(RowEditEvent event){
		Direccion dir =((Direccion) event.getObject());
		direccionService.modificarDireccion(dir.getCalle(), dir.getNumero(), dir.getColonia(), dir.getCiudad(), dir.getEstado(), dir.getPais(), dir.getCodigoPostal(), dir.getIdDireccion());
		FacesMessage msg= new FacesMessage("Direccion editada", dir.getIdDireccion().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	public void onRowCancel(RowEditEvent event){
		FacesMessage msg = new FacesMessage("Edición cancelada", ((Direccion) event.getObject()).getIdDireccion().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	public void onCellEdit(CellEditEvent event ){
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		System.out.println("verifica: " + newValue);
		if(newValue != null && !newValue.equals(oldValue)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Direccion modificada", "Antes: "+ oldValue + "Ahora" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	
	 
	
	//setter´s y getter´s
	
	public Direccion getDireccion(){
		return direccion;
	}
	public void setDireccion(Direccion direccion){
		this.direccion=direccion;
	}
	public List<Direccion> getlistaDireccion(){
		return listaDireccion;
	}
	public void setlistaDireccion(List<Direccion> listaDireccion){
		this.listaDireccion=listaDireccion;
	}

}
