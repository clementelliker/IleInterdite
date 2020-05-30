package Model;

import java.awt.Color;

import View.Fenetre;

public class Bouton {
	
	public Fenetre wd;
	public Plateau p;
	public int x;
	public int y;
	public int width;
	public int height;
	public String text;
	public Color c;
	
	public Bouton(Fenetre wd, Plateau p, int x, int y, int width, int height, String text, Color c) {
		/*
		 * Construit un instance de Bouton
		 * @args: -wd: fenêtre liée au bonton
		 * 		  -p: plateau lié au bouton
		 * 		  -x, y: position du bouton
		 * 		  -width: largueur du bouton
		 * 		  -height: hauteur du bouton
		 * 		  -text: text du bouton
		 * 		  -c: couleur du bouton
		 */
		//on initialise les paramètre du bouton
		this.wd = wd;
		this.p = p;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.c = c;
	}

	public Bouton() {
		// TODO Auto-generated constructor stub
	}

}
