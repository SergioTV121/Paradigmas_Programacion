/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author macario
 */
public class Vista extends JFrame {
    
    // DECLARACION DE CAMPOS Y BOTONES
    
    private final JTextField jTextEmail = new JTextField(),
            jtxtName = new JTextField(),
            jtxtMobilePhone = new JTextField(),
            jtxtPhoto = new JTextField();
    private final JPasswordField jTextPassword = new JPasswordField(),
            jtxtConfirmPassword=new JPasswordField();
    
    // Cuadro Imagen
    private final JLabel jLabelFotografia = new JLabel();
    
    // Botones
    private final JButton jButtonProcesar = new JButton("Process");
    private final JButton jButtonLimpiar  = new JButton("Clear");
        
    public Vista() // Constructor
    {
        this.setTitle("User Registration");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,640,480);
        
        initComponents();
  
        this.setVisible(true);
    }
    
    public void initComponents()
    {
        // Declaración de etiquetas
        JLabel etiquetaEmail    = new JLabel("E-Mail Address:");
        JLabel etiquetaPassword = new JLabel("Password:");
        JLabel etqName    = new JLabel("Name:");
        JLabel etqMobileNumber = new JLabel("Mobile Number:");
        JLabel etqPhoto    = new JLabel("Photo:");
        JLabel etqConfirmPassword = new JLabel("Condirm Password:");

        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
	JMenu archivo 	  = new JMenu("File");
	JMenuItem salir   = new JMenuItem("Exit");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(salir);
            
        // Posiciones de los componentes
        this.setLayout(null); // El programador indica coordenadas y tamaño
        
        
        //Establecer coordenadas
        etqName.setBounds(80,30,120,30);
        jtxtName.setBounds(130,30,200,30);
        
        etiquetaEmail.setBounds(28,80,120,30);
        jTextEmail.setBounds(130,80,200,30);
                  
        etqMobileNumber.setBounds(28,130,120,30);
        jtxtMobilePhone.setBounds(130,130,200,30);
        
        etqPhoto.setBounds(80,180,70,30);
        jtxtPhoto.setBounds(130,180,200,30);
          
        etiquetaPassword.setBounds(60,230,70,30);
        jTextPassword.setBounds(130,230,200,30);
        
        etqConfirmPassword.setBounds(10,280,150,30);
        jtxtConfirmPassword.setBounds(130,280,200,30);
        //
        
       
        jLabelFotografia.setBounds(380,70,180,200);    
        jButtonProcesar.setBounds(200,350,100,40);
        jButtonLimpiar.setBounds(320,350,100,40);
        
        // Propiedades de los componentes
        
      jLabelFotografia.setBorder(BorderFactory.createLineBorder(Color.black));
             
        // Agrega los componentes al Frame (y se mostrarán en el Frame)
        
        this.add(jLabelFotografia);
        
        this.add(etiquetaEmail);
        this.add(jTextEmail);
        
        this.add(etiquetaPassword);
        this.add(jTextPassword);
      
        this.add(etqName);
        this.add(jtxtName);
        
        this.add(etqPhoto);
        this.add(jtxtPhoto);
        
        this.add(etqConfirmPassword);
        this.add(jtxtConfirmPassword);
        
        this.add(etqMobileNumber);
        this.add(jtxtMobilePhone);
        
        this.add(jButtonProcesar);
        this.add(jButtonLimpiar);
        
        // GESTION DE EVENTOS
        
        // Lo que se debe hacer cuando el usuario elija la opción "Salir" 
        salir.addActionListener(evt -> gestionaSalir(evt));
            
        // Lo que se debe hacer cuando el usuario elija el botón "Procesar"
        jButtonProcesar.addActionListener(evt -> gestionaProcesar(evt));
        
        // Lo que se debe hacer cuando el usuario elija la opción "Limpiar"
        jButtonLimpiar.addActionListener(evt -> gestionaLimpiar(evt));
                
        // Lo que se debe hacer cuando e usurio elija la "X" de la ventana para salir      
        class MyWindowAdapter extends WindowAdapter
	{
            @Override
            public void windowClosing(WindowEvent e)
            {
		exit(); 
            } 
	}
        addWindowListener(new MyWindowAdapter());
        
    }
    
    public void gestionaSalir(java.awt.event.ActionEvent evt)
    {
        exit();
    } 

    public void exit()
    {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Aviso",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
    }
    
    public void gestionaProcesar(java.awt.event.ActionEvent evt)
    {
            Usuario user=new Usuario();
        
        if(jtxtName.getText().equals("") || jTextEmail.getText().equals("") 
           || jtxtMobilePhone.getText().equals("") || jtxtPhoto.getText().equals("") 
              || jTextPassword.getText().equals("") || jtxtConfirmPassword.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Por favor rellena todos los campos","Faltan datos", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(!jTextPassword.getText().equals(jtxtConfirmPassword.getText())){
                 JOptionPane.showMessageDialog(rootPane,"Las contraseñas no coinciden","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
        jLabelFotografia.setIcon(new ImageIcon("img/"+jtxtPhoto.getText()+".png"));
        user.setNombre(jtxtName.getText());
        user.setCorreo(jTextEmail.getText());
        user.setNumero(jtxtMobilePhone.getText());
        user.setContraseña(jTextPassword.getText());
        
        String datosCaptados;
        
        datosCaptados = "DATOS DEL USUARIO\n";
        datosCaptados = datosCaptados.concat(user.getDatos());
        
        JOptionPane.showMessageDialog(rootPane, datosCaptados);
            }
               
        }
            
        
        
    }
    
    public void gestionaLimpiar(java.awt.event.ActionEvent evt)
    { 
       jtxtName.setText("");
       jTextEmail.setText("");
       jtxtMobilePhone.setText("");
       jtxtPhoto.setText("");
       jTextPassword.setText("");
       jtxtConfirmPassword.setText("");
       jLabelFotografia.setIcon(null);
    }
    
}
