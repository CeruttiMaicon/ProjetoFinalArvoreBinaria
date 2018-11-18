package CSV;

import java.io.FileWriter;
import java.io.IOException;

import FilaDinamica.FilaDinamica;

public class MainCSVFilaDinamicaAdd {
	public static void main(String[] args) throws Exception {

        // Fila com os valores Crescentes
        try {
            Popula p = new Popula();
            // Aqui definimos o local de criacao do arquivo CSV, no meu Ubuntu coloquei esta
            // rota
            FileWriter writer = new FileWriter("/home/dev3/Documentos/arrayFilaDinamica.csv");
            
            FilaDinamica filaDinamica1 = new FilaDinamica();
            FilaDinamica filaDinamica2 = new FilaDinamica();
//            FilaDinamica filaDinamica3 = new FilaDinamica();

            // Faz o cabeçalho do arquivo CSV

            writer.append("FilaDinamica-Cresc-Add,");
            writer.append("FilaDinamica-Decresc-Add,");
            writer.append("FilaDinamica-Cresc-List,");
            writer.append("FilaDinamica-Decresc-List,");

            writer.append('\n');
            for (int n = 1; n <= 100; n++) {
                int[] crescenteVar = new int[n];
                int[] decrescenteVar = new int[n];
                int[] aleatorioVar = new int[n];

                // Adicionando os elementos na filaCrescentes
                p.crescente(crescenteVar);
                p.decrescente(decrescenteVar);
                p.aleatorio(aleatorioVar);

               

                // Escreve no arquivo CSV
                writer.append(filaDinamica1.add(crescenteVar[n-1]) + ",");
                writer.append(filaDinamica2.add(decrescenteVar[n-1]) + ",");
                writer.append(filaDinamica1.list() + ",");
                writer.append(filaDinamica2.list() + ",");
//                writer.append(filaDinamica3.add(aleatorioVar) + ",");
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
