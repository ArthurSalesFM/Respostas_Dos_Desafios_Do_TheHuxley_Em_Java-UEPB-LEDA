/******************************************************************************

Descrição
Escreva um programa que calcule o mínimo múltiplo comum (MMC) entre dois números inteiros fornecidos pelo usuário.

Formato de entrada

A entrada deve ser composta de dois números inteiros fornecidos em dois inputs diferentes.

Exemplo:

5

6

Formato de saída

A saída deve ser apenas o mmc entre os dois valores.

Exemplo:

30

*******************************************************************************/

import java.util.Scanner;

public class HuxleyCode {
  public static void main(String args[]) {
    
      int valor1, valor2;
      
      Scanner entrada = new Scanner(System.in);
      
      valor1 = entrada.nextInt();
      
      valor2 = entrada.nextInt();
      
      System.out.println(mmc(valor1, valor2));
      
  }
  
  private static int mmc(int vl1, int vl2){
        int resto, a, b;
        
        a = vl1;
        b = vl2;
        
        do{
            resto = a % b;
            
            a = b;
            b = resto;
            
        }while(resto != 0);
      
        return (vl1 * vl2) / a;
  }
}