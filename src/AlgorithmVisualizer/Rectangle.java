package AlgorithmVisualizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle {
	private int x;
	private int height;
	private int width;
	private boolean border;
	private Color color;
	
	
	public Rectangle(int height, int width, Color color) {
		this.height = height;
		this.width = width;
		this.color = color;
		this.border = true;
	}
	
	public void draw(Graphics2D g, boolean border) {		
		g.setColor(this.color);
		g.fillRect(this.x, 700 - this.height, this.width, this.height);
		
//		if(border) {
//			g.setStroke(new BasicStroke(3));
//			g.setColor(Color.black);
//			g.drawRect(this.x, 700 - this.height, this.width, this.height);
//		}
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
