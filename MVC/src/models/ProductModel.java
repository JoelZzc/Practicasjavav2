package models;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.Reader;
public class ProductModel {

	public ProductModel() {
		
	}
	
	public List<Producto> get()
 	{
		List<Producto> productos = new ArrayList<>();
 		JSONParser jsonParser = new JSONParser();
 		String url = "src\\files\\productos.json";
         
 		 try (FileReader reader = new FileReader(url)) {
 			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
 			JSONArray productList = (JSONArray) jsonObject.get("productos");

 			for (Object obj : productList) {
 	            JSONObject prod = (JSONObject) obj;

 	            int id = Math.toIntExact((Long) prod.get("id"));
 	            String nombre = (String) prod.get("nombre");
 	            double precio = (Double) prod.get("precio");
 	            int stock = Math.toIntExact((Long) prod.get("stock"));

 	            Producto producto = new Producto(id, nombre, precio, stock);
 	            productos.add(producto);
 	        }

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ParseException e) {
             e.printStackTrace();
         }
 		 
         return productos;
 	}
	public boolean addProduct(int id, String nombre, double precio, int stock) {
        JSONParser jsonParser = new JSONParser();
 		String url = "src\\files\\productos.json";
        try (FileReader reader = new FileReader(url)) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray productosArray = (JSONArray) jsonObject.get("productos");

            JSONObject producto = new JSONObject();
            producto.put("id", id);
            producto.put("nombre", nombre);
            producto.put("precio", precio);
            producto.put("stock", stock);

            productosArray.add(producto);

            try (FileWriter file = new FileWriter(url)) {
                file.write(jsonObject.toJSONString());
                file.flush();
                return true;
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return false;
    }
	
	public boolean remove(int id) {
		JSONParser jsonParser = new JSONParser();
	    String url = "src\\files\\productos.json";

	    try (FileReader reader = new FileReader(url)) {
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        JSONArray productosArray = (JSONArray) jsonObject.get("productos");

	        for (int i = 0; i < productosArray.size(); i++) {
	            JSONObject producto = (JSONObject) productosArray.get(i);
	            long productoId = (long) producto.get("id");

	            if (productoId == id) {
	                productosArray.remove(i);
	                break;
	            }
	        }

	        try (FileWriter file = new FileWriter(url)) {
	            file.write(jsonObject.toJSONString());
	            file.flush();
	            return true;
	        }

	    } catch (IOException | ParseException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
}
