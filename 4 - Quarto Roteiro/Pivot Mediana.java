/******************************************************************************

Descrição
Implemente um algoritmo de pivoteamento baseado em mediana. 
O algoritmo deve classificar o vetor de entrada de acordo com o pivot selecionado (mediana) e 
retorna o vetor de entrada classificado da maneira como a figura representa:



Ou seja, elementos menores ou iguais que o pivot devem estar à "esquerda"
(entre a posição inicial do vetor indicada pelo índice p e q-1)  do pivot 
(indicado pelo índice q representado pela cor verde). Elementos maiores que p pivot devem estar à "direita" 
(da posição q+1 até o final do array indicado pelo índice r). Finalmente o pivot 
selecionado deve se localizar na posição indicada pelo índice q separando os dois grupos de valores.

Valor médio para a mediana (m) = ( Maior valor + Menor valor ) / 2

Pivot Mediana => Encontrar o valor no vetor de entrada cuja a diferença seja a menor para m.

Formato de entrada

Um vetor de valores inteiros [0..n] com os números separados por espaço entre eles.

Formato de saída

Uma linha de dados informando o valor do pivô.
Uma linha de dados z[0..n] representando os vetores de entrada classificados.

Exemplos de:


*******************************************************************************/

import java.util.*;

public class HuxleyCode {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        
        while (entrada.hasNext()) {
            int numero = entrada.nextInt();
            lista.add(numero);
        }

        int[] vetor = new int[lista.size()];
        copiarListaParaVetor(lista, vetor);
        int pivot = dividirVetor(vetor);

        System.out.println(pivot);
        for (int num : vetor) {
            System.out.print(num + " ");
        }
    }
    
    private static void copiarListaParaVetor(List<Integer> lista, int[] vetor){
        for (int i = 0; i < lista.size(); i++) {
            vetor[i] = lista.get(i);
        }
    }

    private static int dividirVetor(int[] vetor) {
        int valorMinimo = Integer.MAX_VALUE;
        int valorMaximo = Integer.MIN_VALUE;

        for (int num : vetor) {
            if (num < valorMinimo) valorMinimo = num;
            if (num > valorMaximo) valorMaximo = num;
        }

        double valorMediana = (valorMinimo + valorMaximo) / 2.0;

        int pivot = vetor[0];
        double diferenca = Math.abs(vetor[0] - valorMediana);
        int indicePivot = 0;

        for (int i = 1; i < vetor.length; i++) {
            double difAtual = Math.abs(vetor[i] - valorMediana);
            if (difAtual < diferenca) {
                pivot = vetor[i];
                diferenca = difAtual;
                indicePivot = i;
            }
        }

        int temp = vetor[indicePivot];
        vetor[indicePivot] = vetor[vetor.length - 1];
        vetor[vetor.length - 1] = temp;

        int i = -1;
        for (int j = 0; j < vetor.length - 1; j++) {
            if (vetor[j] <= pivot) {
                i++;
                temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        vetor[vetor.length - 1] = vetor[i + 1];
        vetor[i + 1] = pivot;

        return pivot;
    }
}