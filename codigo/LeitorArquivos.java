package codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codigo.Clientes.ClienteRegular;
import codigo.Interfaces.ILeitorDeArquivo;

public class LeitorArquivos implements ILeitorDeArquivo {
    /**
     * Método utilizado para realizar a leitura e configuração inicial do arquivo de
     * audiência.
     * 
     * @param clientes  O mapa de clientes em que deve ser populado a audiência.
     * @param conteudos O conteúdo em que deve ser adicionado a instância do
     *                  cliente.
     * @throws Exception Lançada no caso em que não foi possível
     *                   realizar a leitura do arquivo.
     */
    public void lerArquivosAudiencia(Map<String, Cliente> clientes, Map<String, Conteudo> conteudos) throws Exception {
        String caminhoArquivo = "docs/arquivos/POO_Audiencia.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String login = fields[0];
                String statusAssistido = fields[1];
                String idConteudo = fields[2];

                Cliente cliente = clientes.get(login);

                String statusAssistidoFuturamente = "F";
                String statusConteudoAssistido = "A";
                Conteudo conteudo = conteudos.get(idConteudo);

                if (statusAssistido.equals(statusAssistidoFuturamente)) {
                    cliente.adicionarListaConteudoParaAssistir(conteudo);
                } else if (statusAssistido.equals(statusConteudoAssistido)) {
                    cliente.assistirConteudo(conteudo);
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            throw new Exception("Não foi possível realizar a leitura do arquivo de audiência.");
        }
    }

    /**
     * Método utilizado para realizar a leitura e configuração inicial do arquivo de
     * espectadores.
     * 
     * @throws Exception Lançada no caso em que não foi possível realizar a
     *                   leitura do arquivo.
     * @return O mapa populado com os dados do arquivo de texto.
     */
    public Map<String, Cliente> lerArquivosEspectadores() throws Exception {
        Map<String, Cliente> espectadores = new HashMap<>();

        String caminhoArquivo = "docs/arquivos/POO_Espectadores.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String nome = fields[0];
                String login = fields[1];
                String senha = fields[2];

                espectadores.put(login, new ClienteRegular(nome, login, senha));
                line = br.readLine();
            }

            return espectadores;
        } catch (IOException e) {
            throw new Exception("Não foi possível realizar a leitura do arquivo de espectadores.");
        }
    }

    /**
     * Método utilizado para realizar a leitura e configuração inicial do arquivo de
     * séries.
     * 
     * @throws Exception Lançada no caso em que não foi possível realizar a
     *                   leitura do arquivo.
     * @return O mapa populado com os dados do arquivo de texto.
     */
    public Map<String, Conteudo> lerArquivosSerie() throws Exception {
        Map<String, Conteudo> series = new HashMap<>();

        String caminhoArquivo = "docs/arquivos/POO_Series.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String idSerie = fields[0];
                String nome = fields[1];
                String dataLancamento = fields[2];

                Genero genero = GerarDados.obterGeneroAleatorio();
                Idioma idioma = GerarDados.obterIdiomaAleatorio();

                series.put(idSerie, new Serie(idSerie, nome, genero, idioma, dataLancamento));
                line = br.readLine();

            }

            return series;
        } catch (IOException e) {
            throw new Exception("Não foi possível realizar a leitura do arquivo de séries.");
        }
    }

    /**
     * Método utilizado para realizar a leitura e configuração inicial do arquivo de
     * filmes.
     * 
     * @throws Exception Lançada no caso em que não foi possível realizar a
     *                   leitura do arquivo.
     * @return O mapa populado com os dados do arquivo de texto.
     */
    public Map<String, Conteudo> lerArquivosFilme(Map<String, Conteudo> conteudos) throws Exception {
        Map<String, Conteudo> todosConteudos = conteudos;

        String caminhoArquivo = "docs/arquivos/POO_Filmes.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String idFilme = fields[0];
                String nome = fields[1];
                String dataLancamento = fields[2];
                String duracaoEmMin = fields[3];

                Genero genero = GerarDados.obterGeneroAleatorio();
                Idioma idioma = GerarDados.obterIdiomaAleatorio();

                todosConteudos.put(idFilme,
                        new Filme(idFilme, nome, genero, idioma, dataLancamento, duracaoEmMin, false));
                line = br.readLine();
            }

            return todosConteudos;
        } catch (IOException e) {
            throw new Exception("Não foi possível realizar a leitura do arquivo de filmes.");
        }
    }
}