package us.lsi.alg.puzzle;

import us.lsi.graphs.virtual.ActionSimpleEdge;

public class EdgePuzzle extends ActionSimpleEdge<VertexPuzzle,ActionPuzzle> {
	
	public static EdgePuzzle of(VertexPuzzle v1, VertexPuzzle v2, ActionPuzzle a) {		
		return new EdgePuzzle(v1, v2, a);
	}
	
	private EdgePuzzle(VertexPuzzle v1, VertexPuzzle v2, ActionPuzzle a) {
		super(v1, v2, a, 1.);
	}
	
}


