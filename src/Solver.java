
public class Solver {
	final static int maxCoups = 20; // si il n'y � pas de solution �vite de boucl� � l'infni
	Plateau plateau;
	Robot[] tabRobots;
	Case[] chemin ;
	Case objectif;
	
	public Solver(Plateau plateau,Robot[] tabRobots,Case[] chemin) {
		this.plateau = plateau;
		this.tabRobots = tabRobots;
		this.chemin = chemin;
	}

}
