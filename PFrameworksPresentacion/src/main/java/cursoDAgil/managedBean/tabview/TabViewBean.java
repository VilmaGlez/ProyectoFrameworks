package cursoDAgil.managedBean.tabview;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TabViewBean implements Serializable{
	/**
	*
	*/
	private static final long serialVersionUID = 8712965470767487897L;
	private boolean bandera;
	public TabViewBean(){
	setBandera(true);
	}
	//setter y getters
	public boolean getBandera() {
		return bandera;
	}
	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
}