package acsse.csca2a.VisitorPattern;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawCanvasVisitor implements  IDrawVisitor{
	
	GraphicsContext background;
	
	public DrawCanvasVisitor(Canvas canvas)
	{
		
		background = canvas.getGraphicsContext2D();
	}

	@Override
	public void visit(Tile visitor) {
		
		int x = 0;
		
		for(int a = 0 ; a < 550 ; a +=50)
		{
			
			for(int b = 0 ; b < 550 ; b += 50)
			{
				if(x%2 == 0)
				{
			   this.background.setFill(Color.AQUA);
			   this.background.fillRect(a, b, visitor.getWIDTH(), visitor.getHEIGHT());
				}
				else
				{
					 this.background.setFill(Color.BLUE);
					   this.background.fillRect(a, b, visitor.getWIDTH(), visitor.getHEIGHT());
			
					
				}
				x++;
			}
			
			
		}
		
		
	}
	
	
	@Override
	public void visit(SafeArea visitor) {

		this.background.setFill(Color.LIMEGREEN);
		this.background.fillRect(400, 0, visitor.getWIDTH(), visitor.getHEIGHT());
		
	}
	
}
