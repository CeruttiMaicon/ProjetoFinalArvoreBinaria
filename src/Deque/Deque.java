package Deque;
public class Deque {
	
	private Elemento cabeca;
	private Elemento cauda;
	
	int contador;	
	
	public Deque(){
		cabeca = cauda = null;
	}
	
	public int add(Object o){
		Elemento e = new Elemento();
		e.setValor(o);		
		contador++;
		if(cauda != null){
			contador++;
			cauda.setProximo(e);
		}
		contador++;
		e.setAnterior(cauda);
		cauda = e;
		if(cabeca == null){
			contador++;
			cabeca = cauda;
		}
		return contador;
	}
	
	public void addFirst(Object o){
		contador++;
		Elemento e = new Elemento();
		e.setValor(o);		
		if(cabeca != null){
			contador++;
			cabeca.setAnterior(e);
		}
		contador++;
		e.setProximo(cabeca);
		cabeca = e;
		if (cauda == null){
			contador++;
			cabeca = cauda;
		}
	}
	
	public Object remove(){
		if (!isEmpty()){
			Object o = cabeca.getValor();
			cabeca = cabeca.getProximo();			
			if (cabeca == null){
				cauda = null;
			}else{
				cabeca.setAnterior(null);
			}
			System.out.println("Removendo " + o);
			return o;
		}
		return null;
	}
	
	public Object removeLast(){
		if (!isEmpty()){
			Object o = cauda.getValor();
			cauda = cauda.getAnterior();			
			if (cauda == null){
				cabeca = null;
			}else{
				cauda.setProximo(null);
			}
			System.out.println("Removendo " + o);
			return o;			
		}
		return null;
	}
	
	public boolean isEmpty(){
		return cauda == null && cabeca == null;
	}
	
	public void clear(){
		while (!this.isEmpty()){
			try{
				this.remove();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public int procura(Object value){		
		Elemento e = cabeca;
		contador++;
		while (e != null){
			contador++;
			System.out.println("Listando " + e.getValor());
			contador++;
			if (e.getValor().equals(value)){
				contador++;
				return contador;
			}
			e = e.getProximo();			
		}
		return contador;
	}
}