package soundground;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class BallMaker {
	private PApplet app;
	public Ball[] ballArray = new Ball[500];
	private int numBalls;
	private ArrayList<Integer> colors;

	public BallMaker(int pNumBalls, float pBounce, PApplet appRef) {
		app = appRef;
		numBalls = pNumBalls;
		
		colors = new ArrayList<Integer>();
		colors.add(app.color(25,135,240));
		colors.add(app.color(240,10,10));
		colors.add(app.color(240,240,10));
		colors.add(app.color(0,205,10));
		
		Random random = new Random();
		for (int i = 0; i < numBalls; i++) {
			int index = random.nextInt(colors.size());
	        int color = colors.get(index);
			ballArray[i] = new Ball(color, app.random(0, Global.screenWidth), 0, app.random(-1, 1), app.random(-10, 10), app);
			ballArray[i].bounce = pBounce;
		}
	} 

	public void update(float y) {
		for (int i = 0; i < numBalls; i++) {
			ballArray[i].ground = y; 
			ballArray[i].update();
		}
	}

	public void draw(){
		for (int i = 0; i < numBalls; i++) {
			ballArray[i].draw(); 
		}
	}
	
	public void kill(){
		for (int i = 0; i < ballArray.length; i++) {
			ballArray[i] = null; 
		}
	}
}
