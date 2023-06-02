package codigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import codigo.CustomTypes.ClientesComMaisMidiasAssistidas;
import codigo.Interfaces.IRelatorio;

public class Relatorio implements IRelatorio {
    /**
     * Método de obtenção dos clientes com maior quantidade de mídias assistidos,
     * retornando uma lista dos mesmos e a quantidade de mídias assistidas. É
     * utilizada uma lista devido ao caso de clientes com o mesmo número de mídias
     * assistidas.
     * 
     * @param clientes O mapa de clientes em que deseja verificar o cliente com
     *                 maior número de mídias assistidas
     * @return ClientesComMaisMidiasAssistidas, contendo uma lista com todos os
     *         clientes que mais assistiram mídia. É retornado uma lista devido ao
     *         caso de clientes com o mesmo número de mídias assistidas,
     *         possibilitando o retorno de todos.
     */
    public ClientesComMaisMidiasAssistidas obterClientesComMaisMidias(Map<String, Cliente> clientes) {
        int maiorNumeroMidiasAssistidas = -1;
        List<Cliente> clientesQueMaisAssistiram = new ArrayList<>();

        for (var cliente : clientes.entrySet()) {
            int numMidiasAssistidas = cliente.getValue().obterQuantidadeMidiasAssistidas();
            if (numMidiasAssistidas > maiorNumeroMidiasAssistidas) {
                maiorNumeroMidiasAssistidas = numMidiasAssistidas;
                clientesQueMaisAssistiram = new ArrayList<>(Arrays.asList(cliente.getValue()));
            } else if (numMidiasAssistidas == maiorNumeroMidiasAssistidas) {
                clientesQueMaisAssistiram.add(cliente.getValue());
            }
        }

        return new ClientesComMaisMidiasAssistidas(clientesQueMaisAssistiram, maiorNumeroMidiasAssistidas);
    }
}
