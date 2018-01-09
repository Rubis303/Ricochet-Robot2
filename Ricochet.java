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

	public Plateau() {
		plateau = new Case[16][16];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				plateau[i][j] = new Case(i,j);
			}
		}
		

		// Cr�ation des murs et cibles
		plateau[8][7].casePleine();
		plateau[7][7].casePleine();
		plateau[7][8].casePleine();
		plateau[8][8].casePleine();
		plateau[2][0].setMurdroit(true);
		plateau[9][0].setMurdroit(true);
		plateau[12][1].angleHG();
		plateau[12][1].marqueruneCible("1");
		plateau[5][1].angleBG();
		plateau[5][1].marqueruneCible("2");
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

		plateau[0][15].ajoutRobot(rouge);
		plateau[5][3].ajoutRobot(bleu);
		plateau[12][3].ajoutRobot(jaune);
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
		this.objectif = plateau[12][1];
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
    	}
    	if(B) {
    		this.selection = this.bleu;
    	}
    	if(V) {
    		this.selection = this.vert;
    	}
    	if(J) {
    		this.selection = this.jaune;
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
					if (coordonneY == 0) {
						break;
					}
				}
				//p.setNbDeplacement(p.getNbDeplacement() + 1);
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
					
					if (coordonneX == this.taillePlateau() - 1) {

						break;
					}
				}
				//p.setNbDeplacement(p.getNbDeplacement() + 1);
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
					if (coordonneX == 0) {
						break;
					}
				}
				//p.setNbDeplacement(p.getNbDeplacement() + 1);
			}
			
			
			tabCase[2]=this.getCase(coordonneX,coordonneY);
			System.out.println(tabCase[2].getCoordonneeX()+" "+tabCase[2].getCoordonneeY());
			coordonneX = c.getCoordonneeX();
			coordonneY = c.getCoordonneeY();
		
			if (c.getCoordonneeY() < this.taillePlateau() - 1) { //BAS
				
				while (!this.getCase(coordonneX,coordonneY).isMurbas()
						&& !this.getCase(coordonneX,coordonneY + 1).isMurhaut()
						&& !this.getCase(coordonneX,coordonneY + 1).possedeUnRobot()) {
					
					//this.getCase(coordonneX,coordonneY).retirerrobot();
					//this.getCase(coordonneX,coordonneY - 1).ajoutRobot(r);

					coordonneY = coordonneY+1;
					
					if (coordonneY == 0) {
						break;
					}
				}
				
				//p.setNbDeplacement(p.getNbDeplacement() + 1);
			}
			
			
		tabCase[3]=this.getCase(coordonneX,coordonneY);
		System.out.println(tabCase[3].getCoordonneeX()+" "+tabCase[3].getCoordonneeY());
		return tabCase;
	}
	
	public int calculChemin(Robot r) {
		// System.out.println("plateau : " + this.plateau);
		ArrayList<Case> listeV = new ArrayList<Case>(); // à regarder
		ArrayList<Case> listeR = new ArrayList<Case>(); // déjà vu
		// colorer case de départ
		Case a = this.getCase(r.getCoordonneeX(),r.getCoordonneeY());
		listeV.add(a);
		//int indice = 0;
		Case courant = a;

		while (!(listeV.isEmpty())) {
			// System.out.println("liste verte : " + listeV.size() +
			// " listeR : " + listeR.size());

			// selection du chemin le plus court
			courant = listeV.get(0);
			/*for (int i = 1; i < listeV.size(); i++) {
				if (courant.getDistance() > listeV.get(i).getDistance()) {
					courant = listeV.get(i);
					indice = i;
				}
			}*/

			if (courant.equals(this.getObjectif())) {
				return courant.getDistance();
			}
			System.out.println("courant x : " + courant.getCoordonneeX()
					+ "  y : " + courant.getCoordonneeY());
			System.out.println("objectif x : "
					+ this.getObjectif().getCoordonneeX() + "  y : "
					+ this.getObjectif().getCoordonneeY());
			System.out.println("---------------------------------------------");
			// stock tout les voisins de x
			Case[] tabc = this.checkMur(courant);
			for (int i = 0; i < 4; i++) {
				if (!(listeR.contains(tabc[i])) && !(listeV.contains(tabc[i]))) {
					tabc[i].setDistance(courant.getDistance() + 1);
					listeV.add(tabc[i]);
				}
			}
			// passe x de vert à rouge
			listeR.add(courant);
			listeV.remove(0);
		}
		return 0;
	}
	
}
