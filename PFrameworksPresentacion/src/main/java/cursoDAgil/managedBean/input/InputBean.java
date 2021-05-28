package cursoDAgil.managedBean.input;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class InputBean implements Serializable {
		
		private static final long serialVersionUID = -3116035240953333203L;
		private String inputText;
		private Integer inputInteger;
		private Double inputDouble;
		private String email;
		public void validado(){
			FacesContext.getCurrentInstance().addMessage(null, new
			FacesMessage(FacesMessage.SEVERITY_INFO, "campos validos", null));
			System.out.print("Campos validados:" + getInputText());
		}
		//Getter's y setter's
		public String getInputText() {
			return inputText;
		}
		public void setInputText(String inputText){
			this.inputText=inputText;
		}
		public Integer getInputInteger() {
			return inputInteger;
		}
		public void setInputInteger(Integer inputInteger){
			this.inputInteger=inputInteger;
		}
		public Double getInputDouble() {
			return inputDouble;
		}
		public void setInputDouble(Double inputDouble){
			this.inputDouble=inputDouble;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
}