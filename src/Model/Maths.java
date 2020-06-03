package Model;
import java.lang.Math.*;

public class Maths {
	
	//contient les formules math�matiques utilis�es au cours d'une partie
	
	public static double distance(int x1, int y1, int x2, int y2) {
		/*
		 * Calcule la distance 2D entre 2 points
		 * @ args: x1; y1: coordonn�es du 1er point
		 * 		x2, y2: coordonn�es du 2�me point
		 */
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

}
