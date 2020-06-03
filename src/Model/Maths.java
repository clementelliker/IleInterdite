package Model;
import java.lang.Math.*;

public class Maths {
	
	//contient les formules mathématiques utilisées au cours d'une partie
	
	public static double distance(int x1, int y1, int x2, int y2) {
		/*
		 * Calcule la distance 2D entre 2 points
		 * @ args: x1; y1: coordonnées du 1er point
		 * 		x2, y2: coordonnées du 2ème point
		 */
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

}
