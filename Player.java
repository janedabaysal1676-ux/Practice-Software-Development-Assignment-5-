package project_1;

public class Player extends Entity {

	public Player(int x, int y) {
		super(x, y);
	}

	@Override
	public void move(char direction, Map map) {
	
		
		int nx = x;
		int ny = y;
		
		
		
		switch (direction) {
		case 'W' : ny += 1; break;  //up
		case 'S' : ny -= 1; break;  //down
		case 'A' : nx -= 1; break;  //left
		case 'D' : nx += 1; break;  //right
		
		default:
			return;
		}
		
		if(!map.inBounds(nx, ny)) {
			System.out.println(" you cannot leave the map");
			return;
		}
		
		if(map.isWall(nx , ny))  {
			System.out.println (" you hit a wall ");
			return;
		}
		 
		x = nx;
		y = ny;
	}
	
}
	
	
