package sqa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import sqa.DistanceConverter;
import sqa.TemperatureConverter;
import sqa.UniversalConverter;
import sqa.WeightConverter;

class BottomUpTest {

	@Test
	void step1_distanceGetMultiplier_kmToMeter() {
		DistanceConverter d = new DistanceConverter();
		assertEquals(1000.0, d.getMultiplier("kilometer", "meter"), 0.0001);
	}

	@Test
	void step1_distanceGetMultiplier_mileToInch() {
		DistanceConverter d = new DistanceConverter();
		assertEquals(63360.0, d.getMultiplier("mile", "inch"), 0.0001);
	}

	@Test
	void step1_distanceGetMultiplier_inchToKilometer() {
		DistanceConverter d = new DistanceConverter();
		assertEquals(0.0000254, d.getMultiplier("inch", "kilometer"), 0.0000001);
	}

	@Test
	void step2_weightGetMultiplier_kgToLbs() {
		WeightConverter w = new WeightConverter();
		assertEquals(2.205, w.getMultiplier("kilogram", "lbs"), 0.0001);
	}

	@Test
	void step2_weightGetMultiplier_gramToOunce() {
		WeightConverter w = new WeightConverter();
		assertEquals(0.035, w.getMultiplier("gram", "ounce"), 0.0001);
	}

	@Test
	void step2_weightGetMultiplier_ounceToKilogram_bugDetection() {
		WeightConverter w = new WeightConverter();
		assertEquals(0.02835, w.getMultiplier("ounce", "kilogram"), 0.0001);
	}

	@Test
	void step3_temperature_cToF_bugDetection() {
		TemperatureConverter t = new TemperatureConverter();
		assertEquals(212.0, t.convert(100, "C", "F"), 0.0001);
	}

	@Test
	void step3_temperature_cToK_ok() {
		TemperatureConverter t = new TemperatureConverter();
		assertEquals(273.15, t.convert(0, "C", "K"), 0.0001);
	}

	@Test
	void step3_temperature_fToC_bugDetection() {
		TemperatureConverter t = new TemperatureConverter();
		assertEquals(100.0, t.convert(212, "F", "C"), 0.0001);
	}

	@Test
	void step4_distanceConvert_kmToMeter() {
		DistanceConverter d = new DistanceConverter();
		assertEquals(1000.0, d.convert(1, "kilometer", "meter"), 0.0001);
	}

	@Test
	void step4_distanceConvert_mileToKilometer() {
		DistanceConverter d = new DistanceConverter();
		assertEquals(16.09, d.convert(10, "mile", "kilometer"), 0.0001);
	}

	@Test
	void step5_weightConvert_kgToLbs() {
		WeightConverter w = new WeightConverter();
		assertEquals(11.025, w.convert(5, "kilogram", "lbs"), 0.0001);
	}

	@Test
	void step5_weightConvert_lbsToGram() {
		WeightConverter w = new WeightConverter();
		assertEquals(907.03, w.convert(2, "lbs", "gram"), 0.01);
	}

	@Test
	void step6_universalConverter_distance() {
		UniversalConverter u = new UniversalConverter();
		assertEquals(10000.0, u.convert(10, "Distance", "kilometer", "meter"), 0.0001);
	}

	@Test
	void step6_universalConverter_weight() {
		UniversalConverter u = new UniversalConverter();
		assertEquals(11.025, u.convert(5, "Weight", "kilogram", "lbs"), 0.0001);
	}

	@Test
	void step6_universalConverter_temperature_bugDetection() {
		UniversalConverter u = new UniversalConverter();
		assertEquals(212.0, u.convert(100, "Temperature", "C", "F"), 0.0001);
	}
}
