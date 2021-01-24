import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ArbolNivel {

	Nodo raiz;
	private int contadorNodos = 0;
	private int contador = 1;
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
	
	public Nodo buscadoUltimo(Nodo ultimo) {
		if(altura != contador) {
			if(ultimo.getHijoIzq() !=null){
				contador++;
				buscadoUltimo(ultimo.getHijoIzq());
			}else {
				if(ultimo.getHijoDer() !=null){
					contador++;
					buscadoUltimo(ultimo.getHijoDer());
				}
			}
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
        retornarAltura (raiz,1);
        return altura;
    }
	
	public Nodo buscador(int dato) {
		if( busqueda(raiz, dato) != null) {
			if(dato == busqueda(raiz, dato).getDato()) {
				return busqueda(raiz, dato);
			}
		}else {
			return null;
		}
		return null;
	}
	
	public Nodo busqueda(Nodo padre,int dato) {
		if(padre != null) {
			if(dato == padre.getDato()) {
				return padre;
			}else if(dato > padre.getDato()){
				return busqueda(padre.getHijoDer(), dato);
			}else if(dato < padre.getDato()){
				return busqueda(padre.getHijoIzq(), dato);
			}
		}
		return null;
	}
	
	
	private Nodo eliminarNodo(Nodo aux, int dato) {	 // El metodo consiste en buscar el nodo mayor del arbol de lado iquierdo.
		if(aux == null) { 
			System.out.println("El nodo no se encontro");
		}else if(dato < aux.getDato()) { // Se busca el dato por el lado izquierdo.
			Nodo izq = eliminarNodo(aux.getHijoIzq(), dato);
			aux.setHijoIzq(izq);
		}else if (dato > aux.getDato()) { // Se busca el dato por el lado derecho.
			Nodo der = eliminarNodo(aux.getHijoDer(), dato);
			aux.setHijoIzq(der);
		}else { // Un vez encontrado se ejecuta el else.
			Nodo n = aux;  
			if(n.getHijoDer() == null) {// si el nodo del lado derecho es igual  null se captura el nodo izquierdo.
				aux = n.getHijoIzq(); 
			}else if (n.getHijoIzq() == null) {// si el nodo del lado izquierdo es igual  null se captura el nodo izquierdo.
				aux = n.getHijoDer();
			}else { // Si el nodo a eliminar tiene dos hijos entonces hacemos cambiamos los lugaresa para despues eliminarlo. 
				n = cambiar(n);
			}
			n = null; // ELiminamos el nodo.
		}
		return aux;
	}
	
	public void eliminarNodo_Dat(int dato) { // llamamos al metodo eliminar Nodo. 
	   raiz = eliminarNodo(raiz, dato);
	}
	
	private Nodo cambiar (Nodo aux) {//Metodo para intercambiar los nodos que resultan afectados por la eliminacion del nodo a eliminar. 
		Nodo n = aux;
		Nodo m = aux.getHijoIzq(); 
		while (m.getHijoDer() != null) {//el while sirve para recorrer el lado derecho para encotrar el dato mayor. 
			n = m; // se guarda el nodo.
			m = m.getHijoDer();
		}
		aux.setDato(m.getDato()); // se establece el dato del nodo mayor para que de ese nodo se hagan los cambios.  
		if(n == aux) { // Si el nodo igual a aux entonces el dato y nodo que se van a eliminar por lo tanto se hacen los comabios. 
			n.setHijoIzq(m.getHijoIzq());
		}else {
			n.setHijoDer(m.getHijoIzq());
		}
		return n;
	}
	
	public void recorridoIN(Nodo nodo) {// recorrido inorden. 
		if(nodo!=null) {
			recorridoIN(nodo.getHijoIzq());
			System.out.print(nodo.getDato()+",");
			recorridoIN(nodo.getHijoDer());
		}
	}
	
}
