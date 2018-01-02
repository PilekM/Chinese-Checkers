package Server;

import static org.junit.Assert.*;

import org.junit.*;

public class TestBoard
{
	Board firstBoard;
	Board secondBoard;
	
	@Before @Test
	public void beforeTest()
	{
		firstBoard = new Board(1);
		secondBoard = new Board(4);
	}
	
	@Test
	public void testBoard() 
	{	
		assertEquals(firstBoard.fields[1][0].getField(), false);
		assertEquals(firstBoard.fields[1][0].getBase(), 0);
		assertEquals(firstBoard.fields[2][0].getField(), false);
		assertEquals(firstBoard.fields[2][0].getBase(), 0);
		assertEquals(firstBoard.fields[3][0].getField(), true);
		assertEquals(firstBoard.fields[3][0].getBase(), 1);
		assertEquals(firstBoard.fields[1][1].getField(), false);
		assertEquals(firstBoard.fields[1][1].getBase(), 0);
		assertEquals(firstBoard.fields[2][1].getField(), false);
		assertEquals(firstBoard.fields[2][1].getBase(), 0);
		assertEquals(firstBoard.fields[3][1].getField(), false);
		assertEquals(firstBoard.fields[3][1].getBase(), 0);
		assertEquals(firstBoard.fields[1][2].getField(), false);
		assertEquals(firstBoard.fields[1][2].getBase(), 0);
		assertEquals(firstBoard.fields[2][2].getField(), true);
		assertEquals(firstBoard.fields[2][2].getBase(), 0);
		assertEquals(firstBoard.fields[3][2].getField(), false);
		assertEquals(firstBoard.fields[3][2].getBase(), 0);		
		
		assertEquals(firstBoard.fields[3][6].getField(), false);
		assertEquals(firstBoard.fields[3][6].getBase(), 0);
		assertEquals(firstBoard.fields[4][6].getField(), true);
		assertEquals(firstBoard.fields[4][6].getBase(), 0);
		assertEquals(firstBoard.fields[5][6].getField(), false);
		assertEquals(firstBoard.fields[5][6].getBase(), 0);
		assertEquals(firstBoard.fields[3][7].getField(), false);
		assertEquals(firstBoard.fields[3][7].getBase(), 0);
		assertEquals(firstBoard.fields[4][7].getField(), false);
		assertEquals(firstBoard.fields[4][7].getBase(), 0);
		assertEquals(firstBoard.fields[5][7].getField(), false);
		assertEquals(firstBoard.fields[5][7].getBase(), 0);
		assertEquals(firstBoard.fields[3][8].getField(), true);
		assertEquals(firstBoard.fields[3][8].getBase(), 6);
		assertEquals(firstBoard.fields[4][8].getField(), false);
		assertEquals(firstBoard.fields[4][8].getBase(), 0);
		assertEquals(firstBoard.fields[5][8].getField(), false);
		assertEquals(firstBoard.fields[5][8].getBase(), 0);	
		
		
		assertEquals(secondBoard.fields[10][0].getField(), false);
		assertEquals(secondBoard.fields[10][0].getBase(), 0);
		assertEquals(secondBoard.fields[11][0].getField(), false);
		assertEquals(secondBoard.fields[11][0].getBase(), 0);
		assertEquals(secondBoard.fields[12][0].getField(), true);
		assertEquals(secondBoard.fields[12][0].getBase(), 1);
		assertEquals(secondBoard.fields[10][1].getField(), false);
		assertEquals(secondBoard.fields[10][1].getBase(), 0);
		assertEquals(secondBoard.fields[11][1].getField(), false);
		assertEquals(secondBoard.fields[11][1].getBase(), 0);
		assertEquals(secondBoard.fields[12][1].getField(), false);
		assertEquals(secondBoard.fields[12][1].getBase(), 0);
		assertEquals(secondBoard.fields[10][2].getField(), false);
		assertEquals(secondBoard.fields[10][2].getBase(), 0);
		assertEquals(secondBoard.fields[11][2].getField(), true);
		assertEquals(secondBoard.fields[11][2].getBase(), 1);
		assertEquals(secondBoard.fields[12][2].getField(), false);
		assertEquals(secondBoard.fields[12][2].getBase(), 0);
		assertEquals(secondBoard.fields[10][3].getField(), false);
		assertEquals(secondBoard.fields[10][3].getBase(), 0);
		assertEquals(secondBoard.fields[11][3].getField(), false);
		assertEquals(secondBoard.fields[11][3].getBase(), 0);
		assertEquals(secondBoard.fields[12][3].getField(), false);
		assertEquals(secondBoard.fields[12][3].getBase(), 0);
		assertEquals(secondBoard.fields[10][4].getField(), true);
		assertEquals(secondBoard.fields[10][4].getBase(), 1);
		assertEquals(secondBoard.fields[11][4].getField(), false);
		assertEquals(secondBoard.fields[11][4].getBase(), 0);
		assertEquals(secondBoard.fields[12][4].getField(), true);
		assertEquals(secondBoard.fields[12][4].getBase(), 1);
		
		assertEquals(secondBoard.fields[15][24].getField(), false);
		assertEquals(secondBoard.fields[15][24].getBase(), 0);
		assertEquals(secondBoard.fields[16][24].getField(), true);
		assertEquals(secondBoard.fields[16][24].getBase(), 0);
		assertEquals(secondBoard.fields[17][24].getField(), false);
		assertEquals(secondBoard.fields[17][24].getBase(), 0);
		assertEquals(secondBoard.fields[18][24].getField(), true);
		assertEquals(secondBoard.fields[18][24].getBase(), 5);
		assertEquals(secondBoard.fields[15][25].getField(), false);
		assertEquals(secondBoard.fields[15][25].getBase(), 0);
		assertEquals(secondBoard.fields[16][25].getField(), false);
		assertEquals(secondBoard.fields[16][25].getBase(), 0);
		assertEquals(secondBoard.fields[17][25].getField(), false);
		assertEquals(secondBoard.fields[17][25].getBase(), 0);
		assertEquals(secondBoard.fields[18][25].getField(), false);
		assertEquals(secondBoard.fields[18][25].getBase(), 0);
		assertEquals(secondBoard.fields[15][26].getField(), true);
		assertEquals(secondBoard.fields[15][26].getBase(), 6);
		assertEquals(secondBoard.fields[16][26].getField(), false);
		assertEquals(secondBoard.fields[16][26].getBase(), 0);
		assertEquals(secondBoard.fields[17][26].getField(), false);
		assertEquals(secondBoard.fields[17][26].getBase(), 0);
		assertEquals(secondBoard.fields[18][26].getField(), false);
		assertEquals(secondBoard.fields[18][26].getBase(), 0);
		
	}

}