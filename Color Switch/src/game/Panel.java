package game;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
public class Panel {

	
	private long lastRepaint;
	private BufferedImage Background;
	private BufferedImage GameOver;
	private BufferedImage Balls;
	private boolean gameOver;
	private double Score;
	
	URL Up;
	
	
	Background W;
	Ball B;
	AudioClip Flap;
	AudioClip oneUp;
	
	
	
	public Panel() {
		
		W = new Background();
		B = new Ball();
		
			Score = 0;
			try{
				Balls = ImageIO.read(new File("images//ball//pink.png"));
			Background = ImageIO.read(new File("images//background.png"));
			}
			catch(Exception e){
				
			}
			
			Up = Panel.class.getResource("sounds//Color Switch Sound Track.mp3");
	
			oneUp = Applet.newAudioClip(Up);
			
			lastRepaint = System.currentTimeMillis();
			gameOver = false;
	
	}
	
	
	public void Click(){
		B.jump();
		if(gameOver == false){
		}
		
	}
	
	public void Update(){
		B.Update();
	}
	
	public void Restart(){
		if(gameOver){
			B = new Ball();
			W = new Background();
			gameOver = false;
			Score = 0;
				
		}
	}
	
	public void Music(File Sound){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
	
	public void paintComponent(Graphics g) {
		if(gameOver){
			g.drawImage(GameOver, 0, 0, null);
			Graphics2D g3 = (Graphics2D) g;
			Font Rewind = new Font("Sans", Font.BOLD, 50);
			
    		g3.setFont(Rewind);
    		g3.setColor(Color.WHITE);
    		g3.drawString("Your Final Score is: " + (int)Score + "", 70, 400);
    		g3.dispose();
			

		}
      else{
			
			Rectangle RECTTOP = new Rectangle(W.getXPosition(), 0, Constants.RECTHEIGHT, W.getCutOutPosition()[1]);
	
			Rectangle RECTBOT = new Rectangle(W.getXPosition(), W.getCutOutPosition()[0], Constants.RECTHEIGHT,93 - W.getCutOutPosition()[0]);
	
			Rectangle BALL = new Rectangle(50, B.getYPosition(), 20, 19);
			
			g.fillRect(0, 0, 855, 1943);
	
			g.drawImage(Background, 0, 0, null);
			
			g.drawImage(Balls,50, B.getYPosition(), null);
	
			W.Update();
			if(BALL.intersects(RECTTOP) || BALL.intersects(RECTBOT) || B.getYPosition() == 855){
			gameOver = true;
			}
	
			if(W.getXPosition() == 50){
				if(B.getYPosition() > 0){
					Score += 0.10000000001;
					oneUp.play();
				}
				else{
					gameOver = true;
				}
				
			}
			
			
			Graphics2D g2 = (Graphics2D) g;
			Font Rewind = new Font("Kindly Rewind.tff", Font.BOLD, 75);
			
    		g2.setFont(Rewind);
    		g2.setColor(Color.CYAN);
    		g2.drawString((int)Score + "", 50, 60);
    		g2.dispose();
      }
	
		try {
			if (System.currentTimeMillis() > lastRepaint + 16) {
				// No wait for refresh, because the program lagged.
			} else {
				Thread.sleep(16);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		//repaint();
	
	}


	public void setSize(Dimension screenSize) {
		
	}
	
	}
