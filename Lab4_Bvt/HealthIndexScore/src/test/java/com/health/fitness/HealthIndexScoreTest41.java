package com.health.fitness;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthIndexScoreTest41 {

    @Test
    @DisplayName("TC001: (45, 70, 15)")
    void testTC001() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC002: (0, 70, 15)")
    void testTC002() {
        HealthIndexScore score = new HealthIndexScore(0, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC003: (1, 70, 15)")
    void testTC003() {
        HealthIndexScore score = new HealthIndexScore(1, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC004: (99, 70, 15)")
    void testTC004() {
        HealthIndexScore score = new HealthIndexScore(99, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC005: (100, 70, 15)")
    void testTC005() {
        HealthIndexScore score = new HealthIndexScore(100, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC006: (45, 40, 15)")
    void testTC006() {
        HealthIndexScore score = new HealthIndexScore(45, 40, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC007: (45, 41, 15)")
    void testTC007() {
        HealthIndexScore score = new HealthIndexScore(45, 41, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC008: (45, 219, 15)")
    void testTC008() {
        HealthIndexScore score = new HealthIndexScore(45, 219, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC009: (45, 220, 15)")
    void testTC009() {
        HealthIndexScore score = new HealthIndexScore(45, 220, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC010: (45, 70, 0)")
    void testTC010() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 0);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC011: (45, 70, 1)")
    void testTC011() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 1);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC012: (45, 70, 29)")
    void testTC012() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 29);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC013: (45, 70, 30)")
    void testTC013() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 30);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }
}