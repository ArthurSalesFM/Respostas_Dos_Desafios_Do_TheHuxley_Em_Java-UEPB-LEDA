/******************************************************************************

Descrição
O algoritmo Quicksort, assim como mergesort, aplica o conceito de dividir para conquistar para ordenar um array A. 
O passo a passo para ordenação de um array A[p..r] se dá como discutido abaixo: 

Dividir: Particionar (reorganizar) o array A[p..r] em dois subarrays (que podem estar vazios) A[p..q-1] e A[q+1..r], 
de tal forma que todo elemento de A[p..q-1] é menor ou igual do que A[q], que por sua vez é menor do que todos os elementos de A[q+1..r]. 
Compute o índice q como parte deste procedimento de particionamento.

Conquistar: Ordene os subarrays A[p..q-1] e A[q+1..r] por chamadas recursivas a quicksort.

Combinar: Pelo fato dos subarrays já estarem ordenados, nenhum trabalho é necessário para combiná-los. O array A[p..r] estará ordenado.

O procedimento abaixo (retirado do capítulo 7 do livro "Introduction to Algorithms", por Cormen et al.) implementa quicksort. 



Para ordenar um array A por inteiro, a chamada inicial deve ser QUICKSORT(A,1,A.length). 

A chave para este algoritmo está no procedimento PARTITION, descrito abaixo, que reorganiza o subarray A[p..r] in place:





Neste problema, você deve implementar o quicksort de acordo com os algoritmos descritos acima. 
Para cada chamada a partition, você deve imprimir o valor do pivot utilizado para particionar, 
o resultado do particionamento no formato:

Partition(A,p,r): x1 x2 ... xn <= pivot < y1 y2 ... yn

Onde p e r são os índices utilizados para a chamada ao procedimento PARTITION, x1...xn 
são todos os elementos no intervalo entre p e r que são menores ou iguais que o valor de pivot (caso existam), 
e y1...yn são todos os elementos no intervalo entre p e r que são maiores que o pivot (caso existam), 
impressos na ordem em que aparecem no array A, vide exemplos de entrada e saída. Além destes, 
para cada chamada a partition deve ser impresso o estado atual do array A inteiro após a chamada. 

Ao término do algoritmo, deve ser impresso o estado final de A, que deve consistir dos números ordenados de maneira crescente.

Formato de entrada

A entrada é constituída por uma linha contendo uma sequência de números a serem ordenados. 

Formato de saída

Inicialmente, deve ser impresso o estado inicial de A. 

Para cada chamada a partition realizada de acordo com as chamadas recursivas a quicksort, você deve imprimir:

Pivot: x
Partition(A,p,r): x1 x2 ... xn <= pivot < y1 y2 ... yn
Estado atual de A: a | b | c | ... | z

Na primeira linha, o valor de x deve ser substituído pelo valor do pivot utilizado para particionar o subarray A[p..r]

Na segunda linha, p e r são os índices utilizados para a chamada ao procedimento PARTITION, 
x1...xn são todos os elementos no intervalo entre p e r que são menores ou iguais que o valor de pivot (caso existam), 
e y1...yn são todos os elementos no intervalo entre p e r que são maiores que o pivot (caso existam), 
impressos na ordem em que aparecem no array A, vide exemplos de entrada e saída. 

Na terceira linha, para cada chamada a partition deve ser impresso o estado atual do array A inteiro após a chamada. 

Ao término do algoritmo, deve ser impresso o estado final de A, que deve consistir dos números ordenados de maneira crescente.

*******************************************************************************/

import java.util.Scanner;

public class HuxleyCode {

  public static int partition(int[] A, int p, int r) {
    int pivot = A[r];
      int i = p - 1;
        
      for(int j = p; j < r; j++) {
          if(A[j] <= pivot) {
              i++;
              int temp = A[i];
              A[i] = A[j];
              A[j] = temp;
          }
      }
    
      int temp = A[i+1];
      A[i+1] = A[r];
      A[r] = temp;
    
      return i+1;
  }

  public static void quicksort(int[] A, int p, int r) {
      if (p < r) {
          int q = partition(A, p, r);
          System.out.println("Pivot: " + A[q]);

          System.out.print("Partition(A," + (p+1) + "," + (r+1) + "): ");
          for (int i = p; i < q; i++) {
            System.out.print(A[i] + " ");
          }

          System.out.print("<= " + A[q] + " <");

          for (int i = q+1; i <= r; i++) {
            System.out.print(" " + A[i]);
          }
          System.out.println();

          System.out.print("Estado atual de A: ");
          for (int i = 0; i < A.length; i++) {
              if(i == A.length - 1){
                System.out.print(A[i]);
              } else {
                System.out.print(A[i] + " | ");
              }
          }
          System.out.println();
          System.out.println();

          quicksort(A, p, q-1); 
          quicksort(A, q+1, r);
      }
  } 

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String[] values = scanner.nextLine().split(" ");
      int[] A = new int[values.length];
  
      for (int i = 0; i < A.length; i++) {
        A[i] = Integer.parseInt(values[i]); 
      }
  
      System.out.print("Estado inicial: ");
      for(int i = 0; i < A.length; i++){
        if(i == A.length - 1){
          System.out.print(A[i]);
        } else {
          System.out.print(A[i] + " | ");
        }
      }
      System.out.println();
      System.out.println();
  
      quicksort(A, 0, A.length - 1);
  
      System.out.print("Resultado Final: ");
      for(int i = 0; i < A.length; i++){
        if(i == A.length - 1){
          System.out.print(A[i]);
        } else {
          System.out.print(A[i] + " | ");
        }
      }
      System.out.println();
  
      scanner.close();
  }
}