
public class Prueba {
	public static void main(String[] args) {
	
	
	ArbolNivel arbol = new ArbolNivel();	
	
	arbol.insertar(8);
	arbol.insertar(3);
	arbol.insertar(10);
	arbol.insertar(1);
	arbol.insertar(6);
	arbol.insertar(14);
	arbol.insertar(7);
	arbol.insertar(13);
	
	System.out.println("\n Primer arbol\n");
	System.out.println("La altura es: "+arbol.retornarAltura());
	System.out.println("El nodo es: "+arbol.buscadorUltimo(arbol.getRaiz()));
	Nodo a = arbol.buscadorUltimo(arbol.getRaiz());
	System.out.println("El valor de nodo es: "+a.getDato());
	
	
	ArbolNivel arbol2 = new ArbolNivel();
	
	arbol2.insertar(8);
	arbol2.insertar(7);
	arbol2.insertar(9);
	arbol2.insertar(6);
	arbol2.insertar(10);
	arbol2.insertar(5);
	arbol2.insertar(11);
	arbol2.insertar(4);
	arbol2.insertar(12);
	
	System.out.println("\n Segundo arbol\n");
	
	System.out.println("La altura es: "+arbol2.retornarAltura());
	System.out.println("El nodo es: "+arbol2.buscadorUltimo(arbol2.getRaiz()));
	Nodo a2 = arbol2.buscadorUltimo(arbol2.getRaiz());
	System.out.println("El valor de nodo es: "+a2.getDato());
	
	
	ArbolNivel arbol3 = new ArbolNivel();
	

	arbol3.insertar(20);
	arbol3.insertar(15);
	arbol3.insertar(25);
	arbol3.insertar(16);
	arbol3.insertar(30);
	arbol3.insertar(14);
	arbol3.insertar(24);
	
	System.out.println("\n Tercer arbol\n");
	
	System.out.println("La altura es: "+arbol3.retornarAltura());
	System.out.println("El nodo es: "+arbol3.buscadorUltimo(arbol3.getRaiz()));
	Nodo a3 = arbol3.buscadorUltimo(arbol3.getRaiz());
	System.out.println("El valor de nodo es: "+a3.getDato());
	
	}
}
