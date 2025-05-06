package controllers;

import java.util.List;

import models.ProductModel;
import models.Producto;
import views.ProductView;

public class ProductController {

	public ProductView view;
	public ProductController() {
		
		view = new ProductView();
	}

	public void products() {
		ProductModel pm = new ProductModel();
        List<Producto> listaProductos = pm.get();
        Object[][] data = new Object[listaProductos.size()][4];
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto p = listaProductos.get(i);
            data[i][0] = p.getID();
            data[i][1] = p.getNombre();
            data[i][2] = p.getPrecio();
            data[i][3] = p.getStock();
        }
        view.products(data);
	}
}
