import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LeituraArquivos {
  
    
    public void lendoExpectadores(){
Map<String, Usuario> map = new HashMap<String, Usuario>();

String sourceFileStr = "C:\\Users\\User\\OneDrive\\Documentos\\arquivospoo\\POO_Espectadores.csv";
//gerando a leitura de linhas do arquivos 
	try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

		  String line = br.readLine();
   	   while (line!=null) {
   	    String[] fields = line.split(";");
   	    map.put(fields[1] , new Usuario(fields [0], fields [1] , fields [2]));
        line = br.readLine();
        
       }
        }catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
        }
     
        }


        public void lendoAudiencia(){
            Map<String, Usuario> map = new HashMap<String, Usuario>();
            String sourceFileStr = "C:\\Users\\User\\OneDrive\\Documentos\\arquivospoo\\POO_Audiencia.csv";
            //gerando a leitura de linhas do arquivos 
                try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            
                      String line = br.readLine();
                      while (line!=null) {
                       String[] fields = line.split(";");
                       map.put(fields[0] , new Usuario(fields [0], fields [1] , fields [2]));
                    line = br.readLine();
                    
                   }
                    }catch (IOException e) {
                        System.out.println("Error writing file: " + e.getMessage());
                    }
                 
                    }
            
                
                public void lendoSeries(){
                    Map<String, Usuario> map = new HashMap<String, Usuario>();
                    String sourceFileStr = "C:\\Users\\User\\OneDrive\\Documentos\\arquivospoo\\POO_Series.csv";
                    //gerando a leitura de linhas do arquivos 
                        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
                    
                              String line = br.readLine();
                              while (line!=null) {
                               String[] fields = line.split(";");
                               map.put(fields[0] , new Usuario(fields [0], fields [1] , fields [2]));
                            line = br.readLine();
                            
                           }  
                            }catch (IOException e) {
                                System.out.println("Error writing file: " + e.getMessage());
                            }
                         
                            }
                    
                        }
        

    