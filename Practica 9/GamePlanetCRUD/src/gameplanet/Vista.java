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
import java.io.FileInputStream;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Sergio
 */
public class Vista extends JFrame{
    
    // DECLARACION DE CAMPOS Y BOTONES
    
    private final JTextField UPC = new JTextField();
    private final JTextField Descripcion = new JTextField();
    private final JTextField Desarrollador = new JTextField();
    private final JTextField Plataforma = new JTextField();
    private final JTextField Clasificacion = new JTextField();
    private final JTextField Generos = new JTextField();
    private final JTextField Precio = new JTextField();
    private final JTextField Imagen = new JTextField();
    
    private final JLabel Portada = new JLabel("Portada");   
    
   
    private final JButton btnBuscar = new JButton("Buscar");
    private final JButton btnAgregar  = new JButton("Agregar");
    private final JButton btnActualizar = new JButton("Actualizar");
    private final JButton btnEliminar  = new JButton("Eliminar");
    private final JButton btnLimpiar  = new JButton("Limpiar");
     
    // Variables auxiliares
    String mensajeError="";
    
    private Properties properties;
    
      public Vista(Properties prop) // Constructor
    {   
          this.properties=prop;
        this.setTitle("Componentes SWING");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,580,400);
        
        initComponents();
  
        this.setVisible(true);
        
