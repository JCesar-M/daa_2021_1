
public class Nodo {

	private Nodo hijoIzq;
	private Nodo hijoDer;
	private int dato; 

	public Nodo(int dato){
		 this.hijoIzq = null;
		 this.hijoDer = null;
		 this.dato = dato;
	}
	
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(Nodo hijoIzq) {
		this.hijoIzq = hijoIzq;
	}

	public Nodo getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(Nodo hijoDer) {
		this.hijoDer = hijoDer;
	}
	
}
