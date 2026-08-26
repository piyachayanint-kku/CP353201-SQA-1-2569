package sqa;

import sqa.WeightConverter;

public class Stub_WeightConverter extends WeightConverter {

	private final double fixedMultiplier;

	public Stub_WeightConverter(double fixedMultiplier) {
		this.fixedMultiplier = fixedMultiplier;
	}

	@Override
	public double getMultiplier(String fromUnit, String toUnit) {
		return fixedMultiplier;
	}
}
