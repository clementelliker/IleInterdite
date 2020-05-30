package Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import View.Fenetre;

public class MyMouseListener implements MouseListener{
	
	//les fonctions non implémentées ne sont pas commentées
	
	public Fenetre wd;
	
	public MyMouseListener(Fenetre wd) {
		/*
		 * Créer une instance de MyMouseListener
		 * @args: -wd: la fenêtre que l'on va lier
		 */
		super();//on appel le superConstructeur 
		this.wd = wd;//on lie la fenêtre
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		 //!!! à ne pas utiliser car comportement étrange: clique de souris marche pas tt le temps !!!
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/*
		 * Effectue les actions suivants un bouton de souris appuyer
		 *@args: -e: contient toutes les informations concernant le clique de souris
		 */
		Point mousePos = e.getPoint();//on regarde quelle est la position de la souris au moment du clique
		if(e.getButton() == MouseEvent.BUTTON1) {//on regarde si c'est un clique gauche
			this.wd.p.mouse1Clicked(mousePos);//on effectue les actions concernant le clique gauche
		}else if(e.getButton() == MouseEvent.BUTTON3) {//on reagrde si c'est un clique droit
			this.wd.p.mouse2Clicked(mousePos);//on effectue les actions concernant le clique droit
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
