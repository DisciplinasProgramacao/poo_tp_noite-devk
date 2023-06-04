package codigo.Interfaces;

import java.util.Map;

import codigo.Cliente;
import codigo.CustomTypes.ClientesComMaisAvaliacoes;
import codigo.CustomTypes.ClientesComMaisMidiasAssistidas;

public interface IRelatorio {
    ClientesComMaisMidiasAssistidas obterClientesComMaisMidias(Map<String, Cliente> clientes);

    ClientesComMaisAvaliacoes obterClientesComMaisAvaliacoes(Map<String, Cliente> clientes);

    double obterPorcentagemClientesComNumeroMinimoAvaliacoes(Map<String, Cliente> clientes, double qtdMinAvaliacoes);
}
