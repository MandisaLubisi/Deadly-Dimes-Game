package acsse.csca2a.VisitorPattern;

public class Tile extends Floor {

	public Tile(double wIDTH, double hEIGHT) {
		super(wIDTH, hEIGHT);
		
	}

	@Override
	public void accept(IDrawVisitor vis) {
			vis.visit(this);		
	}
	
	
	
	
	

}
