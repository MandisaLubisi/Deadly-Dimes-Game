package acsse.csca2a.GUI;

import java.util.ArrayList;
import java.util.Random;

import acsse.csca2a.ObjectPool.Coins;
import acsse.csca2a.ObjectPool.CoinsReusable;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class WorldPane extends  VBox{
	
	//Attributes
	int C = 0;
	int E = 0;
	
	Random ran = new Random();
	private ArrayList<Circle> enemy;
	private ArrayList<CoinsReusable> coins;
	private Circle Player = new Circle(10);
	
	private Pane pane = new Pane();
	private boolean Cont = true;
	private BackCanvas backGround;
	Button btnCollected = new Button();
	Button btnPlay = new Button("Play Game");
	
	private int TotalNumberOfCoins = 20;
	private static int numCoinsVisible = 4;
	static int i = numCoinsVisible;
	private int numEnemies;
	private int Lives = 15;
	private int Level = 1;
	
	Label lblEnemies = new Label("Enemies");
	Label lblCoins = new Label("Coins");
	Label lblLives = new Label("Lives");
	Label lblGameOver = new Label();
	Label lblLevel = new Label();
	
	/**
	 * Default constructor
	 */
	public WorldPane()
	{
		
		numEnemies = numCoinsVisible/2;
		 backGround = new BackCanvas();
		 
		 
		this.getChildren().addAll(lblLevel,lblLives , lblEnemies , lblCoins,   btnPlay , pane);
		enemy = new ArrayList<Circle>();
		coins = new ArrayList<CoinsReusable>();
		
		
		Coins coinses = Coins.getCoins();
		
		pane.getChildren().add(backGround);
		for(int a  = 0  ; a < TotalNumberOfCoins ; a++)
		{
			Coins.releaseCoins(new CoinsReusable());	
		}
		
		for(int a  = 0 ; a <TotalNumberOfCoins/2 ; a++ )
		{
			enemy.add(new Circle(10 , Color.YELLOW));
		}
		
		
		coins = coinses.getCinList();
		
		Player.setCenterX(50);
		Player.setCenterY(50);
		
		
		
		PlayGame();
		MovePlayer();
	}
	
private void PlayGame()
	{
		
		btnPlay.setOnAction(e -> {
			
			ToCoins();
			ToEnemy();
			this.backGround.draw();
			pane.getChildren().add(Player);
			lblLevel.setText("Level  :" + Level);
			lblEnemies.setText("Number of Enemies :" + this.numEnemies);
			lblCoins.setText("Number of Coins : " + numCoinsVisible);
		});
		
		
		
		
		
	}

public void StopGame()
{
	
	
	Cont = false;
	this.getChildren().add(lblGameOver);
}
	
private void MovePlayer()
	{
	
	this.setOnKeyPressed(new EventHandler<KeyEvent>() {
				
		@Override
		public void handle(KeyEvent event) {
			String press = event.getText();
			
			
			
		if(Cont)
		{
			
			if("w".equals(press))
			{
				if(Player.getCenterY()-Player.getRadius() > 0)
				{
					Player.setCenterY(Player.getCenterY() - 10);
					
				}
				
				
				
			}
			else if("s".equals(press))
			{
				
				if(Player.getCenterY() < 500 - Player.getRadius())
				{
					Player.setCenterY(Player.getCenterY() + 10);
					
					
				}
				
				
				
			}
			
			else if("a".equals(press))
			{
				
				if(Player.getCenterX() - Player.getRadius() > 0 )
				{
					Player.setCenterX(Player.getCenterX() - 10);
					
					
				}
				
				
				
			}
			else if("d".equals(press))
			{
				
				if(Player.getCenterX() < 500 - Player.getRadius())
				{
					Player.setCenterX(Player.getCenterX() + 10);
					
					
				}
				
				
				
			}
			
		
			
			for(Circle c : enemy)
			{
				if(Player.getBoundsInLocal().intersects(c.getBoundsInLocal()) && c.getBoundsInLocal().intersects(Player.getBoundsInLocal()))
				{
					//If the player touches the enemy disguised as a coin, loses a life and starts over
					if(c.isVisible())
					{
						System.out.println("You touched the enemy");
						Lives--;
						
						Player.setCenterX(410);
						Player.setCenterY(50);
						
						lblLives.setText("Lives :" + Lives);
						
						// If all the lives are depleted, the player dies
						if(Lives <= 0)
						{
							StopGame();
							lblGameOver.setText("GAME OVER YOU LOST");
							
							
						}
						
					}
					
					
				}
				
				
				
				
			}
			
			for(CoinsReusable c : coins)
			{
				if(Player.getBoundsInLocal().intersects(c.getBoundsInLocal()) && c.getBoundsInLocal().intersects(Player.getBoundsInLocal()))
				{
					//Collecting a coin
					if(c.isVisible())
					{
						System.out.println("You have 1 coin");
						c.setVisible(false);
						ToCoins();
						i--;
						lblCoins.setText("Number of Coins : " + i);

					}
					
					
				}
				
				
				
				
			}
			
			System.out.println("X  :" + Player.getCenterX() +  "   Y  : " + Player.getCenterY() );
			
			// moving the player to the next level
			if(Player.getCenterX() >= 400 && Player.getCenterY() <= 100 && i <= 0)
			{
				numCoinsVisible += 4;
				i = numCoinsVisible;
				numEnemies = numCoinsVisible/2;
				Level++;
				lblLevel.setText("Level  :" + Level);
				SetVisible();
				
			}
			
			
		}

		}
	});
	
	
			
		}
		
private void SetVisible()
{
	int C = 0;
	int R = 0;
			 
	for(Circle c : enemy)
	{
		if(C < numEnemies)
		{
			
			c.setVisible(true);
		}
		
		C++;
	}
		
		
	for(CoinsReusable r : coins)
	{
		if(R < numCoinsVisible)
		{
			
			r.setVisible(true);
			
		}
		R++;
		
	}
	
	
	
}
private void ToCoins()
{
	boolean blnCont;
	int x = 0;
	   for(CoinsReusable r : coins)
	   {
		   blnCont = true;
		   double c = 0 ;
		   double y = 0;
		   while(blnCont)
		   {
		    c = 10 +ran.nextInt(490);
		    y = 10 +ran.nextInt(490);
		 
		   if(y > 110 || c < 390)
		   {
			  blnCont = false; 
			   
		   }
		   }
		   
		   r.setCenterX(c);
		   r.setCenterY(y);
		
		   if(C == 0)
		   {
		   pane.getChildren().add(r);
		   
		   if(x >= this.numCoinsVisible)
		   {
			   
			   r.setVisible(false);
		   }
		   }
		   x++;
	   }
	   
	   C = 1;
	   
	
	
}
public void ToEnemy(){
	
	int y = 0;
	boolean blnCont;
	   for(Circle e : enemy)
	   {
		   
		   blnCont = true;
		   double c = 0 ;
		   double t = 0;
		   while(blnCont)
		   {
		    c = 10 +ran.nextInt(490);
		    t = 10 +ran.nextInt(490);
		 
		   if(t > 110 && c < 390)
		   {
			  blnCont = false; 
			   
		   }
		   }
		   
		   e.setCenterX(c);
		   e.setCenterY(t);
		   
		   
		   
		   if(E == 0)
		   {
		   pane.getChildren().add(e);
		   if(y >= this.numEnemies)
		   {
			   e.setVisible(false);
			   
		   }
		   }
		   y++;
	   }
	
	   E = 1;
	
	
}
	
	

}

