package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthModel {
	
	
	public AuthModel() {
	 		
	}
 	
 	public boolean access(String u, String p){
		String url = "src\\files\\users.txt";
 		try (BufferedReader bf = new BufferedReader(new FileReader(url))){ 
 			// convertir el row en String 
 			String row;
             while ((row = bf.readLine()) != null) {
                 // el string cortarlo con Split 
            	 String[] split = row.split(",");
                 System.out.print(row);
                 // comparar con el arreglo en la pos 1,2
                 if (split[1].equals(u) && split[2].equals(p)) {
                     return true;
                 }
             }
             return false;
 		} catch (Exception e) {
 			
 			e.printStackTrace();
 			System.out.println("error"); 
 		}

 		return false;
 	}
 	
 	
 	
 	public void registro(String name,String lastname, String company, String cargo, 
 			String username, String mail, String password, String confirmPassword ) throws IOException{
 		
 		FileWriter file= null;
 		PrintWriter writer= null;
 		
 		try {
 			file= new FileWriter("src\\files\\users.txt", true);
 			writer= new PrintWriter(file);
 			
 			writer.println();
 			String data=name+"|"+lastname+"|"+company+"|"+cargo+"|"+username+"|"+
 			mail+"|"+password+"|"+confirmPassword;
 			System.out.println(data);
 			writer.append(data);
 			
 		}catch(Exception e) {
 			e.printStackTrace();
 			System.out.println("error"); 
 		}finally {
 			file.close();
 		}
 	}

}


