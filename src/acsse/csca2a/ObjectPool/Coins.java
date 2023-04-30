package acsse.csca2a.ObjectPool;

import java.util.ArrayList;

import javafx.scene.shape.Circle;

/**
 * 
 * @author MT LUBISI
 *
 */


public class Coins {
	
	
	private static Coins coins = null;
	private static ArrayList<CoinsReusable> listOfCoins = null;
	
	private Coins()
	{
		
		listOfCoins = new ArrayList<CoinsReusable>();
	}
	
	public static Coins getCoins()
	{
		
		if(coins == null)
		{
			
			coins = new Coins();
		}
		
		
		
		return coins;
	}

	
	public CoinsReusable equreCars()
	{
		
		if(listOfCoins.isEmpty())
		{
			return null;
		}
		else
		{
			CoinsReusable temp = listOfCoins.get(listOfCoins.size() - 1);
			
			return temp;
		}
		
	}
	
	public static void releaseCoins(CoinsReusable coins)
	{
		if( coins != null)
		{
			listOfCoins.add(coins);
			
		}
		else
		{
			
			System.err.print(coins.toString()+ "Cannot Invoke Class");
			
			
		}
		
	}
	
	public ArrayList<CoinsReusable> getCinList()
	{
		return this.listOfCoins;
	}
}
