/******************************************************************************

Descrição
Dois sorteios serão realizados em uma cidade do interior. 

Um vai sortear um carro e o outro uma moto. Para realização do sorteio, os organizadores coletaram os nomes dos participantes em uma lista e os ordenaram em ordem alfabética. Depois, sortearam dois números n1 e n2 representando a posição na lista ordenada dos ganhadores do carro e da moto, respectivamente.

Porém, algumas pessoas gastaram um pouco mais e se inscreveram nos dois sorteios e agora possuem maior chance de ganhar algum prêmio.

Mostre o resultado do sorteio.

Formato de entrada

N => Quantidade de pessoas inscritas para o sorteio do carro.

As próximas N linhas contém os nomes dos participantes do sorteio do carro. Os nomes não tem mais que 10 caracteres e todos os nomes são diferentes.

M => Quantidade de pessoas inscritas para o sorteio da moto.

As próximas M linhas contém os nomes dos participantes do sorteio de moto. Os nomes não tem mais que 10 caracteres e todos os nomes são diferentes.

Na última linha dois números (n1 e n2) indicando os valores sorteados para os sorteios do carro e da moto, respectivamente.


Formato de saída

Se uma pessoa só foi sortuda e ganhou tudo, mostre:

"Quem ganhou tudo hoje foi [nome]"

Se os prêmios foram para duas pessoas diferentes, mostre:

"Quem ganhou o carro foi: [vencedor_carro]"

"Quem ganhou a moto foi: [vencedor_moto]"

*******************************************************************************/

import java.util.*;

public class /*Main*/ HuxleyCode {
    
    static Scanner entrada = new Scanner (System.in);

    public static void main (String[]args){

        String[] sorteioDoCarro;
        String[] sorteioDaMoto;
        String[] nomesSorteados = new String[2];
        int quantidadeDeParticipantes;

        //System.out.print("Digite a quantidade de participantes do sorteio do CARRO: ");
        quantidadeDeParticipantes = entrada.nextInt ();
        sorteioDoCarro = new String[quantidadeDeParticipantes];
        entrada.nextLine();
        preencheVetor (sorteioDoCarro);

        //System.out.print("Digite a quantidade de participantes do sorteio da MOTO: ");
        quantidadeDeParticipantes = entrada.nextInt ();
        sorteioDaMoto = new String[quantidadeDeParticipantes];
        entrada.nextLine();
        preencheVetor(sorteioDaMoto);

        Arrays.sort(sorteioDoCarro);
        Arrays.sort(sorteioDaMoto);
        
        sorteio(nomesSorteados, sorteioDoCarro, sorteioDaMoto);
        
        imprime(nomesSorteados);
        
    }

    private static void preencheVetor (String[]vetor) {
        for (int i = 0; i < vetor.length; i++) {
	        //System.out.print("Digite o "+ (i+1)+"� nome para o sorteio : ");
	        vetor[i] = entrada.nextLine ();
        }
    }
    
    private static void sorteio(String[] vetor, String[] carro, String[] moto){
        int numeroSorteioCarro = entrada.nextInt();
        int numeroSorteioMoto = entrada.nextInt();
        
        vetor[0] = carro[numeroSorteioCarro - 1];
        vetor[1] = moto[numeroSorteioMoto - 1];
    }

    private static void imprime (String[]vetor){
        
        if(vetor[0].equals(vetor[1])){
            System.out.println("Quem ganhou tudo hoje foi " + vetor[0]);
        }
        else{
            System.out.println("Quem ganhou o carro foi: " + vetor[0]);
            System.out.println("Quem ganhou a moto foi: " + vetor[1]);
        }
    }
}
