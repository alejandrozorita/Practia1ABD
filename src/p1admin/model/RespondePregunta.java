package p1admin.model;


public class RespondePregunta {

	private int relevancia;
	private Opcion numero;

	public RespondePregunta(int relevancia, Opcion numero) {
		this.relevancia = relevancia;
		this.numero = numero;
	}

	public int getRelevancia() {
		return relevancia;
	}
	public Opcion getNumeroOpcion(){
		return this.numero;
	}

	public void setRelevancia(int relevancia) {
		this.relevancia = relevancia;
	}
	public void setNumeroOpcion(Opcion opcion) {
		this.numero = opcion;
	}
}
