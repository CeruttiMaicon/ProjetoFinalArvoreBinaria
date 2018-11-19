package Deque;
public class Elemento {
	
	private Elemento proximo;
	private Elemento anterior;
	private Object valor;
	
	public Elemento getProximo() {
		return proximo;
	}
	public void setProximo(Elemento proximo) {
		this.proximo = proximo;
	}
	public Elemento getAnterior() {
		return anterior;
	}
	public void setAnterior(Elemento anterior) {
		this.anterior = anterior;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	

}
