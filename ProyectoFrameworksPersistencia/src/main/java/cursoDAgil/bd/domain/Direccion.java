package cursoDAgil.bd.domain;

public class Direccion {

	private Integer idDireccion;
	private String calle;
	private Integer numero;
	private String colonia;
	private String ciudad;
	private String estado;
	private String pais;
	private Integer codigoPostal;
	
	
	public Integer getIdDireccion(){
		return idDireccion;
	}
	public void setIdDireccion(Integer idDireccion){
		this.idDireccion=idDireccion;
	}
	
	public String getCalle(){
		return calle;
	}
	public void  setCalle(String calle){
		this.calle=calle;
	}
	
	public String getCiudad(){
		return ciudad;
	}
	public void setCiudad(String ciudad){
		this.ciudad=ciudad;
	}
	
	public Integer getCodigoPostal(){ return codigoPostal;}
	public void setCodigoPostal(Integer codigoPostal){this.codigoPostal=codigoPostal;}
	
	public Integer getNumero(){return numero;}
	public void setNumero(Integer numero){this.numero=numero;}
	
	public String getColonia(){return colonia;}
	public void setColonia(String colonia){this.colonia=colonia;}
	
	public String getEstado(){return estado;}
	public void setEstado(String estado){this.estado=estado;}
	
	public String getPais(){return pais;}
	public void setPais(String pais){this.pais=pais;}
	
	/**/
	
	public boolean equals(Object object){
		if(!(object instanceof Direccion)){
			return false;
		}
		Direccion regDireccion = (Direccion) object;
		 return (this.idDireccion == regDireccion.idDireccion);
	}
}
