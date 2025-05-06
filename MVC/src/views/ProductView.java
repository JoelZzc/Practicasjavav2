package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

import models.ProductModel;
import models.Producto;

public class ProductView {

	private JFrame frame;
 	private ProductModel functions;
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

}
