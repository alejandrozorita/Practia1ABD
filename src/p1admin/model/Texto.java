package p1admin.model;

import java.util.Date;


public class Texto extends Mensaje{

	private String texto;
	public Texto(int id, Date fechayHora, Users orig, Users dest, String texto){
		super(id,fechayHora, orig, dest);
		this.texto = texto;
		
	}
	public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
