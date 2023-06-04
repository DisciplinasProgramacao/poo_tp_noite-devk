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
     * @param clientes   Lista dos clientes com maior número de mídias assistidas.
     *                   É pedido uma lista por parâmetro por ser possível dois ou
     *                   mais clientes possuírem o mesmo número de avaliações, sendo
     *                   possível indicar quem são todos eles.
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
