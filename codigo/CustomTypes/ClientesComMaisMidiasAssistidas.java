package codigo.CustomTypes;

import java.util.ArrayList;
import java.util.List;

import codigo.Cliente;

public class ClientesComMaisMidiasAssistidas {
    private List<Cliente> clientes;
    private int quantidadeAssistidas;

    /**
     * Construtor da classe ClientesComMaisMidiasAssistidas
     * 
     * @param clientes   Os clientes que possuíram a maior quantidade de mídias
     *                   assistidas
     * @param quantidade A quantidade de mídias assistidas por esses clientes
     */
    public ClientesComMaisMidiasAssistidas(List<Cliente> clientes, int quantidade) {
        this.clientes = clientes;
        this.quantidadeAssistidas = quantidade;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(this.clientes);
    }

    public int getQuantidadeAssistidas() {
        return this.quantidadeAssistidas;
    }
}
