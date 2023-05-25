package codigo;
import java.io.*;
import java.util.Scanner;

public class LeitorFilmes {
        String file = "docs/arquivos/POO_Filmes.csv";
        Scanner sc = null;                        //a ideia do scanner era pro usuário selecionar o filme específico, mas acho que deve ser feita fora do leitor
        BufferedReader reader = null;
        String line = "";
        {

		try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {

                String[] linha = line.split(";");
                for(String TodosFilmes : linha) {
                    System.out.printf("%-10s", TodosFilmes); //imprimir todos os filmes + info, separados o porcentagem -10 são os espaço do texto, mas ainda falta teste
                }
            }
        }
		catch (IOException e) {
            e.printStackTrace();
		}
        finally{
            if (sc != null && reader != null){
            sc.close();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}}
