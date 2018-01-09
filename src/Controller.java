 import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Controller {
	AffichagePlateau plateau;
	Plateau p; 
	Timer sablier;
	Pane root;
	GameMenu menu;
	MenuInGame menuJeu;
	String selectionRobot;
		Controller(Plateau p,Timer sablier,Pane root,AffichagePlateau plateau,GameMenu menu ,MenuInGame menuJeu ) {
			this.menuJeu = menuJeu;
			this.plateau = plateau;
			this.p = p;
			this.sablier = sablier;
			this.root = root;
			this.menu = menu;
			
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
				}
            	if(keyEvent.getText().equals("s")) {
            		System.out.println("je me déplace vers le bas");
						//plateau.getPlateau().deplacementBas();
            		 p.deplacementr(p.getSelection(),plateau,"B");
				}
            	if(keyEvent.getText().equals("d")) {
            		System.out.println("je me déplace vers la droite");
						//plateau.getPlateau().deplacementdroite();
            		 p.deplacementr(p.getSelection(),plateau,"D");
				}
            	if(keyEvent.getText().equals("q")) {
            		System.out.println("je me déplace vers la gauche");
						//plateau.getPlateau().deplacementgauche();
            		 p.deplacementr(p.getSelection(),plateau,"G");
				}
            	
            });
			menu.getStart().setOnMouseClicked(event ->{
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
	  		
		}
}
