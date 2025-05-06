/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplanet;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sergio
 */
public class Vista extends JFrame {
    
    // DECLARACION DE CAMPOS Y BOTONES
    
    private final JTextField UPC = new JTextField();
    private final JTextField Descripcion = new JTextField();
    private final JTextField Desarrollador = new JTextField();
    private final JTextField Precio = new JTextField();
    
    private final JLabel Imagen = new JLabel("Imagen");
    private final JLabel Logo = new JLabel();
    
    // Lista desplegable
    private final JComboBox Plataforma = new JComboBox();
    
    // Casillas de verificación
    private final JCheckBox Disparos = new JCheckBox("Disparos");
    private final JCheckBox Estrategia = new JCheckBox("Estrategia");
    private final JCheckBox Lucha = new JCheckBox("Lucha");
    private final JCheckBox Deportivo = new JCheckBox("Deportivo");
    private final JCheckBox MMO = new JCheckBox("MMO");
    private final JCheckBox Sandbox = new JCheckBox("Sandbox");
    private final JCheckBox Aventura = new JCheckBox("Aventura");
    private final JCheckBox Carreras = new JCheckBox("Carreras");
   
    // Radio Botone
    private final ButtonGroup Clasif = new ButtonGroup();
    private final JRadioButton E = new JRadioButton("E: Todos");
    private final JRadioButton E10 = new JRadioButton("E10: Todos +10");
    private final JRadioButton T = new JRadioButton("T: Adolescentes");
    private final JRadioButton M = new JRadioButton("M: Maduro +17");
    private final JRadioButton A = new JRadioButton("A: Adultos +18");
    private final JRadioButton RP = new JRadioButton("RP: Sin clasificar");
   
    // Botones de acción
    private final JButton btnOpenFile = new JButton();
    private final JButton btnProcesar = new JButton("Procesar");
    private final JButton btnRestablecer  = new JButton("Restablecer");
     
    // Variables auxiliares
    File archivoImagen;
    
      public Vista() // Constructor
    {   
        this.setTitle("Componentes SWING");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,450,600);
        
        initComponents();
  
