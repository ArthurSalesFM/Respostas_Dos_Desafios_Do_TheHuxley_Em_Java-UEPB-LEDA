/******************************************************************************

Descrição
Rick percebeu que a incapacidade de Morty em ordenar arrays estava atrapalhando-os em suas aventuras. 
Então ele decidiu trocá-lo por um Morty de outra dimensão que soubesse ordenar arrays em tempo n*lg(n). 
Esse Rick, então, abriu uma competição entre os Mortys sem Ricks, para descobrir qual deles conseguiria tal façanha.

O Mergesort é um algoritmo de ordenação que utiliza da estratégia de divisão e conquista para ordenar um array. 
O processo de divisão consiste em dividir recursivamente o array em trechos que serão ordenados. 
O processo de conquista é feito sobre dois trechos separadamente ordenados, juntando-os em um novo trecho ordenado, 
partindo do pressuposto que um trecho composto por um único elemento é trivialmente ordenado.

O pseudocódigo a seguir, baseado nos algoritmos do livro Algoritmos :Teoria e Prática. Cormem, 
Thomas H., mostram o que pode ser implementado :

                                                                         

                                                                     

Para provar a Rick que você consegue ordenar arrays rapidamente, você deve implementar um Mergesort que :

Descreva os trechos do array com os quais o mergesort foi chamado, no processo de divisão.
Descreva os trechos de arrays antes e depois do processo de conquista.
Formato de entrada

N

N - número natural representando o tamanho do array a ser ordenado
A0 ... An-1

A0 ... An-1, os n elementos do array separados por espaço.
Formato de saída

Para cada chamada do merge-sort : 

"Separando o array V[l...r] : {V[l], ..., V[r]} em V[l...m] : {V[l], ..., V[m]} e V[m+1...r] : {V[m+1], ..., V[r]}"
l, r - números natural, representando os índices do array a ser dividido.
m - número natural, representando o índice que "separa" os 2 novos trechos.
V[i] ... V[j] - números inteiros, representando os elementos do trecho do array sobre o qual o 
merge-sort será executado.
Antes de cada chamada do merge :

"Executando o merge nos arrays {V[l], ..., V[m]} e {V[m+1], ..., V[r]}"
Depois de cada chamada do merge :

"array ordenado : {V[l], ..., V[r]}"

V[i] ... V[j] - números inteiros, representando os elementos do trecho do array sobre o qual o merge será executado.
Por fim, imprimir o array ordenado :

"O array ordenado : V[0] ... V[n-1]"

V[0] ... V[n-1] - representando os elementos do array depois da ordenação separados por espaço.


*******************************************************************************/

import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int tamanhoDoArray;
		int valoresDoArray[];
		
		tamanhoDoArray = entrada.nextInt();
		
		valoresDoArray = new int[tamanhoDoArray];
		
		for(int x = 0; x < tamanhoDoArray; x++){
		    //System.out.print("Digite o " + (x + 1) + "� valor: ");
		    valoresDoArray[x] = entrada.nextInt();
		}
		
		System.out.println();
		mergeSort(valoresDoArray, 0, valoresDoArray.length);
		
		System.out.println("\nO array ordenado : "+ imprimeVetor(valoresDoArray, 0, valoresDoArray.length, 1));
		
	}
	
	private static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim - 1) {
            int meio = (inicio + fim) / 2;
            System.out.print("Separando o array V[" + inicio + "..." + (fim - 1) + "] : {" + imprimeVetor(vetor, inicio, fim, 0) + "} em V[" + inicio + "..." + (meio - 1) + "] : {" + imprimeVetor(vetor, inicio, meio, 0) + "} e V[" + meio + "..." + (fim - 1) + "] : {" + imprimeVetor(vetor, meio, fim, 0) + "}\n" );                                                            
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio, fim);
            intercala(vetor, inicio, meio, fim);
        }
    }
    
    private static void intercala(int[] vetor, int inicio, int meio, int fim) {
        int[] novoVetor = new int[fim - inicio];
        System.out.print("Executando o merge nos arrays {"+ imprimeVetor(vetor, inicio, meio, 0) +"} e {"+ imprimeVetor(vetor, meio, fim, 0) +"}\n");
        int i = inicio;
        int m = meio;
        int pos = 0;

        while (i < meio && m < fim) {
            if (vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos++;
                i++;
            } 
            else {
                novoVetor[pos] = vetor[m];
                pos++;
                m++;
            }
        }

        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos++;
            i++;
        }

        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos++;
            m++;
        }

        for (pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
        
        System.out.print("array ordenado : {"+ imprimeVetor(vetor, inicio, fim, 0) +"}\n");
    }
    
    private static String imprimeVetor(int vetor[], int inicio, int fim, int tipo){
        String texto = "";
        
        if(tipo == 0){
            for(int x = inicio; x < fim; x++){
            
                if(x == fim - 1){
                    texto += vetor[x];
                }
                else{
                    texto += "" + vetor[x] + ", ";
                }
            }
        }
        else{
            for(int x = inicio; x < fim; x++){
            
                if(x == fim - 1){
                    texto += vetor[x];
                }
                else{
                    texto += "" + vetor[x] + " ";
                }
            }
        }
        return texto;
    }
    
}