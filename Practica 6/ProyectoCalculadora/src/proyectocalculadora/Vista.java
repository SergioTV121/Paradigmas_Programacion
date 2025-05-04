/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.lang.Math.*;

/**
 *
 * @author 
 */
public class Vista extends JFrame 
{
        // El objeto calculadora es el que realmente realiza las operaciones
    	private final Calculadora calculator = new Calculadora();
        private final JTextField display = new JTextField();

        private final JButton b0 = new JButton("0");
	private final JButton b1 = new JButton("1");
	private final JButton b2 = new JButton("2");
	private final JButton b3 = new JButton("3");
	private final JButton b4 = new JButton("4");
	private final JButton b5 = new JButton("5");
	private final JButton b6 = new JButton("6");
	private final JButton b7 = new JButton("7");
	private final JButton b8 = new JButton("8");
	private final JButton b9 = new JButton("9");
	private final JButton mas= new JButton("+");
	private final JButton menos=new JButton("-");
	private final JButton igual=new JButton("=");
        private final JButton cE   = new JButton("CE");
        
       private final JButton c = new JButton("c");
	private final JButton e = new JButton("e");
	private final JButton pi = new JButton("π");
	private final JButton multi = new JButton("x");
	private final JButton div = new JButton("÷");
	private final JButton raiz2 = new JButton("√");
	private final JButton raiz3 = new JButton("∛");
	private final JButton potencia = new JButton("^2");
	private final JButton inverso = new JButton("Inv");
	private final JButton sen = new JButton("Sen");
	private final JButton cos= new JButton("Cos");
	private final JButton tan=new JButton("Tan");
	private final JButton punto=new JButton(".");
        
        // Bandera lógica para para indicar el inicio de una nueva cifra
        private boolean nuevo=true;
        
	public Vista()
	{
		initComponents();
		this.setTitle("Calculadora");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.setBounds(100,100,610,370);

		this.setVisible(true);

	}

