package View;
import java.lang.Object;
import javax.swing.*;

import Controller.MyKeyListener;
import Controller.MyMouseListener;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;

import Model.*;

public class Main {
	
	public static void main(String[] args) {
		JFrame cadre = new JFrame("IleDeserte");//on cr�e le cadre de la fenetre
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//on d�finie l'action pour fermer la fen�tre
		Fenetre wd = new Fenetre(new Plateau());//on cr�e l'int�rieur de la fen�tre
		wd.p.linkWindow(wd);//on lie la fenetre au plateau
		JTextField component = new JTextField();//permet d'ajouter le KeyListener
	    wd.addMouseListener(new MyMouseListener(wd));//on ajoute le MouseListener
	    component.addKeyListener(new MyKeyListener(wd));//on ajoute le KeyListener
	    cadre.add(component);//on ajoute les components au cadre
		cadre.add(wd);//on assemble la fen�tre
		cadre.setSize(wd.wdWidth,wd.wdHeight+wd.basHeight);//on d�finie les dimensions du cadre
		cadre.setVisible(true);//on affiche la fen�tre
		wd.p.setupMenuJoueur();//on cr�e ce qu'il faut pour le premier menu
		while(wd.p.eP == EtatPlateau.MenuSelectionNbJoueur) {//permet d'avoir la fen�tre � jour en continue
			wd.repaint();//met a jour les composants graphiques
		}
		wd.p.setupMenuClasse();//on cr�e les boutons du menu de selection des classes
		while(wd.p.eP == EtatPlateau.MenuSelectionClasse) {//permet d'avoir la fen�tre � jour en continue
			wd.repaint();//met a jour les composants graphiques
		}
		wd.p.setupPlateau();//on cr�er les cases/joueurs/boutons
		while(wd.p.eP == EtatPlateau.Jeu) {//permet d'avoir la fen�tre � jour en continue
			wd.repaint();//met a jour les composants graphiques
			if(wd.p.win() == true) {
				wd.p.eP = EtatPlateau.MenudeFinGagnant;//si on a gagn� on modifie l'�tat du jeu
			}else if(wd.p.lose() == true) {
				wd.p.eP = EtatPlateau.MenudeFinPerdant;//si on a perdue on modifie l'�tat du jeu
			}
		}
		while(wd.p.eP == EtatPlateau.MenudeFinGagnant) {
			wd.repaint();//met a jour les composants graphiques
		}
		while(wd.p.eP == EtatPlateau.MenudeFinPerdant) {
			wd.repaint();//met a jour les composants graphiques
		}
	}
	
}
