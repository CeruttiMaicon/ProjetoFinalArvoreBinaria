package CSV;

import java.io.FileWriter;
import java.io.IOException;

import Deque.Deque;

public class MainCSVDequeAdd {
	public static void main(String[] args) throws Exception {

        // Fila com os valores Crescentes
        try {
            Popula p = new Popula();
            // Aqui definimos o local de criacao do arquivo CSV, no meu Ubuntu coloquei esta
            // rota
            FileWriter writer = new FileWriter("/home/dev3/Documentos/arrayDeque.csv");
            
            Deque deque1 = new Deque();
            Deque deque2 = new Deque();
//            FilaDinamica filaDinamica3 = new FilaDinamica();

            // Faz o cabeçalho do arquivo CSV

            //writer.append("Deque-Cresc-Add,");
            writer.append("Deque-Decresc-Add,");
            //writer.append("Deque-Cresc-Procura-MelhorCaso,");
            writer.append("Deque-Decresc-Procura-PiorCaso,");

            writer.append('\n');
            for (int n = 1; n <= 100; n++) {
                int[] crescenteVar = new int[n];
                int[] decrescenteVar = new int[n];
                

                // Adicionando os elementos na filaCrescentes
                p.crescente(crescenteVar);
                p.decrescente(decrescenteVar);
                

               

                // Escreve no arquivo CSV
                //writer.append(deque1.add(crescenteVar[n-1]) + ",");
                writer.append(deque2.add(decrescenteVar[n-1]) + ",");
                //writer.append(deque1.procura(1) + ",");
                writer.append(deque2.procura(1) + ",");

                writer.append('\n');

                // Criando CSV com o array
                // 99 para pegar o array cheio
                if (n == 100) {

                    writer.flush();
                    writer.close();
                    System.out.println("Arquivo CSV criado com Sucesso!");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
