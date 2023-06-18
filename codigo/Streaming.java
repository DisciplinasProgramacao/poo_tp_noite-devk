package codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import codigo.Interfaces.ILeitorDeArquivo;

public class Streaming {
    private Map<String, Conteudo> conteudos = new HashMap<>();
    private Map<String, Cliente> usuarios = new HashMap<>();
    private ILeitorDeArquivo leitorDeArquivo;
    private Cliente usuarioLogado = null;

    // Injeção de dependência do leitor de arquivo
    public Streaming(ILeitorDeArquivo leitorDeArquivo) {
        this.leitorDeArquivo = leitorDeArquivo;
        this.popularDados();
    }

    /**
     * Método para obter o conteúdo ao passar o seu id.
     * 
     * @param id O id do conteúdo, especificado no seu arquivo de texto, podendo ser
     *           tanto uma Serie quanto um Filme.
     * 
     * @return O conteúdo com o id desejado ou nulo, caso um conteúdo com esse id
     *         não exista.
     */
    public Conteudo obterConteudoPorId(String id) {
        return this.conteudos.get(id);
    }

    /**
     * Método para popular os dados iniciais do aplicativo, com clientes, conteúdos
     * e os demais dados necessários.
     */
    private void popularDados() {
        try {
            this.conteudos = this.leitorDeArquivo.lerArquivosSerie();
            this.usuarios = this.leitorDeArquivo.lerArquivosEspectadores();
            // this.leitorDeArquivo.lerArquivosAudiencia(this.usuarios, this.conteudos);
            System.out.println("aqui safe");
            this.conteudos = this.leitorDeArquivo.lerArquivosFilme(this.conteudos);
            System.out.println("aqui tbm");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para realizar login do cliente, atualizando qual o usuário logado no
     * sistema.
     * 
     * @param username O nome de usuário do cliente que deseja fazer login
     * @param senha    A senha do cliente que deseja fazer login
     * 
     * @return Se o login foi sucedido ou não, considerando as credenciais enviadas.
     */
    public boolean fazerLogin(String username, String senha) {
        Cliente usuario = this.usuarios.get(username);
        System.out.println(usuario.username);
        System.out.println(usuario.senha);
        if (!usuario.checarCredenciais(username, senha)) {
            return false;
        }
        this.usuarioLogado = usuario;

        return true;
    }

    /**
     * Método para realizar a busca dos conteúdos por gênero
     * 
     * @param genero O gênero do conteúdo que deseja buscar
     * @return Uma lista de todos os conteúdos que correspondem ao gênero
     *         especificado na
     *         busca
     */
    private List<Conteudo> buscarConteudoPorGenero(String genero) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Map.Entry<String, Conteudo> conteudo : this.conteudos.entrySet()) {
            if (conteudo.getValue().getGenero().equals(genero)) {
                conteudosFiltrados.add(conteudo.getValue());
            }
        }

        return conteudosFiltrados;
    }

    /**
     * Método para realizar a busca dos conteúdos por nome
     * 
     * @param nome O nome do conteúdo que deseja buscar
     * @return Uma lista de todos os conteúdos que correspondem ao nome especificado
     *         na busca.
     */
    public List<Conteudo> buscarConteudoPorNome(String nome) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Map.Entry<String, Conteudo> conteudo : this.conteudos.entrySet()) {
            if (conteudo.getValue().getNome().contains(nome)) {
                conteudosFiltrados.add(conteudo.getValue());
            }
        }

        return conteudosFiltrados;
    }

    /**
     * Método para realizar a busca dos conteúdos por idioma
     * 
     * @param idioma O idioma do conteúdo que deseja buscar.
     * @return Uma lista de todos os conteúdos que correspodnem ao idioma
     *         especificado na busca.
     */
    private List<Conteudo> buscarConteudoPorIdioma(String idioma) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Map.Entry<String, Conteudo> conteudo : this.conteudos.entrySet()) {
            if (conteudo.getValue().getIdioma().equals(idioma)) {
                conteudosFiltrados.add(conteudo.getValue());
            }
        }

        return conteudosFiltrados;
    }

    /**
     * Getter para obter o usuário atual logado no sistema.
     * 
     * @return O usuário atual logado no sistema.
     */
    public Cliente getUsuarioLogado() {
        return this.usuarioLogado;
    }
}