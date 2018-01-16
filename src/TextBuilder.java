import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextBuilder {
		public TextBuilder() {
			
		}
		public static Text titreFenetre() {
			Text titre = new Text("Ricochet Robots");
			titre.setFont(Font.font("game robot", 55));
			titre.setFill(Color.RED);
			titre.setTranslateX(300);
			titre.setTranslateY(100);
			return titre;
		}
		public static Text menuCible() {
			Text cible = new Text("La cible est ");
			cible.setFont(Font.font("game robot", 17));
			cible.setFill(Color.WHITE);
			return cible;
		}
		public static Text robotchoix() {
			Text cible = new Text("Choisissez votre robot dans \n la liste ci-dessous");
			cible.setFont(Font.font("game robot", 16));
			cible.setFill(Color.WHITE);
			return cible;
		}
		
		public static Text robotSelection(){
			Text cible= new Text("Vous ne controlez aucun robot");
			cible.setFont(Font.font("game robot", 16));
			cible.setFill(Color.WHITE);
			return cible;
		}
		
		public static Text robotChoisi(Robot r){
			
			Text cible= new Text("Vous controlez le robot "+r.getColor());
			cible.setFont(Font.font("game robot", 16));
			cible.setFill(Color.WHITE);
			return cible;
		}
		
		public static Text objectif(){
			
			Text cible= new Text("Vous avez atteint l'objectif !");
			cible.setFont(Font.font("game robot", 18));
			cible.setFill(Color.WHITE);
			return cible;
		}
		public static Text deplacement(int i){
			Text cible= new Text(""+i);
			cible.setFont(Font.font("game robot", 18));
			cible.setFill(Color.WHITE);
			return cible;
		}
		
		public static Text texteDeplacement(){

			Text cible= new Text("Compteur de déplacement :");
			cible.setFont(Font.font("game robot", 18));
			cible.setFill(Color.WHITE);
			return cible;
		}
		public static Text textePoint(){

			Text cible= new Text("Vous avez actuellement 0 point");
			cible.setFont(Font.font("game robot", 18));
			cible.setFill(Color.WHITE);
			return cible;
		}
		public static Text fin(){

			Text cible= new Text("");
			cible.setFont(Font.font("game robot", 50));
			cible.setFill(Color.WHITE);
			return cible;
		}
		
}
