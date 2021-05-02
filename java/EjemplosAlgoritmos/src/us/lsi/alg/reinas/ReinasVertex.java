package us.lsi.alg.reinas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.List2;
import us.lsi.common.RangeIntegerSet;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.ActionVirtualVertex;

public record ReinasVertex(Integer index, List<Integer> fo, RangeIntegerSet dpo, RangeIntegerSet dso)
                   implements ActionVirtualVertex<ReinasVertex,ActionSimpleEdge<ReinasVertex,Integer>,Integer> {
	
	public static ReinasVertex copy(ReinasVertex reinas) {
		return new ReinasVertex(reinas.index,List2.copy(reinas.fo),RangeIntegerSet.copy(reinas.dpo),RangeIntegerSet.copy(reinas.dso));
	}

	public static ReinasVertex of(Integer index, List<Integer> fo, RangeIntegerSet dpo, RangeIntegerSet dso) {
		return new ReinasVertex(index, fo, dpo, dso);
	}

	public static ReinasVertex first() {
		return new ReinasVertex(0,List2.empty(),RangeIntegerSet.empty(),RangeIntegerSet.empty(-n,10));
	}
	
	public static ReinasVertex last() {
		return new ReinasVertex(n,List2.empty(),RangeIntegerSet.empty(),RangeIntegerSet.empty(-n,10));
	}
	
	public static Predicate<ReinasVertex> goal() {
		return v->v.index == ReinasVertex.n;
	}
	
	
//	public final Integer errores;
	public static Integer n; // numero de reinas

	
	public Integer errores() {
		return 3*ReinasVertex.n-this.fo.size()-this.dpo.size()-this.dso.size();
	}

	@Override
	public Boolean isValid() {
		return this.index >=0 && this.index <= ReinasVertex.n;
	}
	
	public Integer size() {
		return ReinasVertex.n - this.index;
	}

	@Override
	public List<Integer> actions() {
		List<Integer> r = IntStream.range(0,ReinasVertex.n).boxed()
				.filter(e->!this.fo.contains(e) && !this.dpo.contains(e+this.index) && !this.dso.contains(e-this.index))
				.collect(Collectors.toList());
		return r;
	}

	@Override
	public ReinasVertex neighbor(Integer a) {
		Integer index = this.index+1;
		List<Integer> fo = new ArrayList<>(this.fo); fo.add(a);
		RangeIntegerSet dpo = this.dpo.addNew(a+this.index);
		RangeIntegerSet dso = this.dso.addNew(a-this.index);
		return ReinasVertex.of(index, fo, dpo, dso);
	}

	@Override
	public ActionSimpleEdge<ReinasVertex, Integer> edge(Integer a) {
		return ActionSimpleEdge.of(this,this.neighbor(a), a, 1.);
	}

}
