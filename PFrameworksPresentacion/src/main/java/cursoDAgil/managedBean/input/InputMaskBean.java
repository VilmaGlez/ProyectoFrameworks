package cursoDAgil.managedBean.input;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class InputMaskBean implements Serializable{

	private static final long serialVersionUID = 6684598180534181715L;
	private String date;
	private String phone;
	private String key;
	//método que muestra las mascaras en un growl personalizado
	public void showMask(){
		FacesContext.getCurrentInstance().addMessage("growlMensaje",
				new FacesMessage( FacesMessage.SEVERITY_INFO, "Mascara Primefaces!!", "Date: " + getDate() + " Phone: " + getPhone() + " key: " + getKey()));
	}
	//setters y getters
	public String getDate() {
	return date;
	}
	public void setDate(String date) {
	this.date=date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}