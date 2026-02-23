import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class BallLauncher extends GraphicsProgram{
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int SIZE = 25;
	public static final int MS = 50;
	public static final int SPEED = 2;
	
	private ArrayList<GOval> balls;
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		addMouseListeners();
		
		Timer t = new Timer(MS, this);
		
		balls = new ArrayList<GOval>();
		
		GOval baller = makeBall(50,50);
		add(baller);
		balls.add(baller);
		
		t.start();
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		for (GOval o : balls) {
			o.move(SPEED, 0);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getX() < 100) {
			return;
		}
		GOval ball = makeBall(SIZE/2, e.getY());
		balls.add(ball);
		add(ball);
	}
	
	public GOval makeBall(double x, double y) {
		GOval temp = new GOval(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
		temp.setColor(Color.RED);
		temp.setFilled(true);
		return temp;
	}
	
	public static void main(String[] args) {
		new BallLauncher().start();
	}

}
