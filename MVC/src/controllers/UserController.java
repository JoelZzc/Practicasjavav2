package controllers;

import models.User;
import models.UserModel;
import views.UserView;

public class UserController {

	private UserView view;
	public UserController() {
		view = new UserView();
	}
	
	
	public void users() {
		UserModel um = new UserModel();
		view.user(um.get());
	}
	
	public void add() {
		
		view.showFormAdd();
	}
	
	public void update(User userToUpdate) {
		view.showFormUpdate(userToUpdate);
	}

}
