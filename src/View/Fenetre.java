package View;

import java.lang.Object;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import Model.*;

public class Fenetre extends JPanel{
	
	//met en place les constants que l'on peut modifier pour changer les dimensions de la fenêtre
	public final int wdWidth = 720;
	public final int wdHeight = 720;
	public final int basHeight = 120;
	
	//créer les couleurs que l'on va utiliser
	Color mer = new Color(102,255,230);
	Color jungle = new Color(30,179,0);
	Color plage = new Color(255,255,102);
	Color noir = new Color(0,0,0);
	Color blanc = new Color(255,255,255);
	Color jauneF = new Color(230,230,0);
	Color jauneC = new Color(255,255,0);
	Color rougeF = new Color(230,0,0);
	Color rougeC = new Color(255,0,0);
	Color bleuF = new Color(0,42,255);
	Color bleuC = new Color(25,64,255);
	Color vertF = new Color(0,230,0);
	Color vertC = new Color(0,255,0);
	Color brunC = new Color(179,119,0);
	Color orange = new Color(255,213,22);
	Color heliport = new Color(151,151,151);
	Color arteEau = new Color(14,135,165);
	Color arteFeu = new Color(253,114,18);
	Color arteAir = new Color(248,255,200);
	Color arteTerre = new Color(147,90,53);
	
	//sert a linker la fenêtre au plateau
	public Plateau p;
	
	public Fenetre(Plateau p) {
		/*
		 * Construit une instant de plateau
		 * @args: -p: le plateau linké à la fenêtre
		 */
		this.p = p;
	}
	
	public void paintComponent(Graphics g) {
		/*
		 * S'occupe d'afficher les pixels sur la fenêtre
		 * @args: -g: l'interface graphique
		 */
		super.paintComponent(g); //permet de faire les modifications de base de paintComponent de Jpanel
		//en fonction du Menu dans lequel on est on choisit la bonne fontion
		if(this.p.eP == EtatPlateau.MenuSelectionNbJoueur) {
			this.paintMenuSelectionNbJoueur(g);
		}else if(this.p.eP == EtatPlateau.Jeu) {
			this.paintMenuJeu(g);
		}else if(this.p.eP == EtatPlateau.MenudeFinGagnant) {
			this.paintMenudeFinGagnant(g);
		}else if(this.p.eP == EtatPlateau.MenudeFinPerdant) {
			this.paintMenuFinPerdant(g);
		}else if(this.p.eP == EtatPlateau.MenuSelectionClasse) {
			this.paintMenuSelectionClasse(g);
		}
		
	}

	private void drawInvJoueur(Graphics g, int numJoueur, int x, int y) {
		/*
		 * Dessine l'inventaire d'un joueur
		 * @ args: -g: l'interface graphique
		 *         -numJoueur: le numéro du joueur en question
		 *         -x: la position sur l'axe des x
		 *         -y: la position sur l'axe des y
		 */
		int nbDrawed = 0;
		for(int i = 0; i < 4; i++) {
			if(this.p.joueurs.get(numJoueur).clef.get(i) != 0) {
				drawClef(g, x, y, i, nbDrawed, this.p.joueurs.get(numJoueur).clef.get(i));
				nbDrawed++;
			}
		}
	}
	
	private void drawClef(Graphics g, int x, int y, int numCle, int nbDrawed, int amountCle) {
		/*
		 * Dessine une clé
		 * @ args: -g: l'interface graphique
		 * 		-x: la position sur l'axe des x
		 *      -y: la position sur l'axe des y
		 *      -numCle: l'indice de la clé que l'on va dessiner
		 *      -nbDrawed: combien de clé ont déjà été dessinée
		 *      -amountCle: combien de clé de ce type on possède
		 */
		if(numCle == 0) {//clé eau
			g.setColor(arteEau);
			g.fillRect(x + this.wdWidth*1/16 + this.wdWidth*nbDrawed/32, y + this.basHeight/24, this.wdWidth*1/64, this.wdHeight*1/24);
			g.setColor(noir);
			g.drawString(Integer.toString(amountCle), x + this.wdWidth*1/16 + this.wdWidth*nbDrawed/32, y + this.basHeight/4);
		}else if(numCle == 1) {//clé feu
			g.setColor(arteFeu);
			g.fillRect(x + this.wdWidth*1/16 + this.wdWidth*nbDrawed/32, y + this.basHeight/24, this.wdWidth*1/64, this.wdHeight*1/24);
			g.setColor(noir);
			g.drawString(Integer.toString(amountCle), x + this.wdWidth*1/16 + this.wdWidth*nbDrawed/32, y + this.basHeight/4);
		}else if(numCle == 2) {//clé air
			g.setColor(arteAir);
			g.fillRect(x + this.wdWidth*1/16 + this.wdWidth*nbDrawed/32, y + this.basHeight/24, this.wdWidth*1/64, this.wdHeight*1/24);
			g.setColor(noir);
			g.drawString(Integer.toString(amountCle), x + this.wdWidth*1/16 + this.wdWidth*nbDrawed/32, y + this.basHeight/4);
		}else if(numCle == 3) {//clé terre
			g.setColor(arteTerre);
			g.fillRect(x + this.wdWidth*1/16 + this.wdWidth*nbDrawed/32, y + this.basHeight/24, this.wdWidth*1/64, this.wdHeight*1/24);
			g.setColor(noir);
			g.drawString(Integer.toString(amountCle), x + this.wdWidth*1/16 + this.wdWidth*nbDrawed/32, y + this.basHeight/4);
		}
	}
	
