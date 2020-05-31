package Model;
import View.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Plateau {
	
	public Random seed = new Random();//permet d'avoir de l'aléatoire
	public Fenetre wd;
	public ArrayList<Case> cases;//liste des case du plateau
	public ArrayList<Bouton> buttons;//liste des boutons du plateau
	public ArrayList<Joueur> joueurs;//liste des joueurs du plateau
	public int actionRestante;//nombre d'actions restantes pour le tour du joueur
	public int tourJ;//numéro du tour actuel
	public int nbJoueur;//nombre de joueurs
	public EtatPlateau eP;//etat actuel du plateau
	public ArrayList<Integer> artefactOwned;
	public boolean selectedSDS;
	public boolean selectedH;
	public boolean selectedA;
	public boolean selectedE;
	public boolean selectedF;
	public boolean selectedT;
	public int selectClasseJ;
	public ArrayList<Classe> tempoClasse;
	public Joueur navigPlayerSelected;
	
	public Plateau() {
		/*
		 * Construit une instance de Plateau
		 */
		this.cases = new ArrayList<Case>();//on créer la liste des cases
		this.buttons = new ArrayList<Bouton>();//on créer la liste des boutons
		this.joueurs = new ArrayList<Joueur>();//on créer la liste des joueurs
		this.tourJ = 0;//on initialise le numéro du tour
		this.actionRestante = 3;//on initialise le nombre d'actions restantes
		this.eP = EtatPlateau.MenuSelectionNbJoueur;//on commence par selectionner le nombre de joueurs
		this.artefactOwned = new ArrayList<Integer>();//on créer la liste des artefacts obtenues
		for(int i = 0; i < 4; i++) {
			this.artefactOwned.add(0);
		}
		this.selectedSDS = false;
		this.selectedH = false;
		this.selectedA = false;
		this.selectedE = false;
		this.selectedF = false;
		this.selectedT = false;
		this.selectClasseJ = 1;
		this.tempoClasse = new ArrayList<Classe>();
		this.navigPlayerSelected = new Joueur(99);
	}
	
	public void linkWindow(Fenetre wd) {
		/*
		 * Lie un fenêtre au plateau
		 *@args: -wd: la fenêtre qu'on va lier
		 */
		this.wd = wd;
	}
	
	public void setupPlateau() {
		/*
		 * Met en place toute les instances nécessaires au bon déroulement du jeu
		 */
		//on ajoute toutes les cases
		//1ere ligne
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*2/6, 0, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*3/6, 0, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		//2eme ligne
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth/6, this.wd.wdHeight/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*2/6, this.wd.wdHeight/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*3/6, this.wd.wdHeight/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*4/6, this.wd.wdHeight/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		//3eme ligne
		this.cases.add(new Case(this.wd, this, 0, this.wd.wdHeight*2/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth/6, this.wd.wdHeight*2/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*2/6, this.wd.wdHeight*2/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*3/6, this.wd.wdHeight*2/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*4/6, this.wd.wdHeight*2/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*5/6, this.wd.wdHeight*2/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		//4eme ligne
		this.cases.add(new Case(this.wd, this, 0, this.wd.wdHeight*3/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth/6, this.wd.wdHeight*3/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*2/6, this.wd.wdHeight*3/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*3/6, this.wd.wdHeight*3/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*4/6, this.wd.wdHeight*3/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*5/6, this.wd.wdHeight*3/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		//5eme ligne
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth/6, this.wd.wdHeight*4/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*2/6, this.wd.wdHeight*4/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*3/6, this.wd.wdHeight*4/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*4/6, this.wd.wdHeight*4/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		//6eme ligne
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*2/6, this.wd.wdHeight*5/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		this.cases.add(new Case(this.wd, this, this.wd.wdWidth*3/6, this.wd.wdHeight*5/6, this.wd.wdWidth/6, this.wd.wdHeight/6, caseType.normal));
		
		int r = seed.nextInt(24);//on choisit un case au hasard pour etre l'héliport
		this.cases.get(r).type = caseType.heliport;
		do {//on choisit les cases eau
			r = seed.nextInt(24);
		}while(this.cases.get(r).type != caseType.normal);
		this.cases.get(r).type = caseType.eau;
		do {
			r = seed.nextInt(24);
		}while(this.cases.get(r).type != caseType.normal);
		this.cases.get(r).type = caseType.eau;
		do {//on choisit les cases feu
			r = seed.nextInt(24);
		}while(this.cases.get(r).type != caseType.normal);
		this.cases.get(r).type = caseType.feu;
		do {
			r = seed.nextInt(24);
		}while(this.cases.get(r).type != caseType.normal);
		this.cases.get(r).type = caseType.feu;
		do {//on choisit les cases air
			r = seed.nextInt(24);
		}while(this.cases.get(r).type != caseType.normal);
		this.cases.get(r).type = caseType.air;
		do {
			r = seed.nextInt(24);
		}while(this.cases.get(r).type != caseType.normal);
		this.cases.get(r).type = caseType.air;
		do {//on choisit les cases terre
			r = seed.nextInt(24);
		}while(this.cases.get(r).type != caseType.normal);
		this.cases.get(r).type = caseType.terre;
		do {
			r = seed.nextInt(24);
		}while(this.cases.get(r).type != caseType.normal);
		this.cases.get(r).type = caseType.terre;
		
		//on ajoute le bouton de bouton fin de tour
		this.buttons.add(new Bouton(this.wd, this, 0, 0, this.wd.wdWidth/6, this.wd.wdHeight/12, "Fin de Tour", new Color(150,75,0)));
		//on ajoute les bouton pour les objets spéciaux
		this.buttons.add(new Bouton(this.wd, this, 0, this.wd.wdHeight*9/12, this.wd.wdWidth/12, this.wd.wdHeight/12, "", new Color(255,255,102)));//sac de sable
		this.buttons.add(new Bouton(this.wd, this, 0, this.wd.wdHeight*5/6, this.wd.wdWidth/12, this.wd.wdHeight/12, "", new Color(151,151,151)));//helico
		//on ajoute les bouton pour echanger les clés
		this.buttons.add(new Bouton(this.wd, this, 0, this.wd.wdHeight*11/12, this.wd.wdWidth/24, this.wd.wdHeight/24, "", new Color(248,255,200)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth/24, this.wd.wdHeight*11/12, this.wd.wdWidth/24, this.wd.wdHeight/24, "", new Color(14,135,165)));
		this.buttons.add(new Bouton(this.wd, this, 0, this.wd.wdHeight*23/24, this.wd.wdWidth/24, this.wd.wdHeight/24, "", new Color(253,114,18)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth/24, this.wd.wdHeight*23/24, this.wd.wdWidth/24, this.wd.wdHeight/24, "", new Color(147,90,53)));
		//on ajoute les boutons pour selectionner le joueur a qui on donne la clé
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth/12, this.wd.wdHeight*11/12, this.wd.wdWidth/24, this.wd.wdHeight/24, "", new Color(230,230,0)));
		if(this.nbJoueur > 1) {
			this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*3/24, this.wd.wdHeight*11/12, this.wd.wdWidth/24, this.wd.wdHeight/24, "", new Color(230,0,0)));
		}
		if(this.nbJoueur > 2) {
			this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth/12, this.wd.wdHeight*23/24, this.wd.wdWidth/24, this.wd.wdHeight/24, "", new Color(0,42,255)));
			}
		if(this.nbJoueur > 3) {
			this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*3/24, this.wd.wdHeight*23/24, this.wd.wdWidth/24, this.wd.wdHeight/24, "", new Color(0,230,0)));
		}	
		//on initialise les joueurs
		for(int i = 0; i < this.nbJoueur; i++) {
			this.joueurs.add(new Joueur(this.wd, this, i, this.tempoClasse.get(i)));
		}
	}

	public void mouse1Clicked(Point mousePos) {
		/*
		 * Realise les actions concernants le clique gauche
		 *@args: -mousePos: position de la souris au moment du clique
		 */
		if(this.eP == EtatPlateau.MenuSelectionNbJoueur) {//on regared dans quel menu on est
			for(int i = 0; i < 4; i++) {//on parcourt les 4 boutons
				if(mousePos.x > this.buttons.get(i).x && mousePos.x < this.buttons.get(i).x + this.buttons.get(i).width
						&& mousePos.y > this.buttons.get(i).y && mousePos.y < this.buttons.get(i).y + this.buttons.get(i).height) {//on regarde si on a cliqué sur un bouton
					//on selectionne le nombre de joueurs
					if(this.buttons.get(i).text == "1J") {
						this.nbJoueur = 1;
					}else if(this.buttons.get(i).text == "2J") {
						this.nbJoueur = 2;
					}else if(this.buttons.get(i).text == "3J") {
						this.nbJoueur = 3;
					}else if(this.buttons.get(i).text == "4J") {
						this.nbJoueur = 4;
					}
					this.eP = EtatPlateau.MenuSelectionClasse;//on change l'etat du plateau
					this.buttons.removeAll(buttons);//on enleve les boutons
					break;
				}
			}
		}else if(this.eP == EtatPlateau.MenuSelectionClasse) {
			for(int i = 0; i < this.buttons.size(); i++) {//on parcourt les 6 boutons
				if(mousePos.x > this.buttons.get(i).x && mousePos.x < this.buttons.get(i).x + this.buttons.get(i).width
						&& mousePos.y > this.buttons.get(i).y && mousePos.y < this.buttons.get(i).y + this.buttons.get(i).height) {//on regarde si on a cliqué sur un bouton
					boolean changed = false;
					if(this.buttons.get(i).text == "Pilote") {
						changed = this.checkClasse(Classe.pilote);
					}else if(this.buttons.get(i).text == "Ingénieur") {
						changed = this.checkClasse(Classe.ingenieur);
					}else if(this.buttons.get(i).text == "Explorateur") {
						changed = this.checkClasse(Classe.explorateur);
					}else if(this.buttons.get(i).text == "Navigateur") {
						changed = this.checkClasse(Classe.navigateur);
					}else if(this.buttons.get(i).text == "Plongueur") {
						changed = this.checkClasse(Classe.plongueur);
					}else if(this.buttons.get(i).text == "Messager") {
						changed = this.checkClasse(Classe.messager);
					}
					if(changed == true) {
						this.selectClasseJ++;
						if(this.selectClasseJ > this.nbJoueur) {
							this.buttons.removeAll(buttons);
							this.eP = EtatPlateau.Jeu;
						}
					}						
				}
			}
		}else if(this.eP == EtatPlateau.Jeu) {
			for(int i = 0; i < this.buttons.size(); i++) {//on parcours tout les boutons
				if(mousePos.x > this.buttons.get(i).x && mousePos.x < this.buttons.get(i).x + this.buttons.get(i).width
						&& mousePos.y > this.buttons.get(i).y && mousePos.y < this.buttons.get(i).y + this.buttons.get(i).height) {
					if(this.buttons.get(i).text == "Fin de Tour") {//on vérifie si la souris est sur le bouton
						this.finDeTour();//on fait la fin de tour
					}
					if(i == 1) {
						if(this.selectedSDS == false) {
							this.unselecting();
							this.selectedSDS = true;
						}else {
							this.selectedSDS = false;
						}
					}else if(i == 2) {
						if(this.selectedH == false) {
							this.unselecting();
							this.selectedH = true;
						}else {
							this.selectedH = false;
						}
					}else if(i == 3) {
						if(this.selectedA == false) {
							this.unselecting();
							this.selectedA = true;
						}else {
							this.selectedA = false;
						}
						
					}else if(i == 4) {
						if(this.selectedE == false) {
							this.unselecting();
							this.selectedE = true;
						}else {
							this.selectedE = false;
						}
						
					}else if(i == 5) {
						if(this.selectedF == false) {
							this.unselecting();
							this.selectedF = true;
						}else {
							this.selectedF = false;
						}
						
					}else if(i == 6) {
						if(this.selectedT == false) {
							this.unselecting();
							this.selectedT = true;
						}else {
							this.selectedT = false;
						}
						
					}
					if(this.selectedA == true || this.selectedE == true || this.selectedF == true || this.selectedT == true && i > 6) {
						//on cherche la clé sélectionnée
						int cléSelected = 0;
						if(this.selectedF == true) {
							cléSelected = 1;
						}else if(this.selectedA == true) {
							cléSelected = 2;
						}if(this.selectedT == true) {
							cléSelected = 3;
						}
						for(int j = 0; j < this.nbJoueur; j++) {
							//System.out.println("1 " + Boolean.toString(i == 7+j));
							//System.out.println("2 " + Boolean.toString(this.joueurs.get(this.tourJ%this.nbJoueur).pos == this.joueurs.get(j).pos));
							//System.out.println("3 " + Boolean.toString(this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(cléSelected) > 0));
							if(i == 7+j &&  this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(cléSelected)> 0
									&& (this.joueurs.get(this.tourJ%this.nbJoueur).pos == this.joueurs.get(j).pos || this.joueurs.get(this.tourJ%this.nbJoueur).classe == Classe.messager)) {//on regarde si le joueur est sur la même case et si il peut donner la clé, s'il est messager il n'a pas besoin d'etre sur la meme case
								this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(cléSelected, this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(cléSelected)-1);
								this.joueurs.get(j).clef.set(cléSelected, this.joueurs.get(j).clef.get(cléSelected)+1);
								this.unselecting();
							}
						}
					}
				}else if(i > 6 && mousePos.x > this.buttons.get(i).x-this.wd.wdWidth/12 && mousePos.x < this.buttons.get(i).x-this.wd.wdWidth/12 + this.buttons.get(i).width
						&& mousePos.y > this.buttons.get(i).y-this.wd.wdHeight*9/12 && mousePos.y < this.buttons.get(i).y-this.wd.wdHeight*9/12 + this.buttons.get(i).height
						&& this.joueurs.get(this.tourJ%this.nbJoueur).classe == Classe.navigateur && this.selectedA != true && this.selectedE != true 
						&& this.selectedF != true && this.selectedT != true) {
					if(i-7 != this.joueurs.get(this.tourJ%this.nbJoueur).numJ) {
						this.unselecting();
						this.navigPlayerSelected = this.joueurs.get(i-7);
					}
					
					
				}
				
			}
			if(this.actionRestante != 0) {//on vérifie qu'on a encore des actions restantes
				Case caseClicked = new Case();
				boolean realCase = false;
				for(int i = 0; i < this.cases.size(); i++) {//on parcours toutes les cases
					if(mousePos.x > this.cases.get(i).x && mousePos.x < this.cases.get(i).x + this.cases.get(i).width && mousePos.y > this.cases.get(i).y 
							&& mousePos.y < this.cases.get(i).y + this.cases.get(i).height 
							&& (this.cases.get(i).etat != Etat.submerge || this.joueurs.get(this.tourJ%this.nbJoueur).classe == Classe.plongueur)) {//on vérifie si la case est celle sur laquelle on a cliquer et qu'elle n'est pas submergée ou qu'on est un plongueur
						caseClicked = this.cases.get(i);
						realCase = true;
						
					}
				}
				if(this.joueurs.get(this.tourJ%this.nbJoueur).pos == caseClicked) {//on regarde si on a cliqué sur la case de notre personnage
					if(caseClicked.type != caseType.heliport && caseClicked.type != caseType.normal) {//on regarde si on est sur une case à artefact
						if(caseClicked.type == caseType.eau) {
							if(this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(0) >= 4 && this.artefactOwned.get(0) == 0) {
								this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(0,this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(0) - 4);
								this.artefactOwned.set(0, 1);
								this.actionRestante--;
							}
						}else if(caseClicked.type == caseType.feu) {
							if(this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(1) >= 4 && this.artefactOwned.get(1) == 0) {
								this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(1,this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(1) - 4);
								this.artefactOwned.set(1, 1);
								this.actionRestante--;
							}
						}else if(caseClicked.type == caseType.air) {
							if(this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(2) >= 4 && this.artefactOwned.get(2) == 0) {
								this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(2,this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(2) - 4);
								this.artefactOwned.set(2, 1);
								this.actionRestante--;
							}
						}else if(caseClicked.type == caseType.terre) {
							if(this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(3) >= 4 && this.artefactOwned.get(3) == 0) {
								this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(3,this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(3) - 4);
								this.artefactOwned.set(3, 1);
								this.actionRestante--;
							}
						}
					}
				}
				if((this.sontAdjacentes(this.joueurs.get(this.tourJ%this.nbJoueur).pos, caseClicked) == true && realCase == true) 
						|| (this.joueurs.get(this.tourJ%this.nbJoueur).classe == Classe.explorateur && this.sontDiagonales(this.joueurs.get(this.tourJ%this.nbJoueur).pos, caseClicked) == true) 
						|| (this.joueurs.get(this.tourJ%this.nbJoueur).classe == Classe.pilote && realCase == true && this.joueurs.get(this.tourJ%this.nbJoueur).pos != caseClicked)) {//on vérifie si elle est adjacente à notre personnage ou si on est un pilote ou si on est explorateur et en diagonale
					this.joueurs.get(this.tourJ%this.nbJoueur).pos.j.remove(this.joueurs.get(this.tourJ%this.nbJoueur));//on enlève le joueurs de la liste de sa case précédente
					this.joueurs.get(this.tourJ%this.nbJoueur).pos = caseClicked;//on déplace le joueur sur sa nouvelle case
					caseClicked.j.add(this.joueurs.get(this.tourJ%this.nbJoueur));//on ajoute le joueur à la liste de sa nouvelle case
					this.actionRestante--;//on décremente le nombre d'actions restantes
				}else if(this.joueurs.get(this.tourJ%this.nbJoueur).classe == Classe.navigateur && this.navigPlayerSelected.numJ != 99) {
					if((this.sontAdjacentes(this.navigPlayerSelected.pos, caseClicked) == true && realCase == true)
							|| (this.navigPlayerSelected.classe == Classe.explorateur && this.sontDiagonales(this.navigPlayerSelected.pos, caseClicked) == true) 
							|| (this.navigPlayerSelected.classe == Classe.pilote && realCase == true && this.navigPlayerSelected.pos != caseClicked)) {
						this.navigPlayerSelected.pos.j.remove(this.navigPlayerSelected);//on enlève le joueurs de la liste de sa case précédente
						this.navigPlayerSelected.pos = caseClicked;//on déplace le joueur sur sa nouvelle case
						caseClicked.j.add(this.navigPlayerSelected);//on ajoute le joueur à la liste de sa nouvelle case
						this.actionRestante--;//on décremente le nombre d'actions restantes
						this.navigPlayerSelected = new Joueur(99);
					}
				}
				
			}
		}
	}
	
	private boolean sontDiagonales(Case pos, Case caseClicked) {
		return Maths.distance(pos.x, pos.y, caseClicked.x, caseClicked.y) == java.lang.Math.sqrt(2*(java.lang.Math.pow(this.wd.wdHeight/6, 2)));
	}

	private boolean checkClasse(Classe c) {
		for(int i = 0; i < this.selectClasseJ-1; i++) {
			if(this.tempoClasse.get(i) == c) {
				return false;
			}
		}
		this.tempoClasse.add(c);
		return true;
	}

	public void unselecting() {
		this.selectedSDS = false;
		this.selectedH = false;
		this.selectedA = false;
		this.selectedE = false;
		this.selectedF = false;
		this.selectedT = false;
		this.navigPlayerSelected = new Joueur(99);
	}
	
	public boolean sontAdjacentes(Case c1, Case c2) {
		/*
		 * Dertermine si les deux cases sont adjacentes
		 *@args: -c1,c2: les cases concernées
		 *@return: true si elles sont adjacentes false sinon
		 */
		return Maths.distance(c1.x, c1.y, c2.x, c2.y) == this.wd.wdWidth/6;
	}
    
	public void finDeTour() {
		/*
		 * Effecte les action d'une fin de tour
		 */
		ArrayList<Integer> caseDone = zoneSubmerge();//on regarde quelles sont les zones submergées (1 si oui, 0 sinon)
		int rand;
		rand = seed.nextInt(12);//on tire au hasard l'action de fin de tour
		if(rand < 2) {//on inonde une zone
			if(this.joueurs.get(this.tourJ%this.nbJoueur).pos.etat == Etat.normale) {//on met a jour l'état de la case du personnage
				this.joueurs.get(this.tourJ%this.nbJoueur).pos.etat = Etat.innonde;
			}else {
				this.joueurs.get(this.tourJ%this.nbJoueur).pos.etat = Etat.submerge;
			}
		}else if(rand == 2) {//on ajoute un helico
			this.joueurs.get(this.tourJ%this.nbJoueur).nbHelico++;
		}else if(rand == 3) {//on ajoute a sac de sable
			this.joueurs.get(this.tourJ%this.nbJoueur).nbSacDeSable++;
		}else if(rand == 4 || rand == 5) {//on ajoute une clé de eau
			this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(0,this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(0) + 1);
		}else if(rand == 6  || rand == 7) {//on ajoute une clé de feu
			this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(1,this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(1) + 1);
		}else if(rand == 8  || rand == 9) {//on ajoute une clé de air
			this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(2,this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(2) + 1);
		}else if(rand == 10  || rand == 11) {//on ajoute une clé de terre
			this.joueurs.get(this.tourJ%this.nbJoueur).clef.set(3,this.joueurs.get(this.tourJ%this.nbJoueur).clef.get(3) + 1);
		}
		
		if(this.nbZoneSubmerge() < 22) {//si on peut modifier 3 cases 
			for(int i = 0; i < 3; i++) {//on choisit 3 cases
				do {
					rand = seed.nextInt(24);//on tire un case au hasard
				}while(caseDone.get(rand) == 1);//tant que celle tirée est submergée
				caseDone.set(rand, 1);//on met a jour caseDone pour ne pas tirer 2 fois la même
				if(this.cases.get(rand).etat == Etat.normale) {//on met a jour l'état de la case
					this.cases.get(rand).etat = Etat.innonde;
				}else {
					this.cases.get(rand).etat = Etat.submerge;
				}
			}
		}else if(this.nbZoneSubmerge() == 22) {//si on ne peut en modifier que 2
			for(int i = 0; i < 2; i++) {//on choist 2 cases
				do {
					rand = seed.nextInt(24);//tant que celle tirée est submergée
				}while(caseDone.get(rand) == 1);//tant que celle tirée est submergée
				caseDone.set(rand, 1);//on met a jour caseDone pour ne pas tirer 2 fois la même
				if(this.cases.get(rand).etat == Etat.normale) {//on met a jour l'état de la case
					this.cases.get(rand).etat = Etat.innonde;
				}else {
					this.cases.get(rand).etat = Etat.submerge;
				}
			}
		}else if(this.nbZoneSubmerge() == 23) {//si on ne peut en modifier qu'une seule case
			do {
				rand = seed.nextInt(24);//on choisit une case
			}while(caseDone.get(rand) == 1);//tant que celle tirée est submergée
			if(this.cases.get(rand).etat == Etat.normale) {//on met a jour l'état de la case
				this.cases.get(rand).etat = Etat.innonde;
			}else {
				this.cases.get(rand).etat = Etat.submerge;
			}
		}else {//si toute l'île est submergée
			System.out.println("Ile.exe a cesse de fonctionner");
		}
		this.joueurs.get(this.tourJ%this.nbJoueur).ingeAssech = false;//on remet la capacité de faire des doubles asséchement a 0 pour l'ingénieur
		this.actionRestante = 3;//on reset le nombre d'action restante
		this.tourJ++;//on passe au joueur suivant
		this.joueurs.get(this.tourJ%this.nbJoueur).usedSDS = false;
		this.joueurs.get(this.tourJ%this.nbJoueur).usedH = false;
		this.unselecting();
		this.navigPlayerSelected = new Joueur(99);
	}
	
	public ArrayList<Integer> zoneSubmerge() {
		/*
		 * Créer une liste indiquant quelles sont les cases submergées
		 * @return: la liste en question
		 */
		ArrayList<Integer> caseDone = new ArrayList<Integer>();//on créer la liste que l'on va return
		for(int i = 0; i < this.cases.size(); i++) {//on parcorus toutes les cases
			if(this.cases.get(i).etat == Etat.submerge) {//on vérifie si la case est submergées
				caseDone.add(1);//si oui on l'indique en mettant 1
			}else {
				caseDone.add(0);//sinon on met 0
			}
		}
		return caseDone;
	}
	
	public int nbZoneSubmerge() {
		/*
		 * Indique le nombre de zones submergées
		 * @return: le nombre de zones submergées
		 */
		int ret = 0;//on initialise à 0
		for(int i = 0; i < this.cases.size(); i++) {//on parcourt toutes les cases
			if(this.cases.get(i).etat == Etat.submerge) {//on incrémente si elle est submergée
				ret++;
			}
		}
		return ret;
	}

	public void mouse2Clicked(Point mousePos) {
		/*
		 * Effectue les actions concernant le clique droit
		 * @args: -mousePos: position de la souris au moment du clique
		 */
		Case caseClicked = new Case();
		for(int i = 0; i < this.cases.size(); i++) {//on parcourt toutes les cases
			if(mousePos.x > this.cases.get(i).x && mousePos.x < this.cases.get(i).x + this.cases.get(i).width && mousePos.y > this.cases.get(i).y 
					&& mousePos.y < this.cases.get(i).y + this.cases.get(i).height && this.cases.get(i).etat != Etat.submerge) {//on regarde si c'est la case sur laquelle on a cliqué et si elle n'est pas déjà submergée
				caseClicked = this.cases.get(i);
			}
		}
		if(this.actionRestante != 0) {//on vérifie que l'on effectuer un action
			if(this.sontAdjacentes(this.joueurs.get(this.tourJ%this.nbJoueur).pos, caseClicked) == true || caseClicked == this.joueurs.get(this.tourJ%this.nbJoueur).pos
					|| (this.joueurs.get(this.tourJ%this.nbJoueur).classe == Classe.explorateur && this.sontDiagonales(this.joueurs.get(this.tourJ%this.nbJoueur).pos, caseClicked))) {//on regarde si la case sur laquelle on a cliqué est adjacente ou celle sur laquelle le joueur est déjà
				if(caseClicked.etat == Etat.innonde) {//on vérifie que la case est dans l'état innondé
					if(this.joueurs.get(this.tourJ%this.nbJoueur).classe != Classe.ingenieur) {//on regarde si c'est un ingénieur
						this.actionRestante--;//on décrément le nombre d'actions restante
					}else {
						if(this.joueurs.get(this.tourJ%this.nbJoueur).ingeAssech == false) {
							this.joueurs.get(this.tourJ%this.nbJoueur).ingeAssech = true;
						}else {
							this.joueurs.get(this.tourJ%this.nbJoueur).ingeAssech = false;
							this.actionRestante--;
						}
					}
					caseClicked.etat = Etat.normale;//on modifie l'état de la case modifiée
				}
			}
			if(this.selectedSDS == true && this.joueurs.get(this.tourJ%this.nbJoueur).nbSacDeSable > 0 && this.joueurs.get(this.tourJ%this.nbJoueur).usedSDS == false) {//utilisation du Sac de Sable
				if(caseClicked.etat == Etat.innonde) {//on vérifie que la case est dans l'état innondé
					caseClicked.etat = Etat.normale;//on modifie l'état de la case modifiée
					this.joueurs.get(this.tourJ%this.nbJoueur).nbSacDeSable--;
					this.joueurs.get(this.tourJ%this.nbJoueur).usedSDS = true;
					this.selectedSDS = false;
				}
			}
			if(this.selectedH == true && this.joueurs.get(this.tourJ%this.nbJoueur).usedH == false) {//utilisation de l'hélico
				this.joueurs.get(this.tourJ%this.nbJoueur).pos.j.remove(this.joueurs.get(this.tourJ%this.nbJoueur));//on enlève le joueurs de la liste de sa case précédente
				this.joueurs.get(this.tourJ%this.nbJoueur).pos = caseClicked;//on déplace le joueur sur sa nouvelle case
				caseClicked.j.add(this.joueurs.get(this.tourJ%this.nbJoueur));//on ajoute le joueur à la liste de sa nouvelle case
				this.joueurs.get(this.tourJ%this.nbJoueur).nbHelico--;
				this.joueurs.get(this.tourJ%this.nbJoueur).usedH = true;
				this.selectedH = false;
			}
		}else {
			if(this.selectedSDS == true && this.joueurs.get(this.tourJ%this.nbJoueur).nbSacDeSable > 0 && this.joueurs.get(this.tourJ%this.nbJoueur).usedSDS == false) {//utilisation du Sac de Sable
				if(caseClicked.etat == Etat.innonde) {//on vérifie que la case est dans l'état innondé
					caseClicked.etat = Etat.normale;//on modifie l'état de la case modifiée
					this.joueurs.get(this.tourJ%this.nbJoueur).nbSacDeSable--;
					this.joueurs.get(this.tourJ%this.nbJoueur).usedSDS = true;
					this.selectedSDS = false;
				}
			}
			if(this.selectedH == true && this.joueurs.get(this.tourJ%this.nbJoueur).usedH == false) {//utilisation de l'hélico
				this.joueurs.get(this.tourJ%this.nbJoueur).pos.j.remove(this.joueurs.get(this.tourJ%this.nbJoueur));//on enlève le joueurs de la liste de sa case précédente
				this.joueurs.get(this.tourJ%this.nbJoueur).pos = caseClicked;//on déplace le joueur sur sa nouvelle case
				caseClicked.j.add(this.joueurs.get(this.tourJ%this.nbJoueur));//on ajoute le joueur à la liste de sa nouvelle case
				this.joueurs.get(this.tourJ%this.nbJoueur).nbHelico--;
				this.joueurs.get(this.tourJ%this.nbJoueur).usedH = true;
				this.selectedH = false;
			}
		}
	}

	public void setupMenuJoueur() {
		//on ajoute les boutons de selection de nombre de joueurs
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*3/20, this.wd.wdHeight*12/13, this.wd.wdWidth/10, this.wd.wdHeight/10, "1J", new Color(255,255,0)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*7/20, this.wd.wdHeight*12/13, this.wd.wdWidth/10, this.wd.wdHeight/10, "2J", new Color(255,0,0)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*11/20, this.wd.wdHeight*12/13, this.wd.wdWidth/10, this.wd.wdHeight/10, "3J", new Color(25,64,255)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*3/4, this.wd.wdHeight*12/13, this.wd.wdWidth/10, this.wd.wdHeight/10, "4J", new Color(0,255,0)));
	}
	
	public void setupMenuClasse() {
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth/12, this.wd.wdHeight/2, this.wd.wdWidth/6, this.wd.wdHeight/12, "Pilote", new Color(198, 237, 255)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*5/12, this.wd.wdHeight/2, this.wd.wdWidth/6, this.wd.wdHeight/12, "Ingénieur", new Color(252, 231, 20)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*9/12, this.wd.wdHeight/2, this.wd.wdWidth/6, this.wd.wdHeight/12, "Explorateur", new Color(23, 174, 0)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth/12, this.wd.wdHeight*9/12, this.wd.wdWidth/6, this.wd.wdHeight/12, "Navigateur", new Color(0, 145, 174)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*5/12, this.wd.wdHeight*9/12, this.wd.wdWidth/6, this.wd.wdHeight/12, "Plongueur", new Color(17, 0, 174)));
		this.buttons.add(new Bouton(this.wd, this, this.wd.wdWidth*9/12, this.wd.wdHeight*9/12, this.wd.wdWidth/6, this.wd.wdHeight/12, "Messager", new Color(244, 250, 255)));
	}

	public boolean win() {
		/*
		 * Determine si la partie est gagnée
		 * @return: return true si les joueurs ont les 4 artefacts false sinon
		 */
		for(int i = 0; i < 4; i++) {//on vérifie chaque artefact
			if(this.artefactOwned.get(i) == 0) return false;
		}
		for(int i = 0; i < this.nbJoueur; i++) {
			if(this.joueurs.get(i).pos.type != caseType.heliport) return false;
		}
		return true;
	}
	
	public boolean lose() {
		ArrayList<Integer> check = new ArrayList<Integer>();
		check.add(0);
		check.add(0);
		check.add(0);
		check.add(0);
		for(int i = 0; i < this.cases.size(); i++) {
			if(this.cases.get(i).type == caseType.air && this.cases.get(i).etat == Etat.submerge) {
				check.set(0, check.get(0) + 1);
			}else if(this.cases.get(i).type == caseType.eau && this.cases.get(i).etat == Etat.submerge) {
				check.set(1, check.get(1) + 1);
			}else if(this.cases.get(i).type == caseType.feu && this.cases.get(i).etat == Etat.submerge) {
				check.set(2, check.get(2) + 1);
			}else if(this.cases.get(i).type == caseType.terre && this.cases.get(i).etat == Etat.submerge) {
				check.set(3, check.get(3) + 1);
			}else if(this.cases.get(i).type == caseType.heliport && this.cases.get(i).etat == Etat.submerge) {
				System.out.println("heli submerged");
				return true;
			}
		}
		if(check.get(0) == 2 || check.get(1) == 2 || check.get(2) == 2 || check.get(3) == 2) {
			System.out.println("arti submerged");
			return true;
		}
		int nbCaseAdjaJoueur;
		boolean isPlayerSubmerged;
		for(int i = 0; i < this.nbJoueur; i++) {
			isPlayerSubmerged = true;
			nbCaseAdjaJoueur = 0;
			for(int j = 0; j < this.cases.size(); j++) {
				if(sontAdjacentes(this.joueurs.get(i).pos, this.cases.get(j)) == true && this.cases.get(j).etat != Etat.submerge 
						|| (this.joueurs.get(i).classe == Classe.explorateur && this.sontDiagonales(this.joueurs.get(i).pos, this.cases.get(j)))
						|| this.joueurs.get(i).classe == Classe.plongueur) {
					isPlayerSubmerged = false;
				}
			}
			if(isPlayerSubmerged == true && this.joueurs.get(i).pos.etat == Etat.submerge) {
				System.out.println("player submerged");
				return true;
			}
		}	
		return false;
	}
	
}
