
public class ArbolNivel {

	Nodo raiz;
	private int contadorNodos = 0;
	private int contador = 0;
	private int altura;
	private Nodo aux;
	
	public ArbolNivel() {
		
	}
	
	public int getNumeroDeNodos() {
		return contadorNodos;
	}
	
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public boolean existeRaiz() {
		if(this.raiz != null){
			return true;
		}
		return false;
	}
	
	public void insertar(int dato) {	
		if(!existeRaiz()){
			this.raiz = new Nodo(dato);
			this.contadorNodos++;
		}else {
			this.insertarHijos(this.raiz, dato);
		}
	}
	
	private void insertarHijos(Nodo padre, int dato) {
		if(dato > padre.getDato()) {
			if(padre.getHijoDer() == null) {
				padre.setHijoDer(new Nodo(dato));
				this.contadorNodos++;
			}else {
				this.insertarHijos(padre.getHijoDer(), dato);
			}
		}else {
			if(padre.getHijoIzq() == null) {
				padre.setHijoIzq(new Nodo(dato));
				this.contadorNodos++;
			}else {
				this.insertarHijos(padre.getHijoIzq(), dato);
			}
		}
		
	}
	
	public void mostrarArbol() {
	  boolean bandera = false;
	  int n =0;
	  while(bandera == true && contadorNodos == n) {
		  
	  }
	  
	}
	
	public Nodo nivelMasAlto(ArbolNivel arbol) {
		Nodo padre = arbol.getRaiz();
		
		if(padre.getHijoIzq() != null) {		
			contador++;
		}else if (padre.getHijoDer() !=null){
			contador++;
		}
		
		return this.getRaiz();
	}
	
	public Nodo buscadorUltimo(Nodo ultimo) {
		int contador = 1;
		aux = ultimo;
		Nodo tem = ultimo;
		if(ultimo != null) {
			while(altura != contador ) {
				if(tem.getHijoIzq() !=null) {
					tem = tem.getHijoIzq();
					aux = tem;
					contador++;
				}
				if(tem.getHijoDer()!=null) {
					tem = tem.getHijoDer();
					aux = tem;
					contador++;
				}
			}
			return aux;
		}
		return ultimo;
	}
	
	private void retornarAltura (Nodo padre, int nivel)    {
        if (padre != null) {    
            retornarAltura (padre.getHijoIzq(),nivel+1);
            if (nivel>altura)
                altura = nivel;
            retornarAltura (padre.getHijoDer(),nivel+1);
        }
    }

	public  int retornarAltura () {
        altura=0;
        retornarAltura (raiz,1);
        return altura;
    }

	
	
	
	
}
