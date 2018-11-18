package CSV;

import java.io.FileWriter;
import java.io.IOException;
public class MainCSV {

    public static void main(String[] args) {

        // Fila com os valores Crescentes
        try {
            Popula p = new Popula();
            // Aqui definimos o local de criacao do arquivo CSV, no meu Ubuntu coloquei esta
            // rota
            FileWriter writer = new FileWriter("/home/dev3/Documentos/arrayInsertionSort.csv");

            // Faz o cabeçalho do arquivo CSV

            writer.append("InsertionSort-Cresc,");
            writer.append("InsertionSort-Decresc,");
            writer.append("InsertionSort-Aleatorio,");

            writer.append('\n');
            for (int n = 1; n <= 100; n++) {
                int[] crescenteVar = new int[n];
                int[] decrescenteVar = new int[n];
                int[] aleatorioVar = new int[n];

                // Adicionando os elementos na filaCrescentes
                p.crescente(crescenteVar);
                p.decrescente(decrescenteVar);
                p.aleatorio(aleatorioVar);

                InsertionSort insertionsort1 = new InsertionSort();
                InsertionSort insertionsort2 = new InsertionSort();
                InsertionSort insertionsort3 = new InsertionSort();

                // Escreve no arquivo CSV
                writer.append(insertionsort1.recebeVetor(crescenteVar) + ",");
                writer.append(insertionsort2.recebeVetor(decrescenteVar) + ",");
                writer.append(insertionsort3.recebeVetor(aleatorioVar) + ",");
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