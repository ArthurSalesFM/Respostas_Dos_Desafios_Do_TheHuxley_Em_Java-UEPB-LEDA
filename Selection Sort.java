/******************************************************************************

Descrição
O algoritmo Selection Sort é um algoritmo de ordenação que funciona da seguinte forma: dada uma sequência de elementos em um array A (neste exercício, consideramos apenas números), procuramos inicialmente o menor elemento de A e o colocamos na primeira posição de A (trocando de lugar com a posição onde ele estava anteriormente). Em seguida, procuramos pelo segundo menor elemento de A, e o colocamos na segunda posição do array. Continuamos repetindo esta tarefa para os primeiros n-1 elementos de A.

Neste exercício, deve ser implementado o algoritmo Selection Sort, ilustrando o passo a passo de execução do algoritmo, conforme detalhado no formato de entrada e saída abaixo.

Formato de entrada

A entrada é constituída por uma linha contendo uma sequência de números a serem ordenados. 

Formato de saída

Para cada chave, a saída deve imprimir o passo-a-passo de cada modificação efetuada pelo algoritmo, imprimindo o conteúdo do vetor entre barras verticais e o menor elemento encontrado naquele passo. Entre uma passada e outra deve ser impressa uma linha em branco. 

Ao final da ordenação, deve ser impresso o resultado final da execução do algoritmo. 

*******************************************************************************/
import java.util.*;

public class /*Main*/ HuxleyCode{

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> valores = new ArrayList<>();

        while (entrada.hasNext()) {
            valores.add(entrada.nextInt());
        }

        selectionSort(valores);
    }

    private static void selectionSort(List<Integer> lista) {
        int tamanho = lista.size();
        
        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < tamanho; j++) {
                if (lista.get(j) < lista.get(indiceMinimo)) {
                    indiceMinimo = j;
                }
            }

            int temp = lista.get(indiceMinimo);
            System.out.println("Menor elemento neste passo: " + temp);
            lista.set(indiceMinimo, lista.get(i));
            lista.set(i, temp);
            imprime(lista, "Estado Atual: ");
        }
        imprime(lista, "Resultado Final: ");
    }

    private static void imprime(List<Integer> lista, String frase) {
        System.out.print(frase);
        for (int i = 0; i < lista.size(); i++) {
            if (i == lista.size() - 1) {
                System.out.print(lista.get(i));
            } else {
                System.out.print(lista.get(i) + " | ");
            }
        }
        System.out.println("\n");
    }
}
