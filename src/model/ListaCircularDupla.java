package model;

public class ListaCircularDupla<T> {
	private Node<T> inicio = null;
	private Node<T> fim = null;
	
	public void append(T elemento) {
		Node<T> novo = new Node<>(elemento);
		
		if(this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
			
			this.inicio.setProximo(this.fim);
			this.inicio.setAnterior(this.fim);
			
			this.fim.setProximo(this.inicio);
			this.fim.setAnterior(this.inicio);
		}else {
			Node<T> anterior = this.fim;
			anterior.setProximo(novo);
			novo.setAnterior(anterior);
			novo.setProximo(this.inicio);
			this.fim = novo;
		}
	}
	
	public Node<T> get(int index) throws Exception{
		if(this.inicio == null) {
			throw new Exception("A lista está vazia");
		}
		
		if(index == 0) {
			return this.inicio;
		}
		
		Node<T> buffer = this.inicio;
		
		int i = 0;
		for(i = 0; i < index; i++) {
			if(buffer.getProximo() == this.inicio)
				break;
			
			buffer = buffer.getProximo();
		}
		
		if(i < index)
			throw new Exception("O índice não existe");
		
		return buffer;
	}
	
	public int index(T elemento) throws Exception {
		if(this.inicio.getElemento() == elemento)
			return 0;
		
		Node<T> buffer = this.inicio;
		int i = 0;
		while(buffer.getProximo() != this.inicio) {
			buffer = buffer.getProximo();
			++i;
			if(buffer.getElemento() == elemento)
				break;
		}
		if(buffer.getElemento() != elemento) {
			throw new Exception("Elemento não encontrado");
		}
		
		return i;
	}
	
	public void prepend(T elemento) {
		Node<T> novo = new Node<>(elemento);
		
		if(this.inicio == null) {
			append(elemento);
		}else {
			Node<T> proximo = this.inicio;
			
			proximo.setAnterior(novo);
			novo.setProximo(proximo);
			novo.setAnterior(this.fim);
			this.fim.setProximo(novo);
			this.inicio = novo;
		}
	}
	
	public void insert(int index, T elemento) throws Exception {
		if(index == 0) {
			prepend(elemento);
		}else if(index >= getSize()) {
			append(elemento);
		}else {
			Node<T> anterior = get((index -1));
			Node<T> proximo = anterior.getProximo();
			Node<T> novo = new Node<>(elemento);
			
			anterior.setProximo(novo);
			proximo.setAnterior(novo);
			novo.setAnterior(anterior);
			novo.setProximo(proximo);
		}
	}
	
	public int getSize() throws Exception {
		if(this.inicio == null) {
			throw new Exception("A lista está vazia");
		}
		
		int size = 1;
		Node<T> buffer = this.inicio;
		
		while(buffer.getProximo() != this.inicio) {
			++size;
			buffer = buffer.getProximo();
		}
		
		return size;
	}
	
	public void remove(int index) throws Exception {
		Node<T> removido = get(index);
		
		if(index == 0) {
			Node<T> novoInicio = removido.getProximo();
			novoInicio.setAnterior(this.fim);
			this.fim.setProximo(novoInicio);
			this.inicio = novoInicio;
			
			removido.setAnterior(null);
			removido.setProximo(null);
			removido.setElemento(null);
			
		}else if(index >= getSize()) {
			throw new Exception("Índice inválido para remoção");
		}else {
			Node<T> anterior = removido.getAnterior();
			Node<T> proximo = removido.getProximo();
			
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			
			removido.setAnterior(null);
			removido.setProximo(null);
			removido.setElemento(null);
		}
	}
	
	public Node<T> getLast(){
		return this.fim;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		
		Node<T> buffer = this.inicio;
		builder.append(buffer.getElemento());
		
		while(buffer.getProximo() != this.inicio) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getElemento());
		}
		
		builder.append("]");
		return builder.toString();
	}
}
