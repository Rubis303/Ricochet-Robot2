import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class AffichageCase extends StackPane {
	private Case p;
	private Rectangle carre;
	public AffichageCase(Case c) {
		this.p = c;
		carre = new Rectangle(55, 37);//37
		carre.setOpacity(0);
		carre.setFill(Color.BLACK);
		setAlignment(Pos.CENTER);
		getChildren().addAll(carre);
	}
	public void colorerCase() {
		if(this.p.possedeUnRobot()) {
			this.carre.setOpacity(1);
			this.carre.setFill(this.p.getRobot().getColor());
		} else {
			this.carre.setFill(Color.BLACK);
		}
	}
		
	public void ajoutRobot(Robot r) {
		p.ajoutRobot(r);
		colorerCase();
		
	}
	public void colorerDerniereCase(Robot r){
		retirerrobot();
		ajoutRobot(r);
		colorerCase();
	}
	public void colorerBlanc(){
		this.carre.setFill(Color.BLACK);
	}
	
	public void retirerrobot() {
		p.retirerrobot();
		this.carre.setFill(Color.BLACK);
		this.carre.setOpacity(0);
	}
	
	public Case getCase() {
		return this.p;
	}

}
