/** @author Zeel Shah 
 * This program is built for the Bell PEY 2020 Challenge. The main method takes in all the necessary 
 * input ( x,y,z,roundnum, and betrayal rate) from the command line and calls the playerMove function to calculate the 
 * best play. The main function is just used to test the playMove function. The function is made public so it can be easily incorporated
 * into other projects. 
 */
public class PredWar {
	public static void main(String args[])
	{
		// get the arguments from the command line
		// assuming the input is given the same way it was specified in the README file
		int x = Integer.parseInt(args[0]); // lowest point 
		int y = Integer.parseInt(args[1]); // middle point 
		int z = Integer.parseInt(args[2]); // highest point 
		int r = Integer.parseInt(args[3]); // round number 
		double b = Double.parseDouble(args[4]); // betrayal rate of the opponent 
		
		System.out.println(playerMove(x,y,z,r,b));// print of the move of the player 
		
	}
	
	/**
	 * Function calculates the players move 
	 * @param x-  the number of points my player gets if they betray and the opponent betrays as well
	 * @param y- the number of points my player gets if they cooperate with the other player and the opponent does the same 
	 * @param z - the number of points my player gets if they betray with the other player and the opponent coooperates 
	 * @param r - round number 
	 * @param b - betrayl rate of the opponent 
	 */
	// this function is public in order for other programs to directly access the player's move 
	public static String playerMove(int x, int y, int z, int r, double b)
	{
		/* for the first round betray, since the other player knows it's your first round so they 
		can't easily infer your move*/
		if (r == 0)
		{
			return "betray";
		}
		//if the opponents betrayal rate is < 33% they most likely co-oporates with all the other players, so betray
		// if r > .66 this means the opponent is most likely to betray so you should betray too
		else if (b<(1.0/3.0)||b>=(2.0/3.0))
		{
			return "betray";
		}
		// if the opponent betrayal rate is between .33 and .66 percent, they either betray or cooporate, there is still a good chance 
		// that they will co-operate so if you co-operate then you will win the y points 
		else
		{
			return "cooperate";
		}		
		
		
	}

}
