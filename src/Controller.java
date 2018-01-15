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
		  	
		  	
		  	t1=TextBuilder.objectif();
			t1.setTranslateX(5);
		  	t1.setTranslateY(200);
		  	t2=TextBuilder.textePoint();
			t2.setTranslateX(5);
		  	t2.setTranslateY(650);

		  	
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
	  			menuJeu.getDebutPartie().getText().setText("Partie en cours");
	  			retry();
	  			
	  			try {
					afficherObjectif();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	  			
	  			
	  		});
	  		
	  		menuJeu.getRetry().setOnMouseClicked(event ->{
	  			retry();
	  		});
	  		
	  		gagner.setOnMouseClicked(event ->{
	  			gagner.setDisable(true);
	  			if(p.getCase(p.getSelection().getCoordonneeX(),p.getSelection().getCoordonneeY()).equals(p.getObjectif())){
	  				if(p.getCompteurPoint()>0){
	  					root.getChildren().remove(t2);
	  				}
	  				p.setCompteurPoint(p.getCompteurPoint()+1);
	  				t2.setText("Vous avez actuellement "+p.getCompteurPoint()+" points");
	  				root.getChildren().addAll(t2);
	  				}
	  			
	  			retry();
	  			root.getChildren().removeAll(t1,gagner);
	  			p.setCaseObj();
	  			try {
	  				afficherObjectif();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	  			
	  			
	  		});
		}
	  	
	    public void afficherObjectif() throws IOException{
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