	private void drawJTourActuel(Graphics g, Joueur j) {
		/*
		 * Affiche le joueur qui est en train de jouer
		 * @args: -g: l'interface graphique
		 * 		  -j: le joueur que l'on va afficher
		 */
		//ici on a une fonction pour chaque joueur, on vérifie donc quel joueur est en train de jouer
		if(j.numJ == 0) {
			drawJ1(g, 90, this.wdHeight + this.basHeight/24);
		}else if(j.numJ == 1) {
			drawJ2(g, 90, this.wdHeight + this.basHeight/24);
		}else if(j.numJ == 2) {
			drawJ3(g, 90, this.wdHeight + this.basHeight/24);
		}else if(j.numJ == 3) {
			drawJ4(g, 90, this.wdHeight + this.basHeight/24);
		}	
	}

	private void drawJ(Graphics g, ArrayList<Joueur> joueurs, int cbJ) {
		/*
		 * Affiche un joueur
		 * @args: -g: l'interface graphique
		 * 		  -joueurs: la liste des joueurs a afficher
		 * 		  -cbJ: le nombre de joueurs a afficher
		 */
		for(int i = 0; i < joueurs.size(); i++) {//pour chauque joueurs
			Joueur j = joueurs.get(i);
			int numJ = j.numJ;//on recupère le numéro du joueur pour afficher la bonne couleurs
			//ici on différencie les cas en fonction du nombre de joueurs a afficher pour ne pas avoir de superposition
			if(cbJ == 1) {//1 joueur a afficher
				//on regarde quel joueur afficher
				drawJ(g, j.pos.x + j.pos.width/3, j.pos.y + j.pos.height/3, numJ);
			}else if(cbJ == 2) {//2 joueurs a afficher
				//on regarde quel joueur afficher en premier
				if(i == 0) {
					drawJ(g, j.pos.x + j.pos.width/12, j.pos.y + j.pos.height/3, numJ);
				//on regarde quel joueur afficher en deuxieme
				}else if(i == 1) {
					drawJ(g, j.pos.x + j.pos.width*7/12, j.pos.y + j.pos.height/3, numJ);
				}
			}else if(cbJ == 3) {//3 joueurs a afficher
				//on regarde quel joueur afficher en premier
				if(i == 0) {
					drawJ(g, j.pos.x + j.pos.width/3, j.pos.y + j.pos.height/12, numJ);
					//on regarde quel joueur afficher en deuxieme
				}else if(i == 1) {
					drawJ(g, j.pos.x + j.pos.width/12, j.pos.y + j.pos.height/2, numJ);
					//on regarde quel joueur afficher en troisieme
				}else if(i == 2) {
					drawJ(g, j.pos.x + j.pos.width*7/12, j.pos.y + j.pos.height/2, numJ);
				}
			}else if(cbJ == 4) {//4 joueurs a afficher
				//on regarde quel joueur afficher en premier
				if(i == 0) {
					drawJ(g, j.pos.x + j.pos.width/12, j.pos.y + j.pos.height/12, numJ);
					//on regarde quel joueur afficher en deuxieme
				}else if(i == 1) {
					drawJ(g, j.pos.x + j.pos.width*7/12, j.pos.y + j.pos.height/12, numJ);
					//on regarde quel joueur afficher en troisieme
				}else if(i == 2) {
					drawJ(g, j.pos.x + j.pos.width/12, j.pos.y + j.pos.height*7/12, numJ);
					//on regarde quel joueur afficher en quatrieme
				}else if(i == 3) {
					drawJ(g, j.pos.x + j.pos.width*7/12, j.pos.y + j.pos.height*7/12, numJ);
				}
			}
		}
		
	}
	
