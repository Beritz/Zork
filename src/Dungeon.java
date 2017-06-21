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
		char dir = ' ';
		Scanner scan = new Scanner(System.in);
		//q for quit
		
		
		while(dir != 'Q'){
	
			System.out.println("Room Number is: "  + roomNo);
		
			switch(roomNo){
			
				
				case 1: System.out.println("You are standing in the foyer of an old house.\nYou see a dead scorpion.");
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
				case 3: System.out.println("abefkgaie:");
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
				case 4: System.out.println("abesgfkgaie:");
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
				case 5: System.out.println("abefkgaie:");
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
				case 6: System.out.println("abefkgaie:");
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
						
				case 7: System.out.println("abefkgaie:");
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
				case 8: System.out.println("abefkgaie:");
						dir = scan.nextLine().charAt(0);
						
						if(dir == 'W'){
							roomNo = 6;
						}
						//Spice this up
						else if(dir != 'Q'){
							System.out.println("You were actually dead the whole time. Game has ended.");
							return;
						}
						break;
			
			}
			
			
					
		}
		//
		
		
		
	}
}
