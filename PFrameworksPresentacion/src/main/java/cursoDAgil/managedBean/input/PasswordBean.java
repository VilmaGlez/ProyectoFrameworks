package cursoDAgil.managedBean.input;

import java.io.Serializable;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name="pwdBean")
@ViewScoped
public class PasswordBean implements Serializable{

	/**
	*
	*/
	private static final long serialVersionUID = 915436025790097173L;
	private String password="";
	private String pwd1="";
	private String pwd2="";
	public void showPassword(){
		System.out.println("entra ?");
		
		FacesContext.getCurrentInstance().addMessage("growlMensaje", 
				new FacesMessage( FacesMessage.SEVERITY_INFO, "Password Primefaces!!!", "Password correcto: " + getPassword()));
		}
		public void compararPassword(){
		if(getPwd1().equals(getPwd2()))
		FacesContext.getCurrentInstance().addMessage("growlMensaje2",
		new FacesMessage( FacesMessage.SEVERITY_INFO, "Password Primefaces!!!","los passwords son los mismos: " + getPwd1()));
		else
		FacesContext.getCurrentInstance().addMessage("growlMensaje2",new FacesMessage( FacesMessage.SEVERITY_INFO,
				"Password Primefaces!!!","los passwords son diferentes: " + getPwd1()+ " != " + getPwd2()));
	}
//setter y getter
public String getPassword(){
	return password;
}

public String getPwd1(){
	return pwd1;
}

public String getPwd2(){
	return pwd2;
}

}