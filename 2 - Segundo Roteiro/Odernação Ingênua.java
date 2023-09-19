/******************************************************************************

Descrição
Dado um conjunto de n valores inteiros, ordene-os em ordem crescente.

Formato de entrada

Um inteiro n indicando quantos números serão fornecidos, seguidos de n inteiros separados por um final de linha

Formato de saída

A sequência de n números ordenada em ordem crescente, obedecendo ao seguinte formato:
[numero][numero][numero][numero]
Onde depois do último número existe um final de linha.

*******************************************************************************/

import java.util.*;

public class HuxleyCode {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        
        int[] vetor;
        int tamanho = 0;

        //System.out.print("Digite o tamanho do vetor: ");
        tamanho = entrada.nextInt();

        vetor = new int[tamanho];

        preencheVetor(vetor);

        int[] vetorOrdenado = ordenacao(vetor);
        imprime(vetorOrdenado);
    }

    public static void preencheVetor(int[] vetor) {
        for (int x = 0; x < vetor.length; x++) {
            //System.out.print("Digite o " + (x + 1) + "� valor: ");
            vetor[x] = entrada.nextInt();
        }
    }

    public static int[] ordenacao(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            boolean trocas = false;

            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocas = true;
                }
            }

            // Se não houve trocas nesta iteração o vetor já está ordenado
            if (!trocas) {
                break;
            }
        }

        return vetor;
    }

    public static void imprime(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("[" + vetor[i] + "]");
        }
        System.out.print("\n");
    }
}