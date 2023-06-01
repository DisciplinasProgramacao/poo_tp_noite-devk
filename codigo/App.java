package codigo;

import java.util.*;

import codigo.Interfaces.ILeitorDeArquivo;

public class App {
    public static void main(String[] args) {
        ILeitorDeArquivo leitorDeArquivo = new LeitorArquivos();
        Streaming streaming = new Streaming(leitorDeArquivo);

        Scanner sc = new Scanner(System.in);

        imprimirOperacoes();

        int operacao = sc.nextInt();

        while (operacao != 0) {

            switch (operacao) {
                case 1:
                    break;
            }

        }
    }

    private static void imprimirOperacoes() {
        System.out.println("Digite:" + "\n" + "1 - Fazer Login!" + "\n" + "2 - Adicionar a lista de favoritos!" + "\n"
                + "3 - Remover da lista de favoritos!" + "\n" + "4 - Buscar Mídia assistida por Nome!" + "\n"
                + "5 - Buscar Mídia assistida por Gênero!" + "\n" + "6 - Buscar Mídia assistida por Idioma!" + "\n"
                + "7 - Buscar Mídia para assistir por Nome!" + "\n" + "8 - Buscar Mídia para assistir por Gênero!"
                + "\n" + "9 - Buscar Mídia para assistir por Idioma!" + "\n" + "10 - Avaliar mídia!" + "\n"
                + "11 - Relatorio: Qual cliente assistiu mais mídias, e quantas mídias!" + "\n"
                + "12 - Relatorio: Qual cliente tem mais avaliações, e quantas avaliações!" + "\n"
                + "13 - Relatorio: Qual a porcentagem dos clientes com pelo menos 15 avaliações!" + "\n"
                + "14 - Relatorio: Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente!"
                + "\n"
                + "15 - Relatorio: Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente separadas por gênero!"
                + "\n"
                + "16 - Relatorio: Quais são as 10 mídias com mais visualizações, em ordem decrescente, separadas por gênero!"
                + "\n" + "0 - Parar!");
    }
}