package Model;
import java.util.ArrayList;
import java.util.Random;

import View.*;

public class Joueur {
	
	public Random seed = new Random();//permet de faire de l'aléatoire
	
	public Case pos;
	public Fenetre wd;
	public Plateau p;
	public int numJ;
	public ArrayList<Integer> clef;
	public int nbSacDeSable;
	public int nbHelico;
	public boolean usedSDS;
	public boolean usedH;
	
	public Joueur(Fenetre wd, Plateau p, int numJ) {	
		/*
		 * Construit une instance de joueur
		 * @args: -wd: fenêtre liée au joueur
		 * 		  -p: plateau lié au joueur
		 * 		  -numpJ: numéro du joueur
		 */
		//on initialise les paramètre du joueur
		this.wd = wd;
		this.p = p;
		this.numJ = numJ;
		this.pos = this.p.cases.get(seed.nextInt(24));//on choisit sa position de départ au hasard
		this.pos.j.add(this);//on ajoute le joueur à la liste de la case de départ
		this.clef = new ArrayList<Integer>();//on initialise l'inventaire de clés
		for(int i = 0; i < 4; i++) {
			this.clef.add(0);
		}
		this.nbHelico = 0;
		this.nbSacDeSable = 0;
		this.usedSDS = false;
		this.usedH = false;
	}

}
