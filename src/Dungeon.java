// original code: https://github.com/KSriki/Zork/blob/master/src/Dungeon.java

import java.util.*;
import java.util.Scanner;

public class Dungeon
{
	int count = 0;
	public int roomNo = 1;
	int ghost = 1;
	boolean rich = false;
	
	String dir = "";
	Scanner scan = new Scanner(System.in);

	Random rnd = new Random();
	int rng = 1 + rnd.nextInt(4);
	
	public int[] coins = new int[8];
	String[] items = new String[8];
	
	int userCoins = 0;
	int npc = rnd.nextInt(8);
	int lamp = rnd.nextInt(8) + 1;
	boolean hasLamp = false;

	public void gatherCoins(int x)
	{
		System.out.println("You are standing in the foyer of an old house.\nYou see a dead scorpion.");
		if (coins[x] > 0) {
			System.out.printf("There are %d coins in this room! Would you like to pick them up? (Y/N) ", coins[x]);
			if (scan.nextLine().charAt(0) == 'y') {
				userCoins += coins[x];
				coins[x] = 0;
			}
		}
		return;
	}
	
	public void foyer()
	{
		gatherCoins(0);
		items[0] = "Dead scorpion";
		System.out.println("Exit 'n'orth to the 'front room'. \nExit the Game (Q).");

		dir = scan.nextLine().toLowerCase();
		if(dir.equals("n") || dir.equals("front room")){
			roomNo = 2;
		}

		else if(!dir.equals("q")){
			System.out.println("You were actually dead the whole time. Game has ended.");
			return;
		}
	}
	public void front_room()
	{
		gatherCoins(1);
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
		else if(!dir.equals("q")){
			System.out.println("You were actually dead the whole time. Game has ended.");
			return;
		}
	}

	public void library()
	{
		gatherCoins(2);
		items[2] = "Crawling spiders";
		System.out.println("Exit 'e'ast to the 'front room'. \nExit 'n'orth to the 'dining room'. \nExit the Game (Q).");
		dir = scan.nextLine().toLowerCase();
	
		if(dir.equals("e") || dir.equals("front room")){
			roomNo = 2;
		}
		else if(dir.equals("n") || dir.equals("dining room")){
			roomNo = 5;
		}
		else if(!dir.equals("q")){
			System.out.println("You were actually dead the whole time. Game has ended.");
			return;
		}
	}

	public void kitchen()
	{
		gatherCoins(3);
		items[3] = "Bats";
		System.out.println("Exit 'w'est to the 'front room'. \nExit 'n'orth to the 'parlor' \nExit the Game (Q).");
		dir = scan.nextLine().toLowerCase();
	
		if(dir.equals("w") || dir.equals("front room")){
			roomNo = 2;
		}
		else if(dir.equals("n") || dir.equals("parlor")) {
			roomNo = 7;
		}
		else if(!dir.equals("q")){
			System.out.println("You were actually dead the whole time. Game has ended.");
			return;
		}	
	}

	public void dining_room()
	{
		gatherCoins(4);
		items[4] = "Dust and an empty box";
		System.out.println("Exit 's'outh to the 'library'. \nExit the Game (Q).");
		dir = scan.nextLine().toLowerCase();
	
		if(dir.equals("s") || dir.equals("library")) {
			roomNo = 3;
		}

		else if(!dir.equals("q")){
			System.out.println("You were actually dead the whole time. Game has ended.");
			return;
		}
	}

	public void vault()
	{
		gatherCoins(5);
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

		}
		else if(dir.equals("parlor")){
			roomNo = 7;
		}
		else if(dir.equals("secret room")){
			roomNo = 8;
		}
		else if(!dir.equals("q")){
			System.out.println("You were actually dead the whole time. Game has ended.");
			return;
		}
	}

	public void old_parlor()
	{
		gatherCoins(6);
		items[6] = "Treasure chest";
		System.out.println("Exit 'w'est to the 'vault'. \nExit 's'outh to the 'kitchen'. \nExit the Game (Q).");
		
		dir = scan.nextLine().toLowerCase();
		
		if (dir.equals("s") ||dir.equals("kitchen")) {
			roomNo = 4;
		}
		else if (dir.equals("w") || dir.equals("vault")) {
			roomNo = 6;
		}
		else if(!dir.equals("q")){
			System.out.println("You were actually dead the whole time. Game has ended.");
			return;
		}
	}

	public void secret_room()
	{
		gatherCoins(7);
		items[7] = "Piles of gold";
		System.out.println("Exit 'w'est to the 'vault'. \nExit the Game (Q).");
		dir = scan.nextLine().toLowerCase();
		
		if (dir.equals("w") || dir.equals("vault")) {
			roomNo = 6;
			System.out.println("Why would you leave this shiny place?");
		}
		else if(!dir.equals("q")){
			System.out.println("You were actually dead the whole time. Game has ended.");
			return;
		}
	}

	public Dungeon()
	{
		//System.out.println("Hello2222");
		for (int i = 0; i < coins.length; i++) {
			coins[i] = rnd.nextInt(1001);
		}
		coins[npc] = 0;
		while(!dir.equals("q")){
			if (roomNo == npc) {
				System.out.println("Oh no! You stumble across the path of a giant mountain troll! It picks you up by the leg and shakes you so that all of your coins fall out of your pockets. It drops you to the ground and runs away with all of your money. You just got mugged by a mountain troll!");
				userCoins = 0;
			}
			System.out.printf("You have %d coins! \n",userCoins);
			switch(roomNo){
				case 1: foyer(); break;
				case 2: front_room(); break;
				case 3: library(); break;
				case 4: kitchen();break;
				case 5: dining_room(); break;
				case 6: vault(); break;
				case 7: old_parlor(); break;
				case 8: secret_room(); break;
			}
			count++;
		}
		ending();
	}

	public void ending()
	{
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

	public static void main(String[] args) 
	{
		//System.out.println("Hello");
		Dungeon game = new Dungeon();
	}
}
