package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controllers.HomeController;
import controllers.ProductController;
import controllers.UserController;
import models.ProductModel;
import models.Producto;
import models.User;
import models.UserModel;
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
		
		JLabel lblNewLabel = new JLabel("USUARIOS");
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
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				UserController uc = new UserController();
				uc.add();
				
			}
			
		});
		panel_2.add(btnAdd);
 		
		String[] columnNames = {
				"ID", 
				"Nombre", 
				"Email", 
				"Rol", 
				"Teléfono",
				"Accion"
		};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (User u : user) {
			model.addRow(new Object[]{
				u.getId(),
				u.getName(),
				u.getEmail(),
				u.getRole(),
				u.getPhone(),				
			});
		}

		JTable tabla = new JTable(model);
        tabla.setRowHeight(30);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        tabla.getColumn("Identificador").setCellRenderer(centrado);
        tabla.getColumn("Nombre completo").setCellRenderer(centrado);
        tabla.getColumn("email").setCellRenderer(centrado);
        tabla.getColumn("rol").setCellRenderer(centrado);
        
        tabla.getColumn("editar").setCellEditor(new BotonEditor(new JCheckBox(), "✏️", tabla, frame));
        
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBackground(Color.white);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelUsers.add(scrollPane, BorderLayout.CENTER);
		panel.revalidate();
	}
	
	public void showFormAdd() {
		frame = new JFrame();
 		frame.setBounds(100, 100, 920, 534);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
 		
 		JPanel panelUser = new JPanel();
 		panelUser.setBackground(new Color(255, 255, 255));
 		frame.getContentPane().add(panelUser, BorderLayout.CENTER);
 		panelUser.setBorder(new EmptyBorder(5, 5, 5, 5));
 		panelUser.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelUser.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.decode("#705AAD"));
		panel.setLayout(null);
		
		JLabel idTag = new JLabel("id");
		idTag.setFont(new Font("Arial", Font.PLAIN, 14));
		idTag.setBounds(50,50,200,30);
		panel.add(idTag);
		
		JTextField idInput = new JTextField();
		idInput.setFont(new Font("Arial", Font.PLAIN, 12));
		idInput.setBounds(50,90, 200, 30);
		panel.add(idInput);
		
		JLabel nameTag = new JLabel("Nombre");
		nameTag.setFont(new Font("Arial", Font.PLAIN, 14));
		nameTag.setBounds(50,130,200,30);
		panel.add(nameTag);
		
		JTextField nameInput = new JTextField();
		nameInput.setFont(new Font("Arial", Font.PLAIN, 12));
		nameInput.setBounds(50,170, 200, 30);
		panel.add(nameInput);
		
		JLabel emailTag = new JLabel("Email");
		emailTag.setFont(new Font("Arial", Font.PLAIN, 14));
		emailTag.setBounds(50,210,200,30);
		panel.add(emailTag);
		
		JTextField emailInput = new JTextField();
		emailInput.setFont(new Font("Arial", Font.PLAIN, 12));
		emailInput.setBounds(50,250, 200, 30);
		panel.add(emailInput);
		
		JLabel rolTag = new JLabel("Rol");
		rolTag.setFont(new Font("Arial", Font.PLAIN, 14));
		rolTag.setBounds(50,290,200,30);
		panel.add(rolTag);
		
		JTextField rolInput = new JTextField();
		rolInput.setFont(new Font("Arial", Font.PLAIN, 12));
		rolInput.setBounds(50,330, 200, 30);
		panel.add(rolInput);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#F0DD01"));
		panelUser.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("AÑADIR USUARIO");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#705AAD"));
		panelUser.add(panel_2, BorderLayout.SOUTH);
		
		JButton save = new JButton("Guardar");
		save.setFont(new Font("Arial", Font.PLAIN, 16));
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(idInput.getText()); 
				String name = nameInput.getText();
				String email = emailInput.getText(); 
				String rol = rolInput.getText(); 

				UserModel um = new UserModel();
				um.create(id,name,email,rol);
				frame.dispose();
				
				UserController uc = new UserController();
				uc.users();
				
			}});
		panel_2.add(save);
		
		JButton cancel = new JButton("Cancelar");
		cancel.setFont(new Font("Arial", Font.PLAIN, 16));
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserController uc = new UserController();
				uc.users();
				
			}
		});
		panel_2.add(cancel);
	}
	
	public void showFormUpdate(User user) {
		frame = new JFrame();
 		frame.setBounds(100, 100, 920, 534);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
 		
 		JPanel panelUser = new JPanel();
 		panelUser.setBackground(new Color(255, 255, 255));
 		frame.getContentPane().add(panelUser, BorderLayout.CENTER);
 		panelUser.setBorder(new EmptyBorder(5, 5, 5, 5));
 		panelUser.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelUser.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.decode("#705AAD"));
		panel.setLayout(null);
		
		JLabel idTag = new JLabel("id");
		idTag.setFont(new Font("Arial", Font.PLAIN, 14));
		idTag.setBounds(50,50,200,30);
		panel.add(idTag);
		
		JTextField idInput = new JTextField();
		idInput.setFont(new Font("Arial", Font.PLAIN, 12));
		idInput.setBounds(50,90, 200, 30);
		panel.add(idInput);
		
		JLabel nameTag = new JLabel("Nombre");
		nameTag.setFont(new Font("Arial", Font.PLAIN, 14));
		nameTag.setBounds(50,130,200,30);
		panel.add(nameTag);
		
		JTextField nameInput = new JTextField();
		nameInput.setFont(new Font("Arial", Font.PLAIN, 12));
		nameInput.setBounds(50,170, 200, 30);
		panel.add(nameInput);
		
		JLabel emailTag = new JLabel("Email");
		emailTag.setFont(new Font("Arial", Font.PLAIN, 14));
		emailTag.setBounds(50,210,200,30);
		panel.add(emailTag);
		
		JTextField emailInput = new JTextField();
		emailInput.setFont(new Font("Arial", Font.PLAIN, 12));
		emailInput.setBounds(50,250, 200, 30);
		panel.add(emailInput);
		
		JLabel rolTag = new JLabel("Rol");
		rolTag.setFont(new Font("Arial", Font.PLAIN, 14));
		rolTag.setBounds(50,290,200,30);
		panel.add(rolTag);
		
		JTextField rolInput = new JTextField();
		rolInput.setFont(new Font("Arial", Font.PLAIN, 12));
		rolInput.setBounds(50,330, 200, 30);
		panel.add(rolInput);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#F0DD01"));
		panelUser.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("AÑADIR USUARIO");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#705AAD"));
		panelUser.add(panel_2, BorderLayout.SOUTH);
		
		JButton update = new JButton("Actualizar");
		update.setFont(new Font("Arial", Font.PLAIN, 16));
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(idInput.getText()); 
				String name = nameInput.getText();
				String email = emailInput.getText(); 
				String role = rolInput.getText(); 

				user.id = id;
				user.name = name;
				user.email = name;
				user.role = role;

				UserModel um = new UserModel();
				
				if(um.update(user)) {
					frame.dispose();
					UserController uc = new UserController();
					uc.users();
				}
				
			}});
		panel_2.add(update);
		
		JButton cancel = new JButton("Cancelar");
		cancel.setFont(new Font("Arial", Font.PLAIN, 16));
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserController uc = new UserController();
				uc.users();
				
			}
		});
		panel_2.add(cancel);
	}

	
	public class BotonEditor extends DefaultCellEditor {
	    protected JButton boton;
	    private String texto;
	    private JTable tabla;
	    private JFrame modulo;

	    public BotonEditor(JCheckBox checkBox, String texto, JTable tabla, JFrame modulo) {
	        super(checkBox);
	        this.texto = texto;
	        this.tabla = tabla;
	        this.modulo = modulo;
	        boton = new JButton();
	        boton.setOpaque(true);
	        boton.addActionListener(e->{
	           fireEditingStopped();
	        });
	    }

	    public Component getTableCellEditorComponent(JTable table, Object value,
	            boolean isSelected, int row, int column) {
	        boton.setText(texto);
	        return boton;
	    }

	    public Object getCellEditorValue() {
	        if (texto.equals("✏️")) {
	            	int filaSeleccionada = tabla.getSelectedRow();
	                if (filaSeleccionada >= 0) {
	                   // User uSeleccionado = listaUsers.get(filaSeleccionada);
	                    UserController uc = new UserController();
	                    modulo.dispose();
	                    //uc.update(uSeleccionado); 
	                }
            } else if (texto.equals("eliminar")) {
	    	        	int filaSeleccionada= tabla.getSelectedRow();
	                    if (filaSeleccionada >= 0) {
	                    	//User uSeleccionado = listaUsers.get(filaSeleccionada);
		                    UserController uc = new UserController();
		                    modulo.dispose();
	                    }
	    	        }
	        return texto;
    	}
	}
}
