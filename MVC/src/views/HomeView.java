package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import models.AuthModel;

public class HomeView {
	private JFrame frame;
 	private AuthModel functions;
	public HomeView() {
 		functions = new AuthModel();
	}
	
	public void home() {
		frame = new JFrame();
 		frame.setBounds(100, 100, 500, 500);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
		JPanel panelHome= new JPanel();
		frame.getContentPane().add(panelHome, BorderLayout.CENTER);		
		panelHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelHome.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelHome.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("HOMEVIEW");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panelHome.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Bienvenido a usuario");
			}
			
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registro");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Bienvenido a registro");
			}
			
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Configuración");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Bienvenido a configuración");
			}
			
		});
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panelHome.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.decode("#F0DD01"));
		panel_3.setForeground(new Color(255, 128, 128));
		panel_3.setBounds(10, 10, 295, 181);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 10, 32, 32);
		lblNewLabel_2.setIcon(new ImageIcon(AuthView.class.getResource("/images/calendario (1).png")));
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Contador de usuarios registrados");
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(52, 10, 223, 32);
		panel_3.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_5 = new JLabel("1- Joel Zazueta Carrillo");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(30, 52, 137, 13);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("2- Diego Bueno Castro\r\n");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(30, 75, 192, 13);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("3- Ariel Alejandro Chaides Amador\r\n");
		lblNewLabel_5_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5_1_1.setBounds(30, 98, 192, 13);
		panel_3.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("4- Luis Rincon Camarena\r\n");
		lblNewLabel_5_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5_1_2.setBounds(30, 121, 192, 13);
		panel_3.add(lblNewLabel_5_1_2);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setForeground(new Color(255, 128, 128));
		panel_3_1.setBackground(Color.decode("#705AAD"));
		panel_3_1.setBounds(314, 10, 153, 181);
		panel_2.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hora");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(59, 10, 42, 24);
		panel_3_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(AuthView.class.getResource("/images/reloj-de-pared.png")));
		lblNewLabel_2_1.setBounds(10, 10, 24, 24);
		panel_3_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("13:20");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 40));
		lblNewLabel_4.setBounds(30, 44, 123, 116);
		panel_3_1.add(lblNewLabel_4);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1_1.setForeground(new Color(255, 128, 128));
		panel_3_1_1.setBackground(new Color(255, 255, 255));
		panel_3_1_1.setBounds(10, 202, 153, 187);
		panel_2.add(panel_3_1_1);
		panel_3_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Notificaciones");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(44, 10, 99, 24);
		panel_3_1_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(AuthView.class.getResource("/images/activo.png")));
		lblNewLabel_2_1_1.setBounds(10, 10, 24, 24);
		panel_3_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Vacío");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(54, 44, 62, 13);
		panel_3_1_1.add(lblNewLabel_3);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1_2.setForeground(new Color(255, 128, 128));
		panel_3_1_2.setBackground(Color.decode("#6E40ED"));
		panel_3_1_2.setBounds(173, 202, 294, 187);
		panel_2.add(panel_3_1_2);
		panel_3_1_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Actividad Reciente");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(61, 6, 139, 24);
		panel_3_1_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(AuthView.class.getResource("/images/diagrama.png")));
		lblNewLabel_2_1_2.setBounds(10, 6, 24, 24);
		panel_3_1_2.add(lblNewLabel_2_1_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#E63294"));
		panel_4.setBounds(57, 95, 24, 82);
		panel_3_1_2.add(panel_4);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.decode("#E63294"));
		panel_4_1.setBounds(110, 79, 24, 98);
		panel_3_1_2.add(panel_4_1);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(Color.decode("#E63294"));
		panel_4_2.setBounds(164, 73, 24, 104);
		panel_3_1_2.add(panel_4_2);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setBackground(Color.decode("#E63294"));
		panel_4_3.setBounds(221, 58, 24, 119);
		panel_3_1_2.add(panel_4_3);
	}

}