	public void drawJ(Graphics g, int xpos, int ypos, int numJ) {
		/*
		 * Selectionne quelle fonction a appeler en fonction du numéro du joueur
		 * @ args: -g: l'interface graphique
		 * 		   -xpos: position sur l'axe des x
		 * 		   -ypos: position sur l'axe des y
		 * 		   -numJ: numero du joueur a afficher
		 */
		if(numJ == 0) {
			drawJ1(g, xpos, ypos);
		}else if(numJ == 1) {
			drawJ2(g, xpos, ypos);
		}else if(numJ == 2) {
			drawJ3(g, xpos, ypos);
		}else if(numJ == 3) {
			drawJ4(g, xpos, ypos);
		}
	}

	public void drawJ1(Graphics g, int xpos, int ypos) {
		/*
		 * Affiche le joueur jaune
		 * @args: -g: l'interface graphique
		 * 		  -xpox, ypos: les coordonnees de la position où on va afficher le joueur
		 */
		Joueur j = this.p.joueurs.get(0);
		g.setColor(noir);
		g.fillOval(xpos, ypos + j.pos.height/12, j.pos.width/3, j.pos.height/6);//on affiche le corp 
		g.setColor(jauneF);
		g.fillOval(xpos + j.pos.width/24, ypos + j.pos.width/24, j.pos.width/4, j.pos.height/4);//on affiche la partie sombre du chapeau
		g.setColor(jauneC);
		g.fillOval(xpos + j.pos.height/12, ypos + j.pos.height/12, j.pos.width/6, j.pos.height/6);//on affiche la partie claire du chapeau
	}
	
	public void drawJ2(Graphics g, int xpos, int ypos) {
		/*
		 * Affiche le joueur rouge
		 * @args: -g: l'interface graphique
		 * 		  -xpox, ypos: les coordonnees de la position où on va afficher le joueur
		 */
		Joueur j = this.p.joueurs.get(1);
		g.setColor(noir);
		g.fillOval(xpos, ypos + j.pos.height/12, j.pos.width/3, j.pos.height/6);//on affiche le corp 
		g.setColor(rougeF);
		g.fillOval(xpos + j.pos.width/24, ypos + j.pos.width/24, j.pos.width/4, j.pos.height/4);//on affiche la partie sombre du chapeau
		g.setColor(rougeC);
		g.fillOval(xpos + j.pos.height/12, ypos + j.pos.height/12, j.pos.width/6, j.pos.height/6);//on affiche la partie claire du chapeau
	}
	
	public void drawJ3(Graphics g, int xpos, int ypos) {
		/*
		 * Affiche le joueur bleu
		 * @args: -g: l'interface graphique
		 * 		  -xpox, ypos: les coordonnees de la position où on va afficher le joueur
		 */
		Joueur j = this.p.joueurs.get(2);
		g.setColor(noir);
		g.fillOval(xpos, ypos + j.pos.height/12, j.pos.width/3, j.pos.height/6);//on affiche le corp 
		g.setColor(bleuF);
		g.fillOval(xpos + j.pos.width/24, ypos + j.pos.width/24, j.pos.width/4, j.pos.height/4);//on affiche la partie sombre du chapeau
		g.setColor(bleuC);
		g.fillOval(xpos + j.pos.height/12, ypos + j.pos.height/12, j.pos.width/6, j.pos.height/6);//on affiche la partie claire du chapeau
	}
	
	public void drawJ4(Graphics g, int xpos, int ypos) {
		/*
		 * Affiche le joueur vert
		 * @args: -g: l'interface graphique
		 * 		  -xpox, ypos: les coordonnees de la position où on va afficher le joueur
		 */
		Joueur j = this.p.joueurs.get(3);
		g.setColor(noir);
		g.fillOval(xpos, ypos + j.pos.height/12, j.pos.width/3, j.pos.height/6);//on affiche le corp 
		g.setColor(vertF);
		g.fillOval(xpos + j.pos.width/24, ypos + j.pos.width/24, j.pos.width/4, j.pos.height/4);//on affiche la partie sombre du chapeau
		g.setColor(vertC);
		g.fillOval(xpos + j.pos.height/12, ypos + j.pos.height/12, j.pos.width/6, j.pos.height/6);//on affiche la partie claire du chapeau
	}
	
	public void paintMenuSelectionNbJoueur(Graphics g) {
		/*
		 * Dessine la fenêtre pour le menu de selection du nombre de joueurs 
		 * @ args: -g: l'interface graphique
		 */
		this.drawBackgroundMenu(g);//on dessine le background
		this.drawIleInterditeLogo(g);//on dessine le logo
		this.drawButtonsMenuSelecJ(g);//on dessine les boutons
	}
	
