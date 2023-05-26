package codigo.Interfaces;

import java.util.Map;

import codigo.Audiencia;
import codigo.Serie;
import codigo.Usuario;

public interface ILeitorDeArquivo {
    Map<String, Audiencia> lerArquivosAudiencia();
    Map<String, Usuario> lerArquivosEspectadores();
    Map<String, Serie> lerArquivosSerie();
}
