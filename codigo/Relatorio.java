package codigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import codigo.CustomTypes.ClientesComMaisAvaliacoes;
import codigo.CustomTypes.ClientesComMaisMidiasAssistidas;
import codigo.Interfaces.IRelatorio;

public class Relatorio implements IRelatorio {
    /**
     * Método de obtenção dos clientes que assistiram a maior quantidade de mídias.
     *
     * @param clientes O mapa de clientes em que deseja verificar o cliente com
     *                 maior número de mídias assistidas
     * @return ClientesComMaisMidiasAssistidas, contendo uma lista com todos os
     *         clientes que mais assistiram mídias. É retornado uma lista devido ao
     *         caso de clientes com o mesmo número de mídias assistidas,
     *         possibilitando o retorno de todos eles.
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

    /**
     * Método de obtenção dos clientes que realizaram o maior número de avaliações
     * 
     * @param clientes O mapa de clientes em que deseja verificar quais possuem o
     *                 maior número de avaliações.
     * @return Instância do objeto ClientesComMaisAvaliacoes, contendo uma lista com
     *         todos os clientes que mais realizaram avaliações. É retornada uma
     *         lista com os clientes devido ao caso de clientes com a mesma
     *         quantidade de avaliações, possibilitando o retorno de todos eles.
     */
    public ClientesComMaisAvaliacoes obterClientesComMaisAvaliacoes(Map<String, Cliente> clientes) {
        int maiorNumeroAvaliacoes = -1;
        List<Cliente> clientesComMaisAvaliacoes = new ArrayList<>();

        for (var cliente : clientes.entrySet()) {
            int numAvaliacoes = cliente.getValue().obterQuantidadeAvaliacoes();
            if (numAvaliacoes > maiorNumeroAvaliacoes) {
                maiorNumeroAvaliacoes = numAvaliacoes;
                clientesComMaisAvaliacoes = new ArrayList<>(Arrays.asList(cliente.getValue()));
            } else if (numAvaliacoes == maiorNumeroAvaliacoes) {
                clientesComMaisAvaliacoes.add(cliente.getValue());
            }
        }

        return new ClientesComMaisAvaliacoes(clientesComMaisAvaliacoes, maiorNumeroAvaliacoes);
    }

    /**
     * Método de obtenção da porcentagem dos clientes com um número mínimo de
     * avaliações desejado.
     * 
     * @param clientes         O mapa de clientes em que deseja verificar quais
     *                         possuem o número de avaliações mínimo especificado.
     * @param qtdMinAvaliacoes A quantidade mínima de avaliações que o cliente
     *                         necessita para satisfazer a condição desejada.
     * @return A porcentagem dos clientes que satisfazem a condição de quantidade
     *         mínima de avaliações realizadas. Ex.: Se 5 de 10 clientes
     *         satisfizeram a condição de possuírem o número mínimo de avaliações
     *         especificado, é retornado 50, pois 50% dos clientes cumpriram a
     *         condição.
     */
    public double obterPorcentagemClientesComNumeroMinimoAvaliacoes(Map<String, Cliente> clientes,
            double qtdMinAvaliacoes) {
        int qtdClientesComNumeroMinAvaliacoes = 0;

        for (var cliente : clientes.entrySet()) {
            if (cliente.getValue().obterQuantidadeAvaliacoes() >= qtdMinAvaliacoes) {
                qtdClientesComNumeroMinAvaliacoes++;
            }
        }

        if (qtdClientesComNumeroMinAvaliacoes == 0)
            return 0;

        return (double) qtdClientesComNumeroMinAvaliacoes / clientes.size() * 100.0;
    }

    /**
     * Método para obtenção dos conteúdos mais assistidos, em ordem decrescente
     * 
     * @param conteudos    O mapa de conteúdos em que deseja verificar quais possuem
     *                     o maior número de visualizações.
     * @param numConteudos O número de conteúdos com maior número de visualizações
     *                     que deseja obter. Ex.: Top 10 conteúdos mais assistidos,
     *                     top 15 etc.
     * 
     * @return A lista dos conteúdos mais assistidos em ordem decrescente.
     */
    public List<Conteudo> obterConteudosMaisAssistidos(Map<String, Conteudo> conteudos, int numConteudos) {
        List<Conteudo> conteudosMaisAssistidos = new ArrayList<>(conteudos.values());

        conteudosMaisAssistidos.sort(Comparator.comparingInt(Conteudo::getNumVisualizacoes).reversed());

        return conteudosMaisAssistidos.subList(0, Math.min(numConteudos, conteudosMaisAssistidos.size()));
    }
}
