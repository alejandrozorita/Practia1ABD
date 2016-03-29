package p1admin.model;

import java.util.Date;

public class Mensaje {
	private int idMensaje;
	private Date fechayHora;
	private boolean leido;
	private Users userOrig;
	private Users userDest;
	
	public Mensaje(int idMensaje, Date fechayHora, Users userOrig, Users userDest){
		this.idMensaje = idMensaje;
		this.fechayHora = fechayHora;
		this.leido = false;
		this.userDest = userDest;
		this.userOrig = userOrig;
	}

	public int getIdMensaje(){
		return this.idMensaje;
	}
	public Date getFechayHora(){
		return this.fechayHora;
	}
	public boolean getLeido(){
		return this.leido;
	}
	public Users getUserOrig(){
		return this.userOrig;
	}
	public Users getUserDest(){
		return this.userDest;
	}
	public void setFechayHora(Date fechayHora){
		this.fechayHora = fechayHora;
	}
	public void setUserOrig(Users origen){
		this.userOrig = origen;
	}
	public void getUserDest(Users dest){
		this.userDest = dest;
	}
}
