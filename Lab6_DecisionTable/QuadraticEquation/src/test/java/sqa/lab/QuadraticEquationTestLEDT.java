package sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("QuadraticEquation - Limited Entry Decision Table")
class QuadraticEquationTestLEDT {

    private final QuadraticEquation sut = new QuadraticEquation();

    @DisplayName("LEDT executable rules")
    @ParameterizedTest(name = "{0} ({1}): a={2}, b={3}, c={4} -> {5}")
    @CsvSource({
        // Rule#, TCID,  a,  b,  c,  expected
        "7,  TC007, 0, 5, 3, NOT_QUADRATIC",
        "8,  TC008, 1, 5, 2, REAL_ROOTS",
        "11, TC011, 0, 0, 7, NOT_QUADRATIC",
        "12, TC012, 1, 4, 4, EQUAL_ROOTS",
        "14, TC014, 1, 2, 3, IMAGINARY_ROOTS"
    })
    void testLedtRules(int ruleNo, String testCaseId, int a, int b, int c, RootNature expected) {
        RootNature actual = sut.determineRootNature(a, b, c);
        assertEquals(expected, actual,
            String.format("Rule#%d / %s failed for a=%d, b=%d, c=%d (discriminant = %d)",
                          ruleNo, testCaseId, a, b, c, (b * b) - (4 * a * c)));
    }
}