package us.lsi.alg.mochila;

import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.mochila.datos.DatosMochila;

public class MochilaEdge extends ActionSimpleEdge<MochilaVertex,Integer> {
	
	public static MochilaEdge of(MochilaVertex v1, MochilaVertex v2, Integer a) {	
		Double w = a*DatosMochila.getValor(v1.index).doubleValue();
		return new MochilaEdge(v1, v2, a, w);
	}
	
	private MochilaEdge(MochilaVertex v1, MochilaVertex v2, Integer a, Double weight) {
		super(v1, v2, a, weight);
	}
	
}

