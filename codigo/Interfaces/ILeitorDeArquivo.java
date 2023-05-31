package codigo.Interfaces;

import java.util.Map;

import codigo.Cliente;
import codigo.Conteudo;

public interface ILeitorDeArquivo {
    void lerArquivosAudiencia(Map<String, Cliente> clientes, Map<String, Conteudo> conteudos) throws Exception;

    Map<String, Cliente> lerArquivosEspectadores() throws Exception;

    Map<String, Conteudo> lerArquivosSerie() throws Exception;

    Map<String, Conteudo> lerArquivosFilme(Map<String, Conteudo> conteudos) throws Exception;
}
