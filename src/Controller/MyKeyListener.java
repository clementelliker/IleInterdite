package Controller;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import View.Fenetre;

public class MyKeyListener extends KeyAdapter{
	
	//les fonctions non impl�ment�es ne sont pas comment�es
	
	public Fenetre wd;
	
	public MyKeyListener(Fenetre wd) {
		/*
		 * Construit une instance de MyKeyListener 
		 * @args: la fen�tre que l'on va lier
		 */
		super();//on appel le superConstructeur
		this.wd = wd;//on lie la fen�tre
	}
	
	public void keyPressed(KeyEvent evt) {
		
	}

}
