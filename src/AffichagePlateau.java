import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class AffichagePlateau extends StackPane {
	private Plateau p;
	private AffichageCase[][] plateau;
	public AffichagePlateau(Plateau p) throws IOException {
		this.p = p;
		plateau = new AffichageCase[p.taillePlateau()][p.taillePlateau()];
		final StackPane root = new StackPane(); 
		InputStream Acceuil = Files.newInputStream(Paths.get("./ressources/images/Robots.jpg"));
		Image img = new Image(Acceuil);
		Acceuil.close();
		ImageView imgV = new ImageView(img);
		imgV.setFitHeight(720);
		imgV.setFitWidth(1080);
		double posYcase = 0;
		double posXcase = 0;
		/*for (int i = 15; i >= 0; i--) {
			posYcase = posYcase - 44.6; //44.6
			posXcase =0;
			int k=0;
			
			for (int j = 0; j < 16; j++) {
				plateau[k][j] = new AffichageCase(p.getCase(j, i));
				plateau[k][j].setAlignment(Pos.CENTER);
				plateau[k][j].setTranslateX(posXcase);
				plateau[k][j].setTranslateY(posYcase);
				if(plateau[k][j].getCase().possedeUnRobot()) {
					plateau[k][j].colorerCase();
				}
				posXcase = posXcase + 67.2;//67.3
				root.getChildren().addAll(plateau[k][j]);
			}
			k++;
		}*/
		posYcase=700;
		for (int i = 0; i <16 ; i++) {
			 //44.6
			posXcase =0;
			
			
			for (int j = 0; j < 16; j++) {
				plateau[i][j] = new AffichageCase(p.getCase(j, i));
				plateau[i][j].setAlignment(Pos.CENTER);
				plateau[i][j].setTranslateX(posXcase);
				plateau[i][j].setTranslateY(-posYcase);
				if(plateau[i][j].getCase().possedeUnRobot()) {
					plateau[i][j].colorerCase();
				}
				posXcase = posXcase + 67.2;//67.3
				root.getChildren().addAll(plateau[i][j]);
			}
			posYcase = posYcase - 44.6;
			
		}
		
		root.setTranslateX(-506);
		root.setTranslateY(365);
		getChildren().addAll(imgV,root);
	}
	public AffichageCase getAffCase(int i,int j) {
		return plateau[i][j];
		
	}
	public Plateau getPlateau() {
		return this.p;
	}
	
	
	

	

}
