package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class MainBoard extends GameObject{

	Handler handler;
	Font fnt = new Font("arila", 1, 45);
	public static int xCityWidth = 113;
	public static int yBox = 700;
	public static int yellowYPosition = 570;

	public static int yCityWidth = 87;
	public static int xBox = 1050;
	public static int greenXPosition = 870;

	public static int yTop = 5;
	public static int redYPosition = 135;
	
	public static int xLeft = 5;
	public static int navyXPosition = 185;

	// ImageIcon image = new
	// ImageIcon("C:/Users/JaeHyeok/Desktop/images/arrow.png");

	public MainBoard(double x, double y , ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {

	}
	
	@Override
	public void render(Graphics g) {
		if(Game.gameState == Game.STATE.Game){
		g.setColor(new Color(0,0,0, 200));
		g.fillRect(5, 5, 1045, 695);
		g.setColor(Color.white);
		g.drawLine(5, 570, 1050, 570);
		g.drawLine(185, 5, 185, 700);
		g.drawLine(5, 135, 1050, 135);
		g.drawLine(870, 5, 870, 700);}
		/*
		StartPoint startpoint = new StartPoint(0, 0, 0, ID.Start);
		handler.addObject(startpoint);
		DesertIsland desertisland = new DesertIsland(0, 0, 7, ID.DeserIsland);
		handler.addObject(desertisland);
		g.setColor(Color.yellow);
		for (int i = 0; i < yellowCities.length; i++) {
			if (yellowCities[i].equals("Blue Card")) {
				BlueCard bluecard = new BlueCard(185 + xCityWidth * i, yellowYPosition, i + 1, ID.Yellow,
						yellowCities[i]);
				handler.addObject(bluecard);
			} else {
				YellowLine yellowline = new YellowLine(185 + xCityWidth * i, yellowYPosition, i + 1, ID.Yellow,
						yellowCities[i]);
				handler.addObject(yellowline);
			}
		}
		for (int i = 0; i < greenCities.length; i++) {
			if (greenCities[i].equals("Blue Card")) {
				BlueCard bluecard = new BlueCard(greenXPosition, 570 - yCityWidth * i, i + 8, ID.Green, greenCities[i]);
				handler.addObject(bluecard);
				bluecard.render(g);
			} else {
				GreenLine greenline = new GreenLine(greenXPosition, 570 - yCityWidth * i, i + 8, ID.Green,
						greenCities[i]);
				handler.addObject(greenline);
			}
		}

		for (int i = 0; i < redCities.length; i++) {
			if(redCities[i].equals("Blue Card")){
				BlueCard bluecard =  new BlueCard(870 - xCityWidth*i,redYPosition, i+14, ID.Red, redCities[i]);
				handler.addObject(bluecard);
				
			} else{
				RedLine redline = new RedLine(870 - xCityWidth*i,redYPosition, i+14, ID.Red, redCities[i]);
				handler.addObject(redline);
			}
			
		}
		
		for(int i = 0; i < navyCities.length; i++){
			if(navyCities[i].equals("Blue Card")){
				BlueCard bluecard = new BlueCard(navyXPosition, 135 + yCityWidth*i, i+21, ID.Navy, navyCities[i]);
				handler.addObject(bluecard);
			} else {
				NavyLine navyline = new NavyLine(navyXPosition, 135 + yCityWidth*i, i+21, ID.Navy, navyCities[i]);
				handler.addObject(navyline);
			}
		}*/
		

	}

	@Override
	public int getPointX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPointX2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPointY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCityID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
