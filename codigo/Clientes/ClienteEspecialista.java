package codigo.Clientes;

import codigo.Avaliacao;
import codigo.Cliente;

public class ClienteEspecialista extends Cliente {

    public ClienteEspecialista(String nome, String username, String senha) {
        super(nome, username, senha);
    }

    @Override
    public void avaliarMidia(String idMidia, int notaAvaliacao, String mensagemAvaliacao) {
        if (notaAvaliacao < Avaliacao.NOTA_MIN_AVALIACAO|| notaAvaliacao > Avaliacao.NOTA_MAX_AVALIACAO) {
            return;
        }
        
        // Mídia já foi avaliada pelo usuário
        if (this.avaliacoes.get(idMidia) != null) {
            return;
        }

        Avaliacao avaliacao = new Avaliacao(idMidia, this.username, notaAvaliacao, mensagemAvaliacao);
        avaliacoes.put(idMidia, avaliacao);
    }
    
}
