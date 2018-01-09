
public class MainTest {
	public static void main(String[] args) {
		
		Plateau p=new Plateau();
		
		
		
		//Case[] tableau=d.calculDeplacer(d.getPlateau().getCase(15,15));
		//System.out.println("case robot  " + d.getPlateau().getCase(d.r.getCoordonneeX(),d.r.getCoordonneeY()));
		//System.out.println("case robot x= " + d.r.getCoordonneeX() + " y =  " + d.r.getCoordonneeY());
		/*for(int i=0;i<=3;i++) {
			System.out.println("Coordonnee x : "+tableau[i].getCoordonneeX()+" Coordonnee y : "+tableau[i].getCoordonneeY());
		}*/
		//System.out.println("case x " + tableau[2].getCoordonneeX() + " y  " + tableau[2].getCoordonneeY());
		//System.out.println(p);
		/*
	    Case tab=p.deplacementr(p.getRouge(),"H");
	    System.out.println(tab.getCoordonneeX()+"  "+tab.getCoordonneeY());
	    Case tab1=p.deplacementr(p.getRouge(),"D");
	    System.out.println(tab1.getCoordonneeX()+"  "+tab1.getCoordonneeY());
	    Case tab2=p.deplacementr(p.getRouge(),"G");
	    System.out.println(tab2.getCoordonneeX()+"  "+tab2.getCoordonneeY());*/
	    
		System.out.println(p.calculChemin(p.getVert()));
		
	}
}
