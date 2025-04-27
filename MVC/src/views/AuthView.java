package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import models.AuthModel;

public class AuthView {
	
	private JFrame frame,frame2;
 	private JTextField textField,username;
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
							frame.dispose();
							home();
						}else {
							JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrecto","Error",JOptionPane.ERROR_MESSAGE);
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
				register();
				frame.dispose();
			}
		});
		
		
		panelLogin.add(ir_al_registro);
		panelLogin.repaint();
		
 	}
 	
 	public void register() {
 		
 		System.out.println("Hola");
 		frame2 = new JFrame();
 		frame2.setBounds(100, 100, 500, 600);
 		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame2.setVisible(true);
 		JPanel panelRegistro = new JPanel();
		frame2.getContentPane().add(panelRegistro, BorderLayout.CENTER);		
		panelRegistro.setBackground(new Color(171, 231, 242));
		panelRegistro.setLayout(null);
		
		
		JLabel etiqueta1 = new JLabel("Registro");
		etiqueta1.setSize(160,40);
		etiqueta1.setLocation(160,10);
		etiqueta1.setFont(new Font("Arial",Font.BOLD,25));
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		panelRegistro.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Nombre de usuario ");
		etiqueta2.setSize(180,25);
		etiqueta2.setLocation(30,100);
		etiqueta2.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(etiqueta2);
		
		username = new JTextField();
		username.setBounds(230, 100, 230,25);
		panelRegistro.add(username);
		
		JLabel mail = new JLabel("Correo: ");
		mail.setSize(180,25);
		mail.setLocation(30,140);
		mail.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(mail);
		
		JTextField mailtext = new JTextField();
		mailtext.setBounds(230, 140, 230,25);
		panelRegistro.add(mailtext);
		
		JLabel password = new JLabel("Contraseña: ");
		password.setSize(180,25);
		password.setLocation(30,180);
		password.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(password);
		
		JTextField bio2 = new JTextField();
		bio2.setBounds(230, 180, 230,25);
		panelRegistro.add(bio2);
		
		JLabel preferencias = new JLabel("Preferencias");
		preferencias.setSize(180,25);
		preferencias.setLocation(30,220);
		preferencias.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(preferencias);
		
		JCheckBox dulces = new JCheckBox("Dulces");
		dulces.setBounds(30,260,90,25);
        panelRegistro.add(dulces);
        
        JCheckBox salado = new JCheckBox("Salado");
        salado.setBounds(130,260,90,25);
        panelRegistro.add(salado);
        
        JCheckBox saludable = new JCheckBox("Saludable");
        saludable.setBounds(230,260,90,25);
        panelRegistro.add(saludable);
        
        JLabel términos1 = new JLabel("Términos");
        términos1.setBounds(30,300,180,25);
        términos1.setFont(new Font("Arial",Font.BOLD,15));
        panelRegistro.add(términos1);
					
		String [] colonias_dataset= {"centro", "Villas del encanto", "pedregal", "Agua escondida","Balandra", "Camino real"};
		JComboBox colonias = new JComboBox(colonias_dataset);
		colonias.setBounds(30, 380, 180, 25);
		panelRegistro.add(colonias);
		
		ButtonGroup terminos= new ButtonGroup();
		
		JRadioButton terms1= new JRadioButton("Acepto los terminos");
		terms1.setBounds(30, 330, 180,40);
		panelRegistro.add(terms1);
		
		JRadioButton terms2= new JRadioButton("No acepto los terminos");
		terms2.setBounds(250, 330, 180,40);
		panelRegistro.add(terms2);
		
		terminos.add(terms1);
		terminos.add(terms2);

		JButton crearCuenta = new JButton("Crear cuenta");
		crearCuenta.setBounds(280,480,180,25);
		crearCuenta.setFont(new Font("Arial",Font.BOLD,12));
		crearCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(username.getText().equals("")){
					username.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else
					username.setBorder(BorderFactory.createLineBorder(Color.green,2));
					System.out.println(functions.registro(username.getText()));
			}
			
			
			
		});
		crearCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bio2.getText().equals("")){
					bio2.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else
					bio2.setBorder(BorderFactory.createLineBorder(Color.green,2));
			}
		});
		crearCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				terms1.setBorderPainted(true);
				if(!terms1.isSelected() && terms2.isSelected()){
					terms1.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else
					terms1.setBorder(BorderFactory.createLineBorder(Color.green,2));
			}
		});	
		panelRegistro.add(crearCuenta);
		
		JButton ir_al_login = new JButton ("Inicio");
		ir_al_login.setSize(180,25);
		ir_al_login.setLocation(30, 480);
		ir_al_login.setFont(new Font("Arial",Font.BOLD,12));		
		ir_al_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login();
				frame2.dispose();
			}
		});
		
		panelRegistro.add(ir_al_login);
		panelRegistro.repaint();

 	}
	
 	public void home() {
 		frame = new JFrame();
 		frame.setBounds(100, 100, 500, 500);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
		JPanel panelLogin= new JPanel();
		frame.getContentPane().add(panelLogin, BorderLayout.CENTER);		
		panelLogin.setBackground(new Color(128,0,128));
		panelLogin.setLayout(null);
 	}
}
