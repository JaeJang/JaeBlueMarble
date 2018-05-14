package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class BlueCard  extends GameObject{
	
	private int x,y,cityID;
	private ID id;
	private Handler handler;
	private User user1, user2;
	private String name;
	private String content = "";
	private int xCityWidth = MainBoard.xCityWidth;
	private int yBox = MainBoard.yBox;
	private int yPosition = MainBoard.yellowYPosition;
	
	private int yCityWidth = MainBoard.yCityWidth;
	private int xBox = MainBoard.xBox;
	private int xPositon = MainBoard.greenXPosition;
	
	
	private int yTop = MainBoard.yTop;
	private int redYPosition = MainBoard.redYPosition;
	
	private int xLeft = MainBoard.xLeft;
	private int navyXPosition = MainBoard.navyXPosition;
	
	private int timer = 35;
	private int money = 0;
	NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
	
	public BlueCard(double x, double y, int cityID, ID id, String name, Handler handler){
		super(x, y, id);
		this.x = (int)x;
		this.y = (int)y;
		this.cityID = cityID;
		this.id = id;
		this.name = name;
		this.handler = handler;
		
	}
	
	public void tick(){
		if(Game.gameState == Game.STATE.Game){
			user1 = (User)handler.object.get(27);
			user2 = (User)handler.object.get(28);
			/*for (int i = 0; i < handler.object.size(); i++) {
				GameObject temp = handler.object.get(i);
				if (temp.getId() == ID.Player1) {
					user1 = (User) handler.object.get(i);

				} else if (temp.getId() == ID.Player2) {
					user2 = (User) handler.object.get(i);
				}
			}
			System.out.println("userloca: " + user1.getUserLoca());
			System.out.println("cityID: " + cityID);
			System.out.println("usex: " + user1.getUserX());
			System.out.println("userY: " + user1.getUserY());
			System.out.println("pointX: " + getPointX1());
			System.out.println("pointY: " + getPointY());
			System.out.println();*/
			//handler.user_city(user2.getUserLoca(), cityID, user2.getUserX(), user2.getUserY(), getPointX2(), getPointY())
			// Game.turn == Game.TURN.Player2 && MouseInput.moved2
			if(Game.turn == Game.TURN.Player1 && MouseInput.moved1){
				if(handler.user_city(user1.getUserLoca(), cityID, user1.getUserX(), user1.getUserY(), getPointX1(), getPointY())){
					if (timer > 0) {
						timer--;
					} else if (timer <= 0){
						cardContent();
					}
				}
			} else if(Game.turn == Game.TURN.Player2 && MouseInput.moved2){
				if(handler.user_city(user2.getUserLoca(), cityID, user2.getUserX(), user2.getUserY(), getPointX2(), getPointY())){
					if(timer > 0){
						timer--;
					} else if(timer <= 0){
						cardContent();
					}
				}
				
			}
			
		}
	}
	
	public void render(Graphics g){
		Font fnt = new Font("Impact", 1, 15);
		Font fnt2 = new Font("Impact", 2, 60);
		Font fnt3 = new Font("Impact", 1, 35);
		Font fnt4 = new Font("Impact", 1, 25);
		fmt.setMaximumFractionDigits(0);
		g.setColor(Color.black);
		if(cityID == 4){
			g.drawLine(x + xCityWidth + 7, y, x + xCityWidth+ 7, yBox);
			g.setColor(new Color(0, 131, 255));
			g.fillRect(x, y, xCityWidth+7, 30);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString(name, x+5+7, yPosition+50);
		}
		if(cityID == 11){
			g.drawLine(x, y - yCityWidth, xBox, y - yCityWidth);
			g.setColor(new Color(0, 131, 255));
			g.fillRect(x, y - yCityWidth + 1, 30, yCityWidth - 1);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString(name, x+35, y- 70);
		}
		
		if(cityID == 16){
			g.drawLine(x - xCityWidth - 7, y, x - xCityWidth - 7, yTop);
			g.setColor(new Color(0, 131, 255));
			g.fillRect(x - xCityWidth - 7, y - 30, xCityWidth + 7, 30);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString(name, x-105 - 7, y - 110);
		}
		if(cityID == 23){
			g.drawLine(x, y + yCityWidth, xLeft, y + yCityWidth);
			g.setColor(new Color(0, 131, 255));
			g.fillRect(x - 30, y+1, 30, yCityWidth-1);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString(name, 10, y+17);
		}
		
		if(Game.display == Game.DISPLAY.BlueCard){
			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(5, 5, 1045, 695);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(340, 220, 400, 330);
			g.setColor(Color.white);
			g.drawRect(340, 150, 400, 400);
			g.setColor(new Color(0, 131, 255));
			g.fillRect(340, 150, 400, 70);
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString("Blue Card", 345, 200);
			g.setFont(fnt3);
			g.drawString(content, 370, 280);
			g.drawString("" + fmt.format(money), 470, 350);
			g.setColor(Color.white);
			g.fillRect(470, 450, 150, 50);
			g.setColor(Color.black);
			g.setFont(fnt4);
			g.drawString("Okay", 515, 485);
		}
	}
	
	public int getCityID(){
		return cityID;
	}

	@Override
	public int getPointX1() {
		if(cityID == 4) return x + 10;
		else if(cityID == 11) return 930;
		else if(cityID == 16) return x - 100;
		else return 50;
		//if(cityID == 23) return y + 40;
		
	}

	@Override
	public int getPointX2() {
		if(cityID == 4) return x + 60;
		else if(cityID == 11) return 970;
		else if(cityID == 16) return x - 50;
		else return 100;
	}

	@Override
	public int getPointY() {
		if(cityID == 4) return 650;
		else if(cityID == 11) return y - 55;
		else if(cityID == 16) return 40;
		else return y + 40;
	}
	
	private void cardContent(){
		Game.display = Game.DISPLAY.BlueCard;
		if(MouseInput.card == 1){
			content = "You won the lottery!";
			money = 200;
		} else if(MouseInput.card == 2){
			content = "You robbed";
			money = -100;
		} else if(MouseInput.card == 3){
			content = "You are locky";
			money = 100;
		}else if(MouseInput.card == 4){
			content = "Thanks for donation!";
			money = -100;
		}
	}

}
