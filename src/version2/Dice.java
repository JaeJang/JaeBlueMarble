package version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;

public class Dice {
	
	private int x, y;
	Handler handler;
	Random r = new Random();
	public static boolean diceClicked = false;
	//public static boolean diceClicked2 = false;
	public static boolean doubled = false;
	
	public static int firstDice = 0;
	public static int secondDice = 0;
	public static int doubledDice = 0;
	
	private int firstDice2 = 0;
	private int secondDice2 = 0;
	
	public Dice(Handler handler){
		this.handler = handler;
	}
	
	public void tick(){
		
		if(diceClicked){
			firstDice = r.nextInt(3) + 1 ;
			firstDice2 = firstDice;
			diceClicked = false;
		//}
		//if(diceClicked2){
			secondDice = r.nextInt(3) + 1;
			//diceClicked2 = false;
			secondDice2 = secondDice;
		}
		//if(firstDice == )
		
		/*
		if(firstDice == secondDice){
			doubledDice =  doubledDice + firstDice * 2;
			MouseInput.rolled = 0;
			//firstDice = 0;
			//secondDice = 0;
		}*/
		/*
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player1) tempObject.setVelX(firstDice + secondDice);
		}*/
		/*
		if(doubledDice ==0) System.out.println(firstDice + secondDice);
		else System.out.println(doubledDice);*/
	}
	
	public void render(Graphics g){
		ImageIcon icon = new ImageIcon("images/dice.png");
		g.drawImage(icon.getImage(), 580, 330,100,100, null);
		g.setColor(Color.white);
		g.drawRect(400, 300, 300, 150);
		g.drawRect(399,299,302,152);
		
		/*g.setColor(Color.red);
		g.fillRect(615, 355, 80, 50);*/
		
		g.setColor(Color.white);
		Font fnt = new Font("arial", 1, 40);
		g.setFont(fnt);
		g.drawString(""+firstDice2, 420, 395);
		g.drawString(""+secondDice2, 480, 395);
		
	}
}
