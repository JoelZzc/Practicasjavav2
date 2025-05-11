package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.ProductController;
import models.ProductModel;
import models.Producto;

public class ProductView {

	private JFrame frame;
	public ProductView() {
		
	}
	
	public void products(Object[][] data) {
 		
 		frame = new JFrame();
 		frame.setBounds(100, 100, 920, 534);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
 		
 		JPanel panelProducts = new JPanel();
 		panelProducts.setBackground(new Color(255, 255, 255));
 		frame.getContentPane().add(panelProducts, BorderLayout.CENTER);
 		panelProducts.setBorder(new EmptyBorder(5, 5, 5, 5));
 		panelProducts.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelProducts.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.decode("#705AAD"));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#F0DD01"));
		panelProducts.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#705AAD"));
		panelProducts.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				ProductController pc = new ProductController();
				pc.add();
				
			}
			
		});
		panel_2.add(btnNewButton);
 		
 		String[] columnNames= {
				"ID",
				"Nombre",
				"Precio",
				"Stock",
		};
 		
 		JTable table = new JTable(data,columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 10, 800,400);
		panel.add(scrollPane);
		panel.revalidate();
 		
 	}
	
	public void add() {
		frame = new JFrame();
 		frame.setBounds(100, 100, 920, 534);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
 		
 		JPanel panelProducts = new JPanel();
 		panelProducts.setBackground(new Color(255, 255, 255));
 		frame.getContentPane().add(panelProducts, BorderLayout.CENTER);
 		panelProducts.setBorder(new EmptyBorder(5, 5, 5, 5));
 		panelProducts.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelProducts.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.decode("#705AAD"));
		panel.setLayout(null);
		
		JLabel idTag = new JLabel("ID del producto");
		idTag.setFont(new Font("Arial", Font.PLAIN, 14));
		idTag.setBounds(50,50,200,30);
		panel.add(idTag);
		
		JTextField idInput = new JTextField();
		idInput.setFont(new Font("Arial", Font.PLAIN, 12));
		idInput.setBounds(50,90, 200, 30);
		panel.add(idInput);
		
		JLabel nameTag = new JLabel("Nombre del producto");
		nameTag.setFont(new Font("Arial", Font.PLAIN, 14));
		nameTag.setBounds(50,130,200,30);
		panel.add(nameTag);
		
		JTextField nameInput = new JTextField();
		nameInput.setFont(new Font("Arial", Font.PLAIN, 12));
		nameInput.setBounds(50,170, 200, 30);
		panel.add(nameInput);
		
		JLabel priceTag = new JLabel("Precio del producto");
		priceTag.setFont(new Font("Arial", Font.PLAIN, 14));
		priceTag.setBounds(50,210,200,30);
		panel.add(priceTag);
		
		JTextField priceInput = new JTextField();
		priceInput.setFont(new Font("Arial", Font.PLAIN, 12));
		priceInput.setBounds(50,250, 200, 30);
		panel.add(priceInput);
		
		JLabel stockTag = new JLabel("Stock del producto");
		stockTag.setFont(new Font("Arial", Font.PLAIN, 14));
		stockTag.setBounds(50,290,200,30);
		panel.add(stockTag);
		
		JTextField stockInput = new JTextField();
		stockInput.setFont(new Font("Arial", Font.PLAIN, 12));
		stockInput.setBounds(50,330, 200, 30);
		panel.add(stockInput);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#F0DD01"));
		panelProducts.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("AÑADIR PRODUCTO");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#705AAD"));
		panelProducts.add(panel_2, BorderLayout.SOUTH);
		
		JButton add = new JButton("Añadir");
		add.setFont(new Font("Arial", Font.PLAIN, 16));
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int id = Integer.parseInt(idInput.getText()); 
				String name = nameInput.getText();
				double price = Double.parseDouble(priceInput.getText()); 
				int stock = Integer.parseInt(stockInput.getText()); 

				ProductModel pm = new ProductModel();
				pm.addProduct(id,name,price,stock);
				
				frame.dispose();
				
				ProductController pc = new ProductController();
				pc.products();
				
			}});
		panel_2.add(add);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_2.add(btnNewButton_1);
	}
}
