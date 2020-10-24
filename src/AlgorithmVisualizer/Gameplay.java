package AlgorithmVisualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements ActionListener{
	private Rectangle[] rectangles;
	private int[] rectangleHeights;
	private int totalRectangles;
	private int rectangleWidth;
	boolean start = true;
	
	private Timer timer;
	private int delay = 8;
	
	public Gameplay(int totalRectangles) throws InterruptedException {
		this.totalRectangles = totalRectangles;
		this.rectangles = new Rectangle[this.totalRectangles];
		this.rectangleWidth = 650 / this.totalRectangles;
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);

		timer = new Timer(totalRectangles, this);
		timer.start();
		makeRectangles();
	}
	
	public void paint(Graphics g) {
		
		// Background
		drawBackground(g);
		
		// Shuffle Rectangles
		if(start) {
			start = false;
//			try {
//				shuffleRectangles();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		// Rectangles
		try {
			drawRectangles(g);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Line
		g.setColor(Color.white);
		g.drawLine(66, 700, 66 + ((this.totalRectangles) * rectangleWidth), 700);

		g.dispose();
	}
	
	public void makeRectangles() {
		// Make 100 rectangles with different unique heights between 1 - 100, and with different colors
		for(int i = 0; i < this.totalRectangles; i++) {
			Rectangle curr = new Rectangle((i + 1) * 10, rectangleWidth, Color.white);
			curr.setX(66 + (i * rectangleWidth));
			rectangles[i] = curr;
		}
	}
	
	public void drawRectangles(Graphics g) throws InterruptedException {
		for(int i = 0; i < this.totalRectangles; i++) {
			rectangles[i].draw((Graphics2D) g, true);
		}
	}
	
	public void drawBackground(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 792, 792);
	}
	
	public void shuffleRectangles() throws InterruptedException {
		for(int i = 0; i < rectangles.length; i++) {
			rectangles[i].setColor(Color.white);
		}
		// Shuffles the rectangles in place
		for(int i = 0; i < this.totalRectangles; i++) {
			int rand = (int) ((Math.random() * (this.totalRectangles - i)) + i);
			
		
			
			int randRectHeight = this.rectangles[rand].getHeight();
			int currHeight = this.rectangles[i].getHeight();
			int temp = randRectHeight;
			
//			this.rectangles[rand].setColor(Color.darkGray);
//			this.rectangles[i].setColor(Color.darkGray);
//			this.rectangles[rand].draw((Graphics2D) getGraphics(), true);
//			this.rectangles[i].draw((Graphics2D) getGraphics(), true);	
			
			this.rectangles[rand].setHeight(currHeight);
			this.rectangles[i].setHeight(temp);
			
			this.rectangles[rand].setColor(Color.blue);
			this.rectangles[i].setColor(Color.white);
			System.out.println("hi");
			
//			this.rectangles[rand].draw((Graphics2D) getGraphics(), true);
//			this.rectangles[i].draw((Graphics2D) getGraphics(), true);	
			
			drawBackground(getGraphics());
			drawRectangles(getGraphics());
			TimeUnit.MILLISECONDS.sleep(35);
			if(i != rand) {
				this.rectangles[rand].setColor(Color.white);
			}

		}
		repaint();
	}
	
	public void clearRectangles(int firstHeight, int secondHeight, int firstX, int secondX) {
		// Draw background each time instead
		this.repaint();
//		Rectangle curr = new Rectangle(firstHeight, rectangleWidth, Color.DARK_GRAY);
//		curr.setX(firstX);
//		curr.clear(getGraphics());
////		curr.draw(getGraphics());
//		
//		curr = new Rectangle(secondHeight, rectangleWidth, Color.DARK_GRAY);
//		curr.setX(secondX);
//		curr.clear(getGraphics());
//		curr.draw(getGraphics());
	}
	
	public int[] getRectangleHeights() {
		return this.rectangleHeights;
	}
	
	public Rectangle[] getRectangles() {
		return this.rectangles;
	}
	
	public void setRectangleHeights(int[] rectangleHeights) {
		this.rectangleHeights = rectangleHeights;
	}
	
	public int getRectangleWidth() {
		return this.rectangleWidth;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
