/******************************************************************************

Descrição
Implemente a estratégia de bubble sort para ordenar os n maiores números de uma sequência de inteiros passada como parâmetro.

Formato de entrada

A entrada consiste de duas linhas de valores. Na primeira linha, o valor correspondente ao tamanho do vetor a ser passado e o valor de n. Na segunda linha a sequência a ser usada para ordenação.

O valor de m - Você deve passar um inteiro que corresponde ao tamanho da sequência de valores a ser informada na linha a seguir.

O valor de n - Você deve informar quantos números o algoritmo deve ordenar, ou seja, os n maiores números a serem ordenados. Onde n deve ser menor do que a quantidade de números passada como parâmetro.

Em seguida deve informar uma sequência de valores inteiros separados por espaço.

Formato de saída

Deve ser impresso os arrays correspondentes a cada passo do processo de ordenação pelo método da bolha. Desta forma, ao final deve ser impresso o conjunto de números correspondentes ao array de entrada com os n maiores números ordenados.

*******************************************************************************/

import java.util.Scanner;

public class /*Main*/HuxleyCode{

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int quantidadeDeNumerosNoVetor;
        int limiteDeOrdenacoes;

        quantidadeDeNumerosNoVetor = entrada.nextInt();
        limiteDeOrdenacoes = entrada.nextInt();

        int[] vetor = new int[quantidadeDeNumerosNoVetor];
        preencheVetor(vetor);

        ordenacaoBolha(vetor, limiteDeOrdenacoes);

    }

    private static void preencheVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = entrada.nextInt();
        }
    }

    private static void ordenacaoBolha(int[] vetor, int limiteDeOrdenacao) {
        int n = vetor.length;

        for (int i = 0; i < limiteDeOrdenacao && i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
            imprime(vetor);
        }
    }

    private static void imprime(int[] vetor) {
        System.out.print("[");
        for (int i = 0; i < vetor.length; i++) {
            if (i == vetor.length - 1) {
                System.out.print(vetor[i] + "]");
            } else {
                System.out.print(vetor[i] + ", ");
            }
        }
        System.out.println("");
    }
}
