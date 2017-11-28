package game;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
public class Frame extends JFrame implements Runnable,KeyListener {
	
	
	private Panel panel;
	private char restart = 'r';
	
	public Frame(){
		Dimension screenSize = new Dimension(855, 1943); // This is the size of the window created
		setSize(screenSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Color Switch");
		setResizable(false);
		panel = new Panel();
		panel.setSize(screenSize);
		//add(panel);
		//addMouseListener(this);
		addKeyListener(this);
		setVisible(true);
	}
	
	
	/*public void start(){
		running = true;
		thread = new Thread(this,"Display");
		thread.start();
	
	}
	
	public void stop(){
	if(running) return;
	running=false;
	try{
		thread.join();
	}
	catch(Exception e){
		
		
	}
	
	}
	*/

	@Override
	public void keyPressed(KeyEvent e) {
		panel.Click();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(restart == e.getKeyChar()){
			panel.Restart();
		}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	}


