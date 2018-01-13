import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Plateau {
	private Case[][] plateau;
	private Robot rouge = new Robot(Color.RED);
	private Robot jaune = new Robot(Color.YELLOW);
	private Robot vert = new Robot(Color.GREEN);
	private Robot bleu = new Robot(Color.BLUE);
	private Robot selection= new Robot(Color.WHITE);
	//private String objectif;
	private Case objectif;
	private int nbDeplacement = 1;
	private Color c;

	public Plateau() {
		plateau = new Case[16][16];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				plateau[i][j] = new Case(i,j);
			}
		}
		

		// Création des murs et cibles
		plateau[8][7].casePleine();
		plateau[7][7].casePleine();
		plateau[7][8].casePleine();
		plateau[8][8].casePleine();
		plateau[2][0].setMurdroit(true);
		plateau[9][0].setMurdroit(true);
		plateau[5][1].angleBG();
		plateau[5][1].marqueruneCible("1");
		plateau[12][1].angleHG();
		plateau[12][1].marqueruneCible("2");
		plateau[7][2].angleBD();
		plateau[7][2].marqueruneCible("3");
		plateau[9][3].angleBG();
		plateau[9][3].marqueruneCible("4");
		plateau[3][4].angleBD();
		plateau[3][4].marqueruneCible("5");
		plateau[14][4].angleBD();
		plateau[14][4].marqueruneCible("6");
		plateau[15][2].setMurhaut(true);
		plateau[6][5].angleHG();
		plateau[6][5].marqueruneCible("7");
		plateau[10][5].angleBD();
		plateau[10][5].marqueruneCible("8");
		plateau[0][4].setMurhaut(true);
		plateau[1][6].angleHD();
		plateau[1][6].marqueruneCible("9");
		
		plateau[11][9].angleBG();
		plateau[11][9].marqueruneCible("10");
		plateau[3][10].angleBD();
		plateau[3][10].marqueruneCible("11");
		plateau[0][10].setMurhaut(true);
		plateau[5][11].angleHD();
		plateau[5][11].marqueruneCible("12");
		// System.out.println(""+plateau[11][3].getCible()+"");
		plateau[14][11].angleHD();
		plateau[14][11].marqueruneCible("13");
		// System.out.print(""+plateau[11][14].getCible()+"");
		plateau[2][12].angleBG();
		plateau[2][12].marqueruneCible("14");
		plateau[9][12].angleHG();
		plateau[9][12].marqueruneCible("15");
	
		plateau[15][9].setMurhaut(true);
		plateau[4][13].angleHG();
		plateau[4][13].marqueruneCible("16");
		plateau[12][14].angleBD();
		plateau[12][14].marqueruneCible("17");
		plateau[3][15].setMurdroit(true);
		plateau[13][15].setMurdroit(true);
		
	
		// placement des robots

		plateau[15][0].ajoutRobot(rouge);
		plateau[5][3].ajoutRobot(bleu);
		plateau[0][0].ajoutRobot(jaune);
		plateau[6][12].ajoutRobot(vert);
		
		
		for(int i=0;i<16;i++){  //Limitation Plateau
			plateau[i][0].setMurhaut(true);
			plateau[i][15].setMurbas(true);
			plateau[0][i].setMurgauche(true);
			plateau[15][i].setMurdroit(true);
		}
		
		int lower = 1;
		int higher = 17;
		int random = (int)(Math.random() * (higher-lower)) + lower;
		//this.objectif = ""+random;
		this.objectif = plateau[5][1];
		//System.out.println(this.objectif);

	}
	public void setCaseObj(String s){
		
	}
	public Robot getSelection() {
		return this.selection;
	}
	public void setSelection(Robot r) {
		 this.selection = r;

	}
	public Robot[] getAllRobot() {
		Robot[] tab = new Robot[4];
		tab[0] = this.rouge;
		tab[1] = this.bleu;
		tab[2] = this.vert;
		tab[3] = this.jaune;
		return tab;
	}
	public Case getObjectif() {
		return this.objectif;

	}
	
	public Robot getRouge() {
		return this.rouge;
	}

	public Robot getJaune() {
		return this.jaune;
	}

	public Robot getVert() {
		return this.vert;
	}

	public Robot getBleu() {
		return this.bleu;
	}
    public void selectionRobotCouleur(boolean R,boolean V,boolean B,boolean J) {
    	if(R) {
    		this.selection = this.rouge;
    		this.rouge.setColor(Color.WHITE);
    	}
    	else{
    		this.rouge.setColor(Color.RED);
    		
    	}
    	if(B) {
    		this.selection = this.bleu;
    		this.bleu.setColor(Color.WHITE);
		}
    	else{
    		this.bleu.setColor(Color.BLUE);
    	}
    	if(V) {
    		this.selection = this.vert;
    		this.vert.setColor(Color.WHITE);
    	}
    	else{
    		this.vert.setColor(Color.GREEN);
    	}
    	if(J) {
    		this.selection = this.jaune;
    		this.jaune.setColor(Color.WHITE);
    	}
    	else{
    		this.jaune.setColor(Color.YELLOW);
    	}
    	rouge.setSelection(R);
    	bleu.setSelection(B);
    	vert.setSelection(V);
    	jaune.setSelection(J);
    }
