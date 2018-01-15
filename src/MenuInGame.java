import java.io.IOException;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;


public class MenuInGame extends Parent {
	AffichagePlateau plateau ;
	ImageView couleurRobot;
	ButtonInGame play;
	ButtonInGame pause;
	ButtonInGame quitter;
	Button startSablier;
	Button finSablier;
	Button debut;
	Button retry;
	Button nouveau;
	Pane root;
	Plateau p;
	Text deplacement;
	Text robot;
	ChoiceBox<String> boxrobot = new ChoiceBox<>();
		public MenuInGame(AffichagePlateau plateau,Plateau pl) throws IOException {
			Pane root = new Pane();
			//final MediaPlayer mediaPlayer = MediaBuilder.sonJeu();
	  		root.setPrefSize(300,1920);
	  		root.setStyle("-fx-background-color: #808080;");
	  		root.setOpacity(0.6);
	  		this.plateau = plateau;
	  		this.p=pl;
	  		ChoiceBox<String> boxrobot = new ChoiceBox<>();
	  		boxrobot.getItems().add("rouge");
	  		boxrobot.getItems().add("bleu");
	  		boxrobot.getItems().add("vert");
	  		boxrobot.getItems().add("jaune");
	  		VBox box = new VBox(10);
	  		box.setPadding(new Insets(20,20,20,20));
	  		box.getChildren().addAll(boxrobot);
	  		//ImageView imgCible = ImageBuilder.imageCible(this.plateau.getPlateau().getObjectif());
	  		Text cibleT = TextBuilder.menuCible();
	  		Text robotchoix = TextBuilder.robotchoix();
	  		Text texteDeplacement = TextBuilder.texteDeplacement();
	  		texteDeplacement.setTranslateX(5);
			texteDeplacement.setTranslateY(230);
	  		deplacement = TextBuilder.deplacement(p.getNbDeplacement());
			deplacement.setTranslateX(250);
			deplacement.setTranslateY(230);
			
			robot = TextBuilder.robotSelection();
			robot.setTranslateX(5);
			robot.setTranslateY(600);
			//imgCible.setFitHeight(50);
			//imgCible.setFitWidth(50);
	  		pause = new ButtonInGame(ImageBuilder.pause());
	  		pause.setOnMouseClicked(event ->{
		  		//mediaPlayer.setMute(true);
		  		});
			play = new ButtonInGame(ImageBuilder.play());
			play.setOnMouseClicked(event ->{
				//mediaPlayer.play();
			});
			quitter = new ButtonInGame(ImageBuilder.off());
			quitter.setOnMouseClicked(event ->{
				System.exit(0);
			});
			startSablier = new Button("Activer sablier");
		  	finSablier = new Button("Stopper sablier");
		  	debut = new Button("Commencer la partie");
		  	retry = new Button("Réessayer");
		  	//imgCible.setTranslateX(150);
			//imgCible.setTranslateY(390);
			cibleT.setTranslateX(5);
			cibleT.setTranslateY(430);
			robotchoix.setTranslateX(5);
			robotchoix.setTranslateY(470);
			boxrobot.setTranslateX(5);
			boxrobot.setTranslateY(480);
		  	pause.setTranslateX(190);
		  	pause.setTranslateY(10);
		  	play.setTranslateX(95);
		  	play.setTranslateY(10);
		  	quitter.setTranslateX(0);
		  	quitter.setTranslateY(10);
		  	startSablier.setTranslateX(10);
		  	startSablier.setTranslateY(100);
		  	finSablier.setTranslateX(10);
		  	finSablier.setTranslateY(150);
		  	debut.setTranslateX(10);
		  	debut.setTranslateY(250);
		  	retry.setTranslateX(10);
		  	retry.setTranslateY(300);
		 	root.getChildren().addAll(cibleT,box,robotchoix,pause,play,quitter,startSablier,finSablier,debut,deplacement,texteDeplacement,robot,retry);
			getChildren().addAll(root);
			boxrobot.getSelectionModel().selectedItemProperty().addListener( (v,OldValue , NewValue) ->{
		  		if(NewValue.equals("rouge")) {
		  			System.out.println("vous avez sï¿½lectionner le robot rouge.");
		  			plateau.getPlateau().selectionRobotCouleur(true,false,false,false);
		  			plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		robot.setText("Vous avez sélectionner le robot rouge");
            		
		  		}
		  		else if (NewValue.equals("bleu")) {
		  			System.out.println("vous avez sï¿½lectionner le robot bleu.");
		  			plateau.getPlateau().selectionRobotCouleur(false,false,true,false);
		  			plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		robot.setText("Vous avez sélectionner le robot bleu");
		  		}
		  		else if (NewValue.equals("vert")) {
		  			System.out.println("vous avez sï¿½lectionner le robot vert.");
		  			plateau.getPlateau().selectionRobotCouleur(false,true,false,false);
		  			plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerDerniereCase(p.getJaune());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		robot.setText("Vous avez sélectionner le robot vert");
		  		}
		  		else {
		  			System.out.println("vous avez sï¿½lectionner le robot jaune.");
		  			plateau.getPlateau().selectionRobotCouleur(false,false,false,true);
		  			plateau.getAffCase(p.getJaune().getCoordonneeY(),p.getJaune().getCoordonneeX()).colorerBlanc();
            		plateau.getAffCase(p.getVert().getCoordonneeY(),p.getVert().getCoordonneeX()).colorerDerniereCase(p.getVert());
            		plateau.getAffCase(p.getRouge().getCoordonneeY(),p.getRouge().getCoordonneeX()).colorerDerniereCase(p.getRouge());
            		plateau.getAffCase(p.getBleu().getCoordonneeY(),p.getBleu().getCoordonneeX()).colorerDerniereCase(p.getBleu());
            		robot.setText("Vous avez sélectionner le robot jaune");
		  		}
		  		});
		}
		public String choixrobot() {
			String robot = boxrobot.getValue();
			return robot;
		}
		public Button getSSablier() {
			return startSablier;
		}
		public Button getFSablier() {
			return finSablier;
		}
		public ButtonInGame getPlay() {
			return play;
		}
		public ButtonInGame getPause() {
			return pause;
		}
		public Button getDebutPartie(){
			return debut;
		}
		public ButtonInGame getQuitter() {
			return quitter;
		}

		public Pane getroot() {
			return root;
		}
		public Text getDeplacement(){
			return this.deplacement;
		}
		public Text getSelection(){
			return this.robot;
		}
		public Button getRetry(){
			return retry;
		}
		public Button getNouveauTry(){
			return nouveau;
		}
}
