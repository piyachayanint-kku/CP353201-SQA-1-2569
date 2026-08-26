package sqa;

import sqa.DistanceConverter;

public class Stub_DistanceConverter extends DistanceConverter {

	private final double fixedMultiplier;

	public Stub_DistanceConverter(double fixedMultiplier) {
		this.fixedMultiplier = fixedMultiplier;
	}

	@Override
	public double getMultiplier(String fromUnit, String toUnit) {
		return fixedMultiplier;
	}
}
