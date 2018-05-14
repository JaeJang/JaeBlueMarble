package version2;


import java.awt.Graphics;

public abstract class GameObject {
	
	protected double x,y;
	protected double velX, velY;
	protected ID id;
	protected int owned;
	protected int panel;
	protected int buy, rent;
	protected boolean sell, sellChoice;
	protected String name;
	
	public GameObject(double x, double y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract int getPointX1();
	public abstract int getPointX2();
	public abstract int getPointY();
	public abstract int getCityID();
	
	
	public void setY(int y){
		this.y = y;
		
	}
	public void setX(int x){
		this.x = x;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public double getVelX(){
		return velX;
	}
	public double getVelY(){
		return velY;
	}
	public void setOwned(int owned){
		this.owned = owned;
	}
	public int getOwned(){
		return owned;
	}
	public void setPanel(int panel){
		this.panel = panel;
	}
	public int getBuy(){
		return buy;
	}
	public String getName(){
		return name;
	}
	public int getRent(){
		return rent;
	}
	public boolean setSell(boolean sell){
		return this.sell = sell; 
	}
	public boolean setSellChoice(boolean sell){
		return this.sellChoice = sellChoice; 
	}
	
}
