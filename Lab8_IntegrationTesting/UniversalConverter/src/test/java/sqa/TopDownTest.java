package sqa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import sqa.DistanceConverter;
import sqa.UniversalConverter;
import sqa.WeightConverter;

class TopDownTest {

	UniversalConverter universalConverter = new UniversalConverter();

	@Test
	void step1_dispatchToDistanceConverter() {
		double actual = universalConverter.convert(10, "Distance", "kilometer", "meter");
		assertEquals(10000.0, actual, 0.0001);
	}

	@Test
	void step1_dispatchToWeightConverter() {
		double actual = universalConverter.convert(10, "Weight", "kilogram", "gram");
		assertEquals(0.01, actual, 0.0001);
	}

	@Test
	void step1_dispatchToTemperatureConverter_bugDetection() {
		double actual = universalConverter.convert(10, "Temperature", "C", "F");
		assertEquals(50.0, actual, 0.0001);
	}

	@Test
	void step2_distanceConverter_convert_withStubbedMultiplier() {
		Stub_DistanceConverter stub = new Stub_DistanceConverter(1000.0);
		double actual = stub.convert(1, "kilometer", "meter");
		assertEquals(1000.0, actual, 0.0001);
	}

	@Test
	void step3_distanceConverter_kmToMile() {
		DistanceConverter d = new DistanceConverter();
		assertEquals(3.105, d.convert(5, "kilometer", "mile"), 0.0001);
	}

	@Test
	void step3_distanceConverter_inchToMeter() {
		DistanceConverter d = new DistanceConverter();
		assertEquals(0.254, d.convert(100, "inch", "meter"), 0.0001);
	}

	@Test
	void step4_weightConverter_convert_withStubbedMultiplier() {
		Stub_WeightConverter stub = new Stub_WeightConverter(0.001);
		double actual = stub.convert(2, "kilogram", "gram");
		assertEquals(0.002, actual, 0.0001);
	}

	@Test
	void step5_weightConverter_lbsToOunce() {
		WeightConverter w = new WeightConverter();
		assertEquals(160.0, w.convert(10, "lbs", "ounce"), 0.0001);
	}

	@Test
	void step5_weightConverter_ounceToKilogram_bugDetection() {
		WeightConverter w = new WeightConverter();
		assertEquals(0.02835, w.convert(1, "ounce", "kilogram"), 0.0001);
	}

	@Test
	void step6_fullSystem_distance() {
		assertEquals(10000.0, universalConverter.convert(10, "Distance", "kilometer", "meter"), 0.0001);
	}

	@Test
	void step6_fullSystem_weight() {
		assertEquals(11.025, universalConverter.convert(5, "Weight", "kilogram", "lbs"), 0.0001);
	}

	@Test
	void step6_fullSystem_temperature_bugDetection() {
		assertEquals(100.0, universalConverter.convert(212, "Temperature", "F", "C"), 0.0001);
	}
}
