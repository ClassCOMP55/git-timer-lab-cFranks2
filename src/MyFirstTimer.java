import acm.graphics.*;
import acm.program.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFirstTimer extends GraphicsProgram {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	private GLabel myLabel;
	private int calls;
	private Timer t;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		myLabel = new GLabel("# of times called?", 0, 100);
		add(myLabel);
		t = new Timer(1000, this);
		t.setInitialDelay(3000);
		t.start();
		
		calls = 0;
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		myLabel.move(5, 0);
		calls += 1;
		
		myLabel.setLabel("Times called? " + calls);
		
		if (calls >= 10) {
			t.stop();
		}
	}
	
	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}