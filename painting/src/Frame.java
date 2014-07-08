/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.*;


public class Frame extends JFrame{
	private static Container frame; 
	static JMenuBar belkamenu;
	JMenu plik;
	JMenu edycja;
	static JMenuItem wyjscie;
	static JMenuItem cofnij;
	static Stack<JPanel> previousPanels;
    static Stack<JPanel> forwardPanels;
	

public Frame(){
	
	frame = getContentPane();  
    frame.setLayout(new BorderLayout());
	belkamenu = new JMenuBar();
	setJMenuBar(belkamenu);
	plik = new JMenu("Plik");
	edycja = new JMenu("Edycja");
	belkamenu.add(plik);
	belkamenu.add(edycja);
	
	wyjscie = new JMenuItem("Wyjœcie");
	cofnij = new JMenuItem("Cofnij");
	plik.add(wyjscie);
	edycja.add(cofnij);
	
	cofnij.addActionListener(
			new ActionListener(){
		public void actionPerformed(ActionEvent event){
			

		
		}});
	
	wyjscie.addActionListener(
			new ActionListener(){
		public void actionPerformed(ActionEvent event){
			
			System.exit(0);
			
		
		}});
	
	setTitle("Paint");

	


	


	}
public static void main(String args[])
{

Frame gui = new Frame();
gui.setLayout(new BorderLayout());

gui.add(new Painting(),BorderLayout.NORTH);
gui.add(new Roboczy(),BorderLayout.SOUTH);
gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
gui.setSize(1024,576);
gui.setVisible(true);
}
		
}*/
