package version2;

import java.awt.Color;
import java.awt.Graphics;

public class UserCityName {
	
	private final int BOXSIZE = 40;
	private final int BOXXPOSITION = 1070;
	private final int YELLOWNAME_Y1 = 95;
	private final int YELLOWNAME_Y2 = 450;
	private final int GREEN_Y1 = 155;
	private final int GREEN_Y2 = YELLOWNAME_Y2 + 60;
	private final int RED_Y1 = 215;
	private final int RED_Y2 = YELLOWNAME_Y2 + 120;
	private final int NAVY_Y1 = 275;
	private final int NAVY_Y2 = YELLOWNAME_Y2 + 180;
	private final int FONTHEIGHT = 15;
	
	
	Handler handler;
	ID id;
	
	public UserCityName(Handler handler, ID id){
		this.handler = handler;
		this.id = id;
	}
	
	private void ownedCity(GameObject temp, int cityID, int x, int y, Color color, Graphics g, ID id){
		if(temp.getCityID() == cityID){
			if(temp.getOwned() == 0) g.setColor(Color.black);
			if(id == ID.Player1){
				if(temp.getOwned() == 1) g.setColor(color);
				else if(temp.getOwned() ==2) g.setColor(Color.black);
			}
			if(id == ID.Player2){
				if(temp.getOwned() == 2) g.setColor(color);
				else if(temp.getOwned() ==1) g.setColor(Color.black);
			}
			//else if(temp.getOwned() == 1) g.setColor(color);
			g.drawString(temp.getName(), x, y);
		}
	}
	
