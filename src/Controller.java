 import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.IOException;



public class Controller {
	AffichagePlateau plateau;
	Plateau p; 
	Timer sablier;
	Pane root;
	GameMenu menu;
	MenuInGame menuJeu;
	String selectionRobot;
	Text titre;
	Button gagner;
	Text t1;
	Text t2;
	Text fin;
	Text aideTexte;
	Button finir;
	Button backMenu;
	Button aide;
	ImageView img;
	
		Controller(Plateau p,Timer sablier,Pane root,AffichagePlateau plateau,GameMenu menu ,MenuInGame menuJeu,Text t) throws IOException {
			this.menuJeu = menuJeu;
			this.plateau = plateau;
			this.p = p;
			this.sablier = sablier;
			this.root = root;
			this.menu = menu;
			this.titre=t;
			gagner = new Button("Nouveau tour");
			gagner.setTranslateX(10);
		  	gagner.setTranslateY(350);
		  	
		  	finir = new Button("Terminer la partie");
			finir.setTranslateX(10);
		  	finir.setTranslateY(250);
		  	
		  	aide = new Button("Aide");
			aide.setTranslateX(10);
		  	aide.setTranslateY(540);
		  	
		  	aideTexte=TextBuilder.textePoint();
			aideTexte.setTranslateX(5);
		  	aideTexte.setTranslateY(550);
		  	
		  	t1=TextBuilder.objectif();
			t1.setTranslateX(5);
		  	t1.setTranslateY(700);
		  	
		  	t2=TextBuilder.textePoint();
			t2.setTranslateX(5);
		  	t2.setTranslateY(650);
		  	
		  	fin=TextBuilder.fin();
			fin.setTranslateX(100);
		  	fin.setTranslateY(200);

		  	backMenu = new Button("Retour au Menu");
			backMenu.setTranslateX(200);
		  	backMenu.setTranslateY(250);
		  	
		}
		public void controllerMain(){
			
			root.setOnKeyPressed(keyEvent -> {
            	System.out.println(keyEvent.getText());
            	if(keyEvent.getText().equals("&") || keyEvent.getText().equals("1")) {
            	
            		System.out.println("Vous avez sélectionner le robot rouge.");
            		p.selectionRobotCouleur(true,false,false,false);
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		menuJeu.getSelection().setText("Vous avez sélectionner le robot Rouge");
        			
            	}
            	if(keyEvent.getText().equals("é") || keyEvent.getText().equals("2")) {
            		System.out.println("Vous avez sélectionné le robot bleu.");
            		p.selectionRobotCouleur(false,false,true,false);
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		menuJeu.getSelection().setText("Vous avez sélectionné le robot Bleu");
            	}
            	if(keyEvent.getText().equals("" + '"') || keyEvent.getText().equals("3")) {
            		System.out.println("vous avez sélectionner le robot vert.");
            		p.selectionRobotCouleur(false,true,false,false);
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		menuJeu.getSelection().setText("Vous avez sélectionné le robot Vert");
            	}
            	if(keyEvent.getText().equals("'") || keyEvent.getText().equals("4")) {
            		System.out.println("Vous avez sélectionner le robot jaune.");
            		p.selectionRobotCouleur(false,false,false,true);
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		menuJeu.getSelection().setText("Vous avez sélectionné le robot Jaune");
            	}
            	if(keyEvent.getText().equals("z") || keyEvent.getText().equals("Z") ) {
            		System.out.println("je me déplace vers le haut");
					//plateau.getPlateau().deplacementHaut();
            	    p.deplacementr(p.getSelection(),plateau,"H");
            	    try {
						this.afficherGagner();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
            	if(keyEvent.getText().equals("s") || keyEvent.getText().equals("S")) {
            		System.out.println("je me déplace vers le bas");
						//plateau.getPlateau().deplacementBas();
            		 p.deplacementr(p.getSelection(),plateau,"B");
            		 try {
 						this.afficherGagner();
 					} catch (IOException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
				}
            	if(keyEvent.getText().equals("d") || keyEvent.getText().equals("D")) {
            		System.out.println("je me déplace vers la droite");
						//plateau.getPlateau().deplacementdroite();
            		 p.deplacementr(p.getSelection(),plateau,"D");
            		 try {
 						this.afficherGagner();
 					} catch (IOException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
				}
            	if(keyEvent.getText().equals("q") || keyEvent.getText().equals("Q")) {
            		System.out.println("je me déplace vers la gauche");
						//plateau.getPlateau().deplacementgauche();
            		 p.deplacementr(p.getSelection(),plateau,"G");
            		 
            		 try {
						this.afficherGagner();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
            	
            });
			menu.getStart().setOnMouseClicked(event ->{
				titre.setTranslateX(800);
				menuJeu.setVisible(true);
				plateau.setVisible(true);
				menu.setVisible(false);
				
	  		});
			menuJeu.getSSablier().setOnMouseClicked(event ->{
	  			sablier.startTimer();
	  			long seconds = sablier.checkTimer();
	  				System.out.println(seconds);
	  		});
	  		menuJeu.getFSablier().setOnMouseClicked(event ->{
		  			sablier.checkTimer();
		  		});
	  		menuJeu.getDebutPartie().setOnMouseClicked(event ->{
	  			menuJeu.getDebutPartie().setDisable(true);
  			root.getChildren().addAll(finir,aide);
	  			p.setCompteurPoint(0);
	  			
	  			try {
	  				img=afficherObjectif();
	  				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	  		});
	  		
	  		menuJeu.getRetry().setOnMouseClicked(event ->{
	  			retry();
	  		});
	  		
	  		gagner.setOnMouseClicked(event ->{
	  			root.getChildren().removeAll(img,aide,aideTexte);
	  			gagner.setDisable(true);
	  			if(p.getCase(p.getSelection().getCoordonneeX(),p.getSelection().getCoordonneeY()).equals(p.getObjectif())){
	  				if(p.getCompteurPoint()>0){
	  					root.getChildren().remove(t2);
	  				}
	  				p.setCompteurPoint(p.getCompteurPoint()+1);
	  				t2.setText("Vous avez actuellement "+p.getCompteurPoint()+" points");
	  				root.getChildren().addAll(t2,aide);
	  				}
	  			
	  			retry();
	  			root.getChildren().removeAll(t1,gagner);
	  			p.setCaseObj();
	  			try {
	  				img=afficherObjectif();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	  			
	  			
	  		});
	  		
	  		finir.setOnMouseClicked(event ->{
	  		
	  			if(p.getCase(p.getSelection().getCoordonneeX(),p.getSelection().getCoordonneeY()).equals(p.getObjectif())){
	  				p.setCompteurPoint(p.getCompteurPoint()+1);
	  				p.setCaseObj();
	  			}
	  			retry();
	  			menuJeu.setVisible(false);
				plateau.setVisible(false);
				titre.setTranslateX(150);
				titre.setText("Fin de partie");
				root.getChildren().removeAll(img,finir,gagner,t1,t2,aide,aideTexte);
				fin.setText("Vous avez terminé la partie avec "+p.getCompteurPoint()+" points");
				root.getChildren().addAll(fin,backMenu);
				
	  		});
	  		
	  		backMenu.setOnMouseClicked(event ->{
			
	
	  			root.getChildren().removeAll(fin,backMenu);
	  			
	  			titre.setText("Ricochet Robots");
				menu.setVisible(true);
				menuJeu.getDebutPartie().setDisable(false);
			    
	  		});
	  		
	  		aide.setOnMouseClicked(event ->{
				
	  			retry();
	  			root.getChildren().remove(aide);
	  			Robot r=p.getChemin();
	  			if(r!=null){
	  				int a=p.calculChemin(r);
	  				aideTexte.setText("Le robot "+r.getVraieCouleur()+" en "+a+" mouvements");
	  				
	  			}
	  			else{
	  				aideTexte.setText("Aucune aide disponible");
	  				
	  			}
	  			root.getChildren().add(aideTexte);
			    
	  		});
	  	
		}
		
	    public ImageView afficherObjectif() throws IOException {
	         	Case obj=p.getObjectif();
  		    	String cible=obj.MaCible();
  		 
				ImageView imgC = ImageBuilder.imageCible(cible);
				imgC.setFitHeight(40);//hauteur
				imgC.setFitWidth(60);//largeur
				imgC.setTranslateX(100); //800
				imgC.setTranslateY(400);
				this.root.getChildren().addAll(imgC);
				return imgC;
			
  			}
		
  			
	    
	  		
		
		public void afficherGagner() throws IOException{
			if(p.getCase(p.getSelection().getCoordonneeX(),p.getSelection().getCoordonneeY()).equals(p.getObjectif())){
				gagner.setDisable(false);
			  	root.getChildren().addAll(t1,gagner);
			  	
			}

			menuJeu.getDeplacement().setText(""+p.getNbDeplacement());
		}
		
		public void retry(){
			plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).retirerrobot();
  			plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).retirerrobot();
  			plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).retirerrobot();
  			plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).retirerrobot();
  			
  			p.setNbDeplacement(0);
  			menuJeu.getDeplacement().setText(""+0);
  			p.remiseRobot();
  			
  			plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).ajoutRobot(p.getRouge());
  			plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).ajoutRobot(p.getBleu());
  			plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).ajoutRobot(p.getVert());
  			plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).ajoutRobot(p.getJaune());
		}
}
