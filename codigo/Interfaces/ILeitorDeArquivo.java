package codigo.Interfaces;

import java.util.Map;

import codigo.Audiencia;
import codigo.Cliente;
import codigo.Conteudo;

public interface ILeitorDeArquivo {
    Map<String, Audiencia> lerArquivosAudiencia() throws Exception;

    Map<String, Cliente> lerArquivosEspectadores() throws Exception;

    Map<String, Conteudo> lerArquivosSerie() throws Exception;

    Map<String, Conteudo> lerArquivosFilme() throws Exception;
}
