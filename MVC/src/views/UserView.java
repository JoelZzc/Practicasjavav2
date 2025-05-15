package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.HomeController;
import controllers.ProductController;
import controllers.UserController;
import models.ProductModel;
import models.Producto;
import models.User;
import views.ProductView.ButtonEditor;
import views.ProductView.ButtonRenderer;

public class UserView {
	
	private JFrame frame;

	public UserView() {
		
	}
	
	public void user(ArrayList<User> user) {
 		frame = new JFrame();
 		frame.setBounds(100, 100, 920, 534);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
 		
 		JPanel panelUsers = new JPanel();
 		panelUsers.setBackground(new Color(255, 255, 255));
 		frame.getContentPane().add(panelUsers, BorderLayout.CENTER);
 		panelUsers.setBorder(new EmptyBorder(5, 5, 5, 5));
 		panelUsers.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelUsers.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.decode("#705AAD"));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#F0DD01"));
		panelUsers.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#705AAD"));
		panelUsers.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				HomeController hc = new HomeController();
				hc.home();;
				
			}
			
		});
		panel_2.add(btnNewButton);
 		
		String[] columnNames = {
				"ID", 
				"Nombre", 
				"Email", 
				"Rol", 
				"Teléfono"
		};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);

		for (User u : user) {
			model.addRow(new Object[]{
				u.getId(),
				u.getName(),
				u.getEmail(),
				u.getRole(),
				u.getPhone()
			});
		}

		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		panelUsers.add(scrollPane, BorderLayout.CENTER);
		panel.revalidate();
	}

}
