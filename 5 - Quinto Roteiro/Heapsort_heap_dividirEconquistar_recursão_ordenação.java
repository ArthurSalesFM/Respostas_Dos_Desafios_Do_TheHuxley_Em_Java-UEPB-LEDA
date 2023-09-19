/******************************************************************************

Descrição
O algoritmo Heapsort é um algoritmo de ordenação que funciona da seguinte forma: 
dada uma sequência de elementos em um array A (neste exercício, consideramos apenas números), 
primeiro é construída uma heap máxima (max-heap) com os elementos nas posições 1 a n, onde n é o tamanho original 
do array (vide exercício Construir Heap Máxima presente aqui no Huxley também). 
Ao construir esta max-heap, o primeiro elemento será o maior elemento de A, portanto podemos colocá-lo na posição n. 
Se removermos o nó n da heap - podemos fazê-lo simplesmente decrementando o tamanho da heap armazenada em A - observamos 
que os nós que são filhos da raiz continuam como max-heaps, mas o novo elemento na posição de raiz da heap em A pode 
estar violando a propriedade de max-heap. Portanto é necessário restaurar a propriedade max-heap, chamando a 
função MAX-HEAPIFY a partir da raiz, o que terá como resultado uma max-heap nas posições de 1 a n-1. 
O algoritmo heapsort repete este processo para a max-heap de tamanho 1:n-1, vide descrição do algoritmo abaixo: 



(fonte: Capítulo 6.4 do livro "Introduction to Algorithms", por Cormen et al.)

Neste exercício, deve ser implementado o algoritmo Heapsort, ilustrando o passo a passo de execução do algoritmo, 
conforme detalhado no formato de entrada e saída abaixo.

Formato de entrada

A entrada é constituída por uma linha contendo uma sequência de números a serem ordenados.

Formato de saída

A entrada deve ser impressa separada por barras verticais, como no exemplo. 
Após a construção da heap máxima, o estado inicial da heap deve ser exibido usando a mesma formatação. 
Para cada passo do algoritmo, a saída deve imprimir o elemento raiz da heap e o conteúdo da mesma entre barras verticais.
Ao final da ordenação, deve ser impresso o resultado final da execução do algoritmo.

*******************************************************************************/

import java.util.*;

public class HuxleyCode{
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
        
        heapSort(vetorDeValores);
        
        System.out.println("Resultado Final: " + imprimeVetor(vetorDeValores, 0, vetorDeValores.length));
	}
	
	private static void copiarListaParaVetor(List<Integer> lista, int[] vetor){
        for (int i = 0; i < lista.size(); i++) {
            vetor[i] = lista.get(i);
        }
    }
    
    private static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            
            System.out.println("Estado Atual da Heap: " + imprimeVetor(arr, 0, i + 1));
            
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            if (i > 0) {
                System.out.println("Maior elemento neste passo: " + arr[i]);
            }
            
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int maior = i;
        int filhoEsquerdo = 2 * i + 1;
        int filhoDireito = 2 * i + 2;

        if (filhoEsquerdo < n && arr[filhoEsquerdo] > arr[maior]) {
            maior = filhoEsquerdo;
        }

        if (filhoDireito < n && arr[filhoDireito] > arr[maior]) {
            maior = filhoDireito;
        }

        if (maior != i) {
            int troca = arr[i];
            arr[i] = arr[maior];
            arr[maior] = troca;

            heapify(arr, n, maior);
        }
    }
    
    private static String imprimeVetor(int vetor[], int inicio, int fim){
        String saida = "";
        
        for(int i = inicio; i < fim; i++){
            if(i == fim -1){
                saida += vetor[i];
            }
            else{
                saida += vetor[i] + " | ";
            }
        }
        return saida;
    }
}
