package acsse.csca2a.VisitorPattern;

public abstract class Floor implements IDrawableVisitor{
	
	private double WIDTH;
	private double HEIGHT;
	public Floor(double wIDTH, double hEIGHT) {
		
		WIDTH = wIDTH;
		HEIGHT = hEIGHT;
	}
	public double getWIDTH() {
		return WIDTH;
	}
	public void setWIDTH(double wIDTH) {
		WIDTH = wIDTH;
	}
	public double getHEIGHT() {
		return HEIGHT;
	}
	public void setHEIGHT(double hEIGHT) {
		HEIGHT = hEIGHT;
	}
	
	public abstract void accept(IDrawVisitor vis);
	
	
	

}
