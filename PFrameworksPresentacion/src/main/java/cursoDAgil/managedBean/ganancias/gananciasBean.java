/*
 * Número de equipo: 4
 * Autores de la clase:
 *  Garcia Jocelyn Nohemi
 *  Martinez Quiroz Sayra
 *  Fecha: 27/05/2021
 * 
 */
package cursoDAgil.managedBean.ganancias;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.service.ganancias.GananciasService;

@Named
@ViewScoped
public class gananciasBean {
	@Inject
	GananciasService gananciasService;
	private Ganancias ganancia;
	private List<Ganancias> listaGanancias;
	private double total;
	private List<Ganancias> buscarGanancias;

	@PostConstruct
	public void init() {
		if (listaGanancias == null)
			listaGanancias = new ArrayList<Ganancias>();
		if (ganancia == null) {
			ganancia = new Ganancias();
		}

		setListaGanancias(gananciasService.listarTodasGanancias());
		
	}
	
	/*public void registrar(){
		//invocar al servicio
		gananciasService.nuevaGanancia(getGanancias());
		//limpia los valores del objeto
		setGanancias(new Ganancias());
		//se actualizan los valores de la tabla
		setListaGanancias(gananciasService.listarTodasGanancias());
		getListaGanancias();
		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Registro exitoso!"));
	}
	public void onRowEdit(RowEditEvent event){
		Ganancias gan =((Ganancias) event.getObject());
		gananciasService.modificarGanancia(gan.getTotalGanancias(),gan.getIdGanancia());
		FacesMessage msg= new FacesMessage("Ganancia editada", gan.getIdGanancia().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void onRowCancel(RowEditEvent event){
		FacesMessage msg = new FacesMessage("Edición cancelada", ((Ganancias) event.getObject()).getIdGanancia().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void onCellEdit(CellEditEvent event ){
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		System.out.println("verifica: " + newValue);
		if(newValue != null && !newValue.equals(oldValue)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Ganancia modificada", "Antes: "+ oldValue + "Ahora" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}*/
	

	
	// setters y getters
	public Ganancias getGanancia() {
		return ganancia;
	}

	public void setGanancia(Ganancias ganancia) {
		this.ganancia = ganancia;
	}

	public List<Ganancias> getListaGanancias() {
		return listaGanancias;
	}

	public void setListaGanancias(List<Ganancias> listaGanancias) {
		this.listaGanancias = listaGanancias;
	}
	
	public double getTotal() {
		return gananciasService.obtenerTotalGanancias();
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Ganancias> getBuscarGanancias() {
		return buscarGanancias;
	}

	public void setBuscarGanancias(List<Ganancias> buscarGanancias) {
		this.buscarGanancias = buscarGanancias;
	}
	
	
	

}
