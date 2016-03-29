package p1admin.model;

import java.util.Date;


public class InvitacionPregunta extends Mensaje {

	private Pregunta pregunta;
	public InvitacionPregunta(int idMensaje, Date fechayHora, Users userOrig, Users userDest, Pregunta pregunta) {
		super(idMensaje, fechayHora, userOrig, userDest);
		// TODO Auto-generated constructor stub
		this.pregunta = pregunta;
	}

	public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
