package Model;
import java.util.ArrayList;

import View.*;

public class Case {
	
	public Fenetre wd;
	public Plateau p;
	public int x;
	public int y;
	public int width;
	public int height;
	public Etat etat; //l'�tat de la case
	public ArrayList<Joueur> j; //liste des joueurs sur la case
	public caseType type;
	
	public Case(Fenetre wd, Plateau p, int x, int y, int width, int height, caseType type) {
		/*
		 * Construit un instance de Case
		 * @args: -wd: la fen�tre li� � la case
		 * 		  -p: le plateau li� � la case
		 *        -x,y: les coordonn�es de la case
		 *        -width: la largeur de la case
		 *        -height: la hauteur de la case
		 *        -type; type de la case
		*/
		this.wd = wd;
		this.p = p;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.etat = Etat.normale;//la case est normale au d�but
		this.j = new ArrayList<Joueur>();//il n'y a personne sur la case � sa cr�ation
		this.type = type;
	}
	
	public Case() {
		/*
		 * Construit un instance vide de Case
		 */
	}

}
