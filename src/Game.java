
public class Game {
  public static void main(String[] args) {
	  Board plansza=new Board(3);
	  Referee referee=new Referee();

	  for(int j=0;j<8*3+1;j++)  {
		  for(int i=0;i<6*3+1;i++){
			  if(plansza.fields[i][j].getField()) {
				  System.out.print(plansza.fields[i][j].getBase());
			  }
			  else {
				  System.out.print(" ");
			  }
		  }
	   System.out.println();
	  }
	  plansza.fields[10][14].changeChecker(5);
	  plansza.fields[11][12].changeChecker(4);
	  plansza.fields[13][12].changeChecker(4);
	  referee.markMovable(plansza.fields,9,12);


	  for(int j=0;j<8*3+1;j++)  {
		  for(int i=0;i<6*3+1;i++){
			  if(plansza.fields[i][j].getField()) {
			  	 if(plansza.fields[i][j].getCanMove()){
			  	 	System.out.print(8);
				 }
				 else
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
