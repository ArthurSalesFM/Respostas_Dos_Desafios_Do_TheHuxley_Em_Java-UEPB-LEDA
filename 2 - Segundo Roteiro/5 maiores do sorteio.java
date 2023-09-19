/******************************************************************************

Descrição
Dado um quantidade de números N,  um dígito sorteado D e N números, sua tarefa é informar os 5 maiores números sorteados que possuem o ultimo dígito igual a D, caso não exista números suficientes você deve substitui-los por -1.

Os números devem ser impressos em ordem crescente.

Formato de entrada

Dois inteiros N e D, seguidos de N números não negativos.

5 <= N <= 1000.

0 <= D <= 9.

Formato de saída

Os 5 maiores números sorteados , 1 por linha, ou -1 quando necessário.

*******************************************************************************/

import java.io.*;
import java.util.*;

public class HuxleyCode {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String args[]) {
        int quantidadeDeNumeros;
        int valorFinalEscolhido;
        int[] vetorDeValores;

        quantidadeDeNumeros = entrada.nextInt();
        valorFinalEscolhido = entrada.nextInt();

        vetorDeValores = new int[quantidadeDeNumeros];
        preencheVetor(vetorDeValores);
        osCincoMaioresValores(vetorDeValores, valorFinalEscolhido);
    }

    public static void preencheVetor(int[] vetorDeValores) {
        for (int x = 0; x < vetorDeValores.length; x++) {
            vetorDeValores[x] = entrada.nextInt();
        }
    }

    public static void osCincoMaioresValores(int[] vetor, int valorFinalEscolhido) {
        int[] osCincoMaiores = new int[5];
        int ultimoDigito = valorFinalEscolhido % 10;
        int quantidadeDeZeros = 0;
        
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == 0){
                quantidadeDeZeros++;
            }
        }
        
        if(quantidadeDeZeros == vetor.length && valorFinalEscolhido == 0){
            imprime(vetor);
        }
        else{
            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] % 10 == ultimoDigito) {
                    for (int j = 0; j < 5; j++) {
                        if (osCincoMaiores[j] == 0 || vetor[i] > osCincoMaiores[j]) {
                            for (int k = 4; k > j; k--) {
                                osCincoMaiores[k] = osCincoMaiores[k - 1];
                            }
                            osCincoMaiores[j] = vetor[i];
                            break;
                        }
                    }
                }
            }

            for (int x = 0; x < 5; x++) {
                if (osCincoMaiores[x] == 0) {
                    osCincoMaiores[x] = -1;
                }
            }

            Arrays.sort(osCincoMaiores);
            imprime(osCincoMaiores);
        }
    }

    public static void imprime(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}