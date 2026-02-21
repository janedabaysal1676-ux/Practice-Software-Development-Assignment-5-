package project_1;

public abstract class Entity {
	
	protected int x;
	protected int y;
	
	
	public Entity(int x , int y)    {
		this.x= x;
		this.y= y;
		
	}
	
	public int getX()  {return x;}
	public int getY()   {return y;}
	
	
	public abstract void move (char direction, Map map);
	
	
	

}
