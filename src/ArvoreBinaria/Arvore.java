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
			contador++;
		}

		if (no.direita != null) {
			direita = altura(no.direita) + 1;
			contador++;
		}
		contador++;
		return esquerda - direita;
	}

	private int altura(No<T> no){
		int esquerda = 0, direita = 0;

		if (no.esquerda != null) {
			esquerda = altura(no.esquerda) + 1;
			contador++;
		}

		if (no.direita != null) {
			direita = altura(no.direita) + 1;
			contador++;
		}
		contador++;
		return esquerda > direita ? esquerda : direita;
	}


	public No<T> rse(No<T> no) {
		No<T> pai = no.pai;
		No<T> direita = no.direita;
		contador++;
		no.pai = direita;
		no.direita = direita.esquerda;
		
		if (no.direita != null) {
			no.direita.pai = no;
			contador++;
		}

		direita.esquerda = no;
		direita.pai = pai;
		contador++;
		if (pai == null) {
			raiz = direita;
			contador++;
		} else {
			contador++;
			if (direita.valor.compareTo(pai.valor) < 0) {
				pai.esquerda = direita;
				contador++;
			} else {
				pai.direita = direita;
				contador++;
			}
		}
		
		return direita;
	}

	public No<T> rsd(No<T> no) {
		No<T> pai = no.pai;
		No<T> esquerda = no.esquerda;
		contador++;
		no.pai = esquerda;
		no.esquerda = esquerda.direita;
		
		if (no.esquerda != null) {
			no.esquerda.pai = no;
			contador++;
		}

		esquerda.direita = no;
		esquerda.pai = pai;
		contador++;

		if (pai == null) {
			raiz = esquerda;
			contador++;
		} else {
			contador++;
			if (esquerda.valor.compareTo(pai.valor) < 0) {
				contador++;
				pai.esquerda = esquerda;
			} else {
				contador++;
				pai.direita = esquerda;
			}
		}
		contador++;
		return esquerda;
	}

	public No<T> rde(No<T> no) {
		contador++;
		no.direita = rsd(no.direita);
		return rse(no);
	}

	public No<T> rdd(No<T> no) {
		contador++;
		no.esquerda = rse(no.esquerda);
		return rsd(no);
	}
	
	private void verificaFB(No<T> no) {
		contador++;
		if (no != null) {
			contador++;
			balancear(no);
			verificaFB(no.pai);
		}
	}
	
	private void balancear(No<T> no) {
		int fb = fb(no);
		contador++;
		if (fb < -1) {
			contador++;
			if (fb(no.direita) < 0) {
				contador++;
				rse(no);
			} else {
				contador++;
				rde(no);
        	}
		} else if (fb > 1) {
			contador++;
			if (fb(no.esquerda) > 0) {
				contador++;
				rsd(no);
			} else {
				contador++;
				rdd(no);
			}
		}
	}
	
	//Copiado esta estrutura da arvore do projeto do allan. Implementar os contadores e fazer retornar o numero de interações
	public No<T> localizar(T valor) {
		return this.localizar(this.raiz, valor);
	}

	private No<T> localizar(No<T> no, T valor) {
		if (no != null) {
			if (no.valor.equals(valor)) {
				return no;
			}
    
			No<T> aux = localizar(no.esquerda, valor);
			if (aux != null) {
				return aux;
			}
			
			aux = localizar(no.direita, valor);
			if (aux != null) {
				return aux;
			}
  		}
		
		return null;
	}
}
