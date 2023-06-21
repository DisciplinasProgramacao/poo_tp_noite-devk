package codigo.Interfaces;

import java.util.List;
import java.util.Map;

import codigo.Cliente;
import codigo.Conteudo;
import codigo.Genero;
import codigo.CustomTypes.ClientesComMaisAvaliacoes;
import codigo.CustomTypes.ClientesComMaisMidiasAssistidas;

public interface IRelatorio {
    ClientesComMaisMidiasAssistidas obterClientesComMaisMidias(Map<String, Cliente> clientes);

    ClientesComMaisAvaliacoes obterClientesComMaisAvaliacoes(Map<String, Cliente> clientes);

    double obterPorcentagemClientesComNumeroMinimoAvaliacoes(Map<String, Cliente> clientes, double qtdMinAvaliacoes);

    List<Conteudo> obterConteudosMaisAssistidos(Map<String, Conteudo> conteudos, int numConteudos);

    List<Conteudo> obterConteudosComMelhorMedia(Map<String, Conteudo> conteudos, int numMinVezesVisto, int numConteudos);
    
    Map<Genero, List<Conteudo>> obterConteudosComMaisVisualizacoesSeparadasPorGenero(Map<String, Conteudo> conteudos, int numConteudos);
}
