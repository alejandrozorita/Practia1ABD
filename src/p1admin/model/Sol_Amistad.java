package p1admin.model;

import java.util.Date;

public class Sol_Amistad extends Mensaje {
	private String texto;
	private boolean respuesta;

	public Sol_Amistad(int idMensaje, Date fechayHora, Users userOrig, Users userDest, String texto) {
		super(idMensaje, fechayHora, userOrig, userDest);
		// TODO Auto-generated constructor stub
		this.texto = texto;
		this.respuesta = false;

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
