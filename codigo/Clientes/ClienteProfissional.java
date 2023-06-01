package codigo.Clientes;

import codigo.Avaliacao;
import codigo.Cliente;
import codigo.Conteudo;

public class ClienteProfissional extends Cliente {

    public ClienteProfissional(String nome, String username, String senha) {
        super(nome, username, senha);
    }

    @Override
    public void avaliarMidia(Conteudo midia, int notaAvaliacao, String mensagemAvaliacao) {
        if (notaAvaliacao < Avaliacao.NOTA_MIN_AVALIACAO || notaAvaliacao > Avaliacao.NOTA_MAX_AVALIACAO)
            return;

        // Mídia já foi avaliada pelo usuário
        if (this.avaliacoes.get(midia.getId()) != null)
            return;

        midia.avaliarMidia(notaAvaliacao);

        Avaliacao avaliacao = new Avaliacao(midia.getId(), this.username, notaAvaliacao, mensagemAvaliacao);
        avaliacoes.put(midia.getId(), avaliacao);
    }
}
