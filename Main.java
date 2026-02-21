package project_1;

import java.util.*;

@SuppressWarnings("unused")
public class Main {
	
	public static void main (String[]args )  {
		int size = 8;
		int wallCount = 20;
		int treasureCount = 6;
		
		Map map = new Map( size, wallCount, treasureCount);
		
		
		Player player = new Player(0,0);
		
		
		Random rnd = new Random();
		int gx , gy ;
		do {
			gx = rnd.nextInt(size);
			gy = rnd.nextInt(size);
		}
		
		while ((gx==0 && gy==0 ) || map.isWall(gx, gy));
		Guard guard = new Guard(gx,gy);
		
		
		
		List <Entity> entities = new ArrayList<>();
		entities.add(player);
		entities.add(guard);
		
		Scanner sc = new Scanner (System.in);
		
		
		while(true) {
			System.out.println("Player position :(" + player.getX() + "," + player.getY() + ")");
			System.out.println("Guard position :(" + guard.getX() + "," + guard.getY() + ")");
			System.out.println(" Move (W/A/S/D): ");
			
			
			
			String input = sc.nextLine().trim().toUpperCase();
					if (input.isEmpty()) continue;
			 
					char dir = input.charAt(0);
					
					
					if ("WASD".indexOf(dir)==-1) {
						System.out.println("invalid input! use W/A/S/D.");
						continue;
						
					}
					
					player.move(dir,map);
					
					if (map.hasTreasure(player.getX(), player.getY()))  {
						map.removeTreasure(player.getX(), player.getY());
						System.out.println("treasure collected! remaining:"  + map.getRemainingTreasures());
						
					}
					
					guard.move('X', map);
					
					if (player.getX()   ==  guard.getX()  &&  player.getY()  ==  guard.getY()) {
						System.out.println("you lost ! ");
						break;
					}
					

					
					if (map.getRemainingTreasures() == 0) {
						System.out.println("you won.");
						break;
						
					}
					
		}
		
		
		sc.close();
		
	
	
	}
	}
