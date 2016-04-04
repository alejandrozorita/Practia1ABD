package p1admin.model;


public class Opcion {
	private Pregunta preguntaMadre;
	private int numeroOrden;
	private int id_opcion;
	private String texto;
	
	public Opcion(int id_opcion, Pregunta preguntaMadre, int numeroOrden, String texto) {
		this.id_opcion = id_opcion;
		this.preguntaMadre = preguntaMadre;
		this.numeroOrden = numeroOrden;
		this.texto = texto;
	}

	public Opcion() {
		// TODO Auto-generated constructor stub
	}

	public Pregunta getPreguntaMadre() {
		return preguntaMadre;
	}

	public void setPreguntaMadre(Pregunta preguntaMadre) {
		this.preguntaMadre = preguntaMadre;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getTexto() {
		return texto;
	}

	public void setIdOpcion(int idOpcion) {
		this.id_opcion = idOpcion;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + numeroOrden + ") " + texto;
	}

	public void setIdRespuesta(int id) {
		// TODO Auto-generated method stub
		this.id_opcion = id;
	}
}
