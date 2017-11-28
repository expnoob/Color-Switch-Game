package game;

public class Background {

	private int bottomY;
	private int topY;
	private int[] cutOutPosition = new int[2];
	private double xPosition;
	
	public Background(){
		bottomY = (int)(Math.random() * 101);
		topY = bottomY + 150;
		cutOutPosition[0] = topY;
		cutOutPosition[1] = bottomY;
		xPosition = 855;
	}
	
	public int getXPosition(){
		return (int)xPosition;
	}
	
	public void Update(){
		xPosition -= 0.1;
		
		if(xPosition <= -Constants.RECTHEIGHT){
			bottomY = (int)(Math.random() * 240);
			topY = bottomY + 150;
			cutOutPosition[0] = topY;
			cutOutPosition[1] = bottomY;
			xPosition = 640;
		}
	}
	
	public int[] getCutOutPosition(){
		return cutOutPosition;
	}
}
