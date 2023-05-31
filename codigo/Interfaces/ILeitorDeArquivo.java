package codigo.Interfaces;

import java.util.Map;

import codigo.Audiencia;
import codigo.Serie;
import codigo.Cliente;

public interface ILeitorDeArquivo {
    Map<String, Audiencia> lerArquivosAudiencia() throws Exception;
    Map<String, Cliente> lerArquivosEspectadores() throws Exception;
    Map<String, Serie> lerArquivosSerie() throws Exception;
}
