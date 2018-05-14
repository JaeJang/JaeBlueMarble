package version2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

public class Game extends Canvas implements Runnable {
	
	private Thread thread;
	ImageIcon icon;
	GetUser getuser;
	Window window;
	Handler handler;
	UserName un;
	MainBoard mainboard;
	Dice dice;
	UnderBalance underbal;
	GameOver gameover;
	
	private boolean running = false;
	
	public static int xCityWidth = 113;
	public static int yBox = 700;
	public static int yellowYPosition = 570;
	private String yellowCities[] = { "Istanbul", "Cairo", "Singapore", "Blue Card", "Victoria", "Hong Kong" };

	public static int yCityWidth = 87;
	public static int xBox = 1050;
	public static int greenXPosition = 870;
	private String greenCities[] = { "Zurich", "Copenhagen", "Berlin", "Blue Card", "Stockholm" };

	public static int yTop = 5;
	public static int redYPosition = 135;
	private String redCities[] = { "Sydney", "Sao Paulo", "Blue Card", "Toronto", "Hawaii", "Madrid"};
	
	public static int xLeft = 5;
	public static int navyXPosition = 185;
	private String navyCities[] = {"Tokyo", "Paris", "Blue Card", "London", "Vancouver"};

	
	public static enum STATE {
		Username,
		Menu,
		Game
	};
	public static enum TURN{
		Player1,
		Player2
	};
	public static enum DISPLAY{
		Board,
		New,
		OwnedByTheOther,
		UnderBal,
		Sell,
		BlueCard,
		Desert1,
		Desert2,
		End
	};
	
	public static DISPLAY display = DISPLAY.Board;
	public static TURN turn = TURN.Player1;
	public static STATE gameState = STATE.Username;
	
	public Game(){
		new Window("Blue Marble", this);
		
		handler = new Handler();
		un = new UserName();
		//if(gameState == STATE.Username){
		getuser = new GetUser(handler, this);
			this.addKeyListener(new KeyUser(handler, this));
			this.addMouseListener(new MouseInput(handler, this));
		//}
		//mainboard = new MainBoard(handler);
		dice = new Dice(handler);
		underbal = new UnderBalance();
		gameover = new GameOver(handler);
		//if(gameState == STATE.Game){
			handler.addObject(new MainBoard( 0, 0, ID.MainBoard,handler));
			
			handler.addObject(new StartPoint(0, 0, 0, ID.Start, handler));
			handler.addObject(new DesertIsland(0, 0, 7, ID.DeserIsland, handler));
			handler.addObject(new SocialWelfare(0, 0, 13, ID.SocialWelfare, handler));
			handler.addObject(new SpaceTrip(0,0,20, ID.SpaceTrip, handler));
			for (int i = 0; i < yellowCities.length; i++) {
				if (yellowCities[i].equals("Blue Card")) {
					handler.addObject(new BlueCard(185 + xCityWidth * i, yellowYPosition, i + 1, ID.Yellow,
							yellowCities[i], handler));
				} else {
					handler.addObject(new YellowLine(185 + xCityWidth * i, yellowYPosition, i + 1, ID.Yellow,
							yellowCities[i], handler));
				}
			}
			for (int i = 0; i < greenCities.length; i++) {
				if (greenCities[i].equals("Blue Card")) {
					handler.addObject(new BlueCard(greenXPosition, 570 - yCityWidth * i, i + 8, ID.Green, greenCities[i], handler));
				} else {
					handler.addObject(new GreenLine(greenXPosition, 570 - yCityWidth * i, i + 8, ID.Green,
							greenCities[i], handler));
				}
			}

			for (int i = 0; i < redCities.length; i++) {
				if(redCities[i].equals("Blue Card")){
					handler.addObject(new BlueCard(870 - xCityWidth*i,redYPosition, i+14, ID.Red, redCities[i], handler));
					
				} else{
					handler.addObject(new RedLine(870 - xCityWidth*i,redYPosition, i+14, ID.Red, redCities[i], handler));
				}
				
			}
			
			for(int i = 0; i < navyCities.length; i++){
				if(navyCities[i].equals("Blue Card")){
					handler.addObject(new BlueCard(navyXPosition, 135 + yCityWidth*i, i+21, ID.Navy, navyCities[i], handler));
				} else {
					handler.addObject(new NavyLine(navyXPosition, 135 + yCityWidth*i, i+21, ID.Navy, navyCities[i], handler));
				}
			}
		
		//}
		
	}
	
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
		//game loop
		
		//자동으로 창에 포커스
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now =  System.nanoTime();
			delta += (now - lastTime) /  ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running){
				render();
			}
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		if(gameState == STATE.Game){
			dice.tick();
		}
		handler.tick();
		if(gameState == STATE.Username){
			getuser.tick();
		}
		gameover.tick();
		
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		icon = new ImageIcon("images/background.jpg");
		g.drawImage(icon.getImage(), 0, 0, null);
		//setOpaque(false);
		if(gameState == STATE.Game){
			handler.render(g);
			dice.render(g);
		}
		
		if(gameState == STATE.Username){
			un.render(g);
			getuser.render(g);
		} else if(gameState == STATE.Game){
			
			if(display != DISPLAY.Sell){
				for(int i = 0; i < handler.object.size(); i++){
					GameObject tempObject = handler.object.get(i);
					if(User.user1Loca != 0 && Game.turn == Game.TURN.Player1){
						if(User.user1Loca == tempObject.getCityID()) 	tempObject.render(g);
					}
					if(User.user2Loca != 0 && Game.turn == Game.TURN.Player2){
						if(User.user2Loca == tempObject.getCityID())	tempObject.render(g);
					}
				}
			}
			else{
				GameObject tempObject = handler.object.get(MouseInput.sellSelected);
				tempObject.render(g);
			}
			
			if(gameState != STATE.Username && display ==DISPLAY.Board){
				User user1 = (User)handler.object.get(27);
				user1.render(g);
				User user2 = (User)handler.object.get(28);
				user2.render(g);
			}
			underbal.render(g);
			gameover.render(g);
			
		}
		
		
		g.dispose();
		bs.show();
	}
	public static void main(String[] args) {
		new Game();

	}

	

}
