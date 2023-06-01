package codigo.testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import codigo.Cliente;
import codigo.Conteudo;
import codigo.Filme;
import codigo.GerarDados;
import codigo.LeitorArquivos;
import codigo.Clientes.ClienteRegular;
import codigo.Interfaces.ILeitorDeArquivo;

public class leitorArquivosTeste {
    public static void main(String[] args) throws Exception {
        // Caminho do arquivo CSV a ser lido
        String caminhoArquivo = "docs/arquivos/POO_Espectadores.csv";
        Map<String, Cliente> espectadores = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String nome = fields[0];
                String login = fields[1];
                String senha = fields[2];

                espectadores.put(login, new ClienteRegular(nome, login, senha));
                line = br.readLine();
            }

         
        } catch (IOException e) {
            throw new Exception("Não foi possível realizar a leitura do arquivo de espectadores.");
        }
    

        
        // Verifica se o HashMap está vazio
                if (espectadores.isEmpty()) {
               
                    System.out.println("O arquivo CSV está vazio ou não foi possível lê-lo.");
               
                } else {
                    System.out.println("Conteúdo do arquivo CSV:");
                    for (Map.Entry<String, Cliente> entry : espectadores.entrySet()) {
                        String key = entry.getKey();
                        Cliente value = entry.getValue();
                        System.out.println("Chave: " + key + ", Valor: " + value);
                    }
                }
        
///teste refente ao leitura de arquivos filme
               Map<String, Conteudo> todosConteudos = new HashMap<>();
               caminhoArquivo = "docs/arquivos/POO_Filmes.csv";
             // gerando a leitura de linhas do arquivos
             try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String idFilme = fields[0];
                String nome = fields[1];
                String dataLancamento = fields[2];
                String duracaoEmMin = fields[3];

                String genero = GerarDados.obterGeneroAleatorio();
                String idioma = GerarDados.obterIdiomaAleatorio();

                todosConteudos.put(idFilme, new Filme(idFilme, nome, genero, idioma, dataLancamento, duracaoEmMin));
                line = br.readLine();
            }

        } catch (IOException e) {
            throw new Exception("Não foi possível realizar a leitura do arquivo de filmes.");
        }
    
    if (espectadores.isEmpty()) {
               
        System.out.println("O arquivo CSV está vazio ou não foi possível lê-lo.");
   
    } else {
        System.out.println("Conteúdo do arquivo CSV:");
        for (Map.Entry<String, Conteudo> entry : todosConteudos.entrySet()) {
            String key = entry.getKey();
            Conteudo value = entry.getValue();
            System.out.println("Chave: " + key + ", Valor: " + value);
        }
    }




}}