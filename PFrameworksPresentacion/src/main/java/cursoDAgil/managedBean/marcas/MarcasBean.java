package cursoDAgil.managedBean.marcas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;


import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.service.marcas.MarcasService;

@Named
@ViewScoped
public class MarcasBean implements Serializable {
	private static final long serialVersionUID = 6472377493921731094L;
	@Inject
	MarcasService marcasService;
	
	private List<Marcas> listaMarcas;
	private Marcas marcas;
	@PostConstruct
	public void init() {
		if (listaMarcas == null)
			listaMarcas = new ArrayList<Marcas>();
		if (marcas == null) {
			marcas = new Marcas();
			
		}
		// se invoca el metodo del servicio para obtener los marcas
		//con su dirección
	
		setlistaMarcas(marcasService.obtenerMarcas());
	}
	////
	// metodo que registra nuevo marca
	public void registrar() {
		// invocar al servicio
		System.out.println("funcion registrar:"+getMarcas().getIdMarca());
		
		marcasService.nuevaMarca(getMarcas());
		// limpia los valores del objeto
		setMarcas(new Marcas());
		// se actualiza los valores de la tabla
		setlistaMarcas(marcasService.obtenerMarcas());
		
		getlistaMarcas();
		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Registro exitoso!"));
	
	}
	public void onRowEdit(RowEditEvent event) {
		Marcas mar = ((Marcas) event.getObject());
		marcasService.modificarMarca(mar.getNombreMarca(), mar.getIdMarca());
		FacesMessage msg = new FacesMessage("Marca editado", mar.getIdMarca().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion cancelada",((Marcas) event.getObject()).getIdMarca().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Marca modificado", "Antes: " + oldValue + ", Ahora: " +newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	// setters y getters
	public Marcas getMarcas() {
		return marcas;
	}
	public void setMarcas(Marcas marcas) {
		this.marcas = marcas;
	}
	public List<Marcas> getlistaMarcas() {
		return listaMarcas;
	}
	public void setlistaMarcas(List<Marcas> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}
}
