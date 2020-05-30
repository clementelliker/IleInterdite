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
	public Etat etat; //l'état de la case
	public ArrayList<Joueur> j; //liste des joueurs sur la case
	public caseType type;
	
	public Case(Fenetre wd, Plateau p, int x, int y, int width, int height, caseType type) {
		/*
		 * Construit un instance de Case
		 * @args: -wd: la fenêtre lié à la case
		 * 		  -p: le plateau lié à la case
		 *        -x,y: les coordonnées de la case
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
		this.etat = Etat.normale;//la case est normale au début
		this.j = new ArrayList<Joueur>();//il n'y a personne sur la case à sa création
		this.type = type;
	}
	
	public Case() {
		/*
		 * Construit un instance vide de Case
		 */
	}

}
