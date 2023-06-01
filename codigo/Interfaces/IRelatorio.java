package codigo.Interfaces;

import java.util.Map;

import codigo.Cliente;
import codigo.CustomTypes.ClientesComMaisMidiasAssistidas;

public interface IRelatorio {
    ClientesComMaisMidiasAssistidas obterClientesComMaisMidias(Map<String, Cliente> clientes);
}
