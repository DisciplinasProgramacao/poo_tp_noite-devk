package pooMain;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import pooMain.Usuario;



public class pooMain {  
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	 System.out.println("digite o nome do usuário") ;
	      String Nomeusuario = "Ada31";
	      System.out.println("digite a senha:") ;
          String Senha = "ABro14436";    
   
          
	     
	
	List<Usuario> list = new ArrayList<>();
     

	String sourceFileStr = "C:\\Users\\User\\OneDrive\\Área de Trabalho\\poo_series\\POO_Espectadores.csv";
	
//gerando a leitura de linhas do arquivos 
	try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

		  String line = br.readLine();
   	   while (line!=null) {
   	    String[] fields = line.split(";");
   	      list.add(new Usuario (fields[0] , fields[1],  fields[2]));
           line = br.readLine();
        
           
           // francisco franmoura fadff
         //  Ada23;ABro14428
   	   }
   //for para testar se a lista esta sendo devidamente lida
   	boolean existe =  false;
   	   for (Usuario item : list) {
   	     if( item.checarCredenciais(Nomeusuario,Senha)) {
   	    	 existe=true;
   	      break;
   	     }
   	     
				
   	   }
   	if (existe) {
			System.out.println ("acesso permitido"); 

		}
		
		else {
			
			System.out.println ("login ou senha incorreto"); 
		}
		
	}catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}

}}