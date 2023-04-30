package acsse.csca2a.GUI;

/**
 * @author MT Lubisi
 */

import acsse.csca2a.VisitorPattern.DrawCanvasVisitor;
import acsse.csca2a.VisitorPattern.SafeArea;
import acsse.csca2a.VisitorPattern.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class BackCanvas extends Canvas{
	
	DrawCanvasVisitor backGround;
	GraphicsContext graphics;
	Tile tile = new Tile(50 , 50);
	SafeArea safeArea = new SafeArea(100 , 100);
	
	/**
	 * Default constructor
	 */
	public BackCanvas()
	{
		this.setHeight(500);
		this.setWidth(500);
		backGround = new DrawCanvasVisitor(this); 
		graphics = this.getGraphicsContext2D();
		
		
		
	}
	
	public void draw()
	{
		tile.accept(backGround);
		safeArea.accept(backGround);

	}
	
	

}
