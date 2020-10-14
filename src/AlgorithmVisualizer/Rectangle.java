package AlgorithmVisualizer;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle {
	private int x;
	private int height;
	private int width;
	private Color color;
	
	
	public Rectangle(int height, int width, Color color) {
		this.height = height;
		this.width = width;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setColor(this.color);
//		g.drawRect(this.x, 700 - this.height, this.width, this.height);
		g.fillRect(this.x, 700 - this.height, this.width, this.height);
		g.drawLine(this.x, 700 - this.height, this.x, this.height );
	}
	
	public void clear(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(this.x, 700 - this.height, this.width, this.height);
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	

}