        try
		{
			prop.load(new FileInputStream("config.properties"));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
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

              
        // Tamaño y posición       
        this.setLayout(null);
        
        et1.setBounds(40,30,150,20); 
        UPC.setBounds(200,30,150,20);
   
        et2.setBounds(40,60,150,20);         
        Descripcion.setBounds(200,60,150,20);
        
        et3.setBounds(40,90,150,20); 
        Desarrollador.setBounds(200,90,150,20);
        
        et4.setBounds(40,120,150,20); 
        Plataforma.setBounds(200,120,150,20);
        
        et5.setBounds(40,150,150,20); 
        Clasificacion.setBounds(200,150,150,20);
        
        et6.setBounds(40,180,150,20); 
        Generos.setBounds(200,180,150,20);
                
        et7.setBounds(40,210,150,20); 
        Precio.setBounds(200,210,150,20);
        
        et8.setBounds(40,240,150,20); 
        Imagen.setBounds(200,240,150,20);
        
        btnBuscar.setBounds(380,30,80,30);
        btnAgregar.setBounds(20,280,80,30);
        btnActualizar.setBounds(125,280,100,30);
        btnEliminar.setBounds(250,280,80,30);
        btnLimpiar.setBounds(350,280,80,30);
              
        Portada.setBounds(380,85,75,100);
        Portada.setBorder(BorderFactory.createLineBorder(Color.black));

      
        // Agrega Componentes     
        
        
        this.add(et1);
        this.add(et2);
        this.add(et3);
        this.add(et4);
        this.add(et5);
        this.add(et6);
        this.add(et7);
        this.add(et8);

        this.add(UPC);
        this.add(Descripcion);
        this.add(Desarrollador);
        this.add(Plataforma);
        this.add(Clasificacion);
        this.add(Generos);
        this.add(Precio);
        this.add(Imagen);

        this.add(btnBuscar);
        this.add(btnAgregar);
        this.add(btnActualizar);
        this.add(btnEliminar);
        this.add(btnLimpiar);
        
        this.add(Portada);
      
        
        
        // Lo que se debe hacer cuando el usuario elija la opción "Salir" 
        salir.addActionListener(evt -> gestionaSalir(evt));
        
        // Eventos de botónes
        btnBuscar.addActionListener(evt -> gestionaBuscar(evt));
        btnAgregar.addActionListener(evt -> gestionaAgregar(evt));
        btnActualizar.addActionListener(evt -> gestionaActualizar(evt));
        btnEliminar.addActionListener(evt -> gestionaEliminar(evt));
        btnLimpiar.addActionListener(evt -> gestionaLimpiar(evt));
        
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
    
 
    
    
        public void gestionaBuscar(java.awt.event.ActionEvent evt)
        {
         if(UPC.getText().isBlank())
            {
		JOptionPane.showMessageDialog(this, "Para localizar un videojuego se requiere el UPC", 
                        "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                Videojuego videojuego = Videojuego.getVideojuegoFromBD(UPC.getText(),properties); // Método estático para obtener un libro desde la BD 
		if(videojuego != null) // Si hubo éxito
		{                    
                    String nomImg=videojuego.getImagen();                 
                    Descripcion.setText(videojuego.getDescripcion());
                    Desarrollador.setText(videojuego.getDesarrollador());
                    Plataforma.setText(videojuego.getPlataforma());
                    Clasificacion.setText(videojuego.getClasificacion());
                    Generos.setText(videojuego.getGeneros());
                    Precio.setText(videojuego.getPrecio());
                    Imagen.setText(nomImg.substring(9));                    
                    
                    String nombreArchivoImagen = videojuego.getImagen();
                    MostrarPortada(nombreArchivoImagen);
                    
		}
                else JOptionPane.showMessageDialog(this, "El videojuego con el UPC indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }         
      
    }
        
          public void MostrarPortada(String archivoImg){              
           
             ImageIcon imagenCargada = new ImageIcon(archivoImg);
             double w = imagenCargada.getIconWidth();
             double h = imagenCargada.getIconHeight();
             
             // Redimensionar la imagen
             if(h > 160 ||  w > 160)
             {
                 double r;
                 if( h > w)
                    r = 160.0/h;
                 else
                    r = 160.0/w;
                 w = w*r;
                 h = h*r;
                 Image imagenOriginal = imagenCargada.getImage();
                 Image imagenRedimensionada = imagenOriginal.getScaledInstance((int)w, (int)h, java.awt.Image.SCALE_SMOOTH);
                 imagenCargada = new ImageIcon(imagenRedimensionada);
                 
            }         
            Portada.setBounds(380,85,imagenCargada.getIconWidth(), imagenCargada.getIconHeight());
            Portada.setIcon(imagenCargada);
              
           }
        
        
        
          public void gestionaAgregar(java.awt.event.ActionEvent evt)
        {
            if(!invalido()) // Se intenta realizar el INSERT solo si no hay error de captura
            {               
               // Primero investigamos si no hay otro registro con el mismo ISBN
                Videojuego vid = Videojuego.getVideojuegoFromBD(UPC.getText(),properties);
               
                if(vid == null) // Solo si el ISBN no está registrado 
                {                        
                    // Adquirimos los datos de la vista              
                    vid = new Videojuego();
                    vid.setUpc(UPC.getText());
                    vid.setDescripcion(Descripcion.getText());
                    vid.setDesarrollador(Desarrollador.getText());
                    vid.setPlataforma(Plataforma.getText());
                    vid.setClasificacion(Clasificacion.getText());
                    vid.setGeneros(Generos.getText());
                    vid.setPrecio(Precio.getText());
                    vid.setImagen(Imagen.getText());
                
                    // Tratamos de ejecutar el alta
                                
                    if(vid.alta(properties)) // Si la alta fue exitosa
                        JOptionPane.showMessageDialog(this, "Registro agregado: " + UPC.getText(), "Aviso!",JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);                           
                }
                else JOptionPane.showMessageDialog(this, "El UPC ya está registrado", "Aviso!", JOptionPane.ERROR_MESSAGE); 
            } 
            else JOptionPane.showMessageDialog(this, mensajeError, "Aviso!", JOptionPane.ERROR_MESSAGE);          
        }
          
          public void gestionaActualizar(java.awt.event.ActionEvent evt)
        {
            if(UPC.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Para localizar el juego que se va \na actualizar se requiere el UPC",
                        "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                
                if(!invalido()) // Se intenta realizar el UPDATE solo si no hay error de captura
                {
                    Videojuego vid = Videojuego.getVideojuegoFromBD(UPC.getText(),properties); // Método estático para obtener un libro desde la BD 
                    if(vid != null)
                    {
                        vid.setDescripcion(Descripcion.getText());
                        vid.setDesarrollador(Desarrollador.getText());
                        vid.setPlataforma(Plataforma.getText());
                        vid.setClasificacion(Clasificacion.getText());
                        vid.setGeneros(Generos.getText());
                        vid.setPrecio(Precio.getText());
                        vid.setImagen(Imagen.getText());
                        
                        if(vid.cambiar(properties)) // Si hubo éxito
                            JOptionPane.showMessageDialog(this, "Registro actualizado: " + UPC.getText(), "Aviso!",JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(this, "El juego con el UPC indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);                    
                } 
                else JOptionPane.showMessageDialog(this, mensajeError, "Aviso!", JOptionPane.ERROR_MESSAGE);                
	    }
                                       
        }
          
          public void gestionaEliminar(java.awt.event.ActionEvent evt)
        {
            if(UPC.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Para localizar el videojuego que se va \na eliminar se requiere el UPC", 
                        "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // Solicitamos confirmación     
                int respuesta = JOptionPane.showConfirmDialog(this, "Desea borrar este registro?", "Atención!!!", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
                if(respuesta==JOptionPane.YES_OPTION) // Si el usuario confirma
                {

                    Videojuego vid = Videojuego.getVideojuegoFromBD(UPC.getText(),properties); // Trata de recuperar el libro de la BD
                    
                    if(vid != null) // Si lo encuentra
                    {
                        // Intenta eliminar el registro
                        if(vid.borrar(properties)) // Si hubo éxito
                        {   
                            JOptionPane.showMessageDialog(this, "Registro eliminado: " + UPC.getText(), "Aviso!",JOptionPane.WARNING_MESSAGE);
                            Limpiar();
                        }    
                        else JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(this, "El juego con el UPC indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);            
		}
            }
            
        }
    
        
            
            // Validación de datos
        private boolean invalido()
        {
            boolean hayError = false;
            mensajeError = "";
            
            if(UPC.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar el UPC en blanco\n");
            }
            
            if(Descripcion.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar la descripcion en blanco\n");
            }
            
            if(Desarrollador.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar el desarrollador en blanco\n");
            }
            
            if(Plataforma.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar la plataforma en blanco\n");
            }
            
            if(Clasificacion.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar la clasificacion en blanco\n");
            }
            
            if(Generos.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("Debe agregar al menos un genero en blanco\n");
            }
            
            if(Precio.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar el precio en blanco\n");
            }
            
            if(Imagen.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar el nombre del archivo imagen en blanco\n");
            }
            
            return hayError;
        }

    
       public void gestionaLimpiar(java.awt.event.ActionEvent evt)
    {
       Limpiar();            
    }
       
       
        public void Limpiar(){
             UPC.setText("");
        Descripcion.setText("");
        Desarrollador.setText("");
        Clasificacion.setText("");
        Generos.setText("");
        Plataforma.setText("");
        Imagen.setText("");
        Precio.setText("");
        
        Portada.setIcon(null);
        }

    
       
}