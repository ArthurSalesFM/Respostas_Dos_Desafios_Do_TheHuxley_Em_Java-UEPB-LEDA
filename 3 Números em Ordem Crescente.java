/******************************************************************************

Descrição
Faça um programa que leia 3 números inteiros e os imprima em ordem crescente.

Formato de entrada

03 números inteiros separados por um final de linha.

Formato de saída

Os 03 números lidos impressos em ordem crescente, cada um em uma linha.

*******************************************************************************/

import java.util.Scanner;

public class HuxleyCode{
    
    public static void main(String[] args) {
        /*Variáveis para leitura e armazenamento de dados*/
        Scanner entrada = new Scanner(System.in);
        int[] valores = new int[3];
        
        for(int i = 0; i < 3; i++){
            /*System.out.print("Digite o " + (i+1) + "º valor");*/
            valores[i] = entrada.nextInt();
        }
        
        ordena(valores);
        imprimir(valores);
    }
    
    
    private static void ordena(int vetor[]){
        
        /*Variáveis para controle de fluxo(troca)(inicialmente setado como true para iniciar o loop), 
        e para armazenar valores necessários para a troca(aux) */
        boolean troca = true;
        int aux;
        
        while (troca) {
            /*troca setado como false, mas caso exista alguma troca, o loop retorna*/
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                /*Condição criada para verificar o valor atual como o próximo valor, caso o atual seja maior entrará na condição*/
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
    }
    
    /*Método criado apenas para imprimir os valores*/
    private static void imprimir(int[] vetor){
        for(int i = 0; i < vetor.length; i ++){
            System.out.println(vetor[i]);
        }
    }
    
}