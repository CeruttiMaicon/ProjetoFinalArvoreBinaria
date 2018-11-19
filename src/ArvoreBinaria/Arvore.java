package ArvoreBinaria;

public class Arvore<T extends Comparable<T>> {
	public No<T> raiz;
	public int contador;

	public int adiciona(T valor) {
		No<T> no = null;
		contador++;
		if (this.raiz == null) {
			contador++;
			no = new No<T>(valor);
			this.raiz = no;
		} else {  
			contador++;
			no = this.adiciona(this.raiz, valor);
		}
		contador++;
		this.verificaFB(no);
		return contador;
	}

	private No<T> adiciona(No<T> no, T valor) {
		if (no.valor.compareTo(valor) < 0) {
			contador++;
			if (no.direita == null) {
				No<T> novo = new No<T>(valor);
				novo.pai = no;
				no.direita = novo;
				contador++;
				return novo;
			} else {
				contador++;
				return this.adiciona(no.direita, valor);
			}
		} else {
			contador++;
			if (no.esquerda == null) {
				No<T> novo = new No<T>(valor);
				novo.pai = no;
				no.esquerda = novo;
				contador++;
				return novo;
			} else {
				contador++;
				return this.adiciona(no.esquerda, valor);
			}
		}
	}

	public int fb(No<T> no) {
		int esquerda = 0, direita = 0;

		if (no.esquerda != null) {
			esquerda = altura(no.esquerda) + 1;
			
		}

		if (no.direita != null) {
			direita = altura(no.direita) + 1;
			
		}
		
		return esquerda - direita;
	}

	private int altura(No<T> no){
		int esquerda = 0, direita = 0;

		if (no.esquerda != null) {
			esquerda = altura(no.esquerda) + 1;
			
		}

		if (no.direita != null) {
			direita = altura(no.direita) + 1;
			
		}
		
		return esquerda > direita ? esquerda : direita;
	}


	public No<T> rse(No<T> no) {
		No<T> pai = no.pai;
		No<T> direita = no.direita;
		
		no.pai = direita;
		no.direita = direita.esquerda;
		
		if (no.direita != null) {
			no.direita.pai = no;
			
		}

		direita.esquerda = no;
		direita.pai = pai;
		
		if (pai == null) {
			raiz = direita;
			
		} else {
			
			if (direita.valor.compareTo(pai.valor) < 0) {
				pai.esquerda = direita;
				
			} else {
				pai.direita = direita;
				
			}
		}
		
		return direita;
	}

	public No<T> rsd(No<T> no) {
		No<T> pai = no.pai;
		No<T> esquerda = no.esquerda;
		
		no.pai = esquerda;
		no.esquerda = esquerda.direita;
		
		if (no.esquerda != null) {
			no.esquerda.pai = no;
			
		}

		esquerda.direita = no;
		esquerda.pai = pai;
		

		if (pai == null) {
			raiz = esquerda;
			
		} else {
			
			if (esquerda.valor.compareTo(pai.valor) < 0) {
				
				pai.esquerda = esquerda;
			} else {
				
				pai.direita = esquerda;
			}
		}
		
		return esquerda;
	}

	public No<T> rde(No<T> no) {
		
		no.direita = rsd(no.direita);
		return rse(no);
	}

	public No<T> rdd(No<T> no) {
		
		no.esquerda = rse(no.esquerda);
		return rsd(no);
	}
	
	private void verificaFB(No<T> no) {
		
		if (no != null) {
			
			balancear(no);
			verificaFB(no.pai);
		}
	}
	
	private void balancear(No<T> no) {
		int fb = fb(no);
		
		if (fb < -1) {
			
			if (fb(no.direita) < 0) {
				
				rse(no);
			} else {
				
				rde(no);
        	}
		} else if (fb > 1) {
			
			if (fb(no.esquerda) > 0) {
				
				rsd(no);
			} else {
				
				rdd(no);
			}
		}
	}
	
	
	
	public int localizar(T valor) {
		contador++;
		this.localizar(this.raiz, valor);
		
		return contador;
	}

	private No<T> localizar(No<T> no, T valor) {
		contador++;
		if (no != null) {
			contador++;
			if (no.valor.equals(valor)) {
				contador++;
				return no;
			}
			contador++;
			No<T> aux = localizar(no.esquerda, valor);
			if (aux != null) {
				contador++;
				return aux;
			}
			contador++;
			aux = localizar(no.direita, valor);
			if (aux != null) {
				contador++;
				return aux;
			}
			contador++;
  		}
		contador++;
		return null;
	}
}
