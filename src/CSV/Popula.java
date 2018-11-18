package CSV;

import java.util.Random;

public class Popula {
	public int[] crescente (int[] valor)  {
		for (int i = 0; i < valor.length; i++){
			valor[i] = i;
		}
		return valor;
	}
	
	public int[] decrescente (int[] valor)  {
		int gol = 999;
		for (int i = 0; i < valor.length; i++){
			valor[i] = gol - i;
		}
		return valor;
	}
	
	public int[] aleatorio (int[] valor)  {
		for (int i = 0; i < valor.length; i++) {
			Random aleatorio = new Random();
			valor[i] = aleatorio.nextInt(100);
		}
		return valor;
	}
}