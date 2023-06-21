package codigo;

import java.util.*;

import codigo.Interfaces.ILeitorDeArquivo;

public class App {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int operacao = 1;

        ILeitorDeArquivo leitorDeArquivo = new LeitorArquivos();
        Streaming streaming = new Streaming(leitorDeArquivo);
        Cliente usuarioLogado = null;

        limparTela();

       MenuPrincipal();
       operacao = sc.nextInt();
while(operacao != 0){
       while(operacao != 0){

        switch(operacao){
        case 1:
        limparTela();
        boolean credenciaisInvalidas = true;
            do {
                    System.out.println("Digite o nome de usuário: ");
                    String usuario = sc.next();
                    System.out.println("Digite a senha: ");
                    String senha = sc.next();

                if (!streaming.fazerLogin(usuario, senha)) {
                            System.out.println("Credenciais inválidas.");
                 } else {
                        System.out.println("Login realizado com sucesso!\n");
                        usuarioLogado = streaming.getUsuarioLogado();
                        credenciaisInvalidas = false;
                     }
            } while (credenciaisInvalidas);


        case 2:
        limparTela();
        MenuCliente();
       operacao = sc.nextInt();
        switch(operacao){
            case 1:
            limparTela();
                    if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o id do conteúdo que deseja adicionar aos favoritos: ");
                        String idConteudo = sc.next();

                        Conteudo conteudoParaAdicionar = streaming.obterConteudoPorId(idConteudo);
                        if (conteudoParaAdicionar == null) {
                            System.out.println("Id do conteúdo não existe.");
                            break;
                        }

                        adicionarConteudoAosFavoritosDoUsuario(conteudoParaAdicionar, streaming.getUsuarioLogado());
                        System.out.println("Conteúdo adicionado aos favoritos!");
                    }
            break;

            case 2:
            limparTela();
                    if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o id do conteúdo que deseja remover dos favoritos: ");
                        String idConteudo = sc.next();

                        Conteudo conteudoParaRemover = streaming.obterConteudoPorId(idConteudo);
                        if (conteudoParaRemover == null) {
                            System.out.println("Id do conteúdo não existe.");
                            break;
                        }

                        boolean sucessoOperacao = removerConteudoAosFavoritosDoUsuario(conteudoParaRemover,
                                usuarioLogado);

                        if (sucessoOperacao) {
                            System.out.println("Conteúdo removido com sucesso.");
                        } else {
                            System.out.println("Usuário não possui conteúdo com o id especificado nos favoritos.");
                        }
                    }
            break;
            case 3:
                    limparTela();
                    if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o nome da mídia que deseja buscar: ");
                        String nomeMidia = sc.next();

                        List<Conteudo> conteudoBuscado = usuarioLogado
                                .buscarConteudoAssistidoPorNome(nomeMidia.toLowerCase());

                        if (conteudoBuscado.size() == 0) {
                            System.out.println("Não foi encontrado nenhum conteúdo assistido com esse nome");
                        } else {
                            System.out.println("\nConteúdos assistidos com esse nome foram: ");
                            for (Conteudo conteudo : conteudoBuscado) {
                                System.out.println(conteudo.nome + ", de gênero: "
                                        + conteudo.genero.toString().toLowerCase() + ", no idioma "
                                        + conteudo.idioma.toString().toLowerCase() + ", lançado em: "
                                        + conteudo.dataLancamento);
                            }
                        }
                        System.out.println();
                    }
            break;
            case 4:
                    limparTela();
                    if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o tipo de gênero que deseja buscar: ");
                        String genreMidia = sc.next();
                        List<Conteudo> conteudoBuscado = usuarioLogado.buscarConteudoAssistidoPorGenero(Genero.valueOf(genreMidia.toLowerCase()));
                        if (conteudoBuscado.size() == 0) {
                            System.out.println("Não foi encontrado nenhum conteúdo assistido deste gênero");
                        } else {
                            System.out.println("\nConteúdos assistidos desse gênero foram: ");
                            for (Conteudo conteudo : conteudoBuscado) {
                                System.out.println(conteudo.nome + ", de gênero: "
                                        + conteudo.genero.toString().toLowerCase() + ", no idioma "
                                        + conteudo.idioma.toString().toLowerCase() + ", lançado em: "
                                        + conteudo.dataLancamento);
                            }
                        }
                        System.out.println("\n");
                    }
            break;
            case 5:
                    limparTela();
                    if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o idioma que deseja buscar: ");
                        String languageMidia = sc.next();
                        List<Conteudo> conteudoBuscado = usuarioLogado.buscarConteudoAssistidoPorIdioma(Idioma.valueOf(languageMidia.toLowerCase()));
                        if (conteudoBuscado.size() == 0) {
                            System.out.println("Não foi encontrado nenhum conteúdo assistido neste idioma");
                        } else {
                            System.out.println("\nConteúdos assistidos nesse idioma foram: ");
                            for (Conteudo conteudo : conteudoBuscado) {
                                System.out.println(conteudo.nome + ", de gênero: "
                                        + conteudo.genero.toString().toLowerCase() + ", no idioma "
                                        + conteudo.idioma.toString().toLowerCase() + ", lançado em: "
                                        + conteudo.dataLancamento);
                            }
                        }
                        System.out.println();
                    }
            break;
            case 6:
                    limparTela();
                    if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o nome da mídia que deseja buscar: ");
                        String nomeMidia = sc.next();
                        List<Conteudo> conteudoBuscado = streaming.buscarConteudoPorNome(nomeMidia.toLowerCase());
                        System.out.println("\nConteúdos encontrados com esse nome foram: ");
                        for (Conteudo conteudo : conteudoBuscado) {
                            System.out.println(conteudo.nome + ", de gênero: "
                                    + conteudo.genero.toString().toLowerCase() + ", no idioma "
                                    + conteudo.idioma.toString().toLowerCase() + ", lançado em: "
                                    + conteudo.dataLancamento);
                        }
                        System.out.println();
                    }
            break;
            case 7:
                    limparTela();
                    if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o gênero da mídia que deseja buscar: ");
                        String generoMidia = sc.next();
                        List<Conteudo> conteudoBuscado = streaming.buscarConteudoPorGenero(Genero.valueOf(generoMidia.toLowerCase()));
                        System.out.println("\nConteúdos encontrados com esse gênero foram: ");
                        for (Conteudo conteudo : conteudoBuscado) {
                            System.out.println(conteudo.nome + ", de gênero: "
                                    + conteudo.genero.toString().toLowerCase() + ", no idioma "
                                    + conteudo.idioma.toString().toLowerCase() + ", lançado em: "
                                    + conteudo.dataLancamento);
                        }
                        System.out.println();
                    }
            break;
            case 8:
                    limparTela();
                    if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o idioma da mídia que deseja buscar: ");
                        String idiomaMidia = sc.next();
                        List<Conteudo> conteudoBuscado = streaming.buscarConteudoPorIdioma(Idioma.valueOf(idiomaMidia.toLowerCase()));
                        System.out.println("\nConteúdos encontrados com esse idioma foram: ");
                        for (Conteudo conteudo : conteudoBuscado) {
                            System.out.println(conteudo.nome + ", de gênero: "
                                    + conteudo.genero.toString().toLowerCase() + ", no idioma "
                                    + conteudo.idioma.toString().toLowerCase() + ", lançado em: "
                                    + conteudo.dataLancamento);
                        }
                        System.out.println();
                    }
            break;
            case 9:
            limparTela();
            if (usuarioLogado == null) {
                        ifNotLoginMsg();
                    } else {
                        System.out.println("Digite o ID da mídia que deseja avaliar: ");
                        String idMidia = sc.next();
                        System.out.println("Digite uma nota de 1-5 para avaliar: ");
                        int notaAvaliacao = sc.nextInt();

                        Conteudo midia = streaming.obterConteudoPorId(idMidia);

                        usuarioLogado.avaliarMidia(midia, notaAvaliacao);

                    }
            break;
            case 10:
                limparTela();
                if (usuarioLogado == null) {
                    ifNotLoginMsg();
                } else {
                    List<Conteudo> conteudosAssistidos = usuarioLogado.conteudosAssistidos;
                    if (conteudosAssistidos.size() < 0) {
                        System.out.println("Você não possui nenhum conteúdo assistido!");
                    } else {
                        System.out.println("Seus conteúdos assistidos são: ");
                        for (Conteudo conteudo : conteudosAssistidos) {
                            System.out.println(conteudo.nome + ", lançado em: " + conteudo.dataLancamento);
                        }
                    }
                }
            break;
        }
        case 3:
            MenuRelatorio();
            operacao = sc.nextInt();


            limparTela();
            Relatorio relatorio = new Relatorio();
            LeitorArquivos leitor = new LeitorArquivos();
            Map<String, Cliente> clientes = leitor.lerArquivosEspectadores();
            Map<String, Conteudo> conteudo = new HashMap<>();
            conteudo.putAll(leitor.lerArquivosSerie());
            conteudo.putAll(leitor.lerArquivosFilme());
            
            switch(operacao){

            case 1:
            System.out.println("Qual cliente assistiu mais mídias, e quantas mídias:" + "\n");
            relatorio.obterClientesComMaisMidias(clientes);
            break;

            case 2:
            System.out.println("Qual cliente tem mais avalições, e quantas avaliações:" + "\n");
            relatorio.obterClientesComMaisAvaliacoes(clientes);
            break;

            case 3:
            System.out.println("Qual a porcentagem dos clientes com pelo menos 15 avaliações:" + "\n");
            relatorio.obterPorcentagemClientesComNumeroMinimoAvaliacoes(clientes, 15);
            break;
            
            case 4:
            System.out.println("Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente:" + "\n");
            relatorio.obterConteudosMaisAssistidos(conteudo, 10);
            break;

            case 5:
            System.out.println("Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente separadas por gênero" + "\n");
            relatorio.obterConteudosComMelhorMedia(conteudo,100,10);
            break;
            case 6:
            System.out.println("Quais são as 10 mídias com mais visualizações, em ordem decrescente, separadas por gênero");
            relatorio.obterConteudosComMelhorMediaVistopeloMenosCem(conteudo, 100, 10);
            break;
        } 
            break;

    }
}
    operacao = -1;
    MenuPrincipal();
    operacao = sc.nextInt();
}
        
    














































    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void adicionarConteudoAosFavoritosDoUsuario(Conteudo conteudo, Cliente usuarioLogado) {
        usuarioLogado.conteudosParaAssistir.add(conteudo);
    }

    private static boolean removerConteudoAosFavoritosDoUsuario(Conteudo conteudo, Cliente usuarioLogado) {
        return usuarioLogado.removerListaConteudosParaAssistir(conteudo);
    }

     private static String ifNotLoginMsg() {
        String msg = "Faça login antes de utilizar essa opção!";
        return msg;
    }

    private static void MenuPrincipal() {
        System.out.println("Digite:" + "\n" + "1 - Login" +"\n" + "2 - Menu Cliente" + "\n"
                + "3 - Menu Relatórios" + "\n" + "0 - Para finalizar" + "\n");
    }

    private static void MenuCliente() {
        System.out.println("1 - Adicionar a lista de favoritos!" + "\n"
                + "2 - Remover da lista de favoritos!" + "\n" + "3 - Buscar Mídia assistida por Nome!" + "\n"
                + "4 - Buscar Mídia assistida por Gênero!" + "\n" + "5 - Buscar Mídia assistida por Idioma!" + "\n"
                + "6 - Buscar Mídia para assistir por Nome!" + "\n" + "7 - Buscar Mídia para assistir por Gênero!"
                + "\n" + "8 - Buscar Mídia para assistir por Idioma!" + "\n" + "9 - Avaliar mídia!" + "\n"
                + "10 - Visualizar conteúdos assistidos\n" + "0 - Voltar");
    }

    private static void MenuRelatorio() {
        System.out.println("Digite:" + "\n" + "1 - Relatorio: Qual cliente assistiu mais mídias, e quantas mídias!"
                + "\n"
                + "2 - Relatorio: Qual cliente tem mais avaliações, e quantas avaliações!" + "\n"
                + "3 - Relatorio: Qual a porcentagem dos clientes com pelo menos 15 avaliações!" + "\n"
                + "4 - Relatorio: Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente!"
                + "\n"
                + "5 - Relatorio: Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente separadas por gênero!"
                + "\n"
                + "6 - Relatorio: Quais são as 10 mídias com mais visualizações, em ordem decrescente, separadas por gênero!"
                + "\n" + "0 - Voltar");
    }
}
