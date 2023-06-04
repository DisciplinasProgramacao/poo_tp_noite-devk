package codigo.CustomTypes;

import java.util.ArrayList;
import java.util.List;

import codigo.Cliente;

public class ClientesComMaisAvaliacoes {

    private List<Cliente> clientes;
    private int qtdAvaliacoes;

    /**
     * Construtor da classe ClienteComMaisAvaliacoes
     * 
     * @param clientes      Lista dos clientes com maior número de avaliações.
     *                      É pedido uma lista por parâmetro por ser possível
     *                      dois ou mais clientes possuírem o mesmo número de
     *                      avaliações, sendo possível indicar quem são todos eles.
     * @param qtdAvaliacoes Quantidade de avaliações que o(s) cliente(s) com maior
     *                      número de avaliações realizaram.
     */
    public ClientesComMaisAvaliacoes(List<Cliente> clientes, int qtdAvaliacoes) {
        this.clientes = clientes;
        this.qtdAvaliacoes = qtdAvaliacoes;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(this.clientes);
    }

    public int getQuantidadeAssistidas() {
        return this.qtdAvaliacoes;
    }
}
