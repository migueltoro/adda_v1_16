package us.lsi.ag.real;

import java.util.List;

import us.lsi.ag.ValuesInRangeData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

public class DatosReal implements ValuesInRangeData<Double,List<Double>> {

	public DatosReal(){
		
	}

	@Override
	public List<Double> getSolucion(List<Double> dc) {
		return dc;
	}
	
	@Override
	public Double getMax(Integer i) {		
		Double[] r = {15.,15.};
		return r[i];
	}

	@Override
	public Double getMin(Integer i) {
		Double[] r = {0.,-15.};
		return r[i];
	}

	@Override
	public Double fitnessFunction(List<Double> ls) {
		Double a = ls.get(0);
		Double b = ls.get(1);
		Double k = 10000000.;
		return (a * a + b * b) - k * r1(a, b);
	}

	private double r1(Double a, Double b) {
		// (-a + b) >=0;
		Double r = -a + b - 1;
		return r * r;
	}

	@Override
	public Integer size() {
		return 2;
	}
	
	@Override
	public ChromosomeType getType() {
		return ChromosomeType.Real;
	}
}