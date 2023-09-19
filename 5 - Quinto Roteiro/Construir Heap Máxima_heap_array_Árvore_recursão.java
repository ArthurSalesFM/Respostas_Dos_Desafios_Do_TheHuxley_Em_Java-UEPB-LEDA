/******************************************************************************

Descrição
Este exercício tem como objetivo a implementação do algoritmo build-max-heap, como descrito em 
"Introduction to Algorithms", por Cormen et al. 
A ideia é aplicar a operação max-heapify repetidamente de maneira bottom-up, construindo a max-heap de baixo pra cima. 

O pseudo-código do algoritmo está descrito abaixo: 



A função build-max-heap faz uso de max-heapify, cujo pseudo-código segue abaixo: 



Formato de entrada

A entrada é constituída por uma linha contendo uma sequência de números a serem organizados na forma de uma max-heap.

Formato de saída

A entrada deve ser impressa separada por barras verticais, como no exemplo. 
A cada passo do algoritmo, o estado atual da heap deve ser exibido usando a mesma formatação. 
Ao final, deve ser impresso o resultado da execução do algoritmo.

*******************************************************************************/

import java.util.*;

public class Main /*HuxleyCode*/ {
    public static void main(String[] args) {
        List<Integer> listaDeValoresIniciais = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int vetorDeValores[];
        
        while (entrada.hasNext()) {
            int numero = entrada.nextInt();
            listaDeValoresIniciais.add(numero);
        }

        vetorDeValores = new int[listaDeValoresIniciais.size()];
        copiarListaParaVetor(listaDeValoresIniciais, vetorDeValores);

        System.out.println("Estado inicial: " + imprimeVetor(vetorDeValores, 0, vetorDeValores.length));

        construirHeapMaximo(vetorDeValores);

        System.out.println("Resultado Final: " + imprimeVetor(vetorDeValores, 0, vetorDeValores.length));
    }

    private static void copiarListaParaVetor(List<Integer> lista, int[] vetor) {
        
        for (int i = 0; i < lista.size(); i++) {
            vetor[i] = lista.get(i);
        }
    }

    private static void construirHeapMaximo(int[] arr) {
        int tamanhoDoHeap = arr.length;
        
        for (int i = tamanhoDoHeap / 2; i >= 1; i--) {
            maxHeapify(arr, i, tamanhoDoHeap);
            System.out.println("Estado Atual: " + imprimeVetor(arr, 0, arr.length));
        }
    }

    private static void maxHeapify(int[] arr, int i, int tamanhoDoHeap) {
        int esquerda = 2 * i;
        int direita = 2 * i + 1;
        int maior;

        if (esquerda <= tamanhoDoHeap && arr[esquerda - 1] > arr[i - 1]) {
            maior = esquerda;
        } 
        else {
            maior = i;
        }

        if (direita <= tamanhoDoHeap && arr[direita - 1] > arr[maior - 1]) {
            maior = direita;
        }

        if (maior != i) {
            int temp = arr[i - 1];
            arr[i - 1] = arr[maior - 1];
            arr[maior - 1] = temp;

            maxHeapify(arr, maior, tamanhoDoHeap);
        }
    }

    private static String imprimeVetor(int vetor[], int inicio, int fim) {
        String saida = "";

        for (int i = inicio; i < fim; i++) {
            if (i == fim - 1) {
                saida += vetor[i];
            } else {
                saida += vetor[i] + " | ";
            }
        }
        return saida;
    }
}
