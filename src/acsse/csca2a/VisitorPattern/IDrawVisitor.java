package acsse.csca2a.VisitorPattern;



public interface IDrawVisitor {
	
	public void visit(Tile visitor );
	public void visit(SafeArea visitor) ;

}
