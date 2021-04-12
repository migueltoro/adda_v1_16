package us.lsi.ag.reinas;

import java.util.List;
import java.util.Set;

import us.lsi.ag.AuxiliaryAg;
import us.lsi.ag.SeqNormalData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.common.Lists2;
import us.lsi.common.Sets2;
import us.lsi.reinas.datos.Reina;


public class DatosReinasAG implements SeqNormalData<List<Reina>> {

	public static int numeroDeReinas = 8;
	
	public static DatosReinasAG create() {
		return new DatosReinasAG();
	}

	private DatosReinasAG() {
	}

	@Override
	public List<Reina> getSolucion(List<Integer> ls) {
		List<Reina> r = Lists2.empty();
		for (int i = 0; i < ls.size(); i++) {
			r.add(Reina.create(i, ls.get(i)));
		}
		return r;
	}

	@Override
	public Double fitnessFunction(List<Integer> ls) {
		Set<Integer> dp = Sets2.empty();
		Set<Integer> ds = Sets2.empty();
		for (int i = 0; i < ls.size(); i++) {
			dp.add(ls.get(i)-i);
			ds.add(ls.get(i)+i);
		}
		return -100*AuxiliaryAg.distanceToEqZero(2.*DatosReinasAG.numeroDeReinas-dp.size()-ds.size());
	}

	@Override
	public Integer size() {
		return  numeroDeReinas;
	}
	
	@Override
	public ChromosomeType getType() {
		return ChromosomeType.Permutation;
	}


}