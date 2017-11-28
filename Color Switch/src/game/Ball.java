package game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Ball {
	
	private double yPosition;
	private double ySpeed;
	private int x;
	
	public Ball(){
		yPosition = 101;
		ySpeed = 0;
	}
	
	public void jump(){
		ySpeed = 0.25;
	}
	
	public void Update(){
		ySpeed += Constants.GRAVITY;
		yPosition -= ySpeed;
	}
	
	public int getYPosition(){
		return (int)yPosition;
	}
	
	public int isGoingUp(){
		if(ySpeed > 0)
			return 1;
		return 0;	
	}
	
	public int isGoingDown(){
		if(ySpeed < 0)
			return 0;
		return 0;
	}

}
