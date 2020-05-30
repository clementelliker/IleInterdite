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
		JFrame cadre = new JFrame("IleDeserte");//on créer le cadre de la fenetre
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//on définie l'action pour fermer la fenêtre
		Fenetre wd = new Fenetre(new Plateau());//on créer l'intérieur de la fenêtre
		wd.p.linkWindow(wd);//on lie la fenetre au plateau
		JTextField component = new JTextField();//permet d'ajouter le KeyListener
	    wd.addMouseListener(new MyMouseListener(wd));//on ajoute le MouseListener
	    component.addKeyListener(new MyKeyListener(wd));//on ajoute le KeyListener
	    cadre.add(component);//on ajoute les components au cadre
		cadre.add(wd);//on assemble la fenêtre
		cadre.setSize(wd.wdWidth,wd.wdHeight+wd.basHeight);//on définie les dimensions du cadre
		cadre.setVisible(true);//on affiche la fenêtre
		wd.p.setupMenu();//on créer ce qu'il faut pour le premier menu
		while(wd.p.eP == EtatPlateau.MenuSelectionNbJoueur) {//permet d'avoir la fenêtre à jour en continue
			wd.repaint();//met a jour les composants graphiques
		}
		wd.p.setupPlateau();//on créer les cases/joueurs/boutons
		while(wd.p.eP == EtatPlateau.Jeu) {//permet d'avoir la fenêtre à jour en continue
			wd.repaint();//met a jour les composants graphiques
			if(wd.p.win() == true) {
				wd.p.eP = EtatPlateau.MenudeFinGagnant;//si on a gagné on modifie l'état du jeu
			}else if(wd.p.lose() == true) {
				wd.p.eP = EtatPlateau.MenudeFinPerdant;
			}
		}
		while(wd.p.eP == EtatPlateau.MenudeFinGagnant) {
			wd.repaint();//met a jour les composants graphiques
		}
		while(wd.p.eP == EtatPlateau.MenudeFinPerdant) {
			wd.repaint();//met a jour les composants graphiques
			//test
		}
	}
	
}
