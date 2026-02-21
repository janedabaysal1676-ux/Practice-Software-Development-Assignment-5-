package project_1;


import java.util.Random;


public class Guard extends Entity {

	
	
	private static final char[] DIRS = { 'W' , 'A', 'S','D'};
	private Random rnd = new Random();
	
	

	public Guard(int x, int y) {
		super(x, y);
	}
		
		
		@Override
	public void move(char ignored, Map map) {
			
			
		char dir = DIRS[rnd.nextInt(DIRS.length)];
		int nx = x;
		int ny = y;
		
		
		switch (dir)  {
		case 'W' : ny += 1; break;
		case 'S' : ny -= 1; break;
		case 'A' : nx -= 1; break;
		case 'D' : nx += 1; break;
		}
		
		
		if(!map.inBounds(nx, ny)) return;
		if(map.isWall(nx, ny)) return ;
		
		x= nx;
		y= ny;
		
		
		
	
	}

	
		
	}
	
