package models;

public class AuthModel {
	
	
	public AuthModel() {
	 		
	}
 	
 	public boolean access(String u, String p){
 		
 		if(u.equals("joel12@gmail.com") ) {
 			if(p.equals("1234")) {
 				
 				return true; 
 				
 			}else {
 				return false;
 				
 			}
 		}else {
 			return false; 
 		}
 		 
 	}
 	
 	public String registro(String user){
 		return user;
 	}

}


