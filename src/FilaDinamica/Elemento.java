package FilaDinamica;

public class Elemento {

	private Elemento proximo;
	private Object valor;
	
	public Elemento (Object v){
		valor = v;
	}
	
	public Elemento getProximo() {
		return proximo;
	}
	public void setProximo(Elemento e) {
		
		this.proximo = e;
	}
	
	public Object getValor() {
		return valor;
	}

}
