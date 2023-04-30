package acsse.csca2a.VisitorPattern;

public class SafeArea extends Floor{

	public SafeArea(double wIDTH, double hEIGHT) {
		super(wIDTH, hEIGHT);
		
	}

	@Override
	public void accept(IDrawVisitor vis) {
		vis.visit(this);
		
	}

}
