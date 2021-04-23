package us.lsi.alg.mochila;

import java.util.Locale;
import java.util.Optional;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.mochila.datos.DatosMochila;

public class TestAStarMochilaGraph2 {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		DatosMochila.iniDatos("ficheros/objetosMochila.txt");
		MochilaVertex.capacidadInicial = 78;
		MochilaVertex e1 = MochilaVertex.initialVertex();
		MochilaVertex e2 = MochilaVertex.lastVertex();
		EGraph<MochilaVertex, MochilaEdge> graph = Graphs2.simpleVirtualGraph(e1,x->-x.getEdgeWeight());		
		
		AStar<MochilaVertex, MochilaEdge> ms = 
				GraphAlg.aStarEnd(graph,e2,MochilaHeuristic::heuristic_negate);
		
		ms.withGraph = true;
		
		ms.stream().limit(300).forEach(v->System.out.println(v));
		
		System.out.println(ms.heap.isEmpty());
		
		Graphs2.toDot(ms.outGraph,"ficheros/MochilaAstarGraph.gv",
				v->v.toString(),
				e->e.a.toString(),
				v->GraphColors.getColorIf(Color.red,MochilaVertex.goal().test(v)),
				e->GraphColors.getColorIf(Color.red,
						ms.path(e1,Optional.of(e2)).get().getEdgeList().contains(e))
				);
	}

}