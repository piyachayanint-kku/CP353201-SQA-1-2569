package com.health.fitness;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HealthIndexScoreTest42 {


    @Test
    @DisplayName("TC001: (45, 70, 15)")
    void testTC001() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }


    @Test
    @DisplayName("TC002: (-1, 70, 15)")
    void testTC002() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthIndexScore(-1, 70, 15);
        });
    }

    @Test
    @DisplayName("TC003: (0, 70, 15)")
    void testTC003() {
        HealthIndexScore score = new HealthIndexScore(0, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC004: (1, 70, 15)")
    void testTC004() {
        HealthIndexScore score = new HealthIndexScore(1, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC005: (99, 70, 15)")
    void testTC005() {
        HealthIndexScore score = new HealthIndexScore(99, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC006: (100, 70, 15)")
    void testTC006() {
        HealthIndexScore score = new HealthIndexScore(100, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC007: (101, 70, 15)")
    void testTC007() {
        HealthIndexScore score = new HealthIndexScore(101, 70, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }


    @Test
    @DisplayName("TC008: (45, 39, 15)")
    void testTC008() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthIndexScore(45, 39, 15);
        });
    }

    @Test
    @DisplayName("TC009: (45, 40, 15)")
    void testTC009() {
        HealthIndexScore score = new HealthIndexScore(45, 40, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC010: (45, 41, 15)")
    void testTC010() {
        HealthIndexScore score = new HealthIndexScore(45, 41, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC011: (45, 219, 15)")
    void testTC011() {
        HealthIndexScore score = new HealthIndexScore(45, 219, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC012: (45, 220, 15)")
    void testTC012() {
        HealthIndexScore score = new HealthIndexScore(45, 220, 15);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC013: (45, 221, 15)")
    void testTC013() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthIndexScore(45, 221, 15);
        });
    }


    @Test
    @DisplayName("TC014: (45, 70, -1)")
    void testTC014() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthIndexScore(45, 70, -1);
        });
    }

    @Test
    @DisplayName("TC015: (45, 70, 0)")
    void testTC015() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 0);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC016: (45, 70, 1)")
    void testTC016() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 1);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC017: (45, 70, 29)")
    void testTC017() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 29);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC018: (45, 70, 30)")
    void testTC018() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 30);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }

    @Test
    @DisplayName("TC019: (45, 70, 31)")
    void testTC019() {
        HealthIndexScore score = new HealthIndexScore(45, 70, 31);
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, score.getFitnessLevel());
    }
}