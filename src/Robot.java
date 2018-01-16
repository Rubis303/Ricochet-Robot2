import javafx.scene.paint.Color;
public class Robot {
	private int cX;
	private int cY;
	private Color color;
	private boolean selection; 
	private String couleur;
	public Robot(Color color,String c) {
		this.selection = false;
		this.color = color;	
		this.couleur=c;
	}
	public Color getColor() {
		return this.color;
	}
	public void setColor(Color c){
		this.color=c;

	}
	public String getVraieCouleur(){
		return this.couleur;
	}
	public void setCoordonnee(int x,int y) {
		cX = x;
		cY = y;
	}
public void setSelection(boolean b) {
	this.selection = b;
}
public boolean getSelection() {
	return this.selection;
}
	public int getCoordonneeX() {
		return this.cX;
	}
	public int getCoordonneeY() {
		return this.cY;
	}
	
	public void seDeplaceHaut() {
			this.cY ++;
		}
	
   public void seDeplaceBas() {
	       this.cY --;
		
	}
   public void seDeplaceDroite() {
		this.cX++;
		
	}
   public void seDeplaceGauche() {
		this.cX--;
		
	}

   
}