	public void initComponents()
	{
            // Diseña el menu
            JMenuBar barraMenus = new JMenuBar();
            JMenu archivo       = new JMenu("Archivo");
            JMenuItem salir     = new JMenuItem("Salir");
            JMenuItem Radianes     = new JMenuItem("Radianes");
            JMenuItem Grados     = new JMenuItem("Grados");
            this.setJMenuBar(barraMenus);
            
            barraMenus.add(archivo);
            archivo.add(salir);
             archivo.add(Radianes);
             archivo.add(Grados);
            
		// Al desabilitar el LayoutManager, el programador tiene
		// la responsabilidad de situar los componentes
            this.setLayout(null); // Se deshabilita el Gestor de Distribución
            display.setBounds(10,5,580,40);
            b1.setBounds(10,50,50,50);
            b2.setBounds(70,50,50,50);
            b3.setBounds(130,50,50,50);
            mas.setBounds(190,50,50,50);

            b4.setBounds(10,110,50,50);
            b5.setBounds(70,110,50,50);
            b6.setBounds(130,110,50,50);
            menos.setBounds(190,110,50,50);

            b7.setBounds(10,170,50,50);
            b8.setBounds(70,170,50,50);
            b9.setBounds(130,170,50,50);
            b0.setBounds(70,230,50,50);
            e.setBounds(190,170,50,50);
            cE.setBounds(10,230,50,50);
            
            c.setBounds(130,230,50,50);
            pi.setBounds(190,230,50,50);
            multi.setBounds(250,50,50,50);
            div.setBounds(250,110,50,50);
            igual.setBounds(250,230,100,50);
            punto.setBounds(250,170,50,50);
            
            
            //Funciones 
            potencia.setBounds(330,50,70,50);
            raiz2.setBounds(420,50,70,50);
            raiz3.setBounds(510,50,70,50);
            sen.setBounds(330,110,70,50);
            cos.setBounds(420,110,70,50);
            tan.setBounds(510,110,70,50);
            inverso.setBounds(420,170,70,50);       
            
            
            display.setBackground(Color.black);
            display.setForeground(Color.orange);
            display.setFont(new Font("Consolas",Font.BOLD, 26));
            display.setHorizontalAlignment(JTextField.RIGHT);
            display.setEditable(false);

            // Agrega los elementos al JFrame
            this.add(display);
            this.add(b1);
            this.add(b2);
            this.add(b3);
            this.add(b4);
            this.add(b5);
            this.add(b6);
            this.add(b7);
            this.add(b8);
            this.add(b9);
            this.add(b0);
            this.add(mas);
            this.add(menos);
            this.add(igual);
            this.add(cE);
            
            this.add(c);
            this.add(pi);
            this.add(e);
            this.add(multi);
            this.add(div);
            this.add(sen);
            this.add(cos);
            this.add(tan);
            this.add(inverso);
            this.add(potencia);
            this.add(raiz2);
            this.add(raiz3);
            this.add(punto);
                        
            

            // Para la gestión de los eventos de Calculadora
            
            b0.addActionListener(evt -> gestionarBotones(evt));
            b1.addActionListener(evt -> gestionarBotones(evt));
            b2.addActionListener(evt -> gestionarBotones(evt));
            b3.addActionListener(evt -> gestionarBotones(evt));
            b4.addActionListener(evt -> gestionarBotones(evt));         
            b5.addActionListener(evt -> gestionarBotones(evt));
            b6.addActionListener(evt -> gestionarBotones(evt));
            b7.addActionListener(evt -> gestionarBotones(evt));
            b8.addActionListener(evt -> gestionarBotones(evt));
            b9.addActionListener(evt -> gestionarBotones(evt));
            mas.addActionListener(evt -> gestionarBotones(evt));
            menos.addActionListener(evt -> gestionarBotones(evt));               
            igual.addActionListener(evt -> gestionarBotones(evt));
            
            pi.addActionListener(evt -> gestionarBotones(evt));         
            e.addActionListener(evt -> gestionarBotones(evt));
            sen.addActionListener(evt -> gestionarBotones(evt));
            cos.addActionListener(evt -> gestionarBotones(evt));
            tan.addActionListener(evt -> gestionarBotones(evt));
            inverso.addActionListener(evt -> gestionarBotones(evt));
            multi.addActionListener(evt -> gestionarBotones(evt));
            div.addActionListener(evt -> gestionarBotones(evt));               
            potencia.addActionListener(evt -> gestionarBotones(evt));
            raiz2.addActionListener(evt -> gestionarBotones(evt));
            raiz3.addActionListener(evt -> gestionarBotones(evt));
            punto.addActionListener(evt -> gestionarBotones(evt));
            

           
            // Al ser una tecla con dos símbolos en la cara le asignamos
            // un Listener diferente
                
            cE.addActionListener(evt -> gestionarCE(evt));
             c.addActionListener(evt -> gestionarC(evt));
                
            // Gestión de menú
            salir.addActionListener(evt -> gestionarSalir(evt));
            Radianes.addActionListener(evt -> calculator.setRadianes());
            Grados.addActionListener(evt -> calculator.setDegrees());
        
            // Salida 
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
               
        // Métodos para gestión de eventos
        
        public void gestionarSalir(java.awt.event.ActionEvent evt)
        {
            exit();
        }
        
        public void exit()
        {
            int respuesta = JOptionPane.showConfirmDialog(rootPane, 
             "Desea salir?","Federación deportiva",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
        }

        // Gestión para botones numéricos y símbolos de operación
        public void gestionarBotones(java.awt.event.ActionEvent evt)
        {

            String textoBoton = evt.getActionCommand();

            // Cada botón tiene un simbolo numérico o operador en la cara del botón
            // Se obtiene con charAt
            
            char simbolo = textoBoton.charAt(0);
                            
            if( (simbolo >= '0' && simbolo <= '9') || 
                    simbolo == '.' || simbolo == 'e'|| simbolo == 'π') // En caso de número o punto
            {
                if(nuevo) display.setText(""); // Si es una nueva cifra se borra el display
                
                    display.setText(display.getText()+simbolo);
		nuevo = false; // Se pone en falso cuando se pone el primer dígito de una cifra
            }
            else if(simbolo=='+'||simbolo=='-'||
                    simbolo=='x'||simbolo=='÷'||
                    simbolo=='√'||simbolo=='∛'||
                    simbolo=='^'||simbolo=='I'||
                    simbolo=='S'||simbolo=='C'||
                    simbolo=='T'||simbolo=='=') // En caso de operador
            {
		double numero;                
                if(display.getText().equals("e"))numero=Math.E;                
                else if(display.getText().equals("π"))numero=Math.PI;                
                else numero=Double.parseDouble(display.getText());           
                
                calculator.operacion(numero,simbolo);        // Invoca la funcionalidad de la calculadora
		display.setText(""+calculator.getMemoria());  // Obtiene el estado de la memoria de la calculadora
		nuevo = true;
            }
                       
        }
            
        // Gestiona botón CE
        public void gestionarCE(java.awt.event.ActionEvent evt)
        {
            // Codigo para procesar CE
              display.setText(""+calculator.getMemoria());
              nuevo=true;
        } 
        
         public void gestionarC(java.awt.event.ActionEvent evt)
        {
            // Codigo para procesar CE
            display.setText("");
            calculator.clearMemory();
            nuevo=true;
        } 
        
        
}
