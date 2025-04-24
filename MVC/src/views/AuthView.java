package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.AuthModel;

public class AuthView {
	
	private JFrame frame;
 	private JTextField textField;
 	private JPasswordField passwordField;
 	private AuthModel functions;
 
 	public AuthView() {
 		
 		functions = new AuthModel();
 	}
 	
 	public void login() {
 		
 		System.out.println("Hola");
 		
 		frame = new JFrame();
 		frame.setBounds(100, 100, 500, 500);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		frame.setVisible(true);
		JPanel panelLogin= new JPanel();
		frame.getContentPane().add(panelLogin, BorderLayout.CENTER);		
		panelLogin.setBackground(new Color(128,0,128));
		panelLogin.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Inicia sesión");
		etiqueta1.setSize(160,40);
		etiqueta1.setLocation(160,10);
		etiqueta1.setFont(new Font("Arial",Font.BOLD,25));
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		panelLogin.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Nombre de usuario ");
		etiqueta2.setSize(180,25);
		etiqueta2.setLocation(90,80);
		etiqueta2.setForeground(Color.WHITE);
		etiqueta2.setFont(new Font("Arial",Font.BOLD,12));
		panelLogin.add(etiqueta2);
		
		JLabel imagenUser = new JLabel("New label");
		imagenUser.setIcon(new ImageIcon(AuthView.class.getResource("/images/name.png")));
		imagenUser.setBounds(30, 100, 60,50);
		panelLogin.add(imagenUser);
		
		textField = new JTextField();
		textField.setBounds(90, 100,300,30);
		panelLogin.add(textField);
		
		JLabel contraseña = new JLabel("Contraseña ");
		contraseña.setSize(180,25);
		contraseña.setLocation(90,170);
		contraseña.setForeground(Color.WHITE);
		contraseña.setFont(new Font("Arial",Font.BOLD,12));
		panelLogin.add(contraseña);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 190, 300,30);
		panelLogin.add(passwordField);
		
		JLabel imagenLock = new JLabel("New label");
		imagenLock.setIcon(new ImageIcon(AuthView.class.getResource("/images/lock2.png")));
		imagenLock.setBounds(30, 190, 50,50);
		panelLogin.add(imagenLock);
		
		JCheckBox checkBox1 = new JCheckBox("Recordar mi contraseña");
        checkBox1.setBounds(160,250,160,20);
        panelLogin.add(checkBox1);
		
        JLabel olvideContraseña = new JLabel("¿Olvidaste tu contraseña?");
        olvideContraseña.setBounds(160,280,160,20);
        olvideContraseña.setFont(new Font("Arial",Font.BOLD,12));
        olvideContraseña.setForeground(Color.WHITE);
		olvideContraseña.setHorizontalAlignment(JLabel.CENTER);
		
        panelLogin.add(olvideContraseña);
		
		JButton iniciar = new JButton("Siguiente");
		iniciar.setBounds(280,400,180,25);
		iniciar.setFont(new Font("Arial",Font.BOLD,12));
		iniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean flag1=false,flag2=false;
				String username = textField.getText();
				String passText = new String(passwordField.getPassword());
				
				if(passText.equals("") ) {
 					
 					passwordField.setBorder(BorderFactory.createLineBorder(Color.red,2));
 					
 				}else {
 					passwordField.setBorder(BorderFactory.createLineBorder(Color.green,2));
 					flag1 = true;
 				}
 				
 				
 				if(textField.getText().equals("")) {
 					textField.setBorder(BorderFactory.createLineBorder(Color.red,2));
 				}else {
 					
 					textField.setBorder(BorderFactory.createLineBorder(Color.green,2));
 					flag2 = true;
 				}
				
				if (flag1 && flag2) {
					
					boolean user_auth = functions.access(username,passText); 
					
					if(user_auth){
							JOptionPane.showMessageDialog(frame, "Bienvenido");
						}else {
							JOptionPane.showMessageDialog(frame, "Error");

						}
				}
				
				
			}
		});	
		panelLogin.add(iniciar);
		
		JButton ir_al_registro = new JButton ("¿Aún no tienes cuenta?");
		ir_al_registro.setSize(180,25);
		ir_al_registro.setLocation(30, 400);
		ir_al_registro.setFont(new Font("Arial",Font.BOLD,12));		
		ir_al_registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//manager("register");
				
			}
		});
		
		
		panelLogin.add(ir_al_registro);
		panelLogin.repaint();
		
 	}
 	
 	public void register() {
 		
 	}
	

}
