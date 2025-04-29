package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
		
		JLabel name = new JLabel("Nombre:");
		name.setSize(180,25);
		name.setLocation(30,100);
		name.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(name);
		
		JTextField name_text = new JTextField();
		name_text.setBounds(230, 100, 230,25);
		panelRegistro.add(name_text);
		
		JLabel lastname = new JLabel("Apellidos :");
		lastname.setSize(180,25);
		lastname.setLocation(30,140);
		lastname.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(lastname);
		
		JTextField lastname_text = new JTextField();
		lastname_text.setBounds(230, 140, 230,25);
		panelRegistro.add(lastname_text);
		
		JLabel company = new JLabel("Empresa/Institución: ");
		company.setSize(180,25);
		company.setLocation(30,180);
		company.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(company);
		
		JTextField company_text = new JTextField();
		company_text.setBounds(230, 180, 230,25);
		panelRegistro.add(company_text);
		
		JLabel ámbito = new JLabel("Ámbito de la Empresa");
		ámbito.setSize(180,25);
		ámbito.setLocation(30,220);
		ámbito.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(ámbito);
		
		String [] ámbito_dataset= {"Educación", "Salud", "Comercio", "Servicios","Tecnología"};
		JComboBox ámbitos = new JComboBox(ámbito_dataset);
		ámbitos.setBounds(230,220, 180, 25);
		panelRegistro.add(ámbitos);
		
		JLabel cargo = new JLabel("Cargo:");
		cargo.setSize(180,25);
		cargo.setLocation(30,260);
		cargo.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(cargo);
		
		JTextField cargo_text = new JTextField();
		cargo_text.setBounds(230, 260, 230,25);
		panelRegistro.add(cargo_text);
		
		JLabel user_name = new JLabel("Nombre de usuario:");
		user_name.setSize(180,25);
		user_name.setLocation(30,300);
		user_name.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(user_name);
		
		JTextField user_name_text = new JTextField();
		user_name_text.setBounds(230,300, 230,25);
		panelRegistro.add(user_name_text);
		
		JLabel mail = new JLabel("Correo: ");
		mail.setSize(180,25);
		mail.setLocation(30,340);
		mail.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(mail);
		
		JTextField mail_text = new JTextField();
		mail_text.setBounds(230, 340, 230,25);
		panelRegistro.add(mail_text);
		
		JLabel password = new JLabel("Contraseña: ");
		password.setSize(180,25);
		password.setLocation(30,380);
		password.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(password);
		
		JTextField password_text = new JTextField();
		password_text.setBounds(230, 380, 230,25);
		panelRegistro.add(password_text);
		
		JLabel confirm_password = new JLabel("Repite Contraseña: ");
		confirm_password.setSize(180,25);
		confirm_password.setLocation(30,420);
		confirm_password.setFont(new Font("Arial",Font.BOLD,15));
		panelRegistro.add(confirm_password);
		
		JTextField confirm_password_text = new JTextField();
		confirm_password_text.setBounds(230, 420, 230,25);
		panelRegistro.add(confirm_password_text);
		
		JCheckBox términos = new JCheckBox("He leído y acepto los términos del sistema");
		términos.setBounds(120,460,270,25);
        panelRegistro.add(términos);

		JButton crearCuenta = new JButton("Crear cuenta");
		crearCuenta.setBounds(280,500,180,25);
		crearCuenta.setFont(new Font("Arial",Font.BOLD,12));
		crearCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean flag1=false,flag2=false,flag3=false,flag4=false,
						flag5=false,flag6=false,flag7=false,flag8=false, flag9=false;
				String 	name=name_text.getText(),password=password_text.getText(),
						lastname=lastname_text.getText(),company=company_text.getText(),
						cargo=cargo_text.getText(),username=user_name_text.getText(),
						mail=mail_text.getText(),confirmPassword=confirm_password_text.getText();
				
				if(!name.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")){
					name_text.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					name_text.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag1=true;
				}
					
				if(password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s]).{1,}$")){
					password_text.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					password_text.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag2=true;
				}

				if(!lastname.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")){
					lastname_text.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					lastname_text.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag3=true;
				}
					
				if(!company.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$")){
					company_text.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					company_text.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag4=true;
				}
				
				if(!cargo.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")){
					cargo_text.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					cargo_text.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag5=true;
				}
					
				if(!username.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$")){
					user_name_text.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					user_name_text.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag6=true;
				}

				if(!mail.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")){
					mail_text.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					mail_text.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag7=true;
				}
					
				if(!confirmPassword.equals(password)){
					confirm_password_text.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					confirm_password_text.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag8=true;
				}
				
				if(!términos.isSelected()){
					términos.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					términos.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag9=true;
				}
				
				
				if (flag1 && flag2 && flag3 && flag4 && 
					flag5 && flag6 && flag7 && flag8 && flag9) {
					
					try {
						functions.registro(name,lastname,company,cargo,
								username,mail,password,confirmPassword);
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
					JOptionPane.showMessageDialog(frame2, "Registro exitoso");
					home();
					frame2.dispose();
					
				}else {
					JOptionPane.showMessageDialog(frame2, "Asegurate de llenar bien todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		panelRegistro.add(crearCuenta);
		JButton ir_al_login = new JButton ("Inicio");
		ir_al_login.setSize(180,25);
		ir_al_login.setLocation(30, 500);
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
