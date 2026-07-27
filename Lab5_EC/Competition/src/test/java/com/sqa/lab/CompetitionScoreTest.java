package com.sqa.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CompetitionScoreTest {

    private CompetitionScore score;

    @BeforeEach
    void setUp() {
        score = new CompetitionScore();
    }


    @Nested
    @DisplayName("findMaxScore(int, int, int)")
    class ThreeArgOverload {

        @DisplayName("Valid EC - TC001~TC006")
        @ParameterizedTest(name = "{0}: findMaxScore({1},{2},{3}) => {4}")
        @CsvSource({
            "TC001, 450, 300, 100, 450",
            "TC002, 120, 480, 90,  480",
            "TC003, 50,  200, 350, 350",
            "TC004, 250, 250, 250, 250"
        })
        void findMaxScore_validInput_returnsExpectedMax(String tcId, int s1, int s2, int s3, int expected) {
            int actual = score.findMaxScore(s1, s2, s3);
            assertEquals(expected, actual, tcId + " failed");
        }

        @DisplayName("Invalid EC - TC007~TC013")
        @ParameterizedTest(name = "{0}: findMaxScore({1},{2},{3}) should throw IllegalArgumentException")
        @CsvSource({
            "TC005, -10, 200, 150",
            "TC006, 200, -50, 150",
            "TC007, 200, 150, -20",
            "TC008, 600, 300, 100",
            "TC009, 300, 550, 100",
            "TC010, 100, 300, 520",
        })
        void findMaxScore_invalidInput_throwsIllegalArgumentException(String tcId, int s1, int s2, int s3) {
            assertThrows(IllegalArgumentException.class,
                    () -> score.findMaxScore(s1, s2, s3),
                    tcId + " expected IllegalArgumentException");
        }
    }


    @Nested
    @DisplayName("findMaxScore(int[])")
    class ArrayOverload {

        @DisplayName("Valid EC - TC001~TC006")
        @ParameterizedTest(name = "{0}: findMaxScore([{1},{2},{3}]) => {4}")
        @CsvSource({
                "TC001, 450, 300, 100, 450",
                "TC002, 120, 480, 90,  480",
                "TC003, 50,  200, 350, 350",
                "TC004, 250, 250, 250, 250"
        })
        void findMaxScore_validInput_returnsExpectedMax(String tcId, int s1, int s2, int s3, int expected) {
            int actual = score.findMaxScore(new int[] { s1, s2, s3 });
            assertEquals(expected, actual, tcId + " failed");
        }

        @DisplayName("Invalid EC - TC007~TC013")
        @ParameterizedTest(name = "{0}: findMaxScore([{1},{2},{3}]) should throw IllegalArgumentException")
        @CsvSource({
                "TC005, -10, 200, 150",
                "TC006, 200, -50, 150",
                "TC007, 200, 150, -20",
                "TC008, 600, 300, 100",
                "TC009, 300, 550, 100",
                "TC010, 100, 300, 520",
        })
        void findMaxScore_invalidInput_throwsIllegalArgumentException(String tcId, int s1, int s2, int s3) {
            assertThrows(IllegalArgumentException.class,
                    () -> score.findMaxScore(new int[] { s1, s2, s3 }),
                    tcId + " expected IllegalArgumentException");
        }


    }
}
