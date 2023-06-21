package codigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        for (Cliente cliente : clientes.values()) {
            int numMidiasAssistidas = cliente.obterQuantidadeMidiasAssistidas();
            if (numMidiasAssistidas > maiorNumeroMidiasAssistidas) {
                maiorNumeroMidiasAssistidas = numMidiasAssistidas;
                clientesQueMaisAssistiram = new ArrayList<>(Arrays.asList(cliente));
            } else if (numMidiasAssistidas == maiorNumeroMidiasAssistidas) {
                clientesQueMaisAssistiram.add(cliente);
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

        for (Cliente cliente : clientes.values()) {
            int numAvaliacoes = cliente.obterQuantidadeAvaliacoes();
            if (numAvaliacoes > maiorNumeroAvaliacoes) {
                maiorNumeroAvaliacoes = numAvaliacoes;
                clientesComMaisAvaliacoes = new ArrayList<>(Arrays.asList(cliente));
            } else if (numAvaliacoes == maiorNumeroAvaliacoes) {
                clientesComMaisAvaliacoes.add(cliente);
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

        for (Cliente cliente : clientes.values()) {
            if (cliente.obterQuantidadeAvaliacoes() >= qtdMinAvaliacoes) {
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

    /**
     * Método de obtenção dos conteúdos com a melhor média de avaliações e que
     * satisfaçam a condição de terem sido vistos um número mínimo de vezes, em
     * ordem decrescente.
     * 
     * @param conteudos        O mapa de conteúdos em que deseja verificar quais
     *                         possuem a melhor média, satisfazendo a condição de
     *                         número mínimo de vezes visto.
     * @param numMinVezesVisto O número mínimo de vezes em que o conteúdo deve ter
     *                         sido assistido para ser contabilizado.
     * @param numConteudos     O número de conteúdos com a melhor média de
     *                         avaliações em que deseja obter. Ex.: Top 10 conteúdos
     *                         com a melhor média de avaliações e que foram
     *                         assistidos 100 vezes, top 15 etc.
     * @return A lista dos conteúdos com a melhor média de avaliações e que foram
     *         assistidos um número mínimo de vezes especificado, em ordem
     *         decrescente.
     */
    public List<Conteudo> obterConteudosComMelhorMedia(Map<String, Conteudo> conteudos, int numMinVezesVisto,
            int numConteudos) {
        List<Conteudo> conteudosComAMelhorMediaComNumeroMinimoVezesVisto = new ArrayList<>();
        List<Conteudo> conteudosLista = new ArrayList<>(conteudos.values());
        
        conteudosLista.sort(Comparator.comparingLong(Conteudo::getMediaAvaliacoes).reversed());
        
        for (Conteudo conteudo : conteudosLista) {
            if (conteudosComAMelhorMediaComNumeroMinimoVezesVisto.size() == numConteudos) {
                return conteudosComAMelhorMediaComNumeroMinimoVezesVisto;
            }

            if (conteudo.numAvaliacoes >= numMinVezesVisto) {
                conteudosComAMelhorMediaComNumeroMinimoVezesVisto.add(conteudo);
            }
        }

        return conteudosComAMelhorMediaComNumeroMinimoVezesVisto;
    }
    // 15 Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente separadas por gênero'
      public List<Conteudo>obterConteudosComMelhorMediaVistopeloMenosCem(Map<String, Conteudo> conteudos, int numVisualizacoes ,
            int numConteudos){
              List<Conteudo> conteudosComAMelhorMediaComNumeroMinimoVezesVistoPorGenero= new ArrayList<>();
                List<Conteudo> conteudosLista = new ArrayList<>(conteudos.values());
           conteudosLista.sort(Comparator.comparingLong(Conteudo::getMediaAvaliacoes).reversed());
            if(numVisualizacoes >100){
           for(int i=0 ;i <= 10 ; i++ ){
                for (Conteudo conteudo : conteudosLista) {
          conteudosComAMelhorMediaComNumeroMinimoVezesVistoPorGenero.add(conteudo);
          conteudosComAMelhorMediaComNumeroMinimoVezesVistoPorGenero.sort(Comparator.comparing(Conteudo::getGenero));
        
        }
        }}
        return  conteudosComAMelhorMediaComNumeroMinimoVezesVistoPorGenero;
    }

    /**
     * Método para obtenção das mídias com mais visualizações separadas por gênero,
     * em ordem decrescente.
     * 
     * @param conteudos    O mapa de conteúdos em que deseja verificar quais possuem
     *                     o maior número de visualizações, separados
     *                     individualmente por gênero.
     * @param numConteudos O número de conteúdos com mais visualizações em que
     *                     deseja obter. Ex.: Top 10 conteúdos com maior número de
     *                     visualizações separados por gênero, top 15 conteúdos etc.
     * 
     * @return Um mapa contendo o gênero como chave de identificador para a lista
     *         dos conteúdos com maior número de visualizações.
     */
    public Map<Genero, List<Conteudo>> obterConteudosComMaisVisualizacoesSeparadasPorGenero(
            Map<String, Conteudo> conteudos, int numConteudos) {
        Map<Genero, List<Conteudo>> conteudosComMaisVisualizacoesSeparadosPorGenero = new HashMap<>();

        for (Genero genero : Genero.values()) {
            List<Conteudo> listaGenero = conteudos.values().stream().filter(conteudo -> conteudo.genero.equals(genero))
                    .collect(Collectors.toList());
            listaGenero.sort(Comparator.comparingLong(Conteudo::getNumVisualizacoes).reversed());
            List<Conteudo> conteudosMaisAssistidos = listaGenero.subList(0, Math.min(numConteudos, listaGenero.size()));

            conteudosComMaisVisualizacoesSeparadosPorGenero.put(genero, conteudosMaisAssistidos);
        }

        return conteudosComMaisVisualizacoesSeparadosPorGenero;
    }
}


      
                

