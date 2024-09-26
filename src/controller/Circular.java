package controller;
import model.ListaCircularDupla;

public class Circular {

	public static void main(String[] args) {
		ListaCircularDupla<Object> lista = new ListaCircularDupla<Object>();
		
		try {
			lista.append(1);
			lista.append(5);
			lista.prepend("prepend");
			lista.insert(2, "insert 2");
			lista.insert(3, "insert 3");
			System.out.println("index: "+lista.index("insert 2"));
			System.out.println(lista.toString());
			
			lista.remove(0);
			lista.remove(lista.getSize()-1);
			lista.remove(1);
			
			System.out.println(lista.toString());
			System.out.println("Tamanho: "+lista.getSize());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
