package codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codigo.Interfaces.ILeitorDeArquivo;

public class LeitorArquivos implements ILeitorDeArquivo {
    public Map<String, Audiencia> lerArquivosAudiencia() {
        Map<String, Audiencia> audiencia = new HashMap<>();

        String caminhoArquivo = "docs/arquivos/POO_Audiencia.csv";

        // gerando a leitura de linhas do arquivos
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
            System.out.println("Error writing file: " + e.getMessage());
        } finally {
            return audiencia;
        }
    }

    public Map<String, Usuario> lerArquivosEspectadores() {
        Map<String, Usuario> espectadores = new HashMap<>();

        String caminhoArquivo = "docs/arquivos/POO_Espectadores.csv";
        // gerando a leitura de linhas do arquivos
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String nome = fields[0];
                String login = fields[1];
                String senha = fields[2];

                espectadores.put(login, new Usuario(nome, login, senha));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } finally {
            return espectadores;
        }
    }

    public Map<String, Serie> lerArquivosSerie() {
        Map<String, Serie> series = new HashMap<>();

        String caminhoArquivo = "docs/arquivos/POO_Series.csv";
        // gerando a leitura de linhas do arquivos
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String idSerie = fields[0];
                String nome = fields[1];
                String dataLancamento = fields[2];

                series.put(idSerie, new Serie(idSerie, nome, dataLancamento));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } finally {
            return series;
        }
    }
}