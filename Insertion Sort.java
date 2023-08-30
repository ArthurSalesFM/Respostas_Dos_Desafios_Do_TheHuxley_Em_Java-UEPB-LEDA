/******************************************************************************

Descrição
O algoritmo Insertion Sort é um algoritmo eficiente para ordenar quantidades pequenas de elementos. A intuição do seu funcionamento é semelhante à maneira como organizamos uma mão de cartas progressivamente. Partindo de uma pilha de cartas na mesa, e com a mão esquerda vazia, puxamos uma carta de cada vez com a mão direita e inserimos a mesma na posição correta correspondente na mão esquerda. Para definir a posição correta de uma carta, é necessário compará-la com cada uma das cartas na mão esquerda, começando da carta mais à direita até, no máximo, a carta mais à esquerda. Desta forma, sempre que buscamos uma carta da pilha da mesa, a mão esquerda tem uma sequência ordenada de cartas. 

Neste exercício, devemos implementar o algoritmo Insertion Sort, ilustrando o passo a passo de execução do algoritmo, conforme detalhado no formato de entrada e saída abaixo.

Formato de entrada

A entrada é constituída por uma linha contendo uma sequência de números a serem ordenados. 

Formato de saída

Para cada chave, a saída deve imprimir o passo-a-passo de cada troca efetuada pelo algoritmo, imprimindo o conteúdo do vetor entre barras verticais. Entre uma chave e outra deve ser impressa uma linha em branco. 

Ao final da ordenação, deve ser impresso o resultado final da execução do algoritmo.

*******************************************************************************/

import java.util.*;

public class HuxleyCode {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> valores = new ArrayList<>(); 

        while (entrada.hasNext()) {
            valores.add(entrada.nextInt());
        }

        insertionSort(valores);
    }

    private static void insertionSort(List<Integer> lista) { 
        int tamanho = lista.size();

        for (int i = 1; i < tamanho; i++) {
            int chave = lista.get(i);
            int j = i - 1;
            
            System.out.println("Chave: " + chave);
            System.out.print("Estado Atual: ");
            
            while (j >= 0 && lista.get(j) > chave) {
                imprime(lista);
                lista.set(j + 1, lista.get(j));
                //vetor[j + 1] = vetor[j];
                j--;
                lista.set(j + 1, chave);
                //vetor[j + 1] = chave;
            }
    
            imprime(lista);
            System.out.println("");
        }
        
        System.out.print("Resultado Final: ");
        imprime(lista);
        System.out.print("\n");
    }

    private static void imprime(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (i == lista.size() - 1) {
                System.out.print(lista.get(i));
            } else {
                System.out.print(lista.get(i) + " | ");
            }
        }
        System.out.println("");
    }
}
