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
		
		String dir = "";
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
		int npc = rnd.nextInt(8);
		int lamp = rnd.nextInt(8) + 1;
		boolean hasLamp = false;
		coins[npc] = 0;
		
		while(!dir.equals("q")){
			if (roomNo == npc) {
				System.out.println("Oh no! You stumble across the path of a giant mountain troll! It picks you up by the leg and shakes you so that all of your coins fall out of your pockets. It drops you to the ground and runs away with all of your money. You just got mugged by a mountain troll!");
				userCoins = 0;
			}
			System.out.printf("You have %d coins! \n",userCoins);
			switch(roomNo){
			
				

				case 1: System.out.println("You are standing in the foyer of an old house.\nYou see a dead scorpion.");
						if (coins[0] > 0) {
							System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[0]);
							if (scan.nextLine().charAt(0) == 'y') {
								userCoins += coins[0];
								coins[0] = 0;
							}
						}
						items[0] = "Dead scorpion";
						System.out.println("Exit 'n'orth to the 'front room'. \nExit the Game (Q).");

						dir = scan.nextLine().toLowerCase();
						if(dir.equals("n") || dir.equals("front room")){
							roomNo = 2;
						}
						//Spice this up
						else if(!dir.equals("q")){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 2: System.out.println("You are standing in the front room.\nYou see a piano.");
						if (coins[1] > 0) {
							System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[1]);
							if (scan.nextLine().charAt(0) == 'y') {
								userCoins += coins[1];
								coins[1] = 0;
							}
						}
						items[1] = "Piano";
						System.out.println("Exit 'w'est to the 'library'. \nExit 'e'ast to the 'kitchen'. \nExit 's'outh to the 'foyer'. \nExit the Game (Q).");
						dir = scan.nextLine().toLowerCase();
						if(dir.equals("w") || dir.equals("library")){
							roomNo = 3;
						}
						else if(dir.equals("e") || dir.equals("kitchen")){
							roomNo = 4;
						}
						else if(dir.equals("s") || dir.equals("foyer")){
							roomNo = 1;
						}
						//Spice this up
						else if(!dir.equals("q")){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 3: System.out.println("You are standing in a library.\nYou see spiders crawling on the bookshelves.");
						if (coins[2] > 0) {
							System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[2]);
							if (scan.nextLine().charAt(0) == 'y') {
								userCoins += coins[2];
								coins[2] = 0;
							}
						}
						items[2] = "Crawling spiders";
						System.out.println("Exit 'e'ast to the 'front room'. \nExit 'n'orth to the 'dining room'. \nExit the Game (Q).");
						dir = scan.nextLine().toLowerCase();
					
						if(dir.equals("e") || dir.equals("front room")){
							roomNo = 2;
						}
						else if(dir.equals("n") || dir.equals("dining room")){
							roomNo = 5;
						}
						//Spice this up
						else if(!dir.equals("q")){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 4: System.out.println("You find yourself in the kitchen. \nSmall glowing eyes in the room indicate a hidden colony of bats.");
						if (coins[3] > 0) {
							System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[3]);
							if (scan.nextLine().charAt(0) == 'y') {
								userCoins += coins[3];
								coins[3] = 0;
							}
						}
						items[3] = "Bats";
						System.out.println("Exit 'w'est to the 'front room'. \nExit 'n'orth to the 'parlor' \nExit the Game (Q).");
						dir = scan.nextLine().toLowerCase();
					
						if(dir.equals("w") || dir.equals("front room")){
							roomNo = 2;
						}
						else if(dir.equals("n") || dir.equals("parlor")) {
							roomNo = 7;
						}
						//Spice this up
						else if(!dir.equals("q")){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 5: System.out.println("You enter the dining room. \nYou notice the walls are coated in dust and a small empty box resting on the table.");
						if (coins[4] > 0) {
							System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[4]);
							if (scan.nextLine().charAt(0) == 'y') {
								userCoins += coins[4];
								coins[4] = 0;
							}
						}
						items[4] = "Dust and an empty box";
						System.out.println("Exit 's'outh to the 'library'. \nExit the Game (Q).");
						dir = scan.nextLine().toLowerCase();
					
						if(dir.equals("s") || dir.equals("library")) {
							roomNo = 3;
						}
						//Spice this up
						else if(!dir.equals("q")){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
						
						//special for gold
				case 6: System.out.println("You magically appear standing inside a vault. \nThere are 3 sp00ky scary skel3tons.");
						if (coins[5] > 0) {
							System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[5]);
							if (scan.nextLine().charAt(0) == 'y') {
								userCoins += coins[5];
								coins[5] = 0;
							}
						}
						items[5] = "3 skeletons";
						if(rich){
							System.out.println("Exit east to the 'parlor' \nExit east to the 'secret room'. \nExit the Game (Q).");			
						}
						else{
							System.out.println("Exit 'e'ast to the 'parlor'. \nExit the Game (Q).");
						}
								
						dir = scan.nextLine().toLowerCase();
					
						if((dir.equals("e") || dir.equals("parlor")) && !rich){
							if(rng == 2){
								roomNo = 8;
								rich = true;
							}
							else{
								rng = 1 + rnd.nextInt(4);
								roomNo = 7;
							}
						}///test
						else if(dir.equals("parlor")){
							roomNo = 7;
						}
						else if(dir.equals("secret room")){
							roomNo = 8;
						}
						//Spice this up
						else if(!dir.equals("q")){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
						
				case 7: System.out.println("You find yourself entering the old parlor. \nThere is a treasure chest in the middle of the room. \nDo you have the key?");
						if (coins[6] > 0) {
							System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[6]);
							if (scan.nextLine().charAt(0) == 'y') {
								userCoins += coins[6];
								coins[6] = 0;
							}
						}
						items[6] = "Treasure chest";
						System.out.println("Exit 'w'est to the 'vault'. \nExit 's'outh to the 'kitchen'. \nExit the Game (Q).");
						
						dir = scan.nextLine().toLowerCase();
						
						if (dir.equals("s") ||dir.equals("kitchen")) {
							roomNo = 4;
						}
						else if (dir.equals("w") || dir.equals("vault")) {
							roomNo = 6;
						}
						//Spice this up
						else if(!dir.equals("q")){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
				case 8: System.out.println("Congratulations! You found the secret room! \nPiles of gold everywhere!");
						if (coins[7] > 0) {
							System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[7]);
							if (scan.nextLine().charAt(0) == 'y') {
								userCoins += coins[7];
								coins[7] = 0;
							}
						}
						items[7] = "Piles of gold";
						System.out.println("Exit 'w'est to the 'vault'. \nExit the Game (Q).");
						dir = scan.nextLine().toLowerCase();
						
						if (dir.equals("w") || dir.equals("vault")) {
							roomNo = 6;
							System.out.println("Why would you leave this shiny place?");
						}
						//Spice this up
						else if(!dir.equals("q")){
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
		System.out.println("You saw the following items: ");
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				System.out.println(items[i]);
			}
		}
		System.out.printf("You left with %d coins. Congratulations!!", userCoins);
		
	}
}