        this.setVisible(true);
    }
      
       public void initComponents()
    {
        // Etiquetas
        
        JLabel et1 = new JLabel("UPC:");
        JLabel et2 = new JLabel("Descripcion:");
        JLabel et3 = new JLabel("Desarrollador:");
        JLabel et4 = new JLabel("Plataforma:");
        JLabel et5 = new JLabel("Clasificacion:");
        JLabel et6 = new JLabel("Generos:");
        JLabel et7 = new JLabel("Precio: ");
        JLabel et8 = new JLabel("Imagen: ");

        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
	JMenu archivo 	  = new JMenu("Archivo");
	JMenuItem salir   = new JMenuItem("Salir");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(salir);

        // Elementos del ComboBox   
        Plataforma.addItem("Xbox");
        Plataforma.addItem("Play Station");
        Plataforma.addItem("Nintendo Switch");
        Plataforma.addItem("PC");
        Plataforma.setSelectedIndex(-1);
    
        // Añadir los radio botones al ButtonGroup Clasif       
        Clasif.add(E);
        Clasif.add(E10);
        Clasif.add(T);
        Clasif.add(M);
        Clasif.add(A);
        Clasif.add(RP);
                
        
        // Tamaño y posición       
        this.setLayout(null);
        
        et1.setBounds(50,30,150,20); 
        UPC.setBounds(210,30,150,20);
   
        et2.setBounds(50,60,150,20);         
        Descripcion.setBounds(210,60,150,20);
        
        et3.setBounds(50,90,150,20); 
        Desarrollador.setBounds(210,90,150,20);
        
        et4.setBounds(50,120,150,20); 
        Plataforma.setBounds(210,120,150,20);
        
        //Radio Botones
        et5.setBounds(100,150,150,20); 
                
        E.setBounds(20,170,130,20);
        E.setActionCommand("E");
        E.addActionListener(evt -> actionRb(evt));
        E10.setBounds(20,190,130,20);
         E10.setActionCommand("E10");
         E10.addActionListener(evt -> actionRb(evt));
        T.setBounds(20,210,130,20);
         T.setActionCommand("T");
        T.addActionListener(evt -> actionRb(evt));
        M.setBounds(150,170,130,20);
         M.setActionCommand("M");
        M.addActionListener(evt -> actionRb(evt));
        A.setBounds(150,190,130,20); 
         A.setActionCommand("A");
         A.addActionListener(evt -> actionRb(evt));
        RP.setBounds(150,210,130,20); 
         RP.setActionCommand("RP");
         RP.addActionListener(evt -> actionRb(evt));
         
         
        
        Logo.setBounds(300,170,75,100);
        Logo.setBorder(BorderFactory.createLineBorder(Color.black));
        
        
        //CheckBoxs
        et6.setBounds(10,250,130,20);
        
        Disparos.setBounds(10,270,90,20);        
        Estrategia.setBounds(100,270,90,20);
        Lucha.setBounds(190,270,90,20);
        Aventura.setBounds(280,270,90,20);
        
        Deportivo.setBounds(10,300,90,20);
        MMO.setBounds(100,300,90,20);
        Sandbox.setBounds(190,300,90,20);
        Carreras.setBounds(280,300,90,20);
         
        //Precio
       et7.setBounds(10,340,80,20);
       Precio.setBounds(60,340,100,20);
      
        //Botones    
        btnOpenFile.setBounds(170,370,50,50);
        Imagen.setBounds(230,330,120,160);
        btnProcesar.setBounds(20,380,120,30);
        btnRestablecer.setBounds(20,430,120,30);
         
        // Características de los componentes
        btnOpenFile.setToolTipText("Abrir archivo desde disco");
        btnOpenFile.setIcon(new ImageIcon("img_app/open.png"));
        Imagen.setBorder(BorderFactory.createLineBorder(Color.black));
        Imagen.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Agrega Componentes        

        this.add(UPC);
        this.add(Descripcion);
        this.add(Desarrollador);
        this.add(Precio);
       this.add(Plataforma);
        this.add(Disparos);
        this.add(Estrategia);
        this.add(Lucha);
        this.add(Deportivo);
        this.add(MMO);
        this.add(Sandbox);
        this.add(Aventura);
        this.add(Carreras);
        this.add(A);
        this.add(E);
        this.add(E10);
        this.add(RP);
        this.add(M);
        this.add(T);
        this.add(btnOpenFile);
        this.add(Imagen);
        this.add(btnProcesar);
        this.add(btnRestablecer);
        this.add(Logo);
        
        
        this.add(et1);
        this.add(et2);
        this.add(et3);
        this.add(et4);
        this.add(et5);
        this.add(et6);
        this.add(et7);
        this.add(et8);
        
        // Lo que se debe hacer cuando el usuario elija la opción "Salir" 
        salir.addActionListener(evt -> gestionaSalir(evt));
        
        // Eventos de botónes
        btnOpenFile.addActionListener(evt -> gestionaOpenFile(evt));
        btnProcesar.addActionListener(evt -> gestionaProcesar(evt));
        btnRestablecer.addActionListener(evt -> gestionaRestablecer(evt));
        
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
       
           // Gestiona opción de menú "Salir"
    public void gestionaSalir(java.awt.event.ActionEvent evt)
    {
        exit();
    }
    
      public void exit()
    {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Aviso",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
    }
    
  
    public void gestionaOpenFile(java.awt.event.ActionEvent evt)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/img_games"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG", "jpg", "gif", "png");
        fileChooser.setFileFilter(filter);
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
             archivoImagen = fileChooser.getSelectedFile();
             ImageIcon imagenCargada = new ImageIcon(archivoImagen.getAbsolutePath());
             double w = imagenCargada.getIconWidth();
             double h = imagenCargada.getIconHeight();
             
             // Redimensionar la imagen
             if(h > 180 ||  w > 180)
             {
                 double r;
                 if( h > w)
                    r = 180.0/h;
                 else
                    r = 180.0/w;
                 w = w*r;
                 h = h*r;
                 Image imagenOriginal = imagenCargada.getImage();
                 Image imagenRedimensionada = imagenOriginal.getScaledInstance((int)w, (int)h, java.awt.Image.SCALE_SMOOTH);
                 imagenCargada = new ImageIcon(imagenRedimensionada);
                 
            }         
            Imagen.setBounds(230,330,imagenCargada.getIconWidth(), imagenCargada.getIconHeight());
            Imagen.setIcon(imagenCargada);
            
        }
    }
        
    public void gestionaProcesar(java.awt.event.ActionEvent evt)
    {
        Videojuego vid;
        String Gen, datos = "";
        Gen=getGeneros();
        double precio;
        
      if(!(UPC.getText().equals("")||Descripcion.getText().equals("")||Desarrollador.getText().equals("")
        ||Plataforma.getSelectedIndex()==-1 ||Clasif.getSelection()==null||Gen.equals("")||Precio.getText().equals(""))){
          precio=Double.parseDouble(Precio.getText());
          vid=new Videojuego(UPC.getText(),Descripcion.getText(),Desarrollador.getText(),
                  Plataforma.getSelectedItem().toString(),Clasif.getSelection().getActionCommand(),Gen,precio);
           
          datos=vid.getDatos();
        
           JOptionPane.showMessageDialog(rootPane, datos, "Datos del videojuego", JOptionPane.INFORMATION_MESSAGE);
       }
       else{
           JOptionPane.showMessageDialog(null,"Por favor rellene todos los campos","Faltan datos",JOptionPane.WARNING_MESSAGE);
       }
          
      
    }
    
    public String getGeneros(){
        String cad="";
        if(Disparos.isSelected()){
            cad+="\nDisparos";
        }
        if(Estrategia.isSelected()){
            cad+="\nEstrategia";
        }
        if(Lucha.isSelected()){
            cad+="\nLucha";
        }
        if(Deportivo.isSelected()){
            cad+="\nDeportivo";
        }
        if(Carreras.isSelected()){
            cad+="\nCarreras";
        }
        if(MMO.isSelected()){
            cad+="\nMMO";
        }
        if(Sandbox.isSelected()){
            cad+="\nSandbox";
        }
        if(Aventura.isSelected()){
            cad+="\nAventura";
        }
        return cad;
    }
    
    public void gestionaRestablecer(java.awt.event.ActionEvent evt)
    {
        UPC.setText("");
        Descripcion.setText("");
        Desarrollador.setText("");
        Precio.setText("");
        
        Logo.setIcon(null);
        Imagen.setIcon(null);
        
        Plataforma.setSelectedIndex(-1);
        Clasif.clearSelection();
        
        Disparos.setSelected(false);
        Estrategia.setSelected(false);
        Lucha.setSelected(false);
        Deportivo.setSelected(false);
        Carreras.setSelected(false);
        MMO.setSelected(false);
        Sandbox.setSelected(false);
        Aventura.setSelected(false);
    
    }
    
    public void actionRb(ActionEvent e){
        if(e.getSource().equals(E)){
            Logo.setIcon(new ImageIcon("img_clasif/E.jpg"));
        }
        
        else if(e.getSource().equals(E10)){
             Logo.setIcon(new ImageIcon("img_clasif/E10.jpg"));
        }
         
        else if(e.getSource().equals(A)){
      Logo.setIcon(new ImageIcon("img_clasif/A.jpg"));
        }
         
       else if(e.getSource().equals(T)){
            Logo.setIcon(new ImageIcon("img_clasif/T.jpg"));
        }
        
       else if(e.getSource().equals(M)){
           Logo.setIcon(new ImageIcon("img_clasif/M.jpg"));
        }
        
        else if(e.getSource().equals(RP)){
             Logo.setIcon(new ImageIcon("img_clasif/RP.jpg"));
        }
       
    }
    
}
