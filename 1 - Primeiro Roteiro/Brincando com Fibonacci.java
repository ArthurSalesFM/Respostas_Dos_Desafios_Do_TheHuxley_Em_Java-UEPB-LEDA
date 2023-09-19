/******************************************************************************

Descrição
Vamos brincar com Fibonacci.
Na matemática, a Sucessão de Fibonacci (também Sequência de Fibonacci), é uma sequência de números inteiros.

Formato de entrada

Um inteiro

Formato de saída

Um inteiro

*******************************************************************************/

import java.util.Scanner;

public class HuxleyCode {
    
    public static void main(String[] args) {
        int valor;
        Scanner entrada = new Scanner(System.in);
        
        valor = entrada.nextInt();
        Fibonacci(valor);
    }

    private static void Fibonacci(int n) {
        int anterior = 0;
        int atual = 1;
        int[] valores = new int[n];

        for (int i = 1; i <= n; i++) {
            valores[i - 1] = anterior;
            
            int proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }
        System.out.println(valores[n - 1]);
    }
}