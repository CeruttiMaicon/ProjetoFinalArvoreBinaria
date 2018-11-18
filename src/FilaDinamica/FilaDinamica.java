package FilaDinamica;

public class FilaDinamica {

	private Elemento cauda;
	private Elemento cabeca;
	public int contador;


	public FilaDinamica() {
		cabeca = cauda = null;
	}

	public int add (Object valor) throws Exception{
		contador++;
		System.out.println("Adicionando " + valor);
		Elemento e = new Elemento(valor);
		if (cauda != null) {
			contador++;
			cauda.setProximo(e);
		}
		cauda = e;
		if (cabeca == null) {
			contador++;
			cabeca = e;
		}
		contador++;
		return contador;
	}

	public Object remove() throws Exception {
		if (this.isEmpty()) throw new Exception("Fila vazia");
		Object o = cabeca.getValor(); //1 Elemento da fila
		cabeca = cabeca.getProximo();
		if (cabeca == null)
			cauda = null;
		System.out.println("Removendo " + o);
		return o;
	}

	

	//se esta cheio
	public boolean isFull() {
		return false;
	}

	//se esta vazio 
	public boolean isEmpty() {
		return cabeca == null && cauda == null;
	}

	public void clear (){
		while (!this.isEmpty()){
			try{
				this.remove();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public int list() {
		contador++;
		Elemento e = cabeca;
		while (e != null){
			contador++;
			System.out.println("Listando " + e.getValor());
			e = e.getProximo();
		}
		return contador;
	}
}
