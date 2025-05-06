/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolibreria;

/**
 *
 * @author 
 */

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Vista extends JFrame
{
	private JTextField tIsbn  = new JTextField();
	private JTextField tTitulo= new JTextField();
	private JButton    btBuscar  = new JButton("Buscar");
        private JButton    btInsertar  = new JButton("Agregar");
        private JButton    btBorrar  = new JButton("Eliminar");
        private JButton    btCambiar  = new JButton("Cambiar");
        private JButton    btLimpiar = new JButton("Limpiar");
        
        
	private JLabel  imagen    = new JLabel();

	private Properties prop;
        
        private String mensajeError = "";


	public Vista(Properties prop)
	{
                this.prop = prop;
		initComponents();
		this.setTitle("Librerias de Cristal (CRUD del Catálogo)");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(10,10,700,300);
	
                // Carga las propiedades desde el archivo
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
                       
            JLabel et1        = new JLabel("ISBN:");
            JLabel et2        = new JLabel("Título:");
            
            // Diseña el menu

            JMenuBar barraMenus = new JMenuBar();
            JMenu menuArchivo 	  = new JMenu("Archivo");
	    JMenuItem opSalir   = new JMenuItem("Salir");
            this.setJMenuBar(barraMenus);

            barraMenus.add(menuArchivo);
            menuArchivo.add(opSalir);

		// Componentes

	    et1.setBounds(10,30,100,25);
	    et2.setBounds(10,70,100,25);
	    imagen.setBounds(530,30,125,170);
	    tIsbn.setBounds(80,30,100,25);
	    tTitulo.setBounds(80,70,440,25);
            
            // Botones
	    btBuscar.setBounds(440,30,80,25);
            btInsertar.setBounds(80,110,80,25);
            btBorrar.setBounds(200,110,80,25);
            btCambiar.setBounds(320,110,85,25);
            btLimpiar.setBounds(440,110,80,25);
            
            
	    add(et1);
	    add(et2);
	    add(tIsbn);
	    add(tTitulo);
	    add(btBuscar);
            add(btInsertar);
            add(btBorrar);
            add(btCambiar);
            add(btLimpiar);
	    add(imagen);
            
            opSalir.addActionListener(evt -> gestionaSalir(evt));
            btBuscar.addActionListener(evt -> gestionaBuscar(evt));
            btInsertar.addActionListener(evt -> gestionaInsertar(evt));
            btBorrar.addActionListener(evt -> gestionaBorrar(evt));
            btCambiar.addActionListener(evt -> gestionaCambiar(evt));
            btLimpiar.addActionListener(evt -> gestionaLimpiar(evt));
            
            
            class MyWindowAdapter extends WindowAdapter
            {
		public void windowClosing(WindowEvent e)
		{
			exit();
		}
            }
            addWindowListener(new MyWindowAdapter());   

	}

        // Gestión de eventos
        
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
            if(tIsbn.getText().isBlank())
            {
		JOptionPane.showMessageDialog(this, "Para localizar un libro se requiere el ISBN", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                Libro newBook = Libro.getLibroFromDB(tIsbn.getText(),prop); // Método estático para obtener un libro desde la BD 
		if(newBook != null) // Si hubo éxito
		{
                    tTitulo.setText(newBook.getTitulo());
                    String nombreArchivoImagen = newBook.getImagen();
                    imagen.setIcon(new ImageIcon(nombreArchivoImagen));
		}
                else JOptionPane.showMessageDialog(this, "El libro con el ISBN indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        public void gestionaCambiar(java.awt.event.ActionEvent evt)
        {
            if(tIsbn.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Para localizar el libro que se va \na actualizar se requiere el ISBN", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                
                if(!invalido()) // Se intenta realizar el UPDATE solo si no hay error de captura
                {
                    Libro newBook = Libro.getLibroFromDB(tIsbn.getText(),prop); // Método estático para obtener un libro desde la BD 
                    if(newBook != null)
                    {
                        newBook.setTitulo(tTitulo.getText()); // Actualiza el titulo del objeto libro
                        
                        if(newBook.cambiar(prop)) // Si hubo éxito
                            JOptionPane.showMessageDialog(this, "Registro actualizado: " + tIsbn.getText(), "Aviso!",JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(this, "El libro con el ISBN indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);                    
                } 
                else JOptionPane.showMessageDialog(this, mensajeError, "Aviso!", JOptionPane.ERROR_MESSAGE);                
	    }
                                       
        }
        
        public void gestionaInsertar(java.awt.event.ActionEvent evt)
        {
            if(!invalido()) // Se intenta realizar el INSERT solo si no hay error de captura
            {               
               // Primero investigamos si no hay otro registro con el mismo ISBN
                Libro newBook = Libro.getLibroFromDB(tIsbn.getText(),prop);
               
                if(newBook == null) // Solo si el ISBN no está registrado 
                {                        
                    // Adquirimos los datos de la vista              
                    newBook = new Libro();
                    newBook.setIsbn(tIsbn.getText());
                    newBook.setTitulo(tTitulo.getText());
                
                    // Tratamos de ejecutar el alta
                                
                    if(newBook.alta(prop)) // Si la alta fue exitosa
                        JOptionPane.showMessageDialog(this, "Registro agregado: " + tIsbn.getText(), "Aviso!",JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);                           
                }
                else JOptionPane.showMessageDialog(this, "El ISBN ya está registrado", "Aviso!", JOptionPane.ERROR_MESSAGE); 
            } 
            else JOptionPane.showMessageDialog(this, mensajeError, "Aviso!", JOptionPane.ERROR_MESSAGE);          
        }
        
        public void gestionaBorrar(java.awt.event.ActionEvent evt)
        {
            if(tIsbn.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Para localizar el libro que se va \na eliminar se requiere el ISBN", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // Solicitamos confirmación     
                int respuesta = JOptionPane.showConfirmDialog(this, "Desea borrar este registro?", "Atención!!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
                if(respuesta==JOptionPane.YES_OPTION) // Si el usuario confirma
                {

                    Libro newBook = Libro.getLibroFromDB(tIsbn.getText(),prop); // Trata de recuperar el libro de la BD
                    
                    if(newBook != null) // Si lo encuentra
                    {
                        // Intenta eliminar el registro
                        if(newBook.borrar(prop)) // Si hubo éxito
                        {   
                            JOptionPane.showMessageDialog(this, "Registro eliminado: " + tIsbn.getText(), "Aviso!",JOptionPane.WARNING_MESSAGE);
                            limpiarCampos();
                        }    
                        else JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(this, "El libro con el ISBN indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);            
		}
            }
            
        }
        
        public void gestionaLimpiar(java.awt.event.ActionEvent evt)
        {
            limpiarCampos();
        }
        
        private void limpiarCampos()
        {
                    tIsbn.setText("");
                    tTitulo.setText("");
                    imagen.setIcon(null);
        }
        
        // Validación de datos
        private boolean invalido()
        {
            boolean hayError = false;
            mensajeError = "";
            
            if(tIsbn.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar el ISBN en blanco\n");
            }
            
            if(tTitulo.getText().isBlank())
            {
                        hayError = true;
                        mensajeError = mensajeError.concat("No debe dejar el título en blanco\n");
            }
            
            return hayError;
        }
}
