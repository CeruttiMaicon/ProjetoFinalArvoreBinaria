package CSV;

import java.io.FileWriter;
import java.io.IOException;

import ArvoreBinaria.Arvore;
import ArvoreBinaria.BTreePrinter;

public class MainCSVArvoreBinariaAdd {

    public static void main(String[] args) {

        // Fila com os valores Crescentes
        try {
            Popula p = new Popula();
            // Aqui definimos o local de criacao do arquivo CSV, no meu Ubuntu coloquei esta
            // rota
            FileWriter writer = new FileWriter("/home/dev3/Documentos/arrayArvoreBinaria.csv");

            // Faz o cabeçalho do arquivo CSV

            writer.append("ArvoreBinaria-Cresc,");
            writer.append("ArvoreBinaria-Decresc,");
            writer.append("ArvoreBinaria-Aleatorio,");

            writer.append('\n');
            
          //Criando as arvores
            Arvore<Integer> arvore1 = new Arvore<>();
            Arvore<Integer> arvore2 = new Arvore<>();
            Arvore<Integer> arvore3 = new Arvore<>();
            
            for (int n = 1; n <= 100; n++) {
                int[] crescenteVar = new int[n];
                int[] decrescenteVar = new int[n];
                int[] aleatorioVar = new int[n];

                // Adicionando os elementos na filaCrescentes
                p.crescente(crescenteVar);
                p.decrescente(decrescenteVar);
                p.aleatorio(aleatorioVar);

                

                // Escreve no arquivo CSV com a quantidade de interações feitas para executar o algoritmo
                
            	writer.append(arvore1.adiciona(crescenteVar[n-1]) + ",");
            	writer.append(arvore2.adiciona(decrescenteVar[n-1]) + ",");
            	
            	//Mostrar para o Professor Allan
            	// A arvore nao consegue funcionar com valores adicionados aleatoriamente
//                writer.append(arvore3.adiciona(aleatorioVar[n-1]) + ",");
                writer.append('\n');
                
//                System.out.println(aleatorioVar[n-1]);

                // Criando CSV com o array
                // 99 para pegar o array cheio
                if (n == 100) {

                    writer.flush();
                    writer.close();
                    
//                    BTreePrinter.printNode(arvore1.raiz);
                    BTreePrinter.printNode(arvore2.raiz);
//                    BTreePrinter.printNode(arvore3.raiz);
                    System.out.println("\n");
                    System.out.println("Arquivo CSV criado com Sucesso!");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}