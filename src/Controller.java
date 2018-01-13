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
	
		Controller(Plateau p,Timer sablier,Pane root,AffichagePlateau plateau,GameMenu menu ,MenuInGame menuJeu,Text t) {
			this.menuJeu = menuJeu;
			this.plateau = plateau;
			this.p = p;
			this.sablier = sablier;
			this.root = root;
			this.menu = menu;
			this.titre=t;
			
		}
		public void controllerMain(){
			
			root.setOnKeyPressed(keyEvent -> {
            	System.out.println(keyEvent.getText());
            	if(keyEvent.getText().equals("&")) {
            	
            		System.out.println("vous avez sélectionner le robot rouge.");
            		p.selectionRobotCouleur(true,false,false,false);
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		Text robotchoix = TextBuilder.robotChoisi(p.getRouge());
            		robotchoix.setTranslateX(5);
        			robotchoix.setTranslateY(550);
        			this.root.getChildren().addAll(robotchoix);
        			
            	}
            	if(keyEvent.getText().equals("é")) {
            		System.out.println("vous avez sélectionner le robot bleu.");
            		p.selectionRobotCouleur(false,false,true,false);
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		Text robotchoix = TextBuilder.robotChoisi(p.getBleu());
            		robotchoix.setTranslateX(5);
        			robotchoix.setTranslateY(550);
        			this.root.getChildren().addAll(robotchoix);
            	}
            	if(keyEvent.getText().equals("" + '"')) {
            		System.out.println("vous avez sélectionner le robot vert.");
            		p.selectionRobotCouleur(false,true,false,false);
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		Text robotchoix = TextBuilder.robotChoisi(p.getVert());
            		robotchoix.setTranslateX(5);
        			robotchoix.setTranslateY(550);
        			this.root.getChildren().addAll(robotchoix);
            	}
            	if(keyEvent.getText().equals("'")) {
            		System.out.println("vous avez sélectionner le robot jaune.");
            		p.selectionRobotCouleur(false,false,false,true);
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		Text robotchoix = TextBuilder.robotChoisi(p.getJaune());
            		robotchoix.setTranslateX(5);
        			robotchoix.setTranslateY(550);
        			this.root.getChildren().addAll(robotchoix);
            	}
            	if(keyEvent.getText().equals("z")) {
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
            	if(keyEvent.getText().equals("s")) {
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
            	if(keyEvent.getText().equals("d")) {
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
            	if(keyEvent.getText().equals("q")) {
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
	  			menuJeu.getDebutPartie().getText().setText("Partie en cours");
	  			Case obj=p.getObjectif();
	  			String cible=obj.MaCible();
	  			try {
					ImageView imgC = ImageBuilder.imageCible(cible);
					imgC.setFitHeight(40);//hauteur
					imgC.setFitWidth(60);//largeur
					imgC.setTranslateX(100); //800
					imgC.setTranslateY(400);
					this.root.getChildren().addAll(imgC);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  			
	  			
	  		});
	  	
	  		
	  		
		}
		public void afficherGagner() throws IOException{
			if(p.getCase(p.getSelection().getCoordonneeX(),p.getSelection().getCoordonneeY()).equals(p.getObjectif())){
				Text t=TextBuilder.objectif();
				t.setTranslateX(10);
			  	t.setTranslateY(400);
			  	
				Button gagner = new Button("Nouveau tour");
				gagner.setTranslateX(10);
			  	gagner.setTranslateY(350);
			  	root.getChildren().addAll(t,gagner);
			  	
			}
			/*
			Text depl = TextBuilder.deplacement(p.getNbDeplacement());
			depl.setTranslateX(5);
			depl.setTranslateY(300);
			this.root.getChildren().addAll(depl);*/
			menuJeu.getDeplacement().setText(""+p.getNbDeplacement());
		}
}
