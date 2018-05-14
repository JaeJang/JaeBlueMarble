package version2;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i =0; i < object.size(); i ++){
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	public void render(Graphics g){
		for(int i = 0; i< object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public boolean user_city(int userLoca, int cityID, int userX, int userY, int pointX, int pointY){
		if((userLoca == cityID && (userX == pointX || userX == pointX+1 || userX == pointX-1) 
				&& (userY == pointY || userY == pointY+1 || userY == pointY-1))) return true;
		else return false;
	}
	

}
