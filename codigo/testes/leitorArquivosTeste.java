package codigo.testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import codigo.Audiencia;
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
        Map<String, Audiencia> audiencia = new HashMap<>();
            String caminhoArquivo = "docs/arquivos/POO_Audiencia.csv";
                try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
                    String line = br.readLine();
                    while (line != null) {
                        String[] fields = line.split(";");
                        String login = fields[0];
                        String statusAssistido = fields[1];
                        String idSerie = fields[2];
        
                        audiencia.put(login, new Audiencia(login, statusAssistido, idSerie));
                        line = br.readLine();
                    }
                } catch (IOException e) {
                    throw new Exception("Não foi possível realizar a leitura do arquivo de audiência.");
                }
            
        // Verifica se o HashMap está vazio
                if (audiencia.isEmpty()) {
               
                    System.out.println("O arquivo CSV está vazio ou não foi possível lê-lo.");
               //se não , Itera sobre as entradas do HashMap e imprime a chave e o valor correspondentes

                } else {
                    System.out.println("Conteúdo do arquivo CSV:");
                    for (Entry<String, Audiencia> entry :  audiencia.entrySet()) {
                        String key = entry.getKey();
                        Audiencia value = entry.getValue();
                        System.out.println("Chave: " + key + ", Valor: " + value);
                    }
                }
            }
    
        
    }