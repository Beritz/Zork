/*
 * Classic Zork Dungeon Crawler Implementation
 * Srikant Kumar Kalaputapu and Toma Tadros
 * June 21, 2017
 * 
 * For InfoSys Java Training Course 2017.
 * Non-object oriented
 * 
 */
import java.util.Random;
import java.util.Scanner;
public class Dungeon {


	public static void main(String[] args){
		
		int count = 0;
		int roomNo = 1;
		int ghost = 1;
		boolean rich = false;
		
		char dir = ' ';
		Scanner scan = new Scanner(System.in);
		//q for quit
		Random rnd = new Random();
		int rng = 1 + rnd.nextInt(4);
		
		int[] coins = new int[8];
		String[] items = new String[8];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = rnd.nextInt(1001);
		}
		int userCoins = 0;
		int npc = rnd.nextInt(8) + 1;
		coins[npc] = 0;
		
		while(dir != 'Q'){
			if (roomNo == npc) {
				System.out.println("Oh no! You stumble across the path of a giant mountain troll! It picks you up by the leg and shakes you so that all of your coins fall out of your pockets. It drops you to the ground and runs away with all of your money. You just got mugged by a mountain troll!");
				userCoins = 0;
			}
			switch(roomNo){
			
				
				case 1: System.out.println("You are standing in the foyer of an old house.\nYou see a dead scorpion.");
						if (coins[0] > 0) {
							System.out.printf("There are %f coins in this room! Would you like to pick them up? (Y/N)", coins[0]);
							if (scan.nextLine().charAt(0) == 'Y') {
								userCoins += coins[0];
							}
						}
						System.out.println("(N) Exit to the North. \n(Q) Exit the Game.");

						dir = scan.nextLine().charAt(0);
						if(dir == 'N'){
							roomNo = 2;
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 2: System.out.println("You are standing in the front room.\nYou see a piano.");
						if (coins[1] > 0) {
							System.out.printf("There are %f coins in this room! Would you like to pick them up? (Y/N)", coins[1]);
							if (scan.nextLine().charAt(0) == 'Y') {
								userCoins += coins[1];
							}
						}
						System.out.println("(W) Exit to the West. \n(E) Exit to the East. \n(S) Exit to the South. \n(Q) Exit the Game.");
						dir = scan.nextLine().charAt(0);
						if(dir == 'W'){
							roomNo = 3;
						}
						else if(dir == 'E'){
							roomNo = 4;
						}
						else if(dir == 'S'){
							roomNo = 1;
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 3: System.out.println("You are standing in a library.\nYou see spiders crawling on the bookshelves.");
						if (coins[2] > 0) {
							System.out.printf("There are %f coins in this room! Would you like to pick them up? (Y/N)", coins[2]);
							if (scan.nextLine().charAt(0) == 'Y') {
								userCoins += coins[2];
							}
						}
						System.out.println("(E) Exit to the East. \n(N) Exit to the North. \n(Q) Exit the Game.");
						dir = scan.nextLine().charAt(0);
					
						if(dir == 'E'){
							roomNo = 2;
						}
						else if(dir == 'N'){
							roomNo = 5;
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 4: System.out.println("You find yourself in the kitchen. \nSmall glowing eyes in the room indicate a hidden colony of bats.");
						if (coins[3] > 0) {
							System.out.printf("There are %f coins in this room! Would you like to pick them up? (Y/N)", coins[3]);
							if (scan.nextLine().charAt(0) == 'Y') {
								userCoins += coins[3];
							}
						}
						System.out.println("(W) Exit to the West. \n(N) Exit to the North. \n(Q) Exit the Game.");
						dir = scan.nextLine().charAt(0);
					
						if(dir == 'W'){
							roomNo = 2;
						}
						else if(dir == 'N'){
							roomNo = 7;
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 5: System.out.println("You enter the dining room. \nYou notice the walls are coated in dust and a small empty box resting on the table.");
						if (coins[4] > 0) {
							System.out.printf("There are %f coins in this room! Would you like to pick them up? (Y/N)", coins[4]);
							if (scan.nextLine().charAt(0) == 'Y') {
								userCoins += coins[4];
							}
						}
						System.out.println("(S) Exit to the South. \n(Q) Exit the Game.");
						dir = scan.nextLine().charAt(0);
					
						if(dir == 'S'){
							roomNo = 3;
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
						
						//special for gold
				case 6: System.out.println("You magically appear standing inside a vault. \nThere are 3 sp00ky scary skel3tons.");
						if(rich){
							System.out.println("(1) Exit to the East to the parlor. \n(2) Exit to the East to the Secret Room. \n(Q) Exit the Game.");			
						}
						else{
							System.out.println("(E) Exit to the East. \n(Q) Exit the Game.");
						}
								
						dir = scan.nextLine().charAt(0);
					
						if(dir == 'E' && !rich){
							if(rng == 2){
								roomNo = 8;
								rich = true;
							}
							else{
								rng = 1 + rnd.nextInt(4);
								roomNo = 7;
							}
						}
						else if(dir == '1'){
							roomNo = 7;
						}
						else if(dir == '2'){
							roomNo = 8;
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
						
				case 7: System.out.println("You find yourself entering the old parlor. \nThere is a treasure chest in the middle of the room. \nDo you have the key?");
						System.out.println("(W) Exit to the West. \n(S) Exit to the South. \n(Q) Exit the Game.");
						
						dir = scan.nextLine().charAt(0);
						
						if(dir == 'S'){
							roomNo = 4;
						}
						else if(dir == 'W'){
							roomNo = 6;
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 8: System.out.println("Congratulations! You found the secret room! \nPiles of gold everywhere!");
						System.out.println("(W) Exit to the West. \n(Q) Exit the Game.");
						dir = scan.nextLine().charAt(0);
						
						if(dir == 'W'){
							roomNo = 6;
							System.out.println("Why would you leave this shiny place?");
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
			
			}
			count++;
			
			
					
		}
		//

		ghost = 1 + rnd.nextInt(4);
		if(ghost == 3){
			System.out.println("A ghost quietly follows you out the door of the house.");
		}
		
		System.out.println("You visited " + count + " room(s). Please come again!");
		
		
	}
}