public Case getCase(int i, int j) {
		return plateau[i][j];
	}
public int taillePlateau() {
	return plateau.length;
}

	public int getNbDeplacement() {
		return nbDeplacement;
	}
	public void setNbDeplacement(int nbDeplacement) {
		this.nbDeplacement = nbDeplacement;
	}
	
	
	public Case[] checkMur(Case c) {
		
		
		int coordonneX = c.getCoordonneeX();
		int coordonneY = c.getCoordonneeY();
		Case tabCase[]=new Case[4];
		
		
		if (c.getCoordonneeY() != 0) { //HAUT
				while (!this.getCase(coordonneX,coordonneY).isMurhaut()
						&& !this.getCase(coordonneX,coordonneY - 1 ).isMurbas()
						&& !this.getCase(coordonneX,coordonneY - 1).possedeUnRobot()) {
				
					coordonneY = coordonneY-1;
			
				}
				
			}
			tabCase[0]=this.getCase(coordonneX,coordonneY);
			System.out.println(tabCase[0].getCoordonneeX()+" "+tabCase[0].getCoordonneeY());
			
			coordonneX = c.getCoordonneeX();
			coordonneY = c.getCoordonneeY();
	
		if (c.getCoordonneeX() < this.taillePlateau() - 1) { //DROITE
				
				while (!this.getCase(coordonneX,coordonneY).isMurdroit()
						&& !this.getCase(coordonneX + 1,coordonneY).isMurgauche()
						&& !this.getCase( coordonneX + 1,coordonneY).possedeUnRobot()) {
					
					coordonneX = coordonneX+1;
					
				
				}
				
			}
		  tabCase[1]=this.getCase(coordonneX,coordonneY);
		  System.out.println(tabCase[1].getCoordonneeX()+" "+tabCase[1].getCoordonneeY());
		  coordonneX = c.getCoordonneeX();
		  coordonneY = c.getCoordonneeY();
		  
			if (c.getCoordonneeX() != 0) {//GAUCHE
				
				while (!this.getCase( coordonneX,coordonneY).isMurgauche()
						&& !this.getCase( coordonneX - 1,coordonneY).isMurdroit()
						&& !this.getCase( coordonneX - 1,coordonneY).possedeUnRobot()) {
			
					coordonneX = coordonneX-1;
					
				}
				
			}
			
			
			tabCase[2]=this.getCase(coordonneX,coordonneY);
			System.out.println(tabCase[2].getCoordonneeX()+" "+tabCase[2].getCoordonneeY());
			coordonneX = c.getCoordonneeX();
			coordonneY = c.getCoordonneeY();
		
			if (c.getCoordonneeY() < this.taillePlateau() - 1) { //BAS
				
				while (!this.getCase(coordonneX,coordonneY).isMurbas()
						&& !this.getCase(coordonneX,coordonneY + 1).isMurhaut()
						&& !this.getCase(coordonneX,coordonneY + 1).possedeUnRobot()) {
					
					coordonneY = coordonneY+1;
					
				}
				
			}
			
			
		tabCase[3]=this.getCase(coordonneX,coordonneY);
		System.out.println(tabCase[3].getCoordonneeX()+" "+tabCase[3].getCoordonneeY());
		return tabCase;
	}
	
	public int calculChemin(Robot r) {
		ArrayList<Case> listeV = new ArrayList<Case>(); // à  regarder
		ArrayList<Case> listeR = new ArrayList<Case>(); // déjà  vu
		
		Case courant = this.getCase(r.getCoordonneeX(),r.getCoordonneeY());
		listeV.add(courant);
		courant.retirerrobot();

		while (!(listeV.isEmpty())) {

			// selection du chemin le plus court
			courant = listeV.get(0);
			
			if (courant.equals(this.getObjectif())) {
				return courant.getDistance();
			}
			// stock tout les voisins de x
			Case[] tabc = this.checkMur(courant);
			
			for (int i = 0; i < 4; i++) {
				if (!(listeR.contains(tabc[i])) && !(listeV.contains(tabc[i]))) {
					tabc[i].setDistance(courant.getDistance() + 1);
					listeV.add(tabc[i]);
				}
			}
			// passe x de vert à rouge
			listeR.add(courant);
			listeV.remove(0);
		}
		return 0;
	}
	
	
	public Case deplacementr(Robot r,AffichagePlateau affplateau,String s) {
		
		Case robot=this.getCase(r.getCoordonneeX(),r.getCoordonneeY());
		int coordonneX;
		int coordonneY;
		
		if (s.equals("H")) { //HAUT
			
			if (r.getCoordonneeY() != 0) {
				
				coordonneX = r.getCoordonneeX();
				coordonneY = r.getCoordonneeY();
				while (!this.getCase(coordonneX,coordonneY).isMurhaut()
						&& !this.getCase(coordonneX,coordonneY - 1 ).isMurbas()
						&& !this.getCase(coordonneX,coordonneY - 1).possedeUnRobot()) {
					
					this.getCase(coordonneX,coordonneY).retirerrobot();
					affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
					this.getCase(coordonneX,coordonneY - 1).ajoutRobot(r);
					affplateau.getAffCase(coordonneY-1,coordonneX).colorerCase();
					if (this.getCase(coordonneX,coordonneY - 1).getCible().equals(this.getObjectif())) {

						System.out.println("Vous avez atteint l'objectif avec le robot "+ r.getColor()+ " en "+ this.getNbDeplacement());
						break;
					}
					
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					
				}
				this.setNbDeplacement(this.getNbDeplacement() + 1);
				return this.getCase(coordonneX,coordonneY);
			}
			

		} else if (s.equals("D")) {
			if (r.getCoordonneeX() < this.taillePlateau() - 1) {
				coordonneX = r.getCoordonneeX();
				coordonneY = r.getCoordonneeY();
				while (!this.getCase(coordonneX,coordonneY).isMurdroit()
						&& !this.getCase(coordonneX + 1,coordonneY).isMurgauche()
						&& !this.getCase( coordonneX + 1,coordonneY).possedeUnRobot()) {
					this.getCase(coordonneX,coordonneY).retirerrobot();
					 affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
					this.getCase( coordonneX + 1,coordonneY).ajoutRobot(r);
					 affplateau.getAffCase(coordonneY,coordonneX+1).colorerCase();
					//plateau.getCase(coordonneY,coordonneX+1).colorerCase();
					if (this.getCase( coordonneX + 1,coordonneY).getCible().equals(this.getObjectif())) {

						System.out
								.println("Vous avez atteint l'objectif avec le robot "
										+ r.getColor()
										+ " en "
										+ this.getNbDeplacement());
						break;
					}
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					
				}
				this.setNbDeplacement(this.getNbDeplacement() + 1);
				return this.getCase(coordonneX,coordonneY);
			}
		
		} else if (s.equals("G")) {
			if (r.getCoordonneeX() != 0) {
				coordonneX = r.getCoordonneeX();
				coordonneY = r.getCoordonneeY();
				while (!this.getCase( coordonneX,coordonneY).isMurgauche()
						&& !this.getCase( coordonneX - 1,coordonneY).isMurdroit()
						&& !this.getCase( coordonneX - 1,coordonneY).possedeUnRobot()) {
					this.getCase(coordonneX,coordonneY).retirerrobot();
					affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
					this.getCase( coordonneX - 1,coordonneY).ajoutRobot(r);
					affplateau.getAffCase(coordonneY,coordonneX-1).colorerCase();
					// plateau.getCase(coordonneY,coordonneX-1).colorerCase();
					if (this.getCase(coordonneX - 1,coordonneY).getCible().equals(this.getObjectif())) {

						System.out
								.println("Vous avez atteint l'objectif avec le robot "
										+ r.getColor()
										+ " en "
										+ this.getNbDeplacement());
						break;
					}
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					
				}
				this.setNbDeplacement(this.getNbDeplacement() + 1);
				return this.getCase(coordonneX,coordonneY);
			}
			

		}
		// bas
		else if(s.equals("B")){
			if (r.getCoordonneeY() < this.taillePlateau() - 1) {
				coordonneX = r.getCoordonneeX();
				coordonneY = r.getCoordonneeY();
				while (!this.getCase(coordonneX,coordonneY).isMurbas()
						&& !this.getCase(coordonneX,coordonneY + 1).isMurhaut()
						&& !this.getCase(coordonneX,coordonneY + 1).possedeUnRobot()) {
					 this.getCase(coordonneX,coordonneY).retirerrobot();
					 
					 affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
					this.getCase(coordonneX,coordonneY + 1).ajoutRobot(r);
					 affplateau.getAffCase(coordonneY+1,coordonneX).colorerCase();
					// plateau.getCase(coordonneY-1,coordonneX).colorerCase();
					if (this.getCase(coordonneX,coordonneY +1).getCible().equals(this.getObjectif())) {

						System.out
								.println("Vous avez atteint l'objectif avec le robot "
										+ r.getColor()
										+ " en "
										+ this.getNbDeplacement());
						break;
					}
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					
				}
				this.setNbDeplacement(this.getNbDeplacement() + 1);
				return this.getCase(coordonneX,coordonneY);
			}
		}
		
	return robot;
		
	}
	
}
