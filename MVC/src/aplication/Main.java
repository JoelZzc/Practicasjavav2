package aplication;

import controllers.AuthController;

public class Main {

	public static void main(String[] args) {
		
		
		AuthController application = new AuthController();
		//application.register();
 		application.login();
	}

}
