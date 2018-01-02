package Server;

public class Board
{
 Field fields[][];
 
 Board(int rows)
 {
	 fields=new Field[6*rows+1][8*rows+1];
	 for(int i=0;i<6*rows+1;i++) {
		 for(int j=0;j<8*rows+1;j++) {
			 fields[i][j]=new Field();
		 }
	 }
	 markField(fields,rows);
	 markBase(fields,rows);
 }
 
 void markField(Field board[][],int rows) 
 {
	 for(int i=0;i<3*rows+1;i++) 
	 {
		 for(int j=0;j<=i; j++)
	     {		 
		  board[3*rows-i+j*2][i*2].changeField(true);
		 }
	 }
	 int k=0;
	 
	 for(int i=4*rows;i>=rows;i--) 
	 {
		 for(int j=0;j<=k; j++)
	     {		 
		  board[3*rows-k+2*j][i*2].changeField(true);
	     }
		 k++;
	 }
 }
 
 void markBase(Field board[][],int rows) 
 {
  upsideDown(board,rows);
  downsideUp(board,rows);
 }
 void upsideDown(Field board[][],int rows) 
 {
	 for(int i=0;i<rows;i++) 
	 {
		for(int j=0;j<=i;j++)
		{
          board[3*rows-i+2*j][i*2].changeBase(1);
          board[rows-1-i+2*j][2*(2*rows+1+i)].changeBase(3);
          board[5*rows+1-i+2*j][2*(2*rows+1+i)].changeBase(5);
		
		}
	 }
 }
 
 void downsideUp(Field board[][],int rows) 
 {
	 for(int i=0;i<rows;i++) 
	 {
		for(int j=0;j<=i;j++)
		{
          board[3*rows-i+2*j][8*rows-i*2].changeBase(6);
          board[5*rows+1-i+2*j][2*(2*rows-1-i)].changeBase(4);
          board[rows-1-i+2*j][2*(2*rows-1-i)].changeBase(2);
		
		}
	 }
 }
 public Field[][] getFields(){return this.fields;}
}