	public void render(Graphics g){
		if(id == ID.Player1){
			//yellow
			for(int i = 0; i < handler.object.size(); i++){
				GameObject temp = handler.object.get(i);
				ownedCity(temp, 1, BOXXPOSITION + 40, YELLOWNAME_Y1, new Color(236, 255, 119), g, ID.Player1);
				ownedCity(temp, 2, BOXXPOSITION + 130, YELLOWNAME_Y1, new Color(236, 255, 119), g, ID.Player1);
				ownedCity(temp, 3, BOXXPOSITION + 190, YELLOWNAME_Y1, new Color(236, 255, 119), g, ID.Player1);
				ownedCity(temp, 5, BOXXPOSITION + 40, YELLOWNAME_Y1+23, new Color(236, 255, 119), g, ID.Player1);
				ownedCity(temp, 6, BOXXPOSITION + 130, YELLOWNAME_Y1+23, new Color(236, 255, 119), g, ID.Player1);
				ownedCity(temp, 8, BOXXPOSITION + 40, GREEN_Y1, new Color(0, 255, 203), g, ID.Player1);
				ownedCity(temp, 9, BOXXPOSITION + 100, GREEN_Y1, new Color(0, 255, 203), g, ID.Player1);
				ownedCity(temp, 10,BOXXPOSITION + 40, GREEN_Y1+23, new Color(0, 255, 203), g, ID.Player1);
				ownedCity(temp, 12,BOXXPOSITION + 110, GREEN_Y1+23, new Color(0, 255, 203), g, ID.Player1);
				ownedCity(temp, 14, BOXXPOSITION + 40, RED_Y1, new Color(255, 0, 123), g, ID.Player1);
				ownedCity(temp, 15,  BOXXPOSITION + 120, RED_Y1, new Color(255, 0, 123), g, ID.Player1);
				ownedCity(temp, 17,  BOXXPOSITION + 215, RED_Y1, new Color(255, 0, 123), g, ID.Player1);
				ownedCity(temp, 18,  BOXXPOSITION + 40, RED_Y1+23, new Color(255, 0, 123), g, ID.Player1);
				ownedCity(temp, 19,  BOXXPOSITION + 120, RED_Y1+23, new Color(255, 0, 123), g, ID.Player1);
				ownedCity(temp, 21,  BOXXPOSITION + 40, NAVY_Y1, new Color(100, 101, 135), g, ID.Player1);
				ownedCity(temp, 22,  BOXXPOSITION + 110, NAVY_Y1, new Color(100, 101, 135), g, ID.Player1);
				ownedCity(temp, 24,  BOXXPOSITION + 180, NAVY_Y1, new Color(100, 101, 135), g, ID.Player1);
				ownedCity(temp, 25,  BOXXPOSITION + 40, NAVY_Y1+23, new Color(100, 101, 135), g, ID.Player1);
				
			}
			
			g.setColor(new Color(236, 255, 119));
			g.fillRect(BOXXPOSITION, 80, BOXSIZE-10, BOXSIZE);
			/*
			g.drawString("Istanbul", BOXXPOSITION + 40, YELLOWNAME_Y1);
			g.fillRect(BOXXPOSITION + 40, YELLOWNAME_Y1-15, 75, FONTHEIGHT);
			
			g.drawString("Cairo", BOXXPOSITION + 130, YELLOWNAME_Y1);
			g.fillRect(BOXXPOSITION + 130, YELLOWNAME_Y1-15, 49, FONTHEIGHT);
			
			g.drawString("Singapore", BOXXPOSITION + 190, YELLOWNAME_Y1);
			g.fillRect(BOXXPOSITION + 190, YELLOWNAME_Y1-15, 95, FONTHEIGHT);
			
			g.drawString("Victoria", BOXXPOSITION + 40, YELLOWNAME_Y1+23);
			g.fillRect( BOXXPOSITION + 40, YELLOWNAME_Y1+23-15, 70, FONTHEIGHT);
			
			g.drawString("Hong Kong", BOXXPOSITION + 130, YELLOWNAME_Y1+23);
			g.fillRect(BOXXPOSITION + 130, YELLOWNAME_Y1+23-15, 110, FONTHEIGHT);*/
			
			//green
			
			g.setColor(new Color(0, 255, 203));
			g.fillRect(BOXXPOSITION, 140, BOXSIZE - 10, BOXSIZE);
			/*
			g.drawString("Zurih", BOXXPOSITION + 40, GREEN_Y1);
			g.fillRect(BOXXPOSITION + 40, GREEN_Y1-15, 47, FONTHEIGHT);
			
			g.drawString("Copenhagen", BOXXPOSITION + 100, GREEN_Y1);
			g.fillRect(BOXXPOSITION + 100, GREEN_Y1-15, 119, FONTHEIGHT);
			
			g.drawString("Berlin", BOXXPOSITION + 40, GREEN_Y1+23);
			g.fillRect(BOXXPOSITION + 40, GREEN_Y1+23-15, 55, FONTHEIGHT);
			
			g.drawString("Stockholm", BOXXPOSITION + 110, GREEN_Y1+23);
			g.fillRect(BOXXPOSITION + 110, GREEN_Y1+23-15, 100, FONTHEIGHT);
			*/
			//red
			g.setColor(new Color(255, 0, 123));
			g.fillRect(BOXXPOSITION, 200, BOXSIZE-10, BOXSIZE);
			/*
			g.drawString("Sydney", BOXXPOSITION + 40, RED_Y1);
			g.fillRect(BOXXPOSITION + 40, RED_Y1-15, 70, FONTHEIGHT);
			
			g.drawString("SaoPaulo", BOXXPOSITION + 120, RED_Y1);
			g.fillRect(BOXXPOSITION + 120, RED_Y1-15, 89, FONTHEIGHT);
			g.drawString("Toronto", BOXXPOSITION + 215, RED_Y1);
			g.fillRect(BOXXPOSITION + 215, RED_Y1-15, 75, FONTHEIGHT);
			
			g.drawString("Hawaii", BOXXPOSITION + 40, RED_Y1+23);
			g.fillRect(BOXXPOSITION + 40, RED_Y1+23-15, 60, FONTHEIGHT);
			
			g.drawString("Madrid", BOXXPOSITION + 120, RED_Y1+23);
			g.fillRect(BOXXPOSITION + 120, RED_Y1+23-15, 65, FONTHEIGHT);
			*/
			//navy
			g.setColor(new Color(100, 101, 135));
			g.fillRect(BOXXPOSITION, 260, BOXSIZE-10, BOXSIZE);
			/*
			g.drawString("Tokyo", BOXXPOSITION + 40, NAVY_Y1);
			g.fillRect(BOXXPOSITION + 40, NAVY_Y1-15, 58, FONTHEIGHT);
			
			g.drawString("Paris", BOXXPOSITION + 110, NAVY_Y1);
			g.fillRect(BOXXPOSITION + 110, NAVY_Y1-15, 48, FONTHEIGHT);
			
			g.drawString("London", BOXXPOSITION + 180, NAVY_Y1);
			g.fillRect(BOXXPOSITION + 180, NAVY_Y1-15, 72, FONTHEIGHT);
			
			g.drawString("Vancouver", BOXXPOSITION + 40, NAVY_Y1+23);
			g.fillRect(BOXXPOSITION + 40, NAVY_Y1+23-15, 100, FONTHEIGHT);
			*/
		} else if(id == ID.Player2){
			for(int i = 0; i < handler.object.size(); i++){
				GameObject temp = handler.object.get(i);
				ownedCity(temp, 1, BOXXPOSITION + 40, YELLOWNAME_Y2, new Color(236, 255, 119), g, ID.Player2);
				ownedCity(temp, 2, BOXXPOSITION + 130, YELLOWNAME_Y2, new Color(236, 255, 119), g, ID.Player2);
				ownedCity(temp, 3, BOXXPOSITION + 190, YELLOWNAME_Y2, new Color(236, 255, 119), g, ID.Player2);
				ownedCity(temp, 5, BOXXPOSITION + 40, YELLOWNAME_Y2+23, new Color(236, 255, 119), g, ID.Player2);
				ownedCity(temp, 6, BOXXPOSITION + 130, YELLOWNAME_Y2+23, new Color(236, 255, 119), g, ID.Player2);
				ownedCity(temp, 8, BOXXPOSITION + 40, GREEN_Y2, new Color(0, 255, 203), g, ID.Player2);
				ownedCity(temp, 9, BOXXPOSITION + 100, GREEN_Y2, new Color(0, 255, 203), g, ID.Player2);
				ownedCity(temp, 10,BOXXPOSITION + 40, GREEN_Y2+23, new Color(0, 255, 203), g, ID.Player2);
				ownedCity(temp, 12,BOXXPOSITION + 110, GREEN_Y2+23, new Color(0, 255, 203), g, ID.Player2);
				ownedCity(temp, 14, BOXXPOSITION + 40, RED_Y2, new Color(255, 0, 123), g, ID.Player2);
				ownedCity(temp, 15,  BOXXPOSITION + 120, RED_Y2, new Color(255, 0, 123), g, ID.Player2);
				ownedCity(temp, 17,  BOXXPOSITION + 215, RED_Y2, new Color(255, 0, 123), g, ID.Player2);
				ownedCity(temp, 18,  BOXXPOSITION + 40, RED_Y2+23, new Color(255, 0, 123), g, ID.Player2);
				ownedCity(temp, 19,  BOXXPOSITION + 120, RED_Y2+23, new Color(255, 0, 123), g, ID.Player2);
				ownedCity(temp, 21,  BOXXPOSITION + 40, NAVY_Y2, new Color(100, 101, 135), g, ID.Player2);
				ownedCity(temp, 22,  BOXXPOSITION + 110, NAVY_Y2, new Color(100, 101, 135), g, ID.Player2);
				ownedCity(temp, 24,  BOXXPOSITION + 180, NAVY_Y2, new Color(100, 101, 135), g, ID.Player2);
				ownedCity(temp, 25,  BOXXPOSITION + 40, NAVY_Y2+23, new Color(100, 101, 135), g, ID.Player2);
				
			}
			
			//yellow
			g.setColor(new Color(236, 255, 119));
			g.fillRect(BOXXPOSITION, 80+355, BOXSIZE-10, BOXSIZE);
			/*
			g.drawString("Istanbul", BOXXPOSITION + 40, YELLOWNAME_Y2);
			g.fillRect(BOXXPOSITION + 40, YELLOWNAME_Y2-15, 75, FONTHEIGHT);
			
			g.drawString("Cairo", BOXXPOSITION + 130, YELLOWNAME_Y2);
			g.fillRect(BOXXPOSITION + 130, YELLOWNAME_Y2-15, 49, FONTHEIGHT);
			
			g.drawString("Singapore", BOXXPOSITION + 190, YELLOWNAME_Y2);
			g.fillRect(BOXXPOSITION + 190, YELLOWNAME_Y2-15, 95, FONTHEIGHT);
			
			g.drawString("Victoria", BOXXPOSITION + 40, YELLOWNAME_Y2+23);
			g.fillRect( BOXXPOSITION + 40, YELLOWNAME_Y2+23-15, 70, FONTHEIGHT);
			
			g.drawString("Hong Kong", BOXXPOSITION + 130, YELLOWNAME_Y2+23);
			g.fillRect(BOXXPOSITION + 130, YELLOWNAME_Y2+23-15, 110, FONTHEIGHT);
			*/
			//green
			g.setColor(new Color(0, 255, 203));
			g.fillRect(BOXXPOSITION, 140+355, BOXSIZE - 10, BOXSIZE);
			/*
			g.drawString("Zurih", BOXXPOSITION + 40, GREEN_Y2);
			g.fillRect(BOXXPOSITION + 40, GREEN_Y2-15, 47, FONTHEIGHT);
			
			g.drawString("Copenhagen", BOXXPOSITION + 100, GREEN_Y2);
			g.fillRect(BOXXPOSITION + 100, GREEN_Y2-15, 119, FONTHEIGHT);
			
			g.drawString("Berlin", BOXXPOSITION + 40, GREEN_Y2+23);
			g.fillRect(BOXXPOSITION + 40, GREEN_Y2+23-15, 55, FONTHEIGHT);
			
			g.drawString("Stockholm", BOXXPOSITION + 110, GREEN_Y2+23);
			g.fillRect(BOXXPOSITION + 110, GREEN_Y2+23-15, 100, FONTHEIGHT);
			*/
			//red
			g.setColor(new Color(255, 0, 123));
			g.fillRect(BOXXPOSITION, 200+355, BOXSIZE-10, BOXSIZE);
			/*
			g.drawString("Sydney", BOXXPOSITION + 40, RED_Y2);
			g.fillRect(BOXXPOSITION + 40, RED_Y2-15, 70, FONTHEIGHT);
			
			g.drawString("SaoPaulo", BOXXPOSITION + 120, RED_Y2);
			g.fillRect(BOXXPOSITION + 120, RED_Y2-15, 89, FONTHEIGHT);
			g.drawString("Toronto", BOXXPOSITION + 215, RED_Y2);
			g.fillRect(BOXXPOSITION + 215, RED_Y2-15, 75, FONTHEIGHT);
			
			g.drawString("Hawaii", BOXXPOSITION + 40, RED_Y2+23);
			g.fillRect(BOXXPOSITION + 40, RED_Y2+23-15, 60, FONTHEIGHT);
			
			g.drawString("Madrid", BOXXPOSITION + 120, RED_Y2+23);
			g.fillRect(BOXXPOSITION + 120, RED_Y2+23-15, 65, FONTHEIGHT);
			*/
			//navy
			g.setColor(new Color(100, 101, 135));
			g.fillRect(BOXXPOSITION, 260+355, BOXSIZE-10, BOXSIZE);
			/*
			g.drawString("Tokyo", BOXXPOSITION + 40, NAVY_Y2);
			g.fillRect(BOXXPOSITION + 40, NAVY_Y2-15, 58, FONTHEIGHT);
			
			g.drawString("Paris", BOXXPOSITION + 110, NAVY_Y2);
			g.fillRect(BOXXPOSITION + 110, NAVY_Y2-15, 48, FONTHEIGHT);
			
			g.drawString("London", BOXXPOSITION + 180, NAVY_Y2);
			g.fillRect(BOXXPOSITION + 180, NAVY_Y2-15, 72, FONTHEIGHT);
			
			g.drawString("Vancouver", BOXXPOSITION + 40, NAVY_Y2+23);
			g.fillRect(BOXXPOSITION + 40, NAVY_Y2+23-15, 100, FONTHEIGHT);*/
		} 
		
	} 
	
	

}