	public void drawBackgroundMenu(Graphics g) {
		/*
		 * Dessine le background du menu
		 * @ args: -g: l'interface graphique
		 */
		this.drawSeaBackground(g);//on dessine la mer
		g.setColor(plage);//desine la palge en fond
		g.fillRect(this.wdWidth*3/8, this.wdHeight/8, this.wdWidth/4, this.wdHeight*3/4);
		g.fillRect(this.wdWidth/8, this.wdHeight*3/8, this.wdWidth*3/4, this.wdHeight/4);
		g.fillRect(this.wdWidth/4, this.wdHeight/4, this.wdWidth/2, this.wdHeight/2);
		g.setColor(jungle);//on met la jungle par dessus
		g.fillRect(this.wdWidth/4, this.wdHeight*3/8, this.wdWidth/2, this.wdHeight/4);
		g.fillRect(this.wdWidth*3/8, this.wdHeight/4, this.wdWidth/4, this.wdHeight/2);
	}
	
	public void drawIleInterditeLogo(Graphics g) {
		/*
		 * Dessine le logo Ile Interdite
		 * @ args: -g: l'interface graphique
		 */
		g.setColor(orange);//cadre
		g.fillRect(this.wdWidth/32, this.wdHeight/10, this.wdWidth*11/12, this.wdWidth*5/24);
		g.setColor(bleuF);//contour du cadre
		g.drawRect(this.wdWidth/32, this.wdHeight/10, this.wdWidth*11/12, this.wdWidth*5/24);
		g.setColor(noir);
		g.setFont(new Font("title", 5, 100));
		g.drawString("L'île Interdite", this.wdWidth/12, this.wdHeight/4);//on ecrit Ile Interdite
	}
	
