package Model;
import java.util.ArrayList;
import java.util.Random;

import View.*;

public class Joueur {
	
	public Random seed = new Random();//permet de faire de l'al�atoire
	
	public Case pos;
	public Fenetre wd;
	public Plateau p;
	public int numJ;
	public ArrayList<Integer> clef;
	public int nbSacDeSable;
	public int nbHelico;
	public boolean usedSDS;
	public boolean usedH;
	public Classe classe;
	public boolean ingeAssech;
	
	public Joueur(Fenetre wd, Plateau p, int numJ, Classe c) {	
		/*
		 * Construit une instance de joueur
		 * @args: -wd: fen�tre li�e au joueur
		 * 		  -p: plateau li� au joueur
		 * 		  -numpJ: num�ro du joueur
		 */
		//on initialise les param�tre du joueur
		this.wd = wd;
		this.p = p;
		this.numJ = numJ;
		this.pos = this.p.cases.get(seed.nextInt(24));//on choisit sa position de d�part au hasard
		this.pos.j.add(this);//on ajoute le joueur � la liste de la case de d�part
		this.clef = new ArrayList<Integer>();//on initialise l'inventaire de cl�s
		for(int i = 0; i < 4; i++) {
			this.clef.add(0);
		}
		this.nbHelico = 0;
		this.nbSacDeSable = 0;
		this.usedSDS = false;
		this.usedH = false;
		this.classe = c;
		this.ingeAssech = false;
	}

	public Joueur(int numJ) {
		// TODO Auto-generated constructor stub
		this.numJ = numJ;
	}

}
