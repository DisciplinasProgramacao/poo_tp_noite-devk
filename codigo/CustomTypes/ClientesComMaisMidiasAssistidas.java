package codigo.CustomTypes;

import java.util.ArrayList;
import java.util.List;

import codigo.Cliente;

public class ClientesComMaisMidiasAssistidas {
    private List<Cliente> clientes;
    private int quantidade;

    public ClientesComMaisMidiasAssistidas(List<Cliente> clientes, int quantidade) {
        this.clientes = clientes;
        this.quantidade = quantidade;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(this.clientes);
    }

    public int getQuantidade() {
        return this.quantidade;
    }
}
