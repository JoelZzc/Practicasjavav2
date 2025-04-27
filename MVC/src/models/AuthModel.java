package models;

import java.io.BufferedReader;
import java.io.FileReader;

public class AuthModel {
	
	
	public AuthModel() {
	 		
	}
 	
 	public boolean access(String u, String p){
		String url = AuthModel.class.getResource("/files/users.txt").getPath();
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
 	
 	
 	
 	public String registro(String u){
 		return u;
 	}

}


