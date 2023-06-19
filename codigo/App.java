package codigo;

import java.util.*;

import codigo.Interfaces.ILeitorDeArquivo;

public class App {
    public static void main(String[] args) {
        ILeitorDeArquivo leitorDeArquivo = new LeitorArquivos();
        Streaming streaming = new Streaming(leitorDeArquivo);

        Scanner sc = new Scanner(System.in);

        imprimirOperacoes(null);

        int operacao = sc.nextInt();

        Cliente usuarioLogado = null;

        while (operacao != 0) {

            switch (operacao) {
                case 1:
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
                    break;
                case 2:
                    if (streaming.getUsuarioLogado() == null) {
                        System.out.println("Faça login antes de utilizar essa opção!\n");
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
                case 3:
                    if (usuarioLogado == null) {
                        System.out.println("Faça login antes de utilizar essa opção!");
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
                case 4:
                    if (usuarioLogado == null) {
                        System.out.println("Faça login antes de utilizar essa opção!");
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
                case 5:
                    if (usuarioLogado == null) {
                        System.out.println("Faça login antes de utilizar essa opção!");
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
                        System.out.println();
                    }
                    break;
                case 6:
                    if (usuarioLogado == null) {
                        System.out.println("Faça login antes de utilizar essa opção!");
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
                case 7:
                    if (usuarioLogado == null) {
                        System.out.println("Faça login antes de utilizar essa opção!");
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
                case 8:
                    if (usuarioLogado == null) {
                        System.out.println("Faça login antes de utilizar essa opção!");
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
                case 9:
                    if (usuarioLogado == null) {
                        System.out.println("Faça login antes de utilizar essa opção!");
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
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;

            }

            imprimirOperacoes(streaming.getUsuarioLogado() != null ? streaming.getUsuarioLogado().username : null);
            operacao = sc.nextInt();
        }

        sc.close();
    }

    private static void adicionarConteudoAosFavoritosDoUsuario(Conteudo conteudo, Cliente usuarioLogado) {
        usuarioLogado.conteudosParaAssistir.add(conteudo);
    }

    private static boolean removerConteudoAosFavoritosDoUsuario(Conteudo conteudo, Cliente usuarioLogado) {
        return usuarioLogado.removerListaConteudosParaAssistir(conteudo);
    }

    private static void imprimirOperacoes(String usernameUsuarioLogado) {
        if (usernameUsuarioLogado != null) {
            System.out.println("\nUsuário logado: " + usernameUsuarioLogado + "\n");
        }
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