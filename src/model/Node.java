package model;

public class Node<T>{
	private T elemento;
	private Node<T> proximo;
	private Node<T> anterior;
	
	public Node(T elemento) {
		this.elemento = elemento;
		this.proximo = null;
		this.anterior = null;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public Node<T> getProximo() {
		return proximo;
	}

	public void setProximo(Node<T> proximo) {
		this.proximo = proximo;
	}

	public Node<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Node<T> anterior) {
		this.anterior = anterior;
	}
	
	@Override
	public String toString() {
		return elemento.toString();
	}
}
