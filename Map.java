package project_1;

import java.util.Random;


@SuppressWarnings("unused")
public class Map {
	
	
	private int size;
	private boolean [][] walls;
	private boolean [][] treasures;
	private int remainingTreasures;
	private Random rnd = new Random();
	
	
	public Map(int size , int wallCount, int treasureCount)  {
		this.size= size;
		
		walls= new boolean [size][size];
		treasures= new boolean [size][size];
		
		int placedWalls = 0;
		while (placedWalls < wallCount)   {
			int x = rnd.nextInt(size);
			int y = rnd.nextInt(size);
			
			
			if (x == 0 && y == 0)  continue ;
			if (walls[y][x])  continue ;
			
			
			walls [y][x] = true;
			placedWalls++ ;
			
			
		}
		
		
		
		int placedTreasures = 0;
		while (placedTreasures < treasureCount) {
			int x = rnd.nextInt(size);
			int y = rnd.nextInt(size);
			
			
			if (x== 0 && y== 0) continue;
			if (walls[y][x]) continue;
			if (treasures[y][x]) continue;
			
			
			
			treasures[y][x]= true;
			placedTreasures++;

		}
		
		remainingTreasures = treasureCount;
	}

	
	public int getSize()  {return size;}
	
	
	public boolean inBounds( int x, int y) {
		return x >= 0 && x< size && y>= 0  && y<size;
		
		
	}
	
	
	
	 public boolean isWall (int x, int y )    {
		 return walls[y][x];
		 
	 }
	 
	 
	 
	 
	 public boolean hasTreasure(int x, int y ) {
		 return treasures[y][x];
		 
		 
	 }
	 
	 

	 
	 public void removeTreasure(int x , int y) {
		 if(treasures [y][x]) {
			 treasures[y][x] = false;
				remainingTreasures--;
		 }
	 }
	 
	 public int getRemainingTreasures() {
		 return remainingTreasures;
	 }

}
