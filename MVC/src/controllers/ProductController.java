package controllers;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import models.ProductModel;
import models.Producto;
import views.ProductView;

public class ProductController {

	public ProductView view;
	public ProductController() {
		
		view = new ProductView();
	}

	public void products() {
        view.products();
	}
	
	public void add() {
		view.add();
	}
}
