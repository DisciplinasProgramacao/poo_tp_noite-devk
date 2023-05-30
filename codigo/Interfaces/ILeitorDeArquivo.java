package codigo.Interfaces;

import java.util.Map;

import codigo.Audiencia;
import codigo.Serie;
import codigo.Usuario;

public interface ILeitorDeArquivo {
    Map<String, Audiencia> lerArquivosAudiencia() throws Exception;
    Map<String, Usuario> lerArquivosEspectadores() throws Exception;
    Map<String, Serie> lerArquivosSerie() throws Exception;
}