	public void drawButtonsMenuSelecJ(Graphics g) {
		/*
		 * Dessine les boutons pour le menu de selection des joueurs
		 * @ args: -g: l'interface graphique
		 */
		g.setFont(new Font("t",5,30));
		for(int i = 0; i < this.p.buttons.size(); i++) {//on dessine les 4 boutons
			g.setColor(this.p.buttons.get(i).c);
			g.fillRect(this.p.buttons.get(i).x, this.p.buttons.get(i).y, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le background du bouton
			g.setColor(noir);
			g.drawRect(this.p.buttons.get(i).x, this.p.buttons.get(i).y, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le contour du bouton
			g.setColor(noir);
			g.drawString(this.p.buttons.get(i).text, this.p.buttons.get(i).x + this.wdWidth/35, this.p.buttons.get(i).y + this.wdHeight/15);//le texte du bouton
		}
	}
	
	public void drawSeaBackground(Graphics g) {
		/*
		 * Dessine la mer en fond
		 * @ args: -g: l'interface graphique
		 */
		g.setColor(mer);//paint le backgroung (la mer)
		g.fillRect(0,0,this.wdWidth,this.wdHeight + this.basHeight);
		
	}
	
	private void paintMenuJeu(Graphics g) {
		/*
		 * Dessine la fênetre du menu de jeu
		 * @ args: -g: l'interface graphique
		 */
		this.drawSeaBackground(g);//on dessine le background
		this.drawCases(g);//on dessine les cases
		Bouton buttonSelected = this.drawButtonsJeu(g);//on dessine les boutons
		this.drawKeyGiver(g);//on dessine les cases des joueurs pour donners les clés ou le pouvoir du navigateur
		this.drawSelectedButtonRed(g, buttonSelected);//on fait le contour en rouge si on a un bouton selectionner
		this.drawUsedSDSorH(g);//on barre les boutons SDS ou H si ils sont déjà utilisé ce tour
		this.drawBottomJeu(g);//on dessine la partie du bas
		this.drawTopRightJeu(g);//on dessine la partie en haut a droite
	}
	
	public void drawCases(Graphics g) {
		/*
		 * Dessine les cases du jeu
		 * @ args: -g: l'interface graphique
		 */
		for(int i = 0; i < this.p.cases.size(); i++) {//on parcours toutes les cases
			if(this.p.cases.get(i).type != caseType.heliport) {//on regarde si c'est l'heliport
				if(i < 3 || i == 5 || i == 6 || i == 11 || i == 12 || i == 17 || i == 18 || i > 20){//seulement les cases au bord de la mer
					switch(this.p.cases.get(i).etat) {//on différencie les cas pour afficher la case en fonction de son état
					case normale: 
						g.setColor(plage);
						g.fillRect(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
							break;
					case innonde:
						g.setColor(plage);
						g.fillRect(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
						g.setColor(mer);
						g.fillOval(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
							break;
					case submerge:
						break;
					}
				}else {//on paint les cases jungle
					switch(this.p.cases.get(i).etat) {//on différencie les cas pour afficher la case en fonction de son état
					case normale: 
						g.setColor(jungle);
						g.fillRect(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
							break;
					case innonde:
						g.setColor(jungle);
						g.fillRect(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
						g.setColor(mer);
						g.fillOval(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
							break;
					case submerge:
						break;
					}
				}
				
			}else if(this.p.cases.get(i).type == caseType.heliport) {//dans le cas où c'est l'héliport
				switch(this.p.cases.get(i).etat) {//on différencie les cas pour afficher la case en fonction de son état
				case normale: 
					g.setColor(heliport);
					g.fillRect(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
					g.setColor(blanc);
					g.fillOval(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
					g.setColor(heliport);
					g.fillOval(this.p.cases.get(i).x + this.p.cases.get(i).width/16, this.p.cases.get(i).y + this.p.cases.get(i).height/16, this.p.cases.get(i).width*7/8, this.p.cases.get(i).height*7/8);
					g.setColor(blanc);
					g.fillRect(this.p.cases.get(i).x + this.p.cases.get(i).width/4, this.p.cases.get(i).y + this.p.cases.get(i).height/4, this.p.cases.get(i).width/8, this.p.cases.get(i).height/2);
					g.fillRect(this.p.cases.get(i).x + this.p.cases.get(i).width*5/8, this.p.cases.get(i).y + this.p.cases.get(i).height/4, this.p.cases.get(i).width/8, this.p.cases.get(i).height/2);
					g.fillRect(this.p.cases.get(i).x + this.p.cases.get(i).width*3/8, this.p.cases.get(i).y + this.p.cases.get(i).height*7/16, this.p.cases.get(i).width/4, this.p.cases.get(i).height/8);
						break;
				case innonde:
					g.setColor(heliport);
					g.fillRect(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
					g.setColor(mer);
					g.fillOval(this.p.cases.get(i).x, this.p.cases.get(i).y, this.p.cases.get(i).width, this.p.cases.get(i).height);
						break;
				case submerge:
					break;
				}
			}
			if(this.p.cases.get(i).etat != Etat.submerge) {//on dessine les artefacts si la case est non submergée
				if(this.p.cases.get(i).type == caseType.eau) {
					g.setColor(arteEau);
					g.fillOval(this.p.cases.get(i).x + this.p.cases.get(i).width/4, this.p.cases.get(i).y + this.p.cases.get(i).height/4, this.p.cases.get(i).width/2, this.p.cases.get(i).height/2);
				}else if(this.p.cases.get(i).type == caseType.feu) {
					g.setColor(arteFeu);
					g.fillOval(this.p.cases.get(i).x + this.p.cases.get(i).width/4, this.p.cases.get(i).y + this.p.cases.get(i).height/4, this.p.cases.get(i).width/2, this.p.cases.get(i).height/2);
				}else if(this.p.cases.get(i).type == caseType.air) {
					g.setColor(arteAir);
					g.fillOval(this.p.cases.get(i).x + this.p.cases.get(i).width/4, this.p.cases.get(i).y + this.p.cases.get(i).height/4, this.p.cases.get(i).width/2, this.p.cases.get(i).height/2);
				}else if(this.p.cases.get(i).type == caseType.terre) {
					g.setColor(arteTerre);
					g.fillOval(this.p.cases.get(i).x + this.p.cases.get(i).width/4, this.p.cases.get(i).y + this.p.cases.get(i).height/4, this.p.cases.get(i).width/2, this.p.cases.get(i).height/2);
				}
			}
			drawJ(g, this.p.cases.get(i).j, this.p.cases.get(i).j.size());//on affiche les joueurs étant sur la case
		}
	}
	public Bouton drawButtonsJeu(Graphics g) {
		/*
		 * Dessine les boutons pour le menu de jeu
		 * @ args: -g: l'interface graphique
		 */
		Bouton buttonSelected = new Bouton();
		for(int i = 0; i < this.p.buttons.size()-this.p.nbJoueur; i++) {//on affiche les bouttons
			g.setColor(this.p.buttons.get(i).c);
			g.fillRect(this.p.buttons.get(i).x, this.p.buttons.get(i).y, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le fond du bouton
			g.setColor(Color.BLACK);
			if((i == 1 && this.p.selectedSDS == true) || (i == 2 && this.p.selectedH == true) || (i == 3 && this.p.selectedA == true) || (i == 4 && this.p.selectedE == true)
					|| (i == 5 && this.p.selectedF == true) || (i == 6 && this.p.selectedT == true)) {//on  regarde si on a selectionner un des boutons de gauche
				buttonSelected = this.p.buttons.get(i);//on recupére le bouton sélectionné si il existe
			}
			g.drawRect(this.p.buttons.get(i).x, this.p.buttons.get(i).y, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le contour du bouton
			g.setFont(new Font("b", 5, 20));
			g.drawString(this.p.buttons.get(i).text, this.p.buttons.get(i).x+ this.p.buttons.get(i).width/12, (int)(this.p.buttons.get(i).y + this.p.buttons.get(i).width/3.1));//le texte du bouton
			if(i == 1) {//sac de sable
				g.setFont(new Font("b", 5, 50));
				g.drawString(Integer.toString(this.p.joueurs.get(this.p.tourJ%this.p.nbJoueur).nbSacDeSable), this.p.buttons.get(i).x+ this.p.buttons.get(i).width*3/12, (int)(this.p.buttons.get(i).y + this.p.buttons.get(i).width*10/12));
			}else if(i == 2) {//helico
				g.setFont(new Font("b", 5, 50));
				g.drawString(Integer.toString(this.p.joueurs.get(this.p.tourJ%this.p.nbJoueur).nbHelico), this.p.buttons.get(i).x+ this.p.buttons.get(i).width*3/12, (int)(this.p.buttons.get(i).y + this.p.buttons.get(i).width*10/12));
			}
		}
		return buttonSelected;
	}
	
	public void drawKeyGiver(Graphics g) {
		/*
		 * Dessine les cases des joueurs pour des une clé ou si c'est le navigateur dessine les cases pour deplacer les joueurs
		 * @ args: -g: l'interface graphique
		 */
		if(this.p.joueurs.size() != 0) {//bug fix
			if(this.p.selectedA == true || this.p.selectedE == true || this.p.selectedF == true || this.p.selectedT == true ) {//on affiche les couleurs des joueurs si on a appuyer sur le bouton pour dooner une clé
				for(int j = 0; j < this.p.nbJoueur; j++) {//on dessines les cases des joueurs présents
					int i = j+7;
					g.setColor(this.p.buttons.get(i).c);
					g.fillRect(this.p.buttons.get(i).x, this.p.buttons.get(i).y, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le fond du bouton
					g.setColor(Color.BLACK);
					g.drawRect(this.p.buttons.get(i).x, this.p.buttons.get(i).y, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le contour du bouton
					g.setFont(new Font("b", 5, 20));
					g.drawString(this.p.buttons.get(i).text, this.p.buttons.get(i).x+ this.p.buttons.get(i).width/12, (int)(this.p.buttons.get(i).y + this.p.buttons.get(i).width/3.1));//le texte du bouton
				}
			}else if(this.p.joueurs.get(this.p.tourJ%this.p.nbJoueur).classe == Classe.navigateur) {//dessine les boutons plus vers le haut si aucune clé n'est séléctionnée
				for(int j = 0; j < this.p.nbJoueur; j++) {
					int i = j+7;
					g.setColor(this.p.buttons.get(i).c);
					g.fillRect(this.p.buttons.get(i).x - this.wdWidth/12, this.p.buttons.get(i).y-this.wdHeight*9/12, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le fond du bouton
					g.setColor(Color.BLACK);
					g.drawRect(this.p.buttons.get(i).x - this.wdWidth/12, this.p.buttons.get(i).y-this.wdHeight*9/12, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le contour du bouton
					g.setFont(new Font("b", 5, 20));
					g.drawString(this.p.buttons.get(i).text, 0, (int)(this.p.buttons.get(i).y + this.p.buttons.get(i).width/3.1));//le texte du bouton
					if(this.p.navigPlayerSelected.numJ != 99 && this.p.navigPlayerSelected.numJ == i-7) {//fait le contour en rouge de la personne sélectionné
						g.setColor(Color.RED);
						g.drawRect(this.p.buttons.get(i).x - this.wdWidth/12, this.p.buttons.get(i).y-this.wdHeight*9/12, this.p.buttons.get(i).width, this.p.buttons.get(i).height);
					}
				}
			}
		}
	}
	public void drawSelectedButtonRed(Graphics g, Bouton buttonSelected) {
		/*
		 * Dessine le bouton selectionné en rouge
		 * @ args: -g: l'interface graphique
		 * 		-buttonSelected: bouton selectionné
		 */
		g.setColor(Color.RED);
		g.drawRect(buttonSelected.x, buttonSelected.y, buttonSelected.width, buttonSelected.height);
	}
	
	public void drawUsedSDSorH(Graphics g){
		/*
		 * Barre les boutons SDS et H si ils ont été utilisé
		 * @ args: -g: l'interface graphique
		 */
		if(this.p.joueurs.size() != 0) {//permet d'éviter un bug où on rentre ici sans avoir créé de joueurs
			if(this.p.joueurs.get(this.p.tourJ%this.p.nbJoueur).usedSDS == true) {//on regarde si on barre le bouton SDS
				g.setColor(noir);
				g.drawLine(0, this.wdHeight*9/12, this.wdWidth/12, this.wdHeight*5/6);
				g.drawLine(this.wdWidth/12, this.wdHeight*9/12, 0, this.wdHeight*5/6);
			}
			if(this.p.joueurs.get(this.p.tourJ%this.p.nbJoueur).usedH == true) {//on regarde si on barre le bouton H
				g.setColor(noir);
				g.drawLine(0, this.wdHeight*10/12, this.wdWidth/12, this.wdHeight*11/12);
				g.drawLine(this.wdWidth/12, this.wdHeight*10/12, 0, this.wdHeight*11/12);
			}
		}
	}
	
	public void drawBottomJeu(Graphics g) {
		/*
		 * Dessine la partie basse de la fenêtre
		 * @ args: -g: l'interface graphique
		 */
		g.setFont(new Font("b", 5, 20));
		g.setColor(brunC);
		g.fillRect(0, this.wdHeight, this.wdWidth, this.basHeight);
		g.setColor(Color.BLACK);
		g.drawRect(0, this.wdHeight, this.wdWidth, this.basHeight);//on fait le contour
		g.drawString("Tour de:", 10, this.wdHeight + this.basHeight/4);//affiche le texte Tour de:
		if(this.p.joueurs.size() != 0) {//permet d'éviter un bug où on rentre ici sans avoir créé de joueurs
			drawJTourActuel(g, this.p.joueurs.get(this.p.tourJ%this.p.nbJoueur));//affiche l'avatar du joueur qui est entrain de jouer (ce qui n'est pas normal car on rentre dans setupPlateau avant de rentrer ici
			//on dessine les inventaires des personnages		
			for(int i = 0; i < this.p.nbJoueur; i++) {
				if(i == 0) {
					drawJ1(g, this.wdWidth/2, this.wdHeight + this.basHeight/24);
					drawInvJoueur(g, i,this.wdWidth/2, this.wdHeight + this.basHeight/24);
				}else if(i == 1) {
					drawJ2(g, this.wdWidth/2, this.wdHeight + this.basHeight/3);
					drawInvJoueur(g, i,this.wdWidth/2, this.wdHeight + this.basHeight/3);
				}else if(i == 2) {
					drawJ3(g, this.wdWidth*3/4, this.wdHeight + this.basHeight/24);
					drawInvJoueur(g, i,this.wdWidth*3/4, this.wdHeight + this.basHeight/24);
				}else if(i == 3) {
					drawJ4(g, this.wdWidth*3/4, this.wdHeight + this.basHeight/3);
					drawInvJoueur(g, i,this.wdWidth*3/4, this.wdHeight + this.basHeight/3);
				}
			}
		}
		g.setColor(noir);
		g.drawString("Nombre de coups restants: " + this.p.actionRestante, 10, this.wdHeight + this.basHeight/2);//on affiche le nombre de coups restants
		
		//on dessine la séparation du bas
		g.setColor(noir);
		g.fillRect(this.wdWidth*4/9, this.wdHeight, this.wdWidth/256, this.basHeight);
		
	}
	
	public void drawTopRightJeu(Graphics g) {
		/*
		 * Dessine la partie en haut a gauche
		 * @ args: -g: l'interface graphique
		 */
		g.setColor(brunC);
		g.fillRect(this.wdWidth*3/4, 0, this.wdWidth/4, this.wdHeight/12);//interieur du background brun
		g.setColor(noir);
		g.drawRect(this.wdWidth*3/4, 0, this.wdWidth/4, this.wdHeight/12);//contour
		int nbArtDrawed = 0;
		for(int i = 0; i < 4; i++) {//on dessine les artefacts obtenues
			if(this.p.artefactOwned.get(i) == 1) {
				if(i == 0) {
					g.setColor(arteEau);
					g.fillOval(this.wdWidth*3/4 + this.wdWidth*1/128 + this.wdWidth*nbArtDrawed/18, this.wdHeight/48, this.wdWidth/24, this.wdHeight/24);
					nbArtDrawed++;
				}else if(i == 1) {
					g.setColor(arteFeu);
					g.fillOval(this.wdWidth*3/4 + this.wdWidth*1/128 + this.wdWidth*nbArtDrawed/18, this.wdHeight/48, this.wdWidth/24, this.wdHeight/24);
					nbArtDrawed++;
				}else if(i == 2) {
					g.setColor(arteAir);
					g.fillOval(this.wdWidth*3/4 + this.wdWidth*1/128 + this.wdWidth*nbArtDrawed/18, this.wdHeight/48, this.wdWidth/24, this.wdHeight/24);
					nbArtDrawed++;
				}else if(i == 3) {
					g.setColor(arteTerre);
					g.fillOval(this.wdWidth*3/4 + this.wdWidth*1/128 + this.wdWidth*nbArtDrawed/18, this.wdHeight/48, this.wdWidth/24, this.wdHeight/24);
					nbArtDrawed++;
				}
			}
		}
	}
	
	public void paintMenudeFinGagnant(Graphics g) {
		/*
		 * Dessine la fenêtre du menu de fin gagnant
		 * @ args: -g: l'interface graphique
		 */
		this.drawBackgroundMenu(g);//on dessine le background
		this.drawLogoVousAvezGagne(g);//on dessine le logo
	}
	
	public void drawLogoVousAvezGagne(Graphics g) {
		/*
		 * Dessine le logo vous avez gagné
		 * @ args: -g: l'interface graphique
		 */
		g.setColor(orange);//cadre
		g.fillRect(this.wdWidth/32, this.wdHeight/10, this.wdWidth*11/12, this.wdWidth*5/24);
		g.setColor(bleuF);//contour du cadre
		g.drawRect(this.wdWidth/32, this.wdHeight/10, this.wdWidth*11/12, this.wdWidth*5/24);
		g.setColor(noir);
		g.setFont(new Font("win", 5, 60));
		g.drawString("Vous avez gagné", this.wdWidth/6, this.wdHeight*15/64);//texte
	}
	
	public void paintMenuFinPerdant(Graphics g) {
		/*
		 * Dessine la fenêtre du menu de fin perdant
		 * @ args: -g: l'interface graphique
		 */
		this.drawBackgroundMenu(g);//on dessine le background
		this.drawLogoVousAvezPerdue(g);//on dessine le logo
	}
	
	public void drawLogoVousAvezPerdue(Graphics g) {
		/*
		 * Dessine le logo vous avez perdue
		 * @ args: -g: l'interface graphique
		 */
		g.setColor(orange);//cadre
		g.fillRect(this.wdWidth/32, this.wdHeight/10, this.wdWidth*11/12, this.wdWidth*5/24);
		g.setColor(bleuF);//contour du cadre
		g.drawRect(this.wdWidth/32, this.wdHeight/10, this.wdWidth*11/12, this.wdWidth*5/24);
		g.setColor(noir);
		g.setFont(new Font("win", 5, 60));
		g.drawString("Vous avez perdu", this.wdWidth/6, this.wdHeight*15/64);//texte
	}
	
	public void paintMenuSelectionClasse(Graphics g) {
		/*
		 * Dessine la fênetre du menu de selection de classe
		 * @ args: -g: l'interface graphique
		 */
		this.drawBackgroundMenu(g);//on dessine le background
		this.drawLogoSelecClasse(g);//on dessine le logo
		this.drawButtonsSelecClasse(g);//on dessine les boutons
	}
	
	public void drawLogoSelecClasse(Graphics g) {
		/*
		 * Dessine le logo selection de classe
		 * @ args: -g: l'interface graphique
		 */
		g.setColor(orange);//cadre
		g.fillRect(this.wdWidth/32, this.wdHeight/20, this.wdWidth*11/12, this.wdWidth*5/24);
		g.setColor(bleuF);//contour
		g.drawRect(this.wdWidth/32, this.wdHeight/20, this.wdWidth*11/12, this.wdWidth*5/24);
		g.setColor(noir);
		g.setColor(noir);
		g.setFont(new Font("title", 5, 50));
		g.drawString("Sélection de la classe", this.wdWidth/7, this.wdHeight*3/24);//on écrit sélection de la classe
		String str = "de J" + Integer.toString(this.p.selectClasseJ);
		g.drawString(str, this.wdWidth*10/24, this.wdHeight*6/24);//on écrit de J#
	}
	
	public void drawButtonsSelecClasse(Graphics g) {
		/*
		 * Dessine les boutons du menu de selection de classe
		 * @ args: -g: l'interface graphique
		 */
		for(int i = 0; i < 6; i++) {//on dessine les 6 boutons
			g.setColor(this.p.buttons.get(i).c);
			g.fillRect(this.p.buttons.get(i).x, this.p.buttons.get(i).y, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le background du bouton
			g.setColor(noir);
			g.drawRect(this.p.buttons.get(i).x, this.p.buttons.get(i).y, this.p.buttons.get(i).width, this.p.buttons.get(i).height);//le contour du bouton
			g.setColor(noir);
			int tailleText = 0;
			switch(i) {//on choisit la taille du texte en fonction du message (devrait être en attribut de bouton)
			case 0: 
				tailleText = 30;
				break;
			case 1: 
				tailleText = 20;
				break;
			case 2:
				tailleText = 17;
				break;
			case 3: 
				tailleText = 19;
				break;
			case 4: 
				tailleText = 20;
				break;
			case 5: 
				tailleText = 20;
				break;
			}
			g.setFont(new Font("newbutton", 5, tailleText));	
			g.drawString(this.p.buttons.get(i).text, this.p.buttons.get(i).x + this.wdWidth/35, this.p.buttons.get(i).y + this.wdHeight/15);//le texte du bouton
		}
	}
	
}
