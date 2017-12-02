
public class Game {
  public static void main(String[] args) {
	  Board plansza=new Board(6);
	  for(int j=0;j<8*6+1;j++)  {
		  for(int i=0;i<6*6+1;i++){
			  if(plansza.fields[i][j].getField()) {
				  System.out.print(plansza.fields[i][j].getBase());
			  }
			  else {
				  System.out.print(" ");
			  }
		  }
	   System.out.println();
	  }
  }
}
